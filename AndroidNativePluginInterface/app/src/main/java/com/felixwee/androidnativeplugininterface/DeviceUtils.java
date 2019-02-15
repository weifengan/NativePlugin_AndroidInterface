package com.felixwee.androidnativeplugininterface;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;

import java.util.UUID;

public class DeviceUtils {
    private Context context;

    public DeviceUtils(Context context) {
        this.context = context;
    }

    public String getBrand() {
        return Build.BRAND;
    }

    public String getModel() {
        return Build.MODEL;
    }

    //Android API等级
    public int getBuildLevel() {
        return android.os.Build.VERSION.SDK_INT;
    }

    public  String getBuildVersion(){
        return Build.VERSION.RELEASE;
    }

    public  String getDeviceId(){
        return Build.DEVICE.toString();
    }

     //设备宽度
     public  int getDeviceWidth(){
         return context.getResources().getDisplayMetrics().widthPixels;
     }

     //设备高度
     public  int getDeviceHeight(){
         return context.getResources().getDisplayMetrics().heightPixels;
     }

     //SD卡是否可用
    public boolean getSDCardAvailable() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }
     public boolean getNetworkAvaliable(){
         ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                 .getSystemService(Context.CONNECTIVITY_SERVICE);
         NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
         if (mNetworkInfo != null) {
             return mNetworkInfo.isAvailable();
         }
         return false;
     }


}
