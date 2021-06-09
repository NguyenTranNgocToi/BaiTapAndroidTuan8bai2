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


public class register extends AppCompatActivity {
    EditText ed_name, ed_maill,ed_pass1,ed_pass2;
    Button btn_register;
    TextView tv_signin;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regiter);
        mAuth = FirebaseAuth.getInstance();
        ed_name=findViewById(R.id.ed_regiter_name);
        ed_maill=findViewById(R.id.ed_regiter_mail);
        ed_pass1=findViewById(R.id.ed_regiter_pass1);
        ed_pass2=findViewById(R.id.ed_regiter_pass2);
        tv_signin=findViewById(R.id.tv_regiter_signin);
        btn_register=findViewById(R.id.btn_regiter_regiter);
        tv_signin.setOnClickListener(view->{
            startActivity(new Intent(register.this, signin.class));
        });

        btn_register.setOnClickListener(view->{
            createUser();
        });
    }
    private  void createUser(){
        String email = ed_maill.getText().toString();
        String password = ed_pass1.getText().toString();
        String pass2 =ed_pass2.getText().toString();
        if(password.equalsIgnoreCase(pass2)){
            if(email.equalsIgnoreCase(null)){
                Toast.makeText(register.this,"Chua nhap email",Toast.LENGTH_SHORT).show();
            }
            else if(password.equalsIgnoreCase(null)){
                Toast.makeText(register.this,"Chua nhap pass",Toast.LENGTH_SHORT).show();
            }
            else{
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(register.this,"Dang ki thanh cong",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(register.this,signin.class));
                        }else{
                            Toast.makeText(register.this,"Dang ki that bai",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }else {
            Toast.makeText(register.this,"pass không trùng nhau",Toast.LENGTH_SHORT).show();
        }


    }
}