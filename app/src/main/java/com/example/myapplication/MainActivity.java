package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity<button> extends AppCompatActivity {
View view;
EditText etUsername;
EditText etPassowrd;
Button btnLogin;
TextView tvRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view= this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.colorGreen);

        etUsername =(EditText)findViewById(R.id.etUsername);
        etPassowrd = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        tvRegister = (TextView)findViewById(R.id.tvRegister);

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, DrawerActivity.class);
                startActivity(registerIntent);
            }
        });
    }
}
