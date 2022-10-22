package com.example.diseasetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    FirebaseAuth fAuth;
    private ListView listView;

    private CustomAdaptor customAdaptor;
    private List<UserInfo> list;
    String uid,s;
    Button b,SignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        user=FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();

        SignOut=(Button) findViewById(R.id.out);
        SignOut.setOnClickListener(this);

        b=findViewById(R.id.sb);
        b.setOnClickListener(this);
        s=getIntent().getExtras().getString("Value");
        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        listView = findViewById(R.id.listView);
        list = new ArrayList<>();
        customAdaptor = new CustomAdaptor(ProfileActivity.this, list);

    }
    protected void onStart ()
    {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                    UserInfo info= dataSnapshot1.getValue(UserInfo.class);
                    if(dataSnapshot1.child("email").getValue(String.class).equals(s))
                        list.add(info);

                }
                listView.setAdapter(customAdaptor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }

    @Override
    public void onClick(View v) {
        if (R.id.sb == v.getId()) {
            Intent intent = new Intent(ProfileActivity.this, symptom.class);
            startActivity(intent);
        }
        else  if(v.getId()==R.id.out)
        {
            Intent intent=new Intent(ProfileActivity.this,LoginActivity.class);
            startActivity(intent);
        }

    }
}



