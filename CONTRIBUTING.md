# CONTRIBUTING.md

## Contributing to krotoDC

First of all, thank you for considering contributing to krotoDC! We appreciate your time and effort and are excited to have you join our community. This document serves as a guideline for contributing to our open-source library.

### Getting Started

1. Fork the repository on GitHub.
2. Clone your fork to your local machine.
3. Set up your development environment, ensuring that all necessary dependencies are installed.
4. Create a new branch for your feature or bugfix.

### Code Style

We follow the [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html) for code style. Please make sure your code adheres to these conventions.

Additionally, before committing your code, ensure that the `ktlintCheck` passes:
```bash
./gradlew ktlintCheck
```
If there are any issues, you can try to fix them automatically by running:
```bash
./gradlew ktlintFormat
```

### Tests

When changing the generated code output, include a test for it in the same pull request (PR). Add new `.proto` files under `src/test/proto`, and they will be automatically generated and accessible from the tests. Ensure that all tests pass before submitting your PR:
```bash
./gradlew test
```

### Pull Requests

1. Commit your changes to your feature or bugfix branch.
2. Push your branch to your fork on GitHub.
3. Create a pull request from your fork's branch to the original repository's `main` branch.
4. In the pull request description, provide a clear and concise description of the changes you made, and mention any issues that your PR addresses.
5. Await feedback from maintainers. They may request changes or ask questions. Be prepared to iterate on your PR based on their feedback.

### Code of Conduct

We expect all contributors to adhere to the standard [Code of Conduct](https://www.contributor-covenant.org/version/2/0/code_of_conduct.html). Please treat everyone with respect and maintain a professional and inclusive environment.

---

Once again, thank you for your interest in contributing to krotoDC. We look forward to your contributions and to working with you!
