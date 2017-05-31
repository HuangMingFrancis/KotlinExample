package com.francis.kotlinexample.util.sp

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.francis.kotlinexample.base.App

import com.francis.kotlinexample.base.Constants

import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

/**
 * http://blog.csdn.net/lmj623565791/article/details/38965311
 */

/**
 * @ClassName: MaSPUtils
 * *
 * @Description: SharedPreferences封装类(具体项目中SP的二次封装在ProjectSPUtils中编写)
 * *
 * @author: Felix Shi
 * *
 * @date: 2015-9-21 下午3:06:21
 */
object MaSPUtils {
     val TAG = "MaSPUtils"

    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法

     * @param context
     * *
     * @param key
     * *
     * @param object
     */
    fun put(key: String, `object`: Any?) {
        if (`object` == null) {
            return
        }

        val sp = App.instance.getSharedPreferences(Constants.SharedPreferences.SharedPreferencesName,
                Context.MODE_PRIVATE)
        val editor = sp.edit()

        if (`object` is String) {
            editor.putString(key, `object` as String?)
        } else if (`object` is Int) {
            editor.putInt(key, (`object` as Int?)!!)
        } else if (`object` is Boolean) {
            editor.putBoolean(key, (`object` as Boolean?)!!)
        } else if (`object` is Float) {
            editor.putFloat(key, (`object` as Float?)!!)
        } else if (`object` is Long) {
            editor.putLong(key, (`object` as Long?)!!)
        } else {
            editor.putString(key, `object`.toString())
        }

        SharedPreferencesCompat.apply(editor)
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值

     * @param context
     * *
     * @param key
     * *
     * @param defaultObject
     * *
     * @return
     */
    operator fun get(key: String, defaultObject: Any?): Any? {
        val sp = App.instance.getSharedPreferences(Constants.SharedPreferences.SharedPreferencesName,
                Context.MODE_PRIVATE)
        if (defaultObject == null) {
            return null
        }

        if (defaultObject is String) {
            return sp.getString(key, defaultObject as String?)
        } else if (defaultObject is Int) {
            return sp.getInt(key, (defaultObject as Int?)!!)
        } else if (defaultObject is Boolean) {
            return sp.getBoolean(key, (defaultObject as Boolean?)!!)
        } else if (defaultObject is Float) {
            return sp.getFloat(key, (defaultObject as Float?)!!)
        } else if (defaultObject is Long) {
            return sp.getLong(key, (defaultObject as Long?)!!)
        }

        return null
    }

    /**
     * 移除某个key值已经对应的值

     * @param context
     * *
     * @param key
     */
    fun remove(key: String) {
        val sp = App.instance.getSharedPreferences(Constants.SharedPreferences.SharedPreferencesName,
                Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.remove(key)
        SharedPreferencesCompat.apply(editor)
    }

    /**
     * 清除所有数据

     * @param context
     */
    fun clear() {
        val sp = App.instance.getSharedPreferences(Constants.SharedPreferences.SharedPreferencesName,
                Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.clear()
        SharedPreferencesCompat.apply(editor)
    }

    /**
     * 查询某个key是否已经存在

     * @param context
     * *
     * @param key
     * *
     * @return
     */
    fun contains(key: String): Boolean {
        val sp = App.instance.getSharedPreferences(Constants.SharedPreferences.SharedPreferencesName,
                Context.MODE_PRIVATE)
        return sp.contains(key)
    }

    /**
     * 返回所有的键值对

     * @param context
     * *
     * @return
     */
    fun getAll(): Map<String, *> {
        val sp = App.instance.getSharedPreferences(Constants.SharedPreferences.SharedPreferencesName,
                Context.MODE_PRIVATE)
        return sp.all
    }

    /**
     * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类

     * @author zhy
     */
    private object SharedPreferencesCompat {
        private val sApplyMethod = findApplyMethod()

        /**
         * 反射查找apply的方法

         * @return
         */
        private fun findApplyMethod(): Method? {
            try {
                val clz = SharedPreferences.Editor::class.java
                return clz.getMethod("apply")
            } catch (e: NoSuchMethodException) {
            }

            return null
        }

        /**
         * 如果找到则使用apply执行，否则使用commit

         * @param editor
         */
        fun apply(editor: SharedPreferences.Editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor)
                    return
                }
            } catch (e: IllegalArgumentException) {
            } catch (e: IllegalAccessException) {
            } catch (e: InvocationTargetException) {
            }

            editor.commit()
        }
    }

    /**
     * 示例：设置Xxx
     */
    fun setXxx(value: Boolean) {
        put(Constants.SharedPreferences.XxxKey, value)
        Log.d(TAG, "setXxx(): " + value)
    }

    /**
     * 示例：获取Xxx
     */
    fun getXxx(defValue: Boolean): Boolean {
        val value = (MaSPUtils[Constants.SharedPreferences.XxxKey, defValue] as Boolean?)!!

        Log.d(TAG, "getXxx(): " + value)

        return value
    }
}
