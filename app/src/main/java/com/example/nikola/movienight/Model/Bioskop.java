package com.example.nikola.movienight.Model;

import java.util.List;

/**
 * Created by nikola on 4.3.17..
 */

public class Bioskop {
    private String naziv;
    private List<Sala> listaSala;
    private List<Film> listaFilmova;

    public Bioskop(String naziv, List<Sala> listaSala) {
        this.naziv     = naziv;
        this.listaSala = listaSala;
    }

    public void dodajFilm(Film film) {
        listaFilmova.add(film);
    }
}
