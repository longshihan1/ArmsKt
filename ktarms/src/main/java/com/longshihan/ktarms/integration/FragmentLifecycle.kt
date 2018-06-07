package com.longshihan.ktarms.integration

import android.support.v4.app.FragmentManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FragmentLifecycle @Inject
constructor(): FragmentManager.FragmentLifecycleCallbacks()