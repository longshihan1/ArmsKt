package com.longshihan.ktarms.base.delegate

import okhttp3.Cache

/**
 * Created by LONGHE001.
 * @time 2018/5/31 0031
 * @des 框架要求框架中的每个 {@link Activity} 都需要实现此类,以满足规范
 * @function
 */

interface IActivity{
    fun provideCache():Cache
}