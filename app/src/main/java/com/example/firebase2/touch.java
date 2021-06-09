package com.example.firebase2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class touch  extends AppCompatActivity {
    Button btn_touch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.touch);
        btn_touch=findViewById(R.id.btn_touch_finsh);
        btn_touch.setOnClickListener(view->{
            startActivity(new Intent(touch.this, begin.class));
        });
    }
}