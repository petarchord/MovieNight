package com.example.nikola.movienight.Model;

/**
 * Created by nikola on 4.3.17..
 */

public class Korisnik {
    private String email;
    private String pass;
    private String ime;

    public Korisnik(String email, String pass, String ime) {
        this.email = email;
        this.pass  = pass;
        this.ime   = ime;
    }

    public void rezervisi(Bioskop bioskop, Film film, Sala sala) {
        //TODO: Da se prosledi i indeks sale koja se rezervise

    }
}
