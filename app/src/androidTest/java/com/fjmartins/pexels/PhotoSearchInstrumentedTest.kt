package com.fjmartins.pexels

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.fjmartins.pexels.ui.MainActivity
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PhotoSearchInstrumentedTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.fjmartins.forexrates", appContext.packageName)
    }

    @Test
    fun fragmentHomeDisplayedTest() {
        // Set up
        ActivityScenario.launch(MainActivity::class.java)

        // Verify
        onView(withId(R.id.fragment_home_parent)).check(matches(isDisplayed()))
    }

    @Test
    fun fragmentHomeToolbarDisplayedTest() {
        // Set up
        ActivityScenario.launch(MainActivity::class.java)

        // Verify
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()))
    }

}