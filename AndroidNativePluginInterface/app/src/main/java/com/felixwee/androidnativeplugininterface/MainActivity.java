package com.felixwee.androidnativeplugininterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.felixwee.anroidnativeplugin.AndroidInterface;

public class MainActivity extends AppCompatActivity {

    private TextView txt;
    private  DeviceUtils deviceUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=(TextView)findViewById(R.id.textView);

        Button btn=(Button)findViewById(R.id.button2);



        //初始化
        deviceUtils=new DeviceUtils(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuffer sb=new StringBuffer();
                sb.append("品牌:"+deviceUtils.getBrand());
                sb.append("\n型号:"+deviceUtils.getModel());
                sb.append("\n设备id:"+deviceUtils.getDeviceId());
                sb.append("\nSD卡是否可用:"+deviceUtils.getSDCardAvailable());
                sb.append("\n编译版本:"+deviceUtils.getBuildLevel());
                sb.append("\n网络状态:"+deviceUtils.getNetworkAvaliable());
                sb.append("\n宽高:"+deviceUtils.getDeviceWidth()+"x"+deviceUtils.getDeviceHeight());
                txt.setText(sb.toString());
            }
        });
    }
}
