# Generated Code Spec
### DataClasses
For all protobuf messages including nested types, the plugin will generate a Kotlin data class with the same name.

ex)
```protobuf
message Person {
  string name = 1;
  int32 age = 2;
}
```
will be generated as:
```kotlin
@KrotoDC(forProto = io.github.mscheong01.test.Person::class)
public data class Person(
    public val name: String = "",
    public val age: Int = 0,
)
```

**note that enum types will not be regenerated.

The generated data classes will satisfy these conditions to make them easier to use:
#### Nullability
- fields marked with the `optional` keyword will be nullable.

ex)
```protobuf
message OptionalMessage {
  optional string optional_string = 1;
  optional int32 optional_int = 2;
  optional Person optional_person = 3;
}
```
will be generated as:
```kotlin
@KrotoDC(forProto = io.github.mscheong01.test.OptionalMessage::class)
public data class OptionalMessage(
  public val optionalString: String? = null,
  public val optionalInt: Int? = null,
  public val optionalPerson: Person? = null,
)
```

#### Sealed OneOfs
- protobuf oneofs will be generated as a sealed interface with the same name as the oneof.
- the generated sealed interface will include implementing data classes that has a single field of the type of the contained field.

ex)
```protobuf
message OneOfMessage {
  oneof oneof_field {
    string oneof_string = 1;
    int32 oneof_int = 2;
    Person oneof_person = 3;
  }
}
```
will be generated as:
```kotlin
@KrotoDC(forProto = io.github.mscheong01.test.OneOfMessage::class)
public data class OneOfMessage(
  public val oneofField: OneofField? = null,
) {
  public sealed interface OneofField {
    public data class OneofString(
      public val oneofString: String = "",
    ) : OneofField

    public data class OneofInt(
      public val oneofInt: Int = 0,
    ) : OneofField

    public data class OneofPerson(
      public val oneofPerson: Person = io.github.mscheong01.test.krotodc.Person(),
    ) : OneofField
  }
}
```

#### Predefined Types
- in protobuf-java, there are some predefined types that are not generated as protobuf messages. instead, their java classes are pre-defined in the protobuf-java library.
- for these types, krotoDC will not generate data class and converters by default. this is because:
  1. If we generate data classes for them by this plugin, too much unused excessive code will be included in your resulting package
  2. We could instead consider pre-generate them and include them in the krotoDC-core library. However, we will not do this because:
     1. some pre defined messages, like `google.protobuf.Any`, provides other utility methods like packing which will be lost if we just generate data classes for them
     2. if new predefined types are added to protobuf-java in the future, the generated output will break for these types until we update the krotoDC-core library
- what we instead do is provide a way to customize how to `handle` these types. In [HandledPreDefineType.kt](https://github.com/mscheong01/krotoDC/blob/main/generator/src/main/kotlin/com/github/mscheong01/krotodc/predefinedtypes/HandledPreDefinedType.kt),
  we define a list of predefined types that we want to handle. For each type, we define a corresponding enum entry that includes the message descriptor,
  the to-be-converted data classes, and templates that specifies how the predefined protobuf-java type should be converted from and to the data class.
  adding this definition will allow the plugin to use that information to generate converters for the predefined field type.
- because this behavior is breaking change for that particular predefined type when added, we will include them in future release notes.

currently, handled pre defined types are as folows:
- `google.protobuf.Timestamp` is converted to `java.time.LocalDateTime`
- `google.protobuf.Duration` is converted to `java.time.Duration`
- `google.protobuf.Empty` is converted to `kotlin.Unit`
- well known wrapper types (e.g. `google.protobuf.StringValue`) are converted to their corresponding primitive *nullable* types (e.g. `kotlin.String?`)

if you want to add more predefined types to be handled, you can send a PR to add them to the `HandledPreDefinedType` enum class or propose it by subitting an issue.

### Converters
fo all generated krotoDC protobuf dataclasses, two converter extension methods will be generated:
- toProto(): the dataclass will be converted to a protobuf message
- toDataClass(): the protobuf message will be converted to a dataclass
for nullable or oneof fields, the converters will contain appropriate checks on protobuf classes (such as `has~`or checking the `~Case` enum) to convert to the appropriate dataclass field type.

ex) generate `OptionalMessage` converters:

PersonConverters.kt
```kotlin
/**
 * Converts [Person] to [io.github.mscheong01.test.krotodc.Person]
 */
@KrotoDCConverter(
    from = Person::class,
    to = io.github.mscheong01.test.krotodc.Person::class,
)
public fun Person.toDataClass(): io.github.mscheong01.test.krotodc.Person =
    io.github.mscheong01.test.krotodc.Person(name = name,
        age = age,
    )

/**
 * Converts [io.github.mscheong01.test.krotodc.Person] to [Person]
 */
@KrotoDCConverter(
    from = io.github.mscheong01.test.krotodc.Person::class,
    to = Person::class,
)
public fun io.github.mscheong01.test.krotodc.Person.toProto(): Person = Person.newBuilder()
    .apply {
        setName(this@toProto.name)
        setAge(this@toProto.age)
    }
    .build()
```

these extension functions can be used to convert krotoDC dataclasses to protobuf-java GeneratedMessageV3 classes and vice versa
this is useful for interoperability with other libraries that use protobuf-java
### ServiceBases & Stubs
for all protobuf services, the plugin will generate a Kotlin Class with a ~GrpcKroto suffix.
the class will contain a CoroutineServiceBase and a CoroutineStub.
Their functionality is identical to that of the grpc-kotlin library, but the method stubs use krotoDC generated protobuf dataclasses as request and response types
