package com.example.firebase2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class  signin extends AppCompatActivity {
    Button btnsignin;
    EditText edmaill,edpass;
    TextView tvregister;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        mAuth = FirebaseAuth.getInstance();
        btnsignin = findViewById(R.id.btn_signin_signin);
        edmaill=findViewById(R.id.ed_signin_email);
        edpass=findViewById(R.id.ed_signin_pass);
        tvregister=findViewById(R.id.tv_signin_regiter);

        tvregister.setOnClickListener(view->{
            startActivity(new Intent(signin.this,register.class));
        });

        btnsignin.setOnClickListener(view->{
            loginUser();
        });


    }


    private void loginUser() {
        String email = edmaill.getText().toString();
        String passWord =  edpass.getText().toString();
        if(email.equalsIgnoreCase(null)){
            Toast.makeText(signin.this,"Chua nhap email",Toast.LENGTH_SHORT).show();
        }else if(passWord.equalsIgnoreCase(null)){
            Toast.makeText(signin.this,"Chua nhap mat khau",Toast.LENGTH_SHORT).show();
        }else{
            mAuth.signInWithEmailAndPassword(email,passWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(signin.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(signin.this,touch.class));
                    }   else {
                        Toast.makeText(signin.this,"Sai tên tài khoản hoặc mật khẩu",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}