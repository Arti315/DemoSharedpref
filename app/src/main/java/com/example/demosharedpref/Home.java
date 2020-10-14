package com.example.demosharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
TextView textView;
Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textView=findViewById(R.id.tv_user);
        btn1=findViewById(R.id.btn_logout);
        SharedPreferences sharedPreferences=getSharedPreferences("LogIn",MODE_PRIVATE);
        String username=sharedPreferences.getString("username","");
        textView.setText("Welcome to " +username);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("LogIn",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();
                startActivity(new Intent(Home.this,MainActivity.class));
                Toast.makeText(Home.this, "Logout sucessfully", Toast.LENGTH_SHORT).show();
            }
        });

        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
       finishAffinity();
    }
}
