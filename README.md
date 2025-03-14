# Fetch Interview App

A native Android application that retrieves data from a Fetch API endpoint, processes it according to specific business rules, and displays it in an organized format to the user.

## Features

- Retrieves data from https://fetch-hiring.s3.amazonaws.com/hiring.json
- Displays items grouped by "listId"
- Sorts results first by "listId" then by "name" within each group
- Filters out items where "name" is blank or null
- Presents data in an easy-to-read list with a modern Material 3 UI

## Architecture

This application uses a multi-module clean architecture approach with the following components:

### Modules

- **app**: Main application module and entry point
- **core:model**: Contains data models shared across the application
- **core:network**: Handles API communication and data retrieval
- **core:domain**: Contains business logic and use cases
- **core:common**: Shared utilities and extensions
- **feature:itemlist**: UI implementation for the items list screen

### Technologies

- **UI**: Jetpack Compose with Material 3
- **Architecture**: MVVM with Clean Architecture
- **Dependency Injection**: Hilt
- **Networking**: Retrofit with Kotlin Serialization
- **Asynchronous Programming**: Kotlin Coroutines and Flow
- **Build System**: Gradle with Kotlin DSL

## Project Structure

```
├── app/                          # Main application module
├── core/
│   ├── common/                   # Shared utilities
│   ├── model/                    # Data models
│   ├── network/                  # API and repository implementation
│   └── domain/                   # Business logic and use cases
└── feature/
    └── itemlist/                 # Items list feature implementation
```

## Setup & Installation

1. Clone the repository
2. Open the project in Android Studio
3. Build and run the application

## Requirements

- Android Studio Hedgehog or newer
- Minimum SDK: 24 (Android 7.0)
- Target SDK: 34 (Android 14)
- Kotlin 1.9.0 or newer

## Architecture Diagram

```
┌─────────────────┐      ┌────────────────┐      ┌────────────────┐
│                 │      │                │      │                │
│  UI (Compose)   │◄─────┤   ViewModel    │◄─────┤    Use Case    │
│                 │      │                │      │                │
└─────────────────┘      └────────────────┘      └────────┬───────┘
                                                          │
                                                          ▼
                                               ┌────────────────────┐
                                               │                    │
                                               │    Repository      │
                                               │                    │
                                               └──────────┬─────────┘
                                                          │
                                                          ▼
                                               ┌────────────────────┐
                                               │                    │
                                               │   API Service      │
                                               │                    │
                                               └────────────────────┘
```

## Future Improvements

- Add unit and UI tests
- Implement caching for offline support
- Add search and filtering capabilities
- Improve error handling and retry mechanisms
- Add animations and transitions
