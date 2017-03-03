package com.example.nikola.movienight;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText email;
    private EditText password;
    private Button   signin;
    private Button   signup;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        email    = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        signin   = (Button)   findViewById(R.id.signin);
        signup   = (Button)   findViewById(R.id.signup);

        signin.setOnClickListener(this);
        signup.setOnClickListener(this);
    }

    private void toastShow(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void getIn() {
        Intent moviesIntent = new Intent(this, MoviesActivity.class);
        startActivity(moviesIntent);
        finish();
    }

    private void signIn(String mail, String pass) {
        firebaseAuth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    getIn();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view == signup) {
            Intent mainAct = new Intent(this, MainActivity.class);
            startActivity(mainAct);
            finish();
        } else if (view == signin) {
            String mail = email.getText().toString().trim();
            String pass = password.getText().toString().trim();
            if(TextUtils.isEmpty(mail)) {
                toastShow("Provide us with you email.");
            } else if(TextUtils.isEmpty(pass)) {
                toastShow("Provide us with you password.");
            } else {
                signIn(mail, pass);
            }
        }
    }
}
