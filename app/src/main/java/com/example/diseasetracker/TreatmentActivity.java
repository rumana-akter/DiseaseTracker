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

public class TreatmentActivity extends AppCompatActivity implements  ValueEventListener, View.OnClickListener{
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference=firebaseDatabase.getReference();
    private DatabaseReference firstDatabase=databaseReference.child("cremedies");
    private DatabaseReference firstDatabase2=databaseReference.child("dremedies");
    private DatabaseReference firstDatabase3=databaseReference.child("tremedies");
    private DatabaseReference firstDatabase4=databaseReference.child("jremedies");
    private DatabaseReference firstDatabase5=databaseReference.child("aremedies");
    private DatabaseReference firstDatabase6=databaseReference.child("EUremedies");
    private DatabaseReference firstDatabase7=databaseReference.child("EDremedies");
    private DatabaseReference firstDatabase8=databaseReference.child("ECremedies");
    private DatabaseReference firstDatabase9=databaseReference.child("EEremedies");
    private DatabaseReference firstDatabase10=databaseReference.child("SCremedies");
    private DatabaseReference firstDatabase11=databaseReference.child("SPremedies");
    private DatabaseReference firstDatabase12=databaseReference.child("SEremedies");
    private DatabaseReference firstDatabase13=databaseReference.child("SSremedies");
    private TextView t;
    private Button SignOut;
    String st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("treatment");
        setContentView(R.layout.activity_treatment);
        t=findViewById(R.id.text1);
        SignOut=(Button) findViewById(R.id.out);
        SignOut.setOnClickListener(this);

        st=getIntent().getExtras().getString("Value");


        // t.setText(st);
        //st=getIntent().getExtras().getString("Value");


        //remedies=findViewById(R.id.remedies);
        //remedies.setOnClickListener(this);

    }

    public void onDataChange(DataSnapshot dataSnapshot)
    {
        if(st.equals("Corona")) {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("cremedies")) {
                    String first = dataSnapshot.getValue(String.class);
                    t.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }


        if(st.equals("Dengue")) {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("dremedies")) {
                    String first = dataSnapshot.getValue(String.class);
                    t.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }



        if(st.equals("Typhoid")) {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("tremedies")) {
                    String first = dataSnapshot.getValue(String.class);
                    t.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }


        if(st.equals("Jaundice")) {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("jremedies")) {
                    String first = dataSnapshot.getValue(String.class);
                    t.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }



        if(st.equals("Chicken pox"))
        {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("aremedies")) {
                    String first = dataSnapshot.getValue(String.class);
                    t.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }

        if(st.equals("Uvetitis"))
        {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("EUremedies")) {
                    String first = dataSnapshot.getValue(String.class);
                    t.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }

        if(st.equals("Dry Eyes"))
        {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("EDremedies")) {
                    String first = dataSnapshot.getValue(String.class);
                    t.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }
        if(st.equals("Cataract"))
        {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("ECremedies")) {
                    String first = dataSnapshot.getValue(String.class);
                    t.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }
        if(st.equals("Ectropion"))
        {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("EEremedies")) {
                    String first = dataSnapshot.getValue(String.class);
                    t.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }

        if(st.equals("Chillblains"))
        {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("SCremedies")) {
                    String first = dataSnapshot.getValue(String.class);
                    t.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }
        if(st.equals("Pruritus"))
        {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("SPremedies")) {
                    String first = dataSnapshot.getValue(String.class);
                    t.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }
        if(st.equals("Eczema"))
        {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("SEremedies")) {
                    String first = dataSnapshot.getValue(String.class);
                    t.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }
        if(st.equals("Seborrheic"))
        {
            if (dataSnapshot.getValue(String.class) != null) {
                String key = dataSnapshot.getKey();
                if (key.equals("SSremedies")) {
                    String first = dataSnapshot.getValue(String.class);
                    t.setText(first);
                    //st=s1.getText().toString();

                }

            }

        }











    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.out)
        {
            Intent intent=new Intent(TreatmentActivity.this,LoginActivity.class);
            startActivity(intent);
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
        firstDatabase6.addValueEventListener(this);
        firstDatabase7.addValueEventListener(this);
        firstDatabase8.addValueEventListener(this);
        firstDatabase9.addValueEventListener(this);
        firstDatabase10.addValueEventListener(this);
        firstDatabase11.addValueEventListener(this);
        firstDatabase12.addValueEventListener(this);
        firstDatabase13.addValueEventListener(this);

    }
}



