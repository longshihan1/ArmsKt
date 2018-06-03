package com.longshihan.ktarms.integration

import android.app.Application
import android.app.Presentation
import android.content.Context
import android.support.v4.util.Preconditions
import com.longshihan.ktarms.integration.cache.Cache
import com.longshihan.ktarms.integration.cache.CacheType
import io.rx_cache2.internal.ProcessorProviders
import io.rx_cache2.internal.RxCache
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by LONGHE001.
 * @time 2018/6/1 0001
 * @des
 * @function
 */

@Singleton
class RepositoryManager @Inject
constructor():IRepositoryManager{

    @Inject
    internal var mRetrofit:Lazy<Retrofit>?=null

    @Inject
    internal var mRxCache:Lazy<RxCache>?=null

    @Inject
    internal var mApplication:Application?=null

    @Inject
    internal var mCachefactory: Cache.Factory?=null

    internal var mRetrofitServiceCache:Cache<String,Any>?=null

    internal var mCacheServiceCache:Cache<String,Any>?=null


    override fun  <T> obtainRetrofitService(service: Class<T>): T {
        if (mCacheServiceCache==null)
            mRetrofitServiceCache= mCachefactory?.build(CacheType.CACHE_SERVICE_CACHE) as Cache<String, Any>?
        Preconditions.checkNotNull(mRetrofitServiceCache,"Cannot return null from a Cache.Factory#build(int) method")
    }

    override fun <T> obtainCacheService(cache: Class<T>): T {
    }

    override fun getContext(): Context {
    }

    override fun clearAllCache() {
    }
}