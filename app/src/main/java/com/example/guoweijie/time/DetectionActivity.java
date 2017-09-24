package com.example.guoweijie.time;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class DetectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detection);
        Button Start = (Button)findViewById(R.id.start);
        Button Stop = (Button)findViewById(R.id.stop);
        Start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                anyMethod();
                Intent intent = new Intent(DetectionActivity.this,DetectionService.class);
                startService(intent);

            }

        });
        Stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                Intent intent = new Intent(DetectionActivity.this,DetectionService.class);
                Log.d("DetectionActivity","stop1");
                stopService(intent);
            }
        });
    }
    final static String TAG = "AccessibilityUtil";


    // 此方法用来判断当前应用的辅助功能服务是否开启
    public static boolean isAccessibilitySettingsOn(Context context) {
        int accessibilityEnabled = 0;
        try {
            accessibilityEnabled = Settings.Secure.getInt(context.getContentResolver(),
                    android.provider.Settings.Secure.ACCESSIBILITY_ENABLED);
        } catch (Settings.SettingNotFoundException e) {
            Log.i(TAG, e.getMessage());
        }

        if (accessibilityEnabled == 1) {
            String services = Settings.Secure.getString(context.getContentResolver(),
                    Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
            if (services != null) {
                return services.toLowerCase().contains(context.getPackageName().toLowerCase());
            }
        }

        return false;
    }

    private void anyMethod() {
        // 判断辅助功能是否开启
        if (!isAccessibilitySettingsOn(getApplicationContext())) {
            // 引导至辅助功能设置页面
            startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
        } else {
            // 执行辅助功能服务相关操作
        }
    }

}

