package com.example.diseasetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class csymptom3 extends AppCompatActivity implements ValueEventListener {
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference=firebaseDatabase.getReference();
    private DatabaseReference firstDatabase=databaseReference.child("Symptom2");
    private DatabaseReference firstDatabase2=databaseReference.child("dsymptom2");
    private DatabaseReference firstDatabase3=databaseReference.child("tsymptom2");
    private DatabaseReference firstDatabase4=databaseReference.child("jsymptom2");
    private DatabaseReference firstDatabase5=databaseReference.child("asymptom2");

    private RadioButton sa,sb,sc,sd,se;
    private Button done3,SignOut;
    private RadioGroup radioGroup3;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csymptom3);
        this.setTitle("symptom3");
        sa=findViewById(R.id.cosymptomI);
        sb=findViewById(R.id.cosymptomJ);
        sc=findViewById(R.id.cosymptomK);
        sd=findViewById(R.id.cosymptomL);
        se=findViewById(R.id.cosymptomM);
        done3=findViewById(R.id.done3);
        done3=findViewById(R.id.done3);
        SignOut=(Button) findViewById(R.id.out);
        SignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(csymptom3.this,LoginActivity.class);
                startActivity(intent);
            }
        });


        radioGroup3=(RadioGroup)findViewById(R.id.radioGroup3);
        done3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedId3=radioGroup3.getCheckedRadioButtonId();
                findRadioButton3(checkedId3);
            }
        });
    }
    private void findRadioButton3(int checkedId3) {
        switch (checkedId3)
        {
            case R.id.cosymptomI:
            {
                Intent intenti = new Intent(csymptom3.this, result.class);
                st=sa.getText().toString();
                intenti.putExtra("Value",st);
                startActivity(intenti);
                break;
            }
            case R.id.cosymptomJ:
            {
                Intent intentj = new Intent(csymptom3.this, result.class);
                st=sb.getText().toString();
                intentj.putExtra("Value",st);
                startActivity(intentj);
                break;
            }
            case R.id.cosymptomK:
            {
                Intent intentk = new Intent(csymptom3.this, result.class);
                st=sc.getText().toString();
                intentk.putExtra("Value",st);
                startActivity(intentk);
                break;
            }
            case R.id.cosymptomL:
            {
                Intent intentl = new Intent(csymptom3.this, result.class);
                st=sd.getText().toString();
                intentl.putExtra("Value",st);
                startActivity(intentl);
                break;
            }
            case R.id.cosymptomM:
            {
                Intent intentm = new Intent(csymptom3.this, result.class);
                st=se.getText().toString();
                intentm.putExtra("Value",st);
                startActivity(intentm);
                break;
            }
        }


    }




    public void onDataChange(DataSnapshot dataSnapshot)
    {
        if(dataSnapshot.getValue(String.class)!=null){
            String key=dataSnapshot.getKey();

            if(key.equals("Symptom2")) {
                String firsti = dataSnapshot.getValue(String.class);
                sa.setText(firsti);
            }
            if(key.equals("dsymptom2")) {
                String firstj = dataSnapshot.getValue(String.class);
                sb.setText(firstj);
            }
            if(key.equals("tsymptom2")) {
                String firstk = dataSnapshot.getValue(String.class);
                sc.setText(firstk);
            } if(key.equals("jsymptom2")) {
                String firstl = dataSnapshot.getValue(String.class);
                sd.setText(firstl);
            }if(key.equals("asymptom2")) {
                String firstm = dataSnapshot.getValue(String.class);
                se.setText(firstm);
            }

        }




    }
    public void onCancelled(DatabaseError databaseError)
    {


    }
    protected void onStart(){
        super.onStart();
        firstDatabase.addValueEventListener(this);
        firstDatabase2.addValueEventListener(this);
        firstDatabase3.addValueEventListener(this);
        firstDatabase4.addValueEventListener(this);
        firstDatabase5.addValueEventListener(this);

    }

}