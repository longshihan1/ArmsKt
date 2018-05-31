package com.longshihan.ktarms.integration.cache

import android.support.annotation.NonNull

/**
 * Created by LONGHE001.
 * @time 2018/5/31 0031
 * @des
 * @function
 */
interface Cache<K,V>{
    interface Factory{
         /**
         * Returns a new cache
         *
         * @param type 框架中需要缓存的模块类型
         * @return {@link Cache}
         */
        @NonNull
       fun  build(type:CacheType):Cache<*,*>
    }
    /**
     * 返回当前缓存已占用的总 size
     *
     * @return {@code size}
     */
    fun size():Int
    /**
     * 返回当前缓存所能允许的最大 size
     *
     * @return {@code maxSize}
     */
    fun getMaxSize():Int

    operator fun get(key:K):V?


}