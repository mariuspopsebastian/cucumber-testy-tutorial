package org.fasttrackit.bazadedate;

/**
 * Created by Marius on 20-Apr-17.
 */
public class Produs {
    private String produs;
    private String search;
    private int pret;

    public Produs(String produs, String search, int pret) {
        this.produs = produs;
        this.pret = pret;
        this.search = search;

    }

    public String getProdus() {
        return produs;
    }

    public String getSearch() {
        return search;
    }

    public int getPret() {
        return pret;
    }
}
