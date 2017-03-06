package com.example.nikola.movienight.Model;

/**
 * Created by nikola on 4.3.17..
 */
public class Sala {
    private int id;
    private int brojSedista;
    private int preostaloMesta;

    public Sala(int id, int brojSedista, int preostaloMesta) {
        this.id             = id;
        this.brojSedista    = brojSedista;
        this.preostaloMesta = preostaloMesta; //preostalo mesta inicijalno je jednaka broju ukupnih sedista u sali
    }

    public boolean isFull() {
        return preostaloMesta == 0;
    }

    public boolean inkrement() {
        if(!isFull()) {
            this.preostaloMesta--;
            return true;
        } else {
            return false;
        }
    }

    public boolean dekrement() {
        if(this.preostaloMesta == this.brojSedista) {
            return false;
        } else {
            this.preostaloMesta--;
            return true;
        }
    }
}
