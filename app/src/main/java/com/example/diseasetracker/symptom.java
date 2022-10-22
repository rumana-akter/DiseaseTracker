package com.example.diseasetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;

public class symptom extends AppCompatActivity{
    private Button done,SignOut;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom);
        done=(Button)findViewById(R.id.done);
        SignOut=(Button) findViewById(R.id.out);
        SignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(symptom.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkedId=radioGroup.getCheckedRadioButtonId();
                findRadioButton(checkedId);

            }
        });
    }
    private void findRadioButton(int checkedId) {
        switch (checkedId)
        {
            case R.id.symptom1:
            {
                Intent intent = new Intent(symptom.this, csymptom2.class);
                startActivity(intent);
                break;
            }
            case R.id.symptom2:
            {
                Intent intent2 = new Intent(symptom.this, esymptom2.class);
                startActivity(intent2);
                break;
            }
            case R.id.symptom3:
            {
                Intent intent3 = new Intent(symptom.this, ssymptom2.class);
                startActivity(intent3);
                break;
            }
        }
    }


}