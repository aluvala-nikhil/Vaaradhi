package com.example.luvphoto;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class classifyActivity extends AppCompatActivity {
    Button btnLoginOwner;
    Button btnLoginWorker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claasify);
        btnLoginOwner = findViewById(R.id.btnLoginOwner);
        btnLoginWorker = findViewById(R.id.btnLoginWorker);



        btnLoginWorker.setOnClickListener(view->
        {
            startActivity(new Intent(classifyActivity.this, LoginActivity.class));
        });

        btnLoginOwner.setOnClickListener(view->{
            startActivity(new Intent(classifyActivity.this, LoginActivity.class));
        });
    }
}
