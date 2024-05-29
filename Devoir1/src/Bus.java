import java.util.Scanner;

import org.jetbrains.annotations.NotNull;
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
    public Bus(String numImmatriculation, double capaciteReservoir, int nbrPassager, String couleur) {
        this.numImmatriculation = numImmatriculation;
        this.capaciteReservoir = capaciteReservoir;
        this.nbrPassager = nbrPassager;
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

    public void affichageCarachteristique() {
        System.out.println("\033[32m" + "==> Numero d'immatriculation : " + numImmatriculation + "\033[0m");
        System.out.println("\033[32m" + "==> Capacité du Reservoir : " + capaciteReservoir + "\033[0m");
        System.out.println("\033[32m" + "==> Nombre de Passagers : " + nbrPassager + "\033[0m");
        System.out.println("\033[32m" + "==> Couleur : " + couleur + "\033[0m");
    }

    public static @NotNull Bus creationBus(@NotNull Scanner scanner, Bus[] buses) throws Exceptions.InvalidBusNumberException {
        System.out.println("Entrez les informations pour la réservation d’un bus :");
        System.out.print("Numéro d'immatriculation du bus : ");
        String busNumber = scanner.nextLine();

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

            double tankCapacity = validateTankCapacity(scanner);
            int passengerCount = validatePassengerCount(scanner);
            String color = validateColor(scanner);

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

    public static double validateTankCapacity(@NotNull Scanner scanner) {

            double tankCapacity = 0;
            while (true) {
                try {
                    System.out.print("Capacité du réservoir : ");
                    String input = scanner.nextLine();
                    tankCapacity = Double.parseDouble(input);
                    if (tankCapacity <= 0) {
                        throw new Exceptions.InvalidCapacityException("Erreur : La capacité du réservoir doit être un chiffre positif.");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("\033[31mErreur : Veuillez entrer un chiffre pour la capacité du réservoir en Litre.\033[0m");
                } catch (Exceptions.InvalidCapacityException e) {
                    System.out.println("\033[31m" + e.getMessage() + "\033[0m");
                }
            }
            return tankCapacity;
    }

    public static int validatePassengerCount(@org.jetbrains.annotations.NotNull Scanner scanner) {
        int passengerCount = 0;
        while (true) {
            System.out.print("Nombre de passagers : ");
            try {
                String input = scanner.nextLine().trim();
                passengerCount = Integer.parseInt(input);
                if (passengerCount <= 0) {
                    throw new Exceptions.InvalidPassengerCountException("Erreur : Le nombre de passagers doit être un entier positif.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("\033[31mErreur : Veuillez entrer un entier pour le nombre de passagers.\033[0m");
            } catch (Exceptions.InvalidPassengerCountException e) {
                System.out.println("\033[31m" + e.getMessage() + "\033[0m");
            }
        }
        return passengerCount;
    }

    public static String validateColor(@NotNull Scanner scanner){
        String color = "";
        while (true) {
            System.out.print("Couleur : ");
            try {
                color = scanner.nextLine().trim();
                if (!color.matches("^[a-zA-Z]*$")) {
                    throw new Exceptions.InvalidColorException("Erreur : Veuillez entrer une couleur en lettres uniquement.");
                }
                break;
            } catch (Exceptions.InvalidColorException e) {
                System.out.println("\033[31m" + e.getMessage() + "\033[0m");
            }
        }
        return color;
    }

    public static Bus createBusWithValidation(Scanner scanner, Bus[] buses) {
        Bus reservationBus = null;
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