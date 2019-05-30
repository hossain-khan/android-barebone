[![CircleCI](https://circleci.com/gh/amardeshbd/android-barebone.svg?style=svg)](https://circleci.com/gh/amardeshbd/android-barebone)   


# Android Barebone Project
A barebone MVVM architecture based Android project with some essential tools configured the right way.

> Inspiration: The architecture is inspired by combination of different project by Google and Android Community, such as:
> - [Github Browser](https://github.com/googlesamples/android-architecture-components/tree/master/GithubBrowserSample) - Sample project from Android Architecture Components repository
> - [Todo MVVM LiveData App](https://github.com/googlesamples/android-architecture/tree/todo-mvvm-live-kotlin/) - Todo app by Android Architecture Blueprints

## Configured Essentials
There are few essentials that are added to the project. Best way to see what is included is to check the latest **dependecies** from [app/build.gradle](https://github.com/amardeshbd/android-barebone/blob/master/app/build.gradle#L44)

Here are list of dependencies included:
1. **AndroidX** 
    1. AppCompat
    1. Material Theme
    1. ViewModel
    1. Lifecycle
    1. ConstraintLayout
    1. Kotlin Extensions (KTX)
1. **Firebase Crashlytics**
1. **Firebase Analytics**
1. **Timber** - _android logging_
1. **Dagger 2** - _dependency injection_
1. **RxJava 2** - _ReactiveX Java_
1. **Retrofit 2** - _REST API_
1. **OkHttp** - with logging interceptor
1. **Gson** - _JSON response parsing_
1. **Mockito** - _unit test mocking_
1. **Leak Canary** - _automatic memory leak detection_

### Optional Library and Integrations
> You may need to delete optional features based on your need.
1. CircleCI integration for CI/CD.


### Pre-Requisite
* You must create a Firebase project and use the `google-services.json` from your project. A [placeholder google-services.json](https://github.com/amardeshbd/android-barebone/blob/master/app/google-services.json) is provided so that app compiles.
* You must update package name and application ID where applicable.
* Remove feature `X`, `Y`, and `Y` activities and related resources. However, it may be benefitial to keep them as reference point at initial phase of the project.
* Remove unused libraries that are added in [app/build.gradle](https://github.com/amardeshbd/android-barebone/blob/master/app/build.gradle#L44)
* Also update your application's theme color. See [styles.xml](https://github.com/amardeshbd/android-barebone/blob/master/app/src/main/res/values/styles.xml)

### Preview
Currently the barebone app has following sample activities:
* `Feature X` - showcases how REST call is made using injected service in ViewModel.
* `Feature Y` - showcases how RecyclerView can be used in conjunction with DiffUtils.
* `Feature Z` - showcases how Fragment can also have injection and use service in ViewModel.

![](https://user-images.githubusercontent.com/99822/58602978-f7f2d700-825c-11e9-8f51-5bb4e8108af2.png)
