package com.example.nikola.movienight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText email;
    private EditText password;
    private Button   signin;
    private Button   signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email    = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        signin   = (Button)   findViewById(R.id.signin);
        signup   = (Button)   findViewById(R.id.signup);

        signin.setOnClickListener(this);
        signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == signup) {
            Intent mainAct = new Intent(this, MainActivity.class);
            startActivity(mainAct);
            finish();
        }
    }
}
