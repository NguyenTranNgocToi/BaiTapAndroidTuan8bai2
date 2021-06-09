package com.example.firebase2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class  begin extends AppCompatActivity {
    Button btnsignin,btnregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.begin);
        btnsignin = findViewById(R.id.btn_begin_signin);
        btnregister=findViewById(R.id.btn_begin_register);
        btnregister.setOnClickListener(view->{
           startActivity(new Intent(begin.this, register.class));
        });
        btnsignin.setOnClickListener(view->{
            startActivity(new Intent(begin.this, signin.class));
        });
    }
}