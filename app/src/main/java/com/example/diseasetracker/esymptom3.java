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

public class esymptom3 extends AppCompatActivity implements ValueEventListener {
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference=firebaseDatabase.getReference();
    //  private DatabaseReference firstDatabase=databaseReference.child("Symptom2");
    private DatabaseReference firstDatabase2=databaseReference.child("uvesymptom2");
    private DatabaseReference firstDatabase3=databaseReference.child("drysymptom2");
    private DatabaseReference firstDatabase4=databaseReference.child("catsymptom2");
    private DatabaseReference firstDatabase5=databaseReference.child("ectsymptom2");

    private RadioButton s1,s2,s3,s4,s5;
    private Button done2,SignOut;
    private RadioGroup radioGroup1;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esymptom3);
        this.setTitle("symptom3");
        //    s1=findViewById(R.id.cosymptom11);
        s2=findViewById(R.id.cosymptomA);
        s3=findViewById(R.id.cosymptomB);
        s4=findViewById(R.id.cosymptomC);
        s5=findViewById(R.id.cosymptomD);
        done2=findViewById(R.id.done2);
        SignOut=(Button) findViewById(R.id.out);
        SignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(esymptom3.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        radioGroup1=(RadioGroup)findViewById(R.id.radioGroup1);
        done2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedId1=radioGroup1.getCheckedRadioButtonId();
                findRadioButton1(checkedId1);
            }
        });
    }
    private void findRadioButton1(int checkedId1) {
        switch (checkedId1)
        {
            case R.id.cosymptomA:
            {
                Intent intenta = new Intent(esymptom3.this, result.class);
                st=s2.getText().toString();
                intenta.putExtra("Value",st);
                startActivity(intenta);
                break;
            }
            case R.id.cosymptomB:
            {
                Intent intentb = new Intent(esymptom3.this, result.class);
                st=s3.getText().toString();
                intentb.putExtra("Value",st);
                startActivity(intentb);
                break;
            }
            case R.id.cosymptomC:
            {
                Intent intentc = new Intent(esymptom3.this, result.class);
                st=s4.getText().toString();
                intentc.putExtra("Value",st);
                startActivity(intentc);
                break;
            }
            case R.id.cosymptomD:
            {
                Intent intentd = new Intent(esymptom3.this, result.class);
                st=s5.getText().toString();
                intentd.putExtra("Value",st);
                startActivity(intentd);
                break;
            }
        }


    }




    public void onDataChange(DataSnapshot dataSnapshot)
    {
        if(dataSnapshot.getValue(String.class)!=null){
            String key=dataSnapshot.getKey();
          /*  if(key.equals("Symptom2")) {
                String first = dataSnapshot.getValue(String.class);
                s1.setText(first);
                //st=s1.getText().toString();

            }*/
            if(key.equals("uvesymptom2")) {
                String firsta = dataSnapshot.getValue(String.class);
                s2.setText(firsta);
            }
            if(key.equals("drysymptom2")) {
                String firstb = dataSnapshot.getValue(String.class);
                s3.setText(firstb);
            }
            if(key.equals("catsymptom2")) {
                String firstc = dataSnapshot.getValue(String.class);
                s4.setText(firstc);
            } if(key.equals("ectsymptom2")) {
                String firstd = dataSnapshot.getValue(String.class);
                s5.setText(firstd);
            }

        }




    }
    public void onCancelled(DatabaseError databaseError)
    {


    }
    protected void onStart(){
        super.onStart();
        //firstDatabase.addValueEventListener(this);
        firstDatabase2.addValueEventListener(this);
        firstDatabase3.addValueEventListener(this);
        firstDatabase4.addValueEventListener(this);
        firstDatabase5.addValueEventListener(this);

    }

}