package com.fjmartins.pexels.base

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
open class BaseUnitTest {

    val context: Context = ApplicationProvider.getApplicationContext()
}