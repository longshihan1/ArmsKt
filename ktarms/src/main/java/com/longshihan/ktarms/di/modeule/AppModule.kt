package com.longshihan.ktarms.di.modeule

import android.app.Application
import android.app.FragmentManager
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.longshihan.ktarms.integration.ActivityLifecycle
import com.longshihan.ktarms.integration.FragmentLifecycle
import com.longshihan.ktarms.integration.RepositoryManager
import com.longshihan.ktarms.integration.cache.Cache
import com.longshihan.ktarms.integration.cache.CacheType
import com.longshihan.ktarms.integration.lifecycle.ActivityLifecycleForRxLifecycle
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by LONGHE001.
 * @time 2018/6/1 0001
 * @des
 * @function
 */

@Module
abstract class AppModule {
    companion object {
        @Singleton
        @Provides
        open fun provideGson(application: Application, configuration: GsonConfiguration): Gson {
            var build = GsonBuilder()
            configuration!!.configGson(application, build)
            return build.create()
        }

        @Singleton
        @Provides
        internal fun provideExtras(cacheFactory: Cache.Factory): Cache<*, *> {
            return cacheFactory.build(CacheType.EXTRAS)
        }

        @Singleton
        @Provides
        fun provideFragmentLifecycles():List<FragmentManager.FragmentLifecycleCallbacks>{
            return ArrayList()
        }

    }


    @Binds
    internal abstract fun bindRepositoryManager(repositoryManager: RepositoryManager)


    @Binds
    @Named("ActivityLifecycle")
    internal abstract fun bindActivityLifecycle(activityLifecycle: ActivityLifecycle): Application.ActivityLifecycleCallbacks

    @Binds
    @Named("ActivityLifecycleForRxLifecycle")
    internal abstract fun bindActivityLifecycleForRxLifecycle(activityLifecycleForRxLifecycle: ActivityLifecycleForRxLifecycle): Application.ActivityLifecycleCallbacks

    @Binds
    internal abstract fun bindFragmentLifecycle(fragmentLifecycle: FragmentLifecycle): android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks
    interface GsonConfiguration {
        fun configGson(context: Context, builder: GsonBuilder)
    }
}
