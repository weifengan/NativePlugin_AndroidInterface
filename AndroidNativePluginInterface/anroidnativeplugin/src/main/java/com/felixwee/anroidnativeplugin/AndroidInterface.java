package com.felixwee.anroidnativeplugin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.widget.Toast;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

import java.util.HashMap;

public class AndroidInterface {

    private  Context context=null;
    public  AndroidInterface(Context context){
        this.context=context;
    }

    private  static  AndroidInterface _instance=null;

    public static  AndroidInterface getUnityInstance(){
        if(_instance==null){
            //获取主Activity的Context
            Context ct=UnityPlayer.currentActivity.getApplicationContext();
            _instance=new AndroidInterface(ct);
            Log.d("Unity","AndroidInterface initialized for Unity3D!");
        }
        return _instance;
    }

    public static  AndroidInterface getAndroidInstance(Context appContext){
        if(_instance==null){
            _instance=new AndroidInterface(appContext);
        }
        Log.d("Android","AndroidInterface initialized for Android!");
        return _instance;
    }

    /**
     *  获取AppUtils工具类
     */
    private  AppUtils _appUtils=null;
    public  AppUtils getAppUtils(){
        if(_appUtils==null) {
            _appUtils=new AppUtils(context);
            Log.e("Unity","初始化App工具类AppUtils");
        }
        return _appUtils;
    }


    public  void ShowToast(String str){
        Log.d("Unity","Toast.show"+str);
        Toast.makeText(this.context,str,Toast.LENGTH_SHORT).show();
    }

    public  void Test(){
        Log.d("Unity","测试test"+context);
    }
}
