package com.longshihan.ktarms.base.delegate

import android.os.Bundle

/**
 * Created by LONGHE001.
 * @time 2018/5/31 0031
 * @des
 *  ================================================
 * [Activity] 代理类,用于框架内部在每个 [Activity] 的对应生命周期中插入需要的逻辑
 *
 * @see ActivityDelegateImpl
 * @function
 */
interface ActivityDelegate {
    companion object {
        val LAYOUT_LINEARLAYOUT = "LinearLayout"
        val LAYOUT_FRAMELAYOUT = "FrameLayout"
        val LAYOUT_RELATIVELAYOUT = "RelativeLayout"
        val ACTIVITY_DELEGATE = "ACTIVITY_DELEGATE"
    }

    fun onCreate(savedInstanceState: Bundle?)

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onSaveInstanceState(outState: Bundle)

    fun onDestroy()
}