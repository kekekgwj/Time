package com.example.guoweijie.time;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;



public class WindowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window);
        Button Start = (Button)findViewById(R.id.start);
        Button Remove = (Button)findViewById(R.id.remove);

        Start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                if (Build.VERSION.SDK_INT >= 23) {
                    if(!Settings.canDrawOverlays(getApplicationContext())) {
                        //启动Activity让用户授权
                        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                        startActivity(intent);
                        return;
                    } else {
                        //执行6.0以上绘制代码
                    }
                } else {
                    //执行6.0以下绘制代码
                }
                Intent intent = new Intent(WindowActivity.this, WindowService.class);
                //启动MyService
                startService(intent);
                finish();}

        });
        Remove.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(WindowActivity.this, WindowService.class);
                //启动MyService
                stopService(intent);
            }

        });
    }
}

