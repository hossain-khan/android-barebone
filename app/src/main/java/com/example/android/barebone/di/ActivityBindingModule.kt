package com.example.android.barebone.di

import com.example.android.barebone.BareboneApplication
import com.example.android.barebone.ui.featurex.FeatureXActivity
import com.example.android.barebone.ui.home.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * We want Dagger.Android to create a Subcomponent which has a parent Component of whichever
 * module ActivityBindingModule is on, in our case that will be [BareboneApplication].
 *
 * The beautiful part about this setup is that you never need to tell [BareboneApplication]
 * that it is going to have all these subcomponents nor do you need to tell these subcomponents
 * that [BareboneApplication] exists.
 *
 * We are also telling Dagger.Android that this generated SubComponent needs to include
 * the specified modules and be aware of a scope annotation @ActivityScoped
 * When Dagger.Android annotation processor runs it will create subcomponents for us.
 */
@Module
abstract class ActivityBindingModule {
    /*
     * DEV NOTE:
     * ===========
     *
     * `ContributesAndroidInjector` Generates an AndroidInjector for the return type of this method.
     * The injector is implemented with a Subcomponent and will be a child of the Module's component.
     * This annotation must be applied to an abstract method in a Module that returns a concrete Android
     * framework type (e.g. FooActivity, BarFragment, MyService, etc). The method should have no parameters.
     *
     * https://dagger.dev/android
     *
     * Pro-tip: If your subcomponent and its builder have no other methods or supertypes than
     * the ones mentioned in step #2, you can use @ContributesAndroidInjector to generate them for you.
     *
     * Instead of steps 2 and 3, add an abstract module method that returns your activity,
     * annotate it with @ContributesAndroidInjector, and specify the modules you want to install
     * into the subcomponent. If the subcomponent needs scopes, apply the scope annotations to
     * the method as well.
     */

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeFeatureXActivity(): FeatureXActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeHomeActivity(): MainActivity
}