package test;

import entities.*;
import java.util.Scanner;

public class TestBibliotheque {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Capacité de la bibliothèque : ");
        int n = sc.nextInt();
        sc.nextLine();

        Bibliotheque biblio = new Bibliotheque(n);

        // Initialiser avec deux documents
        biblio.ajouter(new Roman("Le Comte de Monte-Cristo", "Alexandre Dumas", 1240, 25.5));
        biblio.ajouter(new Manuel("Mathématiques", "Jean Dupont", 300, "Terminale"));

        boolean quitter = false;
        while (!quitter) {
            System.out.println("\nMenu : 1-Ajouter 2-Afficher 3-Supprimer 4-Rechercher 5-Auteurs 0-Quitter");
            System.out.print("Choix : ");
            int choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Type (Roman/Manuel/Revue/Dictionnaire) : ");
                    String type = sc.nextLine();
                    System.out.print("Titre : ");
                    String titre = sc.nextLine();
                    Document doc = null;

                    switch (type.toLowerCase()) {
                        case "roman":
                            System.out.print("Auteur : ");
                            String auteurR = sc.nextLine();
                            System.out.print("Pages : ");
                            int pagesR = sc.nextInt();
                            System.out.print("Prix : ");
                            double prix = sc.nextDouble(); sc.nextLine();
                            doc = new Roman(titre, auteurR, pagesR, prix);
                            break;
                        case "manuel":
                            System.out.print("Auteur : ");
                            String auteurM = sc.nextLine();
                            System.out.print("Pages : ");
                            int pagesM = sc.nextInt(); sc.nextLine();
                            System.out.print("Niveau : ");
                            String niveau = sc.nextLine();
                            doc = new Manuel(titre, auteurM, pagesM, niveau);
                            break;
                        case "revue":
                            System.out.print("Mois : ");
                            String mois = sc.nextLine();
                            System.out.print("Année : ");
                            int annee = sc.nextInt(); sc.nextLine();
                            doc = new Revue(titre, mois, annee);
                            break;
                        case "dictionnaire":
                            System.out.print("Langue : ");
                            String langue = sc.nextLine();
                            doc = new Dictionnaire(titre, langue);
                            break;
                        default:
                            System.out.println("Type inconnu.");
                    }
                    if (doc != null) {
                        if (biblio.ajouter(doc)) System.out.println("Document ajouté.");
                        else System.out.println("Bibliothèque pleine !");
                    }
                    break;

                case 2:
                    biblio.afficherDocuments();
                    break;

                case 3:
                    System.out.print("Numéro d'enregistrement à supprimer : ");
                    int numSup = sc.nextInt(); sc.nextLine();
                    Document dSup = biblio.document(numSup);
                    if (dSup != null && biblio.supprimer(dSup)) System.out.println("Document supprimé.");
                    else System.out.println("Document introuvable.");
                    break;

                case 4:
                    System.out.print("Numéro d'enregistrement à rechercher : ");
                    int numRech = sc.nextInt(); sc.nextLine();
                    Document dRech = biblio.document(numRech);
                    if (dRech != null) System.out.println(dRech);
                    else System.out.println("Document introuvable.");
                    break;

                case 5:
                    biblio.afficherAuteurs();
                    break;

                case 0:
                    quitter = true;
                    break;

                default:
                    System.out.println("Choix invalide.");
            }
        }

        sc.close();
    }
}
