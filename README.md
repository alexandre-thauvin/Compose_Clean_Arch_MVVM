# Media Retriever

An Android app consuming a [public API](https://il.srgssr.ch/integrationlayer/2.0/rts/mediaList/video/latestEpisodes) from the [RTS](https://www.rts.ch/)
to display a simple list of media. It was build with:
- Jetpack Compose
- MVVM architecture pattern
- Datasource/Repository/Usecase pattern
- Architecture Components

## Table of Contents

- [Architecture](#architecture)
- [Testing](#testing)
- [Libraries](#libraries)

## Architecture

The Application is split into a three layer architecture:
- Presentation
- Domain
- Data

![Architecture Flow Diagram](https://user-images.githubusercontent.com/27420929/231156709-9f7eb7fb-e7d8-4c51-826c-8c817131b99f.png)

This provides better abstractions between framework implementations 
and the underlying business logic.It requires a number of classes to get 
things running but the pros outweigh the cons in terms of building an app 
that should scale.

The 3 layered architectural approach is majorly guided by clean architecture which provides
a clear separation of concerns with its Abstraction Principle.

#### Presentation

```ui``` contains the UI files such as composable and collect UI states from the viewmodel.
The data being received is part of a viewstate class that has properties contained in the
relevant state.

#### Domain

The ```api``` package contains domain model classes which represent the
data we will be handling across presentation and data layer.

Use cases are also provided in the domain layer and orchestrate the flow 
of data from the data layer onto the presentation layer and a split into
modular pieces serving one particular purpose.

#### Data

The ```internal``` package contains all implementations of interface that 
should not be exposed to other modules. At the current state of the project, 
the latter only has one module which is app but in order to make a modularized project 
with multi-module we should use ```internal``` modifier as well as group 
all implementation (repository/usecase etc...) in an ```internal``` package.

Because we use usecase pattern, we can make our repositories and datasource ```internal``` and inject thoses 
in the corresponding ```usecase``` and only make the usecase public.
For that we have the ```di``` package that contains all dependency injection.

For now there is no local storage and data persistence.

## Testing

Each layer should be properly tested but for now only the ```ViewModel``` are tested.

View models testing on live data were guided by this [article](https://proandroiddev.com/how-to-easily-test-a-viewmodel-with-livedata-and-coroutines-230c74416047)
 
## Libraries

Libraries used in the whole application are:

- [Jetpack](https://developer.android.com/jetpack)
  - [Viewmodel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Manage UI related data in a lifecycle conscious way 
  and act as a channel between use cases and ui
  - [Compose](https://developer.android.com/jetpack/compose) Compose is Android’s recommended modern toolkit for building native UI. 
      It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs
- [Retrofit](https://square.github.io/retrofit/) - type safe http client 
and supports coroutines out of the box.  
- [Timber](https://github.com/JakeWharton/timber) - Logging library that makes logging easier and better
- [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines,provides `runBlocking` coroutine builder used in tests
- [Material Design 3](https://m3.material.io/) - build awesome beautiful UIs
- [Dagger Hilt](https://dagger.dev/hilt/) - Dependency injection library at compile time (avoid runtime error), Hilt is an implementation
of Dagger that makes DI easy and readible and customising according to build variant.
- [OkHttp](https://square.github.io/okhttp/) - Http client usually used for customization with Retrofit
- [JUnit 4](https://junit.org/junit4/) - Testing library
- [MockK](https://mockk.io/) - Mocking library especially made for kotlin. Stable and easy to use.
- [Turbine](https://github.com/cashapp/turbine) - kotlinx.coroutines Flow testing library. Testing your flow has never been easier.

## TODO
- Multimodular architecture
- Pagination
- Local data storage for data persistence with ROOM
- Testing all layers


