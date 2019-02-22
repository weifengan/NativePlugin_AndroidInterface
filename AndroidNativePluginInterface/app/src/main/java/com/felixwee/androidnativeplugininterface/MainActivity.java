package com.felixwee.androidnativeplugininterface;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.felixwee.anroidnativeplugin.AndroidInterface;
import com.felixwee.anroidnativeplugin.AppUtils;

public class MainActivity extends AppCompatActivity {

    private TextView txt;
    private  DeviceUtils deviceUtils;
    public Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this.getApplicationContext();
        txt=(TextView)findViewById(R.id.textView);

        Button btn=(Button)findViewById(R.id.button2);

        //初始化

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AndroidInterface ai=AndroidInterface.getAndroidInstance(context);
                AppUtils app=ai.getAppUtils();
                app.getAppList(0);
               /* ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                ComponentName cn = am.getRunningTasks(1).get(0).topActivity;


                Log.e("wfa", "pkg:"+cn.getPackageName());
                Log.e("wfa", "cls:"+cn.getClassName());*/

                //AppUtils app=a1.getAppUtlis();
                //app.startAppPackage("cn.gloud.client");
                /*
                StringBuffer sb=new StringBuffer();
                sb.append("品牌:"+deviceUtils.getBrand());
                sb.append("\n型号:"+deviceUtils.getModel());
                sb.append("\n设备id:"+deviceUtils.getDeviceId());
                sb.append("\nSD卡是否可用:"+deviceUtils.getSDCardAvailable());
                sb.append("\n编译版本:"+deviceUtils.getBuildLevel());
                sb.append("\n网络状态:"+deviceUtils.getNetworkAvaliable());
                sb.append("\n宽高:"+deviceUtils.getDeviceWidth()+"x"+deviceUtils.getDeviceHeight());
                txt.setText(sb.toString());*/
            }
        });
    }

    public void StartAppByPackageName(String packageName){

    }

}
