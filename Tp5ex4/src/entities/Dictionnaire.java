package entities;

public class Dictionnaire extends Document {
    private String langue;

    public Dictionnaire(String titre, String langue) {
        super(titre);
        this.langue = langue;
    }

    @Override
    public String toString() {
        return "Dictionnaire[numEnreg=" + numEnreg +
               ", titre=" + titre +
               ", langue=" + langue + "]";
    }
}
