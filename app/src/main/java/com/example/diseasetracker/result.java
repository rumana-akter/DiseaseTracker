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

public class result extends AppCompatActivity implements  View.OnClickListener{
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference=firebaseDatabase.getReference();
    private DatabaseReference firstDatabase=databaseReference.child("Symptom2");
    private DatabaseReference firstDatabase2=databaseReference.child("dsymptom2");
    private DatabaseReference firstDatabase3=databaseReference.child("tsymptom2");
    private DatabaseReference firstDatabase4=databaseReference.child("jsymptom2");
    private DatabaseReference firstDatabase5=databaseReference.child("asymptom2");
    private TextView text;
    private Button doctor1,remedies1,SignOut;
    String st,s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("result");
        setContentView(R.layout.activity_result);
        text=findViewById(R.id.result);
        SignOut=(Button) findViewById(R.id.out);
        SignOut.setOnClickListener(this);

        st=getIntent().getExtras().getString("Value");


        st=getIntent().getExtras().getString("Value");
        if(st.equals("breathing problem")) {
            //String first = dataSnapshot.getValue(String.class);
            text.setText("Corona");
            s=text.getText().toString();


        }
        if(st.equals("Aches and pains")) {
            //String first = dataSnapshot.getValue(String.class);
            text.setText("Dengue");
            s=text.getText().toString();
        }
        if(st.equals("Loss of appetite")) {
            //String first = dataSnapshot.getValue(String.class);
            text.setText("Typhoid");
            s=text.getText().toString();
        }
        if(st.equals("pale stool")) {
            //String first = dataSnapshot.getValue(String.class);
            text.setText("Jaundice");
            s=text.getText().toString();
        }if(st.equals("Raised pink or red bumps")) {
            //String first = dataSnapshot.getValue(String.class);
            text.setText("Chicken pox");
            s=text.getText().toString();
        }if(st.equals("Sensation of having something in eyes")) {
            //String first = dataSnapshot.getValue(String.class);
            text.setText("Dry Eyes");
            s=text.getText().toString();
        }if(st.equals("Double vision in a single eye or seeing halos around light")) {
            //String first = dataSnapshot.getValue(String.class);
            text.setText("Cataract");
            s=text.getText().toString();
        }if(st.equals("Excessive dryness in eyes")) {
            //String first = dataSnapshot.getValue(String.class);
            text.setText("Ectropion");
            s=text.getText().toString();
        }
        if(st.equals("Dark,floating spot in vision field")) {
            //String first = dataSnapshot.getValue(String.class);
            text.setText("Uvetitis");
            s=text.getText().toString();
        }if(st.equals("Leathery/scaly/dry/cracked skin")) {
            //String first = dataSnapshot.getValue(String.class);
            text.setText("Pruritus");
            s=text.getText().toString();
        }if(st.equals("Changes in skin color from red to dark blue, accompanied by pain")) {
            //String first = dataSnapshot.getValue(String.class);
            text.setText("Chillblains");
            s=text.getText().toString();
        }if(st.equals("Red to brownish-gray patches")) {
            //String first = dataSnapshot.getValue(String.class);
            text.setText("Eczema");
            s=text.getText().toString();
        }if(st.equals("White or yellowish crusty scale on the surface")) {
            //String first = dataSnapshot.getValue(String.class);
            text.setText("Seborrheic");
            s=text.getText().toString();
        }
        remedies1=findViewById(R.id.remedies);
        remedies1.setOnClickListener(this);
        doctor1=findViewById(R.id.doctor);
        doctor1.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (R.id.remedies == v.getId()) {

            Intent intent = new Intent(result.this, TreatmentActivity.class);
            intent.putExtra("Value",s);
            startActivity(intent);
        }

        else if(R.id.doctor == v.getId()) {
            Intent intent = new Intent(result.this, doctor.class);
            intent.putExtra("Value",s);
            startActivity(intent);
        }
        else  if(v.getId()==R.id.out)
        {
            Intent intent=new Intent(result.this,LoginActivity.class);
            startActivity(intent);
        }



    }

}
