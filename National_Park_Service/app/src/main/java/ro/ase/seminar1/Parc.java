package ro.ase.seminar1;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "parcuri")
public class Parc {
    @PrimaryKey(autoGenerate = true)
    private int idMParc;
    @ColumnInfo(name = "localizare")
    private String localizare;
    @ColumnInfo(name="program")
    private String program;
    @ColumnInfo(name = "traseu")
    private String traseuTuristic;
    @ColumnInfo(name = "pret")
    private int pret;

    public Parc(){
        this.localizare = "necunoscuta";
        this.program = "necunoscut";
        this.traseuTuristic = "necunoscut";
        this.pret = 0;
    }

    public Parc(String localizare, String program, String traseuTuristic, int pret) {
        this.localizare = localizare;
        this.program = program;
        this.traseuTuristic = traseuTuristic;
        this.pret = pret;
    }

    public int getIdMParc() {
        return idMParc;
    }

    public void setIdMParc(int idMParc) {
        this.idMParc = idMParc;
    }

    public String getLocalizare() {
        return localizare;
    }

    public void setLocalizare(String localizare) {
        this.localizare = localizare;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getTraseuTuristic() {
        return traseuTuristic;
    }

    public void setTraseuTuristic(String traseuTuristic) {
        this.traseuTuristic = traseuTuristic;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Parc{" +
                "idMParc=" + idMParc +
                ", localizare='" + localizare + '\'' +
                ", program='" + program + '\'' +
                ", traseuTuristic='" + traseuTuristic + '\'' +
                ", pret=" + pret +
                '}';
    }

    public String toStringFB() {
        return "Parc: " +
                "localizare='" + localizare + '\'' +
                ", program='" + program + '\'' +
                ", traseuTuristic='" + traseuTuristic + '\'' +
                ", pret=" + pret;
    }
}
