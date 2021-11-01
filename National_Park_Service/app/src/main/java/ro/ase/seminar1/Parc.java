package ro.ase.seminar1;

public class Parc {
    private String localizare;
    private String program;
    private String traseuTuristic;

    public Parc(String localizare, String program, String traseuTuristic) {
        this.localizare = localizare;
        this.program = program;
        this.traseuTuristic = traseuTuristic;
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

    @Override
    public String toString() {
        return "Parc{" +
                "localizare='" + localizare + '\'' +
                ", program='" + program + '\'' +
                ", traseuTuristic='" + traseuTuristic + '\'' +
                '}';
    }
}
