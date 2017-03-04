package com.example.nikola.movienight;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

/**
 * Created by nikola on 4.3.17..
 */

public class BaseActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;

    /*
    *
    *   SLEDECE DVE METODE SU ISKLJUCIVO POMOCNE RADI CITLJIVIJEG KODA I RADI ODRZIVIJE APLIKACIJE
    *
    */

    // Metoda za prikazivanje i ispisivanje Toast poruka na dnu pametnog telefona
    // Ovo sam napravio radi vece fleksibilnosti i zbog citljivijeg koda

    public void showProgressDialog(String message) {
        if(progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setCancelable(false);
            progressDialog.setMessage(message);
        }

        progressDialog.show();
    }

    public void hideProgressDialog() {
        if(progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    // Ova metoda se koristi za sakrivanje virtualne tastature jer android nije implementiran
    // da tastaturu uklanja kad se klikne (tapne) na dugme tako da je ovo pomocna metoda
    private void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

}
