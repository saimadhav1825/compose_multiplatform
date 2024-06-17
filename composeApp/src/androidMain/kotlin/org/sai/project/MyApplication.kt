package org.sai.project

import android.app.Application

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Logger.init()
    }
}
