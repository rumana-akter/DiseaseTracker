package com.example.diseasetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class doctor extends AppCompatActivity implements  ValueEventListener,View.OnClickListener{
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference=firebaseDatabase.getReference();
    private DatabaseReference firstDatabase1=databaseReference.child("doctor");
    private DatabaseReference firstDatabase21=databaseReference.child("doctor");
    private DatabaseReference firstDatabase31=databaseReference.child("doctor");
    private DatabaseReference firstDatabase41=databaseReference.child("doctor");
    private DatabaseReference firstDatabase51=databaseReference.child("doctor");
    private DatabaseReference firstDatabase61=databaseReference.child("doctor1");
    private DatabaseReference firstDatabase71=databaseReference.child("doctor1");
    private DatabaseReference firstDatabase81=databaseReference.child("doctor1");
    private DatabaseReference firstDatabase91=databaseReference.child("doctor1");
    private DatabaseReference firstDatabase101=databaseReference.child("doctor2");
    private DatabaseReference firstDatabase111=databaseReference.child("doctor2");
    private DatabaseReference firstDatabase121=databaseReference.child("doctor2");
    private DatabaseReference firstDatabase131=databaseReference.child("doctor2");
    private TextView t1;
    private Button SignOut;
    String st1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("doctor");
        setContentView(R.layout.activity_doctor);
        t1=findViewById(R.id.text2);
        SignOut=(Button) findViewById(R.id.out);
        SignOut.setOnClickListener(this);

        st1=getIntent().getExtras().getString("Value");

        // t.setText(st);
        //st=getIntent().getExtras().getString("Value");


        //remedies=findViewById(R.id.remedies);
        //remedies.setOnClickListener(this);

    }

    public void onDataChange(DataSnapshot dataSnapshot)
    {
        if(st1.equals("Corona")) {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("doctor")) {
                    String first = dataSnapshot.getValue(String.class);
                    t1.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }


        if(st1.equals("Dengue")) {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("doctor")) {
                    String first = dataSnapshot.getValue(String.class);
                    t1.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }



        if(st1.equals("Typhoid")) {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("doctor")) {
                    String first = dataSnapshot.getValue(String.class);
                    t1.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }


        if(st1.equals("Jaundice")) {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("doctor")) {
                    String first = dataSnapshot.getValue(String.class);
                    t1.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }



        if(st1.equals("Chicken pox"))
        {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("doctor")) {
                    String first = dataSnapshot.getValue(String.class);
                    t1.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }

        if(st1.equals("Uvetitis"))
        {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("doctor1")) {
                    String first = dataSnapshot.getValue(String.class);
                    t1.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }

        if(st1.equals("Dry Eyes"))
        {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("doctor1")) {
                    String first = dataSnapshot.getValue(String.class);
                    t1.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }
        if(st1.equals("Cataract"))
        {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("doctor1")) {
                    String first = dataSnapshot.getValue(String.class);
                    t1.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }
        if(st1.equals("Ectropion"))
        {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("doctor1")) {
                    String first = dataSnapshot.getValue(String.class);
                    t1.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }

        if(st1.equals("Chillblains"))
        {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("doctor2")) {
                    String first = dataSnapshot.getValue(String.class);
                    t1.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }
        if(st1.equals("Pruritus"))
        {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("doctor2")) {
                    String first = dataSnapshot.getValue(String.class);
                    t1.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }
        if(st1.equals("Eczema"))
        {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("doctor2")) {
                    String first = dataSnapshot.getValue(String.class);
                    t1.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }
        if(st1.equals("Seborrheic"))
        {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("doctor2")) {
                    String first = dataSnapshot.getValue(String.class);
                    t1.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }











    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.out)
        {
            Intent intent=new Intent(doctor.this,LoginActivity.class);
            startActivity(intent);
        }


    }




    public void onCancelled(DatabaseError databaseError)
    {


    }
    protected void onStart(){
        super.onStart();
        firstDatabase1.addValueEventListener(this);
        firstDatabase21.addValueEventListener(this);
        firstDatabase31.addValueEventListener(this);
        firstDatabase41.addValueEventListener(this);
        firstDatabase51.addValueEventListener(this);
        firstDatabase61.addValueEventListener(this);
        firstDatabase71.addValueEventListener(this);
        firstDatabase81.addValueEventListener(this);
        firstDatabase91.addValueEventListener(this);
        firstDatabase101.addValueEventListener(this);
        firstDatabase111.addValueEventListener(this);
        firstDatabase121.addValueEventListener(this);
        firstDatabase131.addValueEventListener(this);

    }
}



