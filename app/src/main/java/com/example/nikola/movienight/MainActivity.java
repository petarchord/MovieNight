package com.example.nikola.movienight;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Samo radi debug-ovanja
    private String TAG = "Signup Activity";

    // Deklaracija komponenti sa layout-a koje cemo da koristimo u daljem radu
    private EditText        email;
    private EditText        password;

    // Ove dve sam odvojio jer cemo se njima baviti samo radi ulepsavanja i poboljsavanja
    // korisnickog iskustva (crveni tekst ispod EditText-a)
    private TextInputLayout emailLabel;
    private TextInputLayout passwordLabel;

    private Button          signup;
    private Button          signin;

    private FirebaseAuth   firebaseAuth;
    private ProgressDialog progressBar;

    /*
    *
    *   SLEDECE DVE METODE SU ISKLJUCIVO POMOCNE RADI CITLJIVIJEG KODA I RADI ODRZIVIJE APLIKACIJE
    *
    */

    // Metoda za prikazivanje i ispisivanje Toast poruka na dnu pametnog telefona
    // Ovo sam napravio radi vece fleksibilnosti i zbog citljivijeg koda
    private void toastShow(String toast) {
        Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_SHORT).show();
    }

    // Ova metoda se koristi za sakrivanje virtualne tastature jer android nije implementiran
    // da tastaturu uklanja kad se klikne (tapne) na dugme tako da je ovo pomocna metoda
    private void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Singleton za komunikaciju sa Firebase Authentication servisom
        firebaseAuth = FirebaseAuth.getInstance();
        progressBar  = new ProgressDialog(this);

        email        = (EditText) findViewById(R.id.email);
        password     = (EditText) findViewById(R.id.password);
        signup       = (Button)   findViewById(R.id.signup);
        signin       = (Button)   findViewById(R.id.signin);

        emailLabel    = (TextInputLayout) findViewById(R.id.emailLabel);
        passwordLabel = (TextInputLayout) findViewById(R.id.passwordLabel);

        // Postavljamo OnClickListener za dugme sa ID - em signup, a taj listener ce biti
        // sama aplikacija. Implementacijom ovog interfejsa sam kod postaje fleksibilniji i otporniji
        // na promene, laksi za odrzavanje i za koriscenje. Primer: recimo da resimo da u aplikaciju
        // dodamo jos koje dugme jednostavno cemo deklarisati novo dugme tipa Button i dodeliti mu
        // listener na isti nacin kao i signup dugmetu. Nastavak u onClick metodu...
        signup.setOnClickListener(this);
        signin.setOnClickListener(this);
    }

    private void signupUser() {

    }

    @Override
    public void onClick(View view) {

        // ...dakle ovakva realizacija pravi fleksibilniju aplikaciju. Naime, pocevsi sa samom organizacijom
        // android aplikacija i kako native android funkcionise mozemo zakljuciti da se sve moze kastovati
        // u tip View, te se ovde moze staviti i LinearLayout da je view (recimo ukoliko odlucimo da pravimo
        // FlappyBird). Medjutim, ovde nam je potreban signup i signin dugme te se samo na njih i fokusiramo...
        if(view == signup) {
            String mail = email.getText().toString().trim();
            String pass = password.getText().toString().trim();

            Log.d(TAG, mail);
            Log.d(TAG, pass);

            //Ako je korisnik kliknuo na signup treba registrovati korisnika, proveriti pritom svaki ulaz
            //koji je korisnik zadao, u slucaju nevalidnog ulaza ispisuje se setError()
            if (TextUtils.isEmpty(mail)) {

                toastShow("Provide us with your email");
                return;

            } else if(TextUtils.isEmpty(pass)) {

                toastShow("Provide us with your password");
                return;

            } else {

                // Ako su username (mail) i password popunjeni onda ce registrovati korisnika (signupUser())
                progressBar.setMessage("Signing up new user...");
                progressBar.show();
                //toastShow("Uspeh!");
                firebaseAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            //OVde prikazati sledeci main activity i nastaviti rad aplikacije
                            toastShow("Success!");
                        } else {
                            toastShow("Failed to connect to the service.");
                        }
                    }
                });
            }
        } else if(view == signin) {
            toastShow("Signin: treba implementirati.");
        }
    }
}
