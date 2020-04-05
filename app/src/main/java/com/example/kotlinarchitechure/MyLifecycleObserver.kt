package com.example.kotlinarchitechure

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyLifecycleObserver : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun OnCreateEvent() {
        Log.i(LOG_VAL, "OnCreate")

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun OnStartEvent() {
        Log.i(LOG_VAL, "OnStart")

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun OnResumeEvent() {
        Log.i(LOG_VAL, "OnResume")

    }

}