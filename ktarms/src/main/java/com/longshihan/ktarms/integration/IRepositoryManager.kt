package com.longshihan.ktarms.integration

import android.content.Context
import okhttp3.Cache

/**
 * Created by LONGHE001.
 * @time 2018/6/1 0001
 * @des
 * 用来管理网络请求层,以及数据缓存层,以后可能添加数据库请求层
 * 提供给 {@link IModel} 必要的 Api 做数据处理
 * @function
 */

interface IRepositoryManager{
    /**
     * 根据传入的 Class 获取对应的 Retrofit service
     *
     * @param service
     * @param <T>
     * @return
    */
    fun <T> obtainRetrofitService(service:Class<T>):T
    /**
     * 根据传入的 Class 获取对应的 RxCache service
     *
     * @param cache
     * @param <T>
     * @return
     */
    fun <T> obtainCacheService(cache: Class<T>):T

    fun getContext():Context
    fun clearAllCache()
}