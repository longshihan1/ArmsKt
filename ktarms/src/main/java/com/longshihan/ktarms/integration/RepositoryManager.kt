package com.longshihan.ktarms.integration

import android.app.Application
import android.content.Context
import com.longshihan.ktarms.integration.cache.Cache
import com.longshihan.ktarms.integration.cache.CacheType
import com.longshihan.ktarms.utils.Preconditions
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
constructor() : IRepositoryManager {

    @Inject
    internal var mRetrofit: dagger.Lazy<Retrofit>? = null

    @Inject
    internal var mRxCache: dagger.Lazy<RxCache>? = null

    @Inject
    internal var mApplication: Application? = null

    @Inject
    internal var mCachefactory: Cache.Factory? = null

    internal var mRetrofitServiceCache: Cache<String, Any>? = null

    internal var mCacheServiceCache: Cache<String, Any>? = null


    /**
     * 根据传入的 Class 获取对应的 Retrofit service
     *
     * @param service
     * @param <T>
     * @return
     */
    @Synchronized override fun <T> obtainRetrofitService(service: Class<T>): T {
        if (mCacheServiceCache == null)
            mRetrofitServiceCache = mCachefactory!!.build(CacheType.CACHE_SERVICE_CACHE) as Cache<String, Any>
        Preconditions.checkNotNull(mRetrofitServiceCache, "Cannot return null from a Cache.Factory#build(int) method")
        var retrofitService= mRetrofitServiceCache!![service.canonicalName] as T?
        if (retrofitService==null){
            retrofitService=mRetrofit!!.get().create(service)
            mRetrofitServiceCache!!.put(service.canonicalName,retrofitService!!)
        }
        return retrofitService
    }
    /**
     * 根据传入的 Class 获取对应的 RxCache service
     *
     * @param cache
     * @param <T>
     * @return
     */
    @Synchronized override fun <T> obtainCacheService(cache: Class<T>): T {
        if (mCacheServiceCache==null)
            mCacheServiceCache=mCachefactory!!.build(CacheType.CACHE_SERVICE_CACHE) as Cache<String, Any>
        Preconditions.checkNotNull(mCacheServiceCache,"Cannot return null from a Cache.Factory#build(int) method")
        var cacheService= mCacheServiceCache!![cache.canonicalName] as T?
        if (cacheService==null){
            cacheService=mRxCache!!.get().using(cache)
            mCacheServiceCache!!.put(cache.canonicalName,cacheService!!)
        }
        return cacheService
    }

    override fun getContext(): Context= mApplication!!

    /**
     * 清理所有缓存
     */
    override fun clearAllCache() {
        mRxCache!!.get().evictAll()
    }
}