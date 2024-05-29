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
            System.out.println("######################################################################");
            System.out.println("#    Menu Principal :                                                #");
            System.out.println("# 1. Faire une réservation de bus.                                   #");
            System.out.println("# 2. Trouver tout les bus conduits par un chauffeur en particulier.  #");
            System.out.println("# 3. Affichage des trajets ainsi que les bus utilisés.               #");
            System.out.println("# 4. Quitter.                                                        #");
            System.out.println("######################################################################");
            System.out.print("# Choisissez une option : ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    // Saisie des informations pour la réservation d’un bus
                    Bus busForReservation;
                    try {
                        busForReservation = Bus.findOrCreateBus(scanner, buses);
                    } catch (Exceptions.InvalidBusNumberException e) {
                        System.out.println("\033[31m" + e.getMessage() + "\033[0m");
                        break;
                    }
                    Chauffeur chauffeurForReservation = Chauffeur.findOrCreateChauffeur(scanner, chauffeurs);
                    Trajet trajet = Trajet.createTrajet(scanner, busForReservation, trajets);

                    // Création du trajet et attribution du trajet et du chauffeur au bus
                    trajet = new Trajet(trajet.getDepartureCity(), trajet.getArrivalCity(), trajet.getDepartureKilometer(), trajet.getArrivalKilometer(), busForReservation);
                    busForReservation.setChauffeur(chauffeurForReservation);
                    busForReservation.setTrajet(trajet);

                    // Create Compagnie object and print reservation details
                    Compagnie compagnie = new Compagnie();
                    compagnie.printReservationDetails(busForReservation, chauffeurForReservation, trajet);
                    break;

                case 2:
                    System.out.println("Veuillez entrer le nom du chauffeur afin de trouver tout les bus qu'il a conduit :");
                    String chauffeurName = scanner.nextLine();
                    for (Bus b : buses) {
                        if (b != null && b.getChauffeur() != null && b.getChauffeur().getLastName().equals(chauffeurName)) {
                            System.out.println("Bus conduit par " + chauffeurName + " :");
                            b.displayCharacteristics();
                        }
                    }
                    break;

                case 3:
                    int nbrTrajet = 1;
                    for (Trajet t : trajets) {
                        if (t != null) {
                            System.out.println("Trajet " + nbrTrajet + " :");
                            System.out.println("----------------------------------------");
                            t.displayCharacteristic();
                            Bus b = t.getBus();
                            if (b != null) {
                                System.out.println("----------------------------------------");
                                System.out.println("Caractéristique de bus pour le trajet " + nbrTrajet + " :");
                                b.displayCharacteristics();
                            }
                            System.out.println("========================================");
                            nbrTrajet++;
                        }
                    }
                    break;

                case 4:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez choisir une option entre 1 et 4.");
                    break;
            }
        } while (option != 4);
    }
}