package com.felixwee.anroidnativeplugin;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.DebugUtils;
import android.util.Log;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class AppUtils{
    private  Context context;
    public AppUtils(Context context) {
        this.context=context;
    }

    /**
     * 通过APk包名启动apk
     * @param packageName  包名
     */
    public void startApp(String packageName){
        Log.e("Unity","startactivity="+packageName);
        PackageManager packageManager = context.getPackageManager();
        Intent intent=new Intent();
        intent =packageManager.getLaunchIntentForPackage(packageName);
        if(intent==null){
            Toast.makeText(context, "未安装APK:"+packageName+"", Toast.LENGTH_LONG).show();
        }else{
            context.startActivity(intent);
        }
    }

    /**
     * 根据类型获取APK列表
     * @param type  0-所有package 1-系统应用 2-第三方应用  3-SDCard应用
     */
    public void getAppList(int type){
        PackageManager pm = context.getPackageManager();
        List<ApplicationInfo> applicationInfos=pm.getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);
        //排序
        Collections.sort(applicationInfos,new ApplicationInfo.DisplayNameComparator(pm));

        for (ApplicationInfo appinfo: applicationInfos){
            String appName;
            String packageName;
            switch (type) {
                case 0: //所有
                    appName = appinfo.loadLabel(pm).toString();// 应用名
                    packageName = appinfo.packageName;// 包名
                    Log.d("Unity", "应用名：" + appName + "包名：" + packageName);
                    break;
                case 1: //系统应用
                    if ((appinfo.flags & appinfo.FLAG_SYSTEM) != 0) {
                        appName = appinfo.loadLabel(pm).toString();// 应用名
                        packageName = appinfo.packageName;// 包名
                        Log.d("Unity", "应用名：" + appName + "包名：" + packageName);
                    }
                case 2: //第三方应用
                    // 非系统应用
                    if ((appinfo.flags & ApplicationInfo.FLAG_SYSTEM) <= 0) {
                        appName = appinfo.loadLabel(pm).toString();// 应用名
                        packageName = appinfo.packageName;// 包名
                        Log.d("Unity", "应用名：" + appName + "包名：" + packageName);
                    }
                    // 系统应用，但更新后变成不是系统应用了
                    else if ((appinfo.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0) {
                        appName = appinfo.loadLabel(pm).toString();// 应用名
                        packageName = appinfo.packageName;// 包名
                        Log.d("Unity", "应用名：" + appName + "包名：" + packageName);
                    }
                    break;
                case 3:
                    if (appinfo.FLAG_SYSTEM==ApplicationInfo.FLAG_SYSTEM){
                        appName = appinfo.loadLabel(pm).toString();// 应用名
                        packageName = appinfo.packageName;// 包名
                        Log.d("Unity", "应用名：" + appName + "包名：" + packageName);
                    }
                    break;
            }
        }
    }

    /**
     * 卸载程序
     * @param packageName
     */
    public void unInstallApp(String packageName){
        //检测apk是否存在
        if(packageName==null || packageName.equals("")){
            Log.d("Unity","不正確的apk包名");
            return;
        }
        try{
            //查找apk
            Intent intent=context.getPackageManager().getLaunchIntentForPackage(packageName);
            if(intent!=null){
                Uri packageURI = Uri.parse("package:".concat(packageName));
                intent = new Intent(Intent.ACTION_DELETE);
                intent.setData(packageURI);
                context.startActivity(intent);
            }else{
                Log.d("Unity","未找到要卸载的apk"+packageName);
            }
        }catch (Exception e) {
            Log.d("Unity", e.getMessage());
        }
    }

    /**
     *
     * @param apkPath
     */
    public  void installApp(String apkPath){

    }







}
