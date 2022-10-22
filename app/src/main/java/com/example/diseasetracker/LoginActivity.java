package com.example.diseasetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button enterNewActivityButton, sign,signUp;
    EditText sendUserIDText, password;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    private GoogleSignInClient mGoogleSignInClient;
    private  final  static int RC_SIGN_IN=123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.setTitle("Login Page");
        mAuth = FirebaseAuth.getInstance();
        password = (EditText) findViewById(R.id.passText);
        enterNewActivityButton = (Button) findViewById(R.id.loginButton);
        sign = (Button) findViewById(R.id.gs);
        signUp = (Button) findViewById(R.id.signUp);
        sendUserIDText = (EditText) findViewById(R.id.emailIdText);
        progressBar=findViewById(R.id.progressId);
        sign.setOnClickListener(this);

        signUp.setOnClickListener(this);

        enterNewActivityButton.setOnClickListener(this);
        createRequest();

    }

    private void createRequest() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            Intent loginIntent = new Intent(LoginActivity.this, symptom.class);
            startActivity(loginIntent);
            // Signed in successfully, show authenticated UI.
            //updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("error", "signInResult:failed code=" + e.getStatusCode());
            //updateUI(null);
        }
    }

    @Override
    public void onClick(View v) {

        if (R.id.loginButton == v.getId()) {
            login();
        }
            /*String userIDStr = sendUserIDText.getText().toString();

            Intent loginIntent = new Intent(MainActivity.this, SecondActivity.class);

            loginIntent.putExtra("name", "ABCD");
            loginIntent.putExtra("studentId", "1234567");
            loginIntent.putExtra("user", userIDStr);

            startActivity(loginIntent);*/
        //}

        else if(R.id.gs==v.getId()){

            signIn();
            //Intent loginIntent = new Intent(LoginActivity.this, signUpActivity.class);
            // startActivity(loginIntent);
        }

        else if(R.id.signUp==v.getId()){


            Intent signupIntent = new Intent(LoginActivity.this, signUpActivity.class);
            startActivity(signupIntent);
        }



    }

    private void login() {


        String email = sendUserIDText.getText().toString().trim();
        String passW0rd = password.getText().toString().trim();
        if (email.isEmpty()) {
            sendUserIDText.setError("Enter an email Address");
            sendUserIDText.requestFocus();
            return;
        }
        if (passW0rd.isEmpty()) {
            password.setError("Enter a Password");
            password.requestFocus();
            return;
        }

        if (passW0rd.length()<8) {
            password.setError("Password must be 8 words long");
            password.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,passW0rd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if(task.isSuccessful())

                {
                    Intent loginIntent = new Intent(LoginActivity.this, ProfileActivity.class);
                    loginIntent.putExtra("Value",sendUserIDText.getText().toString());
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    startActivity(loginIntent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"login Unsuccesfull",Toast.LENGTH_SHORT).show();
                }

            }
        });






    }


}