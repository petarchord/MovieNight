package com.example.nikola.movienight.Model;

import java.util.Date;

/**
 * Created by nikola on 4.3.17..
 */
public class Film {
    private String naziv;
    private String zanr;
    private double ocena;
    private String opis;
    private Date   pocetak;

    public Film(String naziv, String zanr, double ocena, String opis, Date pocetak) {
        this.naziv   = naziv;
        this.zanr    = zanr;
        this.ocena   = ocena;
        this.opis    = opis;
        this.pocetak = pocetak;
    }

    public Film(String naziv, String zanr, String opis) {
        this.naziv   = naziv;
        this.zanr    = zanr;
        this.opis    = opis;
    }

    public Film(String naziv) { this.naziv   = naziv; }

    public Film(String original_title, String overview) {
        this.naziv = original_title;
        this.opis = overview;
    }

    public String getNaziv() {
        return this.naziv;
    }

    //public String getZanr() { return this.zanr; }

    //public String getOpis() {    return this.opis;  }
}
