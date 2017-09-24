package com.example.guoweijie.time;

import android.content.Intent;
import android.support.annotation.FloatRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button FLoatingWindow = (Button)findViewById(R.id.Window);
        Button Detection      = (Button)findViewById(R.id.Detection);

        FLoatingWindow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,WindowActivity.class);
                startActivity(intent);
            }
        });
        Detection.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,DetectionActivity.class);
                startActivity(intent);
            }
        });


    }
}
