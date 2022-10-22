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

public class ssymptom3 extends AppCompatActivity implements ValueEventListener {
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference=firebaseDatabase.getReference();
    //  private DatabaseReference firstDatabase=databaseReference.child("Symptom2");
    private DatabaseReference firstDatabase2=databaseReference.child("chillsymptom2");
    private DatabaseReference firstDatabase3=databaseReference.child("prusymptom2");
    private DatabaseReference firstDatabase4=databaseReference.child("eczsymptom2");
    private DatabaseReference firstDatabase5=databaseReference.child("sebsymptom2");

    private RadioButton s1,s6,s7,s8,s9;
    private Button done3,SignOut;
    private RadioGroup radioGroup2;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssymptom3);
        this.setTitle("symptom3");
        //    s1=findViewById(R.id.cosymptom11);
        s6=findViewById(R.id.cosymptomE);
        s7=findViewById(R.id.cosymptomF);
        s8=findViewById(R.id.cosymptomG);
        s9=findViewById(R.id.cosymptomH);
        done3=findViewById(R.id.done3);
        SignOut=(Button) findViewById(R.id.out);
        SignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ssymptom3.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        radioGroup2=(RadioGroup)findViewById(R.id.radioGroup2);
        done3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedId2=radioGroup2.getCheckedRadioButtonId();
                findRadioButton1(checkedId2);
            }
        });
    }
    private void findRadioButton1(int checkedId2) {
        switch (checkedId2)
        {
            case R.id.cosymptomE:
            {
                Intent intente = new Intent(ssymptom3.this, result.class);
                st=s6.getText().toString();
                intente.putExtra("Value",st);
                startActivity(intente);


                break;
            }
            case R.id.cosymptomF:
            {
                Intent intentf = new Intent(ssymptom3.this, result.class);
                st=s7.getText().toString();
                intentf.putExtra("Value",st);
                startActivity(intentf);
                break;
            }
            case R.id.cosymptomG:
            {
                Intent intentg = new Intent(ssymptom3.this, result.class);
                st=s8.getText().toString();
                intentg.putExtra("Value",st);
                startActivity(intentg);
                break;
            }
            case R.id.cosymptomH:
            {
                Intent intenth = new Intent(ssymptom3.this, result.class);
                st=s9.getText().toString();
                intenth.putExtra("Value",st);
                startActivity(intenth);
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
            if(key.equals("chillsymptom2")) {
                String firste = dataSnapshot.getValue(String.class);
                s6.setText(firste);
            }
            if(key.equals("prusymptom2")) {
                String firstf = dataSnapshot.getValue(String.class);
                s7.setText(firstf);
            }
            if(key.equals("eczsymptom2")) {
                String firstg = dataSnapshot.getValue(String.class);
                s8.setText(firstg);
            } if(key.equals("sebsymptom2")) {
                String firsth = dataSnapshot.getValue(String.class);
                s9.setText(firsth);
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