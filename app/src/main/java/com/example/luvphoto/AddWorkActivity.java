package com.example.luvphoto;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddWorkActivity extends AppCompatActivity{
    Spinner spinnerWorkType;
    Spinner spinnerLocation;
    EditText rtwid;
    EditText rtName;
    EditText rtnw;
    int allot=0;
    int rw=0;
    Button btnWorkDt;
    DatabaseReference VaaradhiDbRef;
    DatabaseReference LoginDbref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addwork);
        rtnw = findViewById(R.id.rtnw);
        rtwid = findViewById(R.id.rtwid);
        spinnerLocation = findViewById(R.id.spinnerLocation);
        spinnerWorkType = findViewById(R.id.spinnerWorkType);
        rtName = findViewById(R.id.rtName);
        btnWorkDt = findViewById(R.id.btnWorkDt);
        VaaradhiDbRef = FirebaseDatabase.getInstance().getReference().child("workdetails");
        LoginDbref = FirebaseDatabase.getInstance().getReference().child("User");

        btnWorkDt.setOnClickListener(view -> {
            insertWorkData();
        });

    }
    private boolean checkrole(){
        String Name = rtName.getText().toString();
        return true;
    }
    private void insertWorkData(){
        String Wid = rtwid.getText().toString();
        String Location = spinnerLocation.getSelectedItem().toString();
        String WorkType = spinnerWorkType.getSelectedItem().toString();
        Integer Rtnw = Integer.parseInt(rtnw.getText().toString());



        String t = VaaradhiDbRef.push().getKey();
        workdetails work=new workdetails(Wid,Rtnw,WorkType,Location,t);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                VaaradhiDbRef.child(t).setValue(work);
            }
        },1000);
        Toast.makeText(AddWorkActivity.this,"Data inserted",Toast.LENGTH_SHORT).show();
    }


}
