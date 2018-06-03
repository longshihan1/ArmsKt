package com.longshihan.ktarms.base.delegate

import android.support.annotation.NonNull
import com.longshihan.ktarms.integration.cache.Cache
import java.util.*


/**
 * Created by LONGHE001.
 * @time 2018/5/31 0031
 * @des 框架要求框架中的每个 {@link Activity} 都需要实现此类,以满足规范
 * @function
 */

interface IActivity{
    /**
     * 提供在 {@link Activity} 生命周期内的缓存容器, 可向此 {@link Activity} 存取一些必要的数据
     * 此缓存容器和 {@link Activity} 的生命周期绑定, 如果 {@link Activity} 在屏幕旋转或者配置更改的情况下
     * 重新创建, 那此缓存容器中的数据也会被清空, 如果你想避免此种情况请使用 <a href="https://github.com/JessYanCoding/LifecycleModel">LifecycleModel</a>
     *
     * @return like {@link LruCache}
     */
    @NonNull
    fun provideCache(): Cache<String,Any>


}