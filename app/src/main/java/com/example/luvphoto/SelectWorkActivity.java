package com.example.luvphoto;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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

import java.util.ArrayList;
import java.util.List;

public class SelectWorkActivity extends AppCompatActivity{


    ListView myListview;
    List<workdetails> workdetailsList;
    DatabaseReference VaaradhiDbref;
    DatabaseReference LoginDbref;

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selctwork);
        myListview = findViewById(R.id.mylistview);

        workdetailsList = new ArrayList<>();
        VaaradhiDbref = FirebaseDatabase.getInstance().getReference("workdetails");
        LoginDbref = FirebaseDatabase.getInstance().getReference("User");
        VaaradhiDbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                workdetailsList.clear();

                for(DataSnapshot workdetailsDatasnap : snapshot.getChildren()){

                    workdetails wd = workdetailsDatasnap.getValue(workdetails.class);
                    workdetailsList.add(wd);
                }

                tables adapter = new tables(SelectWorkActivity.this,workdetailsList);
                myListview.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        myListview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                workdetails pwd = workdetailsList.get(position);
                int x = pwd.getAllot();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        showallotwork(pwd.getwid(),pwd.getId(),pwd.getNw(),pwd.getLocation(),pwd.getWorktype(),x);
                    }
                },1000);

                return false;
            }
        });

    }

    private void showallotwork(String wid, String id, int nw, String loc, String type,int x){
        final AlertDialog.Builder mDialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View mDialogView = inflater.inflate(R.layout.wokers,null);

        mDialog.setView(mDialogView);

        EditText rtAllot = mDialogView.findViewById(R.id.rtAllot);
        Button btnAllotworkers = mDialogView.findViewById(R.id.btnAllotworkers);

        mDialog.setTitle("Alloting the workers");
        mDialog.show();

        btnAllotworkers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Integer newallot = Integer.parseInt(rtAllot.getText().toString());
                if(newallot>(nw-x))
                {
                    rtAllot.setError("Required value is "+(nw-x));
                }else{
                    updatedata(wid,newallot+x,id,nw,loc,type);
                    Toast.makeText(SelectWorkActivity.this,"Work Alloted",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    private void updatedata(String wid, int allot, String id, int nw, String loc, String type){
        DatabaseReference Dbref = FirebaseDatabase.getInstance().getReference("workdetails").child(id);
        workdetails wd = new workdetails(wid,allot,id,nw,loc,type);
        Dbref.setValue(wd);

    }
}
