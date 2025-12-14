package entities;

import java.util.HashSet;
import java.util.Set;

public class Bibliotheque {
    private int capacite;
    private Document[] documents;
    private int nbDocs;

    public Bibliotheque(int capacite) {
        this.capacite = capacite;
        this.documents = new Document[capacite];
        this.nbDocs = 0;
    }

    public boolean ajouter(Document doc) {
        if (nbDocs < capacite) {
            documents[nbDocs++] = doc;
            return true;
        }
        return false;
    }

    public boolean supprimer(Document doc) {
        for (int i = 0; i < nbDocs; i++) {
            if (documents[i].getNumEnreg() == doc.getNumEnreg()) {
                documents[i] = documents[nbDocs - 1]; // remplacer par le dernier
                documents[nbDocs - 1] = null;
                nbDocs--;
                return true;
            }
        }
        return false;
    }

    public Document document(int numEnreg) {
        for (int i = 0; i < nbDocs; i++) {
            if (documents[i].getNumEnreg() == numEnreg)
                return documents[i];
        }
        return null;
    }

    public void afficherDocuments() {
        for (int i = 0; i < nbDocs; i++) {
            System.out.println(documents[i]);
        }
    }

    public void afficherAuteurs() {
        Set<String> auteurs = new HashSet<>();
        for (int i = 0; i < nbDocs; i++) {
            Document doc = documents[i];
            if (doc instanceof Livre) {
                auteurs.add(((Livre) doc).getAuteur());
            }
        }
        for (String a : auteurs) {
            System.out.println(a);
        }
    }
}
