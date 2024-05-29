import src.Exceptions.InvalidInputException;
import src.Exceptions.NoTrajetFoundException;
import java.util.Scanner;
import src.Exceptions;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // creation de tableaux
        Bus[] buses = new Bus[10];
        Chauffeur[] chauffeurs = new Chauffeur[10];
        Trajet[] trajets = new Trajet[10];

        int option = 0;
        do {
            try {
                System.out.println("######################################################################");
                System.out.println("#    Menu Principal :                                                #");
                System.out.println("# 1. Faire une réservation de bus.                                   #");
                System.out.println("# 2. Trouver tout les bus conduits par un chauffeur en particulier.  #");
                System.out.println("# 3. Affichage des trajets ainsi que les bus utilisés.               #");
                System.out.println("# 4. Quitter.                                                        #");
                System.out.println("######################################################################");
                System.out.print("# Choisissez une option : ");

                while (!scanner.hasNextInt()) {
                    scanner.next();
                    throw new InvalidInputException("Erreur : Veuillez entrer un chiffre entre 1 et 4.");
                }
                option = scanner.nextInt();

            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
                continue;
            }
            
            scanner.nextLine();

            try {
                switch (option) {
                    case 1:

                        Bus reservationBus = Bus.createBusWithValidation(scanner, buses);

                        Chauffeur chauffeurForReservation = Chauffeur.findOrCreateChauffeur(scanner, chauffeurs);
                        Trajet trajet = Trajet.createTrajet(scanner, reservationBus, trajets);

                        trajet = new Trajet(trajet.getDepartureCity(), trajet.getArrivalCity(), trajet.getDepartureKilometer(), trajet.getArrivalKilometer(), reservationBus);
                        reservationBus.setChauffeur(chauffeurForReservation);
                        reservationBus.setTrajet(trajet);

                        Compagnie compagnie = new Compagnie();
                        compagnie.printReservationDetails(reservationBus, chauffeurForReservation, trajet);
                        break;
                    case 2:
                        System.out.print("Veuillez entrer le nom du chauffeur afin de trouver tout les bus qu'il a conduit :");
                        String chauffeurName = scanner.nextLine();
                        int busCount = 0;
                        for (Bus b : buses) {
                            if (b != null && b.getChauffeur() != null && b.getChauffeur().getLastName().equals(chauffeurName)) {
                                busCount++;
                                System.out.println("Bus " + busCount + " conduit par " + chauffeurName + " :");
                                b.affichageCarachteristique();
                                System.out.println("----------------------------------------");
                            }
                        }
                        if (busCount == 0) {
                            System.out.println("Aucun bus conduit par " + chauffeurName + ".");
                        } else {
                            System.out.println("Total de bus conduit par " + chauffeurName + " : " + busCount);
                        }
                        break;
                    case 3:
                        int nbrTrajet = 1;
                        boolean trajetFound = false;
                        for (Trajet t : trajets) {
                            if (t != null) {
                                trajetFound = true;
                                System.out.println("Trajet " + nbrTrajet + " :");
                                System.out.println("----------------------------------------");
                                t.displayCharacteristic();
                                Bus b = t.getBus();
                                if (b != null) {
                                    System.out.println("----------------------------------------");
                                    System.out.println("Caractéristique de bus pour le trajet " + nbrTrajet + " :");
                                    b.affichageCarachteristique();
                                }
                                System.out.println("========================================");
                                nbrTrajet++;
                            }
                        }
                        if (!trajetFound) {
                            throw new NoTrajetFoundException("Aucun trajet trouvé.");
                        }
                        break;

                    case 4:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Option invalide. Veuillez choisir une option entre 1 et 4.");
                        break;
                }
            } catch (NoTrajetFoundException e) {
                System.out.println(e.getMessage());
            }
        } while (option != 4);
    }
}