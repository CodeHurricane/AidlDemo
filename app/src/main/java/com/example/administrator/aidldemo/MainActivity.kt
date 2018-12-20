package com.example.administrator.aidldemo

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.R.attr.name
import android.content.Context
import android.content.pm.ResolveInfo
import java.nio.file.Files.size
import android.content.pm.PackageManager



class MainActivity : AppCompatActivity() {
  lateinit  var iMyAidlInterface:IMyAidlInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent=Intent()
        intent.component=ComponentName("com.example.administrator.aidldemo","com.example.administrator.aidldemo.MyService")
        bindService(intent,object:ServiceConnection{
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service)
            }
            override fun onServiceDisconnected(name: ComponentName?){

            }
        },BIND_AUTO_CREATE)
        tv_hello.setOnClickListener {
           Toast.makeText(this,iMyAidlInterface.name,Toast.LENGTH_LONG).show()
        }
    }


}
