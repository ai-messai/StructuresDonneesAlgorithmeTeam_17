// Classe Bus
import java.util.Scanner;
import src.Exceptions;


public class Bus {
    private Chauffeur chauffeur;
    private Trajet trajet;

    // Caractéristiques
    private String numImmatriculation;
    private double capaciteReservoir;
    private int nbrPassager;
    private String couleur;

    // Constructeur
    public Bus(String numImmatriculation, double capaciteReservoir, int passengerCount, String couleur) {
        this.numImmatriculation = numImmatriculation;
        this.capaciteReservoir = capaciteReservoir;
        this.nbrPassager = passengerCount;
        this.couleur = couleur;
    }

    public String getNumImmatriculation() {
        return this.numImmatriculation;
    }

    public double getCapaciteReservoir() {
        return this.capaciteReservoir;
    }

    public int getNbrPassager() {
        return this.nbrPassager;
    }

    public String getCouleur() {
        return this.couleur;
    }

    public void setChauffeur(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }

    public Chauffeur getChauffeur() {
        return this.chauffeur;
    }

    // Méthode pour afficher les caractéristiques du bus
    public void affichageCarachteristique() {
        System.out.println("\033[32m" + "==> Numero d'immatriculation : " + numImmatriculation + "\033[0m");
        System.out.println("\033[32m" + "==> Capacité du Reservoir : " + capaciteReservoir + "\033[0m");
        System.out.println("\033[32m" + "==> Nombre de Passagers : " + nbrPassager + "\033[0m");
        System.out.println("\033[32m" + "==> Couleur : " + couleur + "\033[0m");
    }

    public static Bus creationBus(Scanner scanner, Bus[] buses) throws Exceptions.InvalidBusNumberException {
        System.out.println("Entrez les informations pour la réservation d’un bus :");
        System.out.print("Numéro d'immatriculation du bus : ");
        String busNumber = scanner.nextLine();

        // validation de l'immatriculation
        if (!busNumber.matches("[A-Za-z0-9]{6}")) {
            System.out.println("Le numéro d'immatriculation n'est pas valide ! ");
            throw new Exceptions.InvalidBusNumberException("Format invalide : " + busNumber + " - Veuiller entrer un numéro d'immatriculation de 6 charactères.");
        }

        Bus busForReservation = null;
        for (Bus b : buses) {
            if (b != null && b.getNumImmatriculation().equals(busNumber)) {
                busForReservation = b;
                break;
            }
        }

        if (busForReservation == null) {
            System.out.println("\033[31m" + "Aucun bus trouvé avec ce numéro d'immatriculation." + "\033[0m");
            System.out.println("\033[32m" + "Création d'un nouveau bus." + "\033[0m");

            System.out.print("Capacité du réservoir : ");
            double tankCapacity = scanner.nextDouble();

            System.out.print("Nombre de passagers : ");
            int passengerCount = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Couleur : ");
            String color = scanner.nextLine();

            busForReservation = new Bus(busNumber, tankCapacity, passengerCount, color);

            for (int i = 0; i < buses.length; i++) {
                if (buses[i] == null) {
                    buses[i] = busForReservation;
                    System.out.println("Bus ajouté avec succès !");
                    break;
                }
            }
        }

        return busForReservation;
    }

    public static Bus createBusWithValidation(Scanner scanner, Bus[] buses) {
        Bus reservationBus;
        while (true) {
            try {
                reservationBus = Bus.creationBus(scanner, buses);
                break;
            } catch (Exceptions.InvalidBusNumberException e) {
                System.out.println("\033[31m" + e.getMessage() + "\033[0m");
            }
        }
        return reservationBus;
    }
}