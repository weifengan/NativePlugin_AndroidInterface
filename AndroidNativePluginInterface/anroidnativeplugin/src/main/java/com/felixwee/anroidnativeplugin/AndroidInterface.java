package com.felixwee.anroidnativeplugin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.widget.Toast;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

public class AndroidInterface {

    private  Context context=null;
    public  AndroidInterface(Context context){
        this.context=context;
    }

    private  static  AndroidInterface _instance=null;
    public static  AndroidInterface GetInstance(){
        if(_instance==null){
            //获取主Activity的Context
            Context ct=UnityPlayer.currentActivity.getApplicationContext();
            _instance=new AndroidInterface(ct);
        }
        Log.d("Unity","初始化AndroidInterface ok");
        return _instance;
    }

    public  void ShowToast(String str){
        Log.d("Unity","Toast.show"+str);
        Toast.makeText(this.context,str,Toast.LENGTH_SHORT).show();
    }

    public  void Test(){
        Log.d("Unity","测试test");
    }
}
