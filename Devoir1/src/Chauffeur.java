import java.util.ArrayList;
import java.util.Scanner;

public class Chauffeur {
    private String firstName;
    private String lastName;
    private int age;
    private int hiringYear;
    private String address;
    private ArrayList<Trajet> trajets;
    private String id;

    public Chauffeur(String firstName, String lastName, int age, int hiringYear, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hiringYear = hiringYear;
        this.address = address;
        this.trajets = new ArrayList<>();
        this.id = generateId();
    }

    public String getId() {
        return this.id;
    }

    private String generateId() {
        String idLastName = lastName.length() < 4 ? lastName : lastName.substring(0, 4);
        return idLastName + firstName.charAt(0) + String.valueOf(hiringYear).substring(2);
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int getAge() {
        return this.age;
    }

    public int getHiringYear() {
        return this.hiringYear;
    }

    public String getAddress() {
        return this.address;
    }

    public static Chauffeur findOrCreateChauffeur(Scanner scanner, Chauffeur[] chauffeurs) {
        System.out.print("Nom du chauffeur : ");
        String chauffeurName = scanner.nextLine();

        Chauffeur chauffeurForReservation = null;
        for (Chauffeur c : chauffeurs) {
            if (c != null && c.getLastName().equals(chauffeurName)) {
                chauffeurForReservation = c;
                break;
            }
        }

        if (chauffeurForReservation == null) {
            System.out.println("\033[31m" + "Aucun chauffeur trouvé avec ce nom." + "\033[0m");
            System.out.println("\033[32m" + "Création d'un nouveau Chauffeur." + "\033[0m");
            System.out.print("Prénom : ");
            String firstName = scanner.nextLine();
            System.out.print("Âge : ");
            int age = scanner.nextInt();
            System.out.print("Année d'embauche : ");
            int hiringYear = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Adresse : ");
            String address = scanner.nextLine();

            chauffeurForReservation = new Chauffeur(firstName, chauffeurName, age, hiringYear, address);

            for (int i = 0; i < chauffeurs.length; i++) {
                if (chauffeurs[i] == null) {
                    chauffeurs[i] = chauffeurForReservation;
                    System.out.println("Chauffeur ajouté avec succès !");
                    break;
                }
            }
        }

        return chauffeurForReservation;
    }
}