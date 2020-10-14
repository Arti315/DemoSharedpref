package com.example.demosharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.username);
        e2 = findViewById(R.id.userpassword);
        btn = findViewById(R.id.sumbit);
        SharedPreferences sharedPreferences=getSharedPreferences("LogIn",MODE_PRIVATE);
        Boolean log=sharedPreferences.getBoolean("islogged",true);
        if (log){

            startActivity(new Intent(MainActivity.this,Home.class));
        }

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String user = e1.getText().toString();
                String pass = e2.getText().toString();
                if (TextUtils.isEmpty(user)) {
                    e1.setError("Plz the enter username");
                } else if (TextUtils.isEmpty(pass)) {
                    e2.setError("plz Enter the password");

                } else {


                    SharedPreferences sharedPreferences = getSharedPreferences("LogIn", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username",user);
                    editor.putString("userpassword",pass);
                    editor.putBoolean("logged",true);
                    editor.commit();
                    startActivity(new Intent(MainActivity.this, Home.class));
                    Toast.makeText(MainActivity.this, "Login Sucessully", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}