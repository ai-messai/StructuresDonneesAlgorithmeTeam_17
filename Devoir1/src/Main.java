import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // creation de tableaux
        Bus[] buses = new Bus[10];
        Chauffeur[] chauffeurs = new Chauffeur[10];
        Trajet[] trajets = new Trajet[10];

        int option;
        do {
            System.out.println("Menu Principal :");
            System.out.println("1. Faire une réservation de bus.");
            System.out.println("2. Trouver tout les bus conduits par un chauffeur en particulier.");
            System.out.println("3. Afficher tout les caractéristiques des trajets effectués ainsi que les caractéristiques des bus utilisés.");
            System.out.println("4. Saisir un bus.");
            System.out.println("5. Saisir un chauffeur.");
            System.out.println("6. Saisir un trajet.");
            System.out.println("7. Quitter.");
            System.out.print("Choisissez une option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Pour consommer le '\n' laissé par nextInt()

            switch (option) {
                case 1:
                    // réservation d’un bus
                    break;
                case 2:
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez choisir une option entre 1 et 7.");
                    break;
            }
        } while (option != 7);
    }
}
