package com.example.diseasetracker;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class signUpActivity extends AppCompatActivity implements View.OnClickListener {

    Button enterNewActivityButton, sign;
    EditText sendUserIDText, password,name,age,confirmPassword;
    TextView signuptext;
    RadioGroup radioGroup;
    RadioButton genderButton;
    private FirebaseAuth mAuth;
    DatabaseReference firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        this.setTitle("signUp");
        sign = (Button) findViewById(R.id.register);
        sendUserIDText = (EditText) findViewById(R.id.userIdText);
        password = (EditText) findViewById(R.id.editText);
        signuptext=findViewById(R.id.signIntext);
        name=findViewById(R.id.usernameText);
        confirmPassword=findViewById(R.id.confirmPasswordText);
        age=findViewById(R.id.ageText);

        radioGroup=findViewById(R.id.radioGroupId);


        //firebaseDatabase= FirebaseDatabase.getInstance().getReference();
        sign.setOnClickListener(this);
        signuptext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //userRegister();
        switch (v.getId())
        {
            case R.id.signIntext:
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                break;

            case R.id.register:
                String email = sendUserIDText.getText().toString().trim();
                String passW0rd = password.getText().toString().trim();
                int showGender=radioGroup.getCheckedRadioButtonId();
                genderButton= (RadioButton)findViewById(showGender);

                String UserName=name.getText().toString().trim();
                String Age=age.getText().toString().trim();
                String confirm=confirmPassword.getText().toString().trim();
                //firebaseDatabase= FirebaseDatabase.getInstance().getReference("users");
                //UserInfo userInfo=new UserInfo(UserName,Age);
                //String key= firebaseDatabase.push().getKey();
                //firebaseDatabase.child("users").child(UserName).setValue(userInfo);

                if(TextUtils.isEmpty(UserName))
                {
                    name.setError("Enter an User name");
                    name.requestFocus();
                    return;

                }



                if(TextUtils.isEmpty(email))
                {
                    sendUserIDText.setError("Enter an email");
                    sendUserIDText.requestFocus();
                    return;

                }

                if (TextUtils.isEmpty(passW0rd)) {
                    password.setError("Enter a Password");
                    password.requestFocus();
                    return;
                }

                if (passW0rd.length()<8) {
                    password.setError("Passw0rd must be 8 words long");
                    password.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(confirm)) {
                    confirmPassword.setError("Enter the Password Again");
                    confirmPassword.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(Age)) {
                    age.setError("Enter Your Age");
                    age.requestFocus();
                    return;
                }


                userRegister(email,genderButton.getText().toString(),UserName,age.getText().toString(),passW0rd);
                break;

        }

    }


    private void userRegister(final String email,final String genderButton,final String UserName,final String Age,String passW0rd) {




        mAuth.createUserWithEmailAndPassword(email,passW0rd).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Toast.makeText(getApplicationContext(),"Register is succesfull",Toast.LENGTH_SHORT).show();
                    firebaseDatabase= FirebaseDatabase.getInstance().getReference("users");
                    UserInfo userInfo=new UserInfo(UserName,email,genderButton,Age);
                    String key= firebaseDatabase.push().getKey();
                    firebaseDatabase.child(key).setValue(userInfo);




                }
                else
                {
                    if(task.getException() instanceof FirebaseAuthUserCollisionException)
                    {


                        Toast.makeText(getApplicationContext(),"User is already Registered",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Register is not succesfull",Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });






    }

}
