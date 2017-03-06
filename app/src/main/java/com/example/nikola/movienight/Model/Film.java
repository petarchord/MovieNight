package com.example.nikola.movienight.Model;

import java.util.Date;

/**
 * Created by nikola on 4.3.17..
 */
public class Film {
    private String naziv;
    private String poster;
    private String opis;

    private Date   pocetak;
    private String zanr;
    private double ocena;

    public Film(String naziv, String zanr, double ocena, String opis, Date pocetak) {
        this.naziv   = naziv;
        this.zanr    = zanr;
        this.ocena   = ocena;
        this.opis    = opis;
        this.pocetak = pocetak;
    }

    public Film(String naziv, String opis, String poster) {
        this.naziv  = naziv;
        this.poster = poster;
        this.opis   = opis;
    }

    public Film(String naziv) { this.naziv   = naziv; }


    public String getNaziv() {
        return this.naziv;
    }

    public String getPoster() {
        return this.poster;
    }

    //public String getZanr() { return this.zanr; }

    //public String getOpis() {    return this.opis;  }
}
