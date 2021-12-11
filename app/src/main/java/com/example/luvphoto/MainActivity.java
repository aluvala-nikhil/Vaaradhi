package com.example.luvphoto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button btnLogOut;
    Button btnAddWork;
    Button btnSelectWork;
    Button btnSeeWork;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogOut = findViewById(R.id.btnLogout);
        btnSelectWork = findViewById(R.id.btnSelectWork);
        btnAddWork = findViewById(R.id.btnAddWork);
        btnSeeWork = findViewById(R.id.btnSeeWork);
        btnSelectWork = findViewById(R.id.btnSelectWork);
        mAuth = FirebaseAuth.getInstance();

        btnLogOut.setOnClickListener(view ->{
            mAuth.signOut();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });
        btnAddWork.setOnClickListener(view -> {
                    startActivity(new Intent(MainActivity.this, AddWorkActivity.class));
                });
        btnSeeWork.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity.this, dataviewActivity.class));
        });
        btnSelectWork.setOnClickListener(view ->{
            startActivity(new Intent(MainActivity.this, SelectWorkActivity.class));
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }
}