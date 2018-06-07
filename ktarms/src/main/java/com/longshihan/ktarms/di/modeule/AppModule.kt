package com.longshihan.ktarms.di.modeule

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.longshihan.ktarms.integration.RepositoryManager
import com.longshihan.ktarms.integration.cache.Cache
import com.longshihan.ktarms.integration.cache.CacheType
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by LONGHE001.
 * @time 2018/6/1 0001
 * @des
 * @function
 */

@Module
abstract class AppModule {
    @Singleton
    @Provides
    open fun provideGson(application: Application, configuration: GsonConfiguration): Gson {
        var build = GsonBuilder()
        configuration!!.configGson(application, build)
        return build.create()
    }

//    open fun provideExtras(cacheFactory: Cache.Factory): Cache<String, Any> {
//        return cacheFactory.build(CacheType.EXTRAS)
//    }

    @Binds
    internal abstract fun bindRepositoryManager(repositoryManager: RepositoryManager)


    interface GsonConfiguration {
        fun configGson(context: Context, builder: GsonBuilder)
    }
}
