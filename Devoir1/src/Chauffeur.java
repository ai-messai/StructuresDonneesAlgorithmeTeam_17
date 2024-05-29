import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.jetbrains.annotations.NotNull;
import src.Exceptions;

public class Chauffeur {
    private final String prenom;
    private final String nom;
    private final int age;
    private final int anneeEmbauche;
    private final String addresse;
    private final String id;

    public Chauffeur(String firstName, String nom, int age, int anneeEmbauche, String addresse) {
        this.prenom = firstName;
        this.nom = nom;
        this.age = age;
        this.anneeEmbauche = anneeEmbauche;
        this.addresse = addresse;
        this.id = generateId();
    }

    public String getId() {
        return this.id;
    }

    private String generateId() {
        String idLastName = nom.length() < 4 ? nom : nom.substring(0, 4);
        return idLastName + prenom.charAt(0) + String.valueOf(anneeEmbauche).substring(2);
    }

    public String getNom() {
        return this.nom;
    }

    public String getFirstName() {
        return this.prenom;
    }

    public int getAge() {
        return this.age;
    }

    public int getAnneeEmbauche() {
        return this.anneeEmbauche;
    }

    public String getAddresse() {
        return this.addresse;
    }

    public static @NotNull Chauffeur creationChauffeur(Scanner scanner, Chauffeur[] chauffeurs) {

        String nomChauffeur = validationNom(scanner);

        Chauffeur reservationChauffeur = null;
        for (Chauffeur c : chauffeurs) {
            if (c != null && c.getNom().equals(nomChauffeur)) {
                reservationChauffeur = c;
                break;
            }
        }

        if (reservationChauffeur == null) {
            System.out.println("\033[31m" + "Aucun chauffeur trouvé avec ce nom." + "\033[0m");
            System.out.println("\033[32m" + "Création d'un nouveau Chauffeur." + "\033[0m");

            System.out.print("Prénom : ");
            String prenomChauffeur = validationPrenom(scanner);

            System.out.print("Âge : ");
            int age = validateAge(scanner);

            System.out.print("Année d'embauche : ");
            int hiringYear = validateHiringYear(scanner);
            scanner.nextLine();

            System.out.print("Adresse : ");
            String address = validateAddress(scanner);

            reservationChauffeur = new Chauffeur(prenomChauffeur, nomChauffeur, age, hiringYear, address);

            for (int i = 0; i < chauffeurs.length; i++) {
                if (chauffeurs[i] == null) {
                    chauffeurs[i] = reservationChauffeur;
                    System.out.println("Chauffeur ajouté avec succès !");
                    break;
                }
            }
        }

        return reservationChauffeur;
    }


    public static String validationNom(@NotNull Scanner scanner){
        String nomChauffeur = "";
        while (true) {
            System.out.print("Nom du chauffeur : ");
            try {
                nomChauffeur = scanner.nextLine().trim();
                if (!nomChauffeur.matches("^[a-zA-Z]*$")) {
                    throw new Exceptions.InvalidDriverNameException("Erreur : Veuillez entrer un nom en lettres uniquement.");
                }
                break;
            } catch (Exceptions.InvalidDriverNameException e) {
                System.out.println("\033[31m" + e.getMessage() + "\033[0m");
            }
        }
        return nomChauffeur;
    }

    public static String validationPrenom(@NotNull Scanner scanner){
        String prenomChauffeur = "";
        while (true) {
            System.out.print("Prenom du chauffeur : ");
            try {
                prenomChauffeur = scanner.nextLine().trim();
                if (!prenomChauffeur.matches("^[a-zA-Z]*$")) {
                    throw new Exceptions.InvalidDriverNameException("Erreur : Veuillez entrer un prenom en lettres uniquement.");
                }
                break;
            } catch (Exceptions.InvalidDriverNameException e) {
                System.out.println("\033[31m" + e.getMessage() + "\033[0m");
            }
        }
        return prenomChauffeur;
    }

    public static int validateAge(Scanner scanner) {
        int age = 0;
        while (true) {
            try {
                System.out.print("Âge : ");
                age = scanner.nextInt();
                if (age <= 0) {
                    throw new Exceptions.InvalidAgeException("Erreur : L'âge doit être un entier positif.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Erreur : Veuillez entrer un entier pour l'âge.");
                scanner.next(); // to consume the invalid token
            } catch (Exceptions.InvalidAgeException e) {
                System.out.println(e.getMessage());
            }
        }
        return age;
    }

    public static int validateHiringYear(Scanner scanner) {
        int hiringYear = 0;
        while (true) {
            try {
                System.out.print("Année d'embauche : ");
                hiringYear = scanner.nextInt();
                if (hiringYear < 1900 || hiringYear > Calendar.getInstance().get(Calendar.YEAR)) {
                    throw new Exceptions.InvalidHiringYearException("Erreur : L'année d'embauche doit être entre 1900 et l'année courante.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Erreur : Veuillez entrer un entier pour l'année d'embauche.");
                scanner.next(); // to consume the invalid token
            } catch (Exceptions.InvalidHiringYearException e) {
                System.out.println(e.getMessage());
            }
        }
        return hiringYear;
    }
    public static String validateAddress(Scanner scanner) {
        String address = "";
        while (true) {
            System.out.print("Adresse : ");
            try {
                address = scanner.nextLine().trim();
                if (!address.matches("^\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)\\s+[A-Za-z]\\d[A-Za-z]\\s?\\d[A-Za-z]\\d$")) {
                    throw new Exceptions.InvalidAddressException("Erreur : Veuillez entrer une adresse valide.\nExemple: 123 rue rue Quebec A1A 1A1");                }
                break;
            } catch (Exceptions.InvalidAddressException e) {
                System.out.println(e.getMessage());
            }
        }
        return address;
    }

}