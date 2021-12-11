package com.example.luvphoto;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class worker extends AppCompatActivity{
    DatabaseReference VaaradhiDbref;

    public static void putExtra(String rtAllot, int allot) {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wokers);
        VaaradhiDbref = FirebaseDatabase.getInstance().getReference("workdetails");
        EditText rtAllot =  findViewById(R.id.rtAllot);
        Button btnAllotWorkers = findViewById(R.id.btnAllotworkers);
        rtAllot.setText(getIntent().getStringExtra("rtAllot"));
        String key = getIntent().getExtras().get("Key").toString();

    }
}
