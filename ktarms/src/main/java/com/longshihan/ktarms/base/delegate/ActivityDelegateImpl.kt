package com.longshihan.ktarms.base.delegate
import android.app.Activity
import android.os.Bundle
/**
 * Created by LONGHE001.
 * @time 2018/5/31 0031
 * @des
 * {@link ActivityDelegate} 默认实现类
 * @function
 */



class ActivityDelegateImpl(private var mActivity: Activity?) :ActivityDelegate {
//    private var iActivity:IA
    override fun onStart() {
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun onStop() {
    }

    override fun onSaveInstanceState(outState: Bundle) {
    }

    override fun onDestroy() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
    }

}