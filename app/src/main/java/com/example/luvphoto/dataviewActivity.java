package com.example.luvphoto;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class dataviewActivity extends AppCompatActivity {
    ListView myListview;
    List<workdetails> workdetailsList;
    DatabaseReference VaaradhiDbref;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dataview);
        myListview = findViewById(R.id.mylistview);

        workdetailsList = new ArrayList<>();
        VaaradhiDbref = FirebaseDatabase.getInstance().getReference("workdetails");

       VaaradhiDbref.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               workdetailsList.clear();

               for(DataSnapshot workdetailsDatasnap : snapshot.getChildren()){

                   workdetails wd = workdetailsDatasnap.getValue(workdetails.class);
                   workdetailsList.add(wd);
               }

               tables adapter = new tables(dataviewActivity.this,workdetailsList);
               myListview.setAdapter(adapter);

           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });

    }
}
