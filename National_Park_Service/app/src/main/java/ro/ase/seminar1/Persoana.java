package ro.ase.seminar1;

import java.io.Serializable;

public class Persoana implements Serializable {
    private String nume;
    //private String prenume;
    private String parola;
    private String email;
    private int telefon;

    public Persoana(String nume, String parola, String email, int telefon) {
        this.nume = nume;
        this.parola = parola;
        this.email = email;
        this.telefon = telefon;
    }

    public Persoana() {

    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", parola='" + parola + '\'' +
                ", email='" + email + '\'' +
                ", telefon=" + telefon +
                '}';
    }
}