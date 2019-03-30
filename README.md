# Android Barebone Project
A barebone Android project with some essential tools configured the right way.

## Configured Essentials
There are few essentials that are added to the project. Best way to see what is included is to check the latest **dependecies** from [app/build.gradle](https://github.com/amardeshbd/android-barebone/blob/master/app/build.gradle#L37)

Here are list of dependencies included:
1. AndroidX AppCompat and Material Theme
1. Firebase Crashlytics
1. Firebase Analytics
1. Timber - _android logging_
1. Mockito - _unit test mocking_

### Pre-Requisite
* You must create a Firebase project and use the `google-services.json` from your project. A [placeholder google-services.json](https://github.com/amardeshbd/android-barebone/blob/master/app/google-services.json) is provided so that app compiles.
* You must update package name and application ID where applicable.
