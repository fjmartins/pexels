package com.fjmartins.pexels.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.fjmartins.pexels.PexelApplication
import com.fjmartins.pexels.di.component.DaggerAppComponent
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection

object PexelInjector {
    fun init(app: PexelApplication) {
        app.run {
            DaggerAppComponent.builder().application(this).build().inject(this)

            registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
                override fun onActivityCreated(p0: Activity, p1: Bundle?) {
                    inject(p0)
                }

                override fun onActivityPaused(p0: Activity) {}
                override fun onActivityStarted(p0: Activity) {}
                override fun onActivityDestroyed(p0: Activity) {}
                override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {}
                override fun onActivityStopped(p0: Activity) {}
                override fun onActivityResumed(p0: Activity) {}
            })
        }
    }

    private fun inject(activity: Activity) {
        if (activity is Injectable) {
            AndroidInjection.inject(activity)
        }
        if (activity is FragmentActivity) {
            activity.supportFragmentManager
                .registerFragmentLifecycleCallbacks(object :
                    FragmentManager.FragmentLifecycleCallbacks() {
                    override fun onFragmentCreated(
                        fm: FragmentManager,
                        f: Fragment,
                        savedInstanceState: Bundle?
                    ) {
                        super.onFragmentCreated(fm, f, savedInstanceState)

                        if (f is Injectable) {
                            AndroidSupportInjection.inject(f)
                        }
                    }
                }, true)
        }
    }
}