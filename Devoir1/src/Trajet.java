import java.util.InputMismatchException;
import java.util.Scanner;

import org.jetbrains.annotations.NotNull;
import ExceptionsFo.Exceptions;

public class Trajet {
    private String villeDepart;
    private String VilleArriver;
    private double killometrageDepart;
    private double kilometrageArriver;
    private Bus bus;

    public Trajet(String villeDepart, String VilleArriver, double killometrageDepart, double kilometrageArriver, Bus bus) {
        this.villeDepart = villeDepart;
        this.VilleArriver = VilleArriver;
        this.killometrageDepart = killometrageDepart;
        this.kilometrageArriver = kilometrageArriver;
        this.bus = bus;
    }

    public Bus getBus() {
        return this.bus;
    }

    public String getVilleDepart() {
        return this.villeDepart;
    }

    public String getVilleArriver() {
        return this.VilleArriver;
    }

    public double getKillometrageDepart() {
        return this.killometrageDepart;
    }

    public double getKilometrageArriver() {
        return this.kilometrageArriver;
    }

    public static @NotNull Trajet createTrajet(@NotNull Scanner scanner, Bus bus, Trajet[] trajets) {
        String villeDepart = "";
        String villeArriver = "";
        double kilometrageDepart = 0;
        double kilometrageArriver = 0;

        while (true) {
            try {
                System.out.print("Ville de départ : ");
                villeDepart = scanner.nextLine();
                if (!villeDepart.matches("[a-zA-Z]+")) {
                    throw new Exceptions.InvalideNomDeVilleException("Erreur : Le nom de la ville de départ doit être composé uniquement de lettres.");
                }

                System.out.print("Ville d'arrivée : ");
                villeArriver = scanner.nextLine();
                if (!villeArriver.matches("[a-zA-Z]+")) {
                    throw new Exceptions.InvalideNomDeVilleException("Erreur : Le nom de la ville d'arrivée doit être composé uniquement de lettres.");
                }

                if (villeDepart.equalsIgnoreCase(villeArriver)) {
                    throw new Exceptions.InvalideVilleException("Erreur : La ville de d��part ne doit pas être la même que la ville d'arrivée.");
                }
                break;
            } catch (Exceptions.InvalideVilleException | Exceptions.InvalideNomDeVilleException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Kilométrage au départ : ");
                try {
                    kilometrageDepart = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    throw new Exceptions.InvalidwKmException("Erreur : Le kilometrage de depart doit etre un nombre.");
                }
                if (kilometrageDepart < 0) {
                    throw new Exceptions.InvalidwKmException("Erreur : Le kilometrage de depart doit etre un nombre positif.");
                }

                System.out.print("Kilometrage à l'arriver : ");
                try {
                    kilometrageArriver = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    throw new Exceptions.InvalidwKmException("Erreur : Le kilometrage à l'arriver doit etre un nombre.");
                }
                if (kilometrageArriver < 0) {
                    throw new Exceptions.InvalidwKmException("Erreur : Le kilometrage à l'arriver doit etre un nombre positif.");
                }

                if (kilometrageArriver <= kilometrageDepart) {
                    throw new Exceptions.InvalideKmException("Erreur : Le kilometrage à l'arriver ne doit pas être plus petit que le kilométrage de depart.");
                }
                break;
            } catch (Exceptions.InvalideKmException | Exceptions.InvalidwKmException e) {
                System.out.println(e.getMessage());
                scanner.nextLine(); // clear the input
            }
        }

        scanner.nextLine();
        Trajet trajet = new Trajet(villeDepart, villeArriver, kilometrageDepart, kilometrageArriver, bus);

        // Ajouter le trajet au tableau de trajets
        for (int i = 0; i < trajets.length; i++) {
            if (trajets[i] == null) {
                trajets[i] = trajet;
                break;
            }
        }
        return trajet;
    }



    public void displayCharacteristic() {
        System.out.println("Ville de depart: " + villeDepart);
        System.out.println("Ville d’arrivee: " + VilleArriver);
        System.out.println("Kilométrage au départ: " + killometrageDepart);
        System.out.println("kilométrage à l’arrivée : " + kilometrageArriver);
        System.out.println("Bus Characteristics: ");
    }
}