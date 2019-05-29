[![CircleCI](https://circleci.com/gh/amardeshbd/android-barebone.svg?style=svg)](https://circleci.com/gh/amardeshbd/android-barebone)   


# Android Barebone Project
A barebone MVVM architecture based Android project with some essential tools configured the right way.

> Inspiration: The architecture is inspired by combination of different project by Google and Android Community, such as:
> - [Github Browser](https://github.com/googlesamples/android-architecture-components/tree/master/GithubBrowserSample) - Sample project from Android Architecture Components repository
> - [Todo MVVM LiveData App](https://github.com/googlesamples/android-architecture/tree/todo-mvvm-live-kotlin/) - Todo app by Android Architecture Blueprints

## Configured Essentials
There are few essentials that are added to the project. Best way to see what is included is to check the latest **dependecies** from [app/build.gradle](https://github.com/amardeshbd/android-barebone/blob/master/app/build.gradle#L37)

Here are list of dependencies included:
1. **AndroidX** 
    1. AppCompat
    1. Material Theme
    1. ViewModel
    1. Lifecycle
1. **Firebase Crashlytics**
1. **Firebase Analytics**
1. **Timber** - _android logging_
1. **Dagger 2** - _dependency injection_
1. **Retrofit 2** - _REST API_
1. **Gson** - _JSON response parsing_
1. **Mockito** - _unit test mocking_

### Optional Library and Integrations
> You may need to delete optional features based on your need.
1. CircleCI integration for CI/CD.


### Pre-Requisite
* You must create a Firebase project and use the `google-services.json` from your project. A [placeholder google-services.json](https://github.com/amardeshbd/android-barebone/blob/master/app/google-services.json) is provided so that app compiles.
* You must update package name and application ID where applicable.
* Also update your application's theme color. See [styles.xml](https://github.com/amardeshbd/android-barebone/blob/master/app/src/main/res/values/styles.xml)
