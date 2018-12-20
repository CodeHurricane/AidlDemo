package com.example.administrator.aidldemo

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyService : Service() {
    //在onBind中返回自定义的Binderd对象，自定义的Binder类继承生成接口的内部类，自己实现接口的方法
    override fun onBind(intent: Intent): IBinder {
       return MyBinder()
    }
    class MyBinder: IMyAidlInterface.Stub(){
        override fun getName(): String {
                 return "MyService"
        }
    }
}
