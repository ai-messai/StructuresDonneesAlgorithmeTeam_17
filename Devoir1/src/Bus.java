// Classe Bus
import java.util.Scanner;
public class Bus {
    private Chauffeur chauffeur;
    private Trajet trajet;

    // Caractéristiques du bus
    private String registrationNumber; // Numéro d'immatriculation
    private double tankCapacity; // Capacité du réservoir
    private int passengerCount; // Nombre de passagers
    private String color; // Couleur

    // Constructeur de la classe Bus
    public Bus(String registrationNumber, double tankCapacity, int passengerCount, String color) {
        this.registrationNumber = registrationNumber;
        this.tankCapacity = tankCapacity;
        this.passengerCount = passengerCount;
        this.color = color;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public double getTankCapacity() {
        return this.tankCapacity;
    }

    public int getPassengerCount() {
        return this.passengerCount;
    }

    public String getColor() {
        return this.color;
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
    public void displayCharacteristics() {
        System.out.println("\033[32m" + "==> Registration Number: " + registrationNumber + "\033[0m");
        System.out.println("\033[32m" + "==> Tank Capacity: " + tankCapacity + "\033[0m");
        System.out.println("\033[32m" + "==> Passenger Count: " + passengerCount + "\033[0m");
        System.out.println("\033[32m" + "==> Color: " + color + "\033[0m");
    }

    public static Bus findOrCreateBus(Scanner scanner, Bus[] buses) throws Exceptions.InvalidBusNumberException {
        System.out.println("Entrez les informations pour la réservation d’un bus :");
        System.out.print("Numéro d'immatriculation du bus : ");
        String busNumber = scanner.nextLine();

        // Validate bus number
        if (!busNumber.matches("[A-Za-z0-9]{6}")) {
            System.out.println("Le numéro d'immatriculation n'est pas valide ! ");
            throw new Exceptions.InvalidBusNumberException("Format invalide : " + busNumber + " - Veuiller entrer un numéro d'immatriculation de 6 charactères.");
        }

        Bus busForReservation = null;
        for (Bus b : buses) {
            if (b != null && b.getRegistrationNumber().equals(busNumber)) {
                busForReservation = b;
                break;
            }
        }

        if (busForReservation == null) {
            System.out.println("\033[31m" + "Aucun bus trouvé avec ce numéro d'immatriculation. Création d'un nouveau bus." + "\033[0m");
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
}