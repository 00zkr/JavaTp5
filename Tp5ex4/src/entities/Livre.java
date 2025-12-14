package entities;

public class Livre extends Document {
    private String auteur;
    private int nbrPages;

    public Livre(String titre, String auteur, int nbrPages) {
        super(titre);
        this.auteur = auteur;
        this.nbrPages = nbrPages;
    }

    public String getAuteur() { return auteur; }
    public int getNbrPages() { return nbrPages; }

    @Override
    public String toString() {
        return "Livre[numEnreg=" + numEnreg +
               ", titre=" + titre +
               ", auteur=" + auteur +
               ", nbrPages=" + nbrPages + "]";
    }
}
