[![CircleCI](https://circleci.com/gh/amardeshbd/android-barebone.svg?style=svg)](https://circleci.com/gh/amardeshbd/android-barebone) [![](https://github.com/amardeshbd/android-barebone/workflows/Android%20CI/badge.svg)](https://github.com/amardeshbd/android-barebone/actions)  

---
# What about template for 2020?
While the template was made in `2019`, it holds up well in `2020`, however there are more cool stuff came around since then.
You should always refer to Google's official projects for pointers. Here are some relevant references:
* https://developer.android.com/jetpack and https://developer.android.com/jetpack/androidx/versions
* https://github.com/android/sunflower
* https://github.com/cortinico/kotlin-android-template
* https://medium.com/@hossainkhan/how-to-take-your-beginner-android-skills-to-the-next-level-by-studying-open-source-android-apps-713d55c5094
---


# Android Barebone Template Project
A barebone MVVM architecture based Android project with some essential tools configured the right* way. See [Android Architecture Blueprints v2](https://github.com/googlesamples/android-architecture) for more comprehensive app architecture example.

> Inspiration: The architecture is inspired by combination of different project by Google and Android Community, such as:
> - [Github Browser](https://github.com/googlesamples/android-architecture-components/tree/master/GithubBrowserSample) - Sample project from Android Architecture Components repository
> - [Todo MVVM LiveData App](https://github.com/googlesamples/android-architecture/tree/todo-mvvm-live-kotlin/) - Todo app by Android Architecture Blueprints
> - [Android Blueprints v2 - Modern Architecture](https://github.com/googlesamples/android-architecture) - Todo app using all the modern libraries like Architecture Components, Navigation, MVVM and so on.

## Configured Essentials
There are few essentials that are added to the project. Best way to see what is included is to check the latest **dependecies** from [app/build.gradle](https://github.com/amardeshbd/android-barebone/blob/master/app/build.gradle#L44)

Here are list of dependencies included:
1. **AndroidX** 
    1. AppCompat
    1. Material Theme
    1. ViewModel
    1. Lifecycle
    1. ConstraintLayout
    1. ViewPager 2
    1. Kotlin Extensions (KTX)
1. **Firebase Crashlytics**
1. **Firebase Analytics**
1. **Timber** - _android logging_
1. **~Dagger 2~** - _~dependency injection for Activity and Fragment~_ Upgraded to **Dagger Hilt** (alpha), see [PR#38](https://github.com/amardeshbd/android-barebone/pull/38)
1. **RxJava 3** - _ReactiveX Java_
1. **Retrofit 2** - _REST API_
1. **OkHttp** - with logging interceptor
1. **Gson** - _JSON response parsing_
1. **Mockito** - _unit test mocking_
1. **Leak Canary 2** - _automatic memory leak detection_
1. **Kt Lint Format** - _An anti-bikeshedding Kotlin linter with built-in formatter_

### Optional Library and Integrations
> You may need to delete optional features based on your need.
1. CircleCI integration for CI/CD.


### Pre-Requisite (:computer: TODO After cloning repo)
* You must create a Firebase project and use the `google-services.json` from your project. A [placeholder google-services.json](https://github.com/amardeshbd/android-barebone/blob/master/app/google-services.json) is provided so that app compiles.
* You must update package name and application ID where applicable.
* Remove feature `X`, `Y`, and `Y` activities and related resources. However, it may be beneficial to keep them as reference point at initial phase of the project.
* Remove fragment `A`, `B`, and `C` and related files like ViewModel and Layout files.
* Remove unused libraries that are added in [app/build.gradle](https://github.com/amardeshbd/android-barebone/blob/master/app/build.gradle#L44)
* Also update your application's theme color. See [styles.xml](https://github.com/amardeshbd/android-barebone/blob/master/app/src/main/res/values/styles.xml)

### Preview
Currently the barebone app has following sample activities:
* `MainActivity` - Hosts fragments using `ViewPager` and navigates using `BottomNavigationView`.
* `Feature X` - showcases how REST call is made using injected service in ViewModel.
* `Feature Y` - showcases how RecyclerView can be used in conjunction with DiffUtils.
* `Feature Z` - showcases how Fragment can also have injection and use service in ViewModel.

![](https://user-images.githubusercontent.com/99822/58602978-f7f2d700-825c-11e9-8f51-5bb4e8108af2.png)
