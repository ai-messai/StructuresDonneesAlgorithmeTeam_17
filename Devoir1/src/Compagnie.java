import java.util.ArrayList;

public class Compagnie {

    public Compagnie() {
        ArrayList<Bus> buses = new ArrayList<>();
        ArrayList<Chauffeur> chauffeurs = new ArrayList<>();
    }

    public void printReservationDetails(Bus busForReservation, Chauffeur chauffeurForReservation, Trajet trajet) {
        System.out.println("\n\033[33m" + "========================================");
        System.out.println("\033[32m" + "Réservation de bus effectuée avec succès !");
        System.out.println("\033[33m" + "========================================" + "\033[0m");

        System.out.println("\n\033[34m" + "Résumé de la réservation :" + "\033[0m");
        System.out.println("\033[33m" + "-------------------------" + "\033[0m");

        System.out.println("\n\033[34m" + "Détails du bus :" + "\033[0m");
        System.out.println("Numéro d'immatriculation : " + busForReservation.getRegistrationNumber());
        System.out.println("Capacité du réservoir : " + busForReservation.getTankCapacity());
        System.out.println("Nombre de passagers : " + busForReservation.getPassengerCount());
        System.out.println("Couleur : " + busForReservation.getColor());

        System.out.println("\n\033[34m" + "Détails du chauffeur :" + "\033[0m");
        System.out.println("Prénom : " + chauffeurForReservation.getFirstName());
        System.out.println("Nom : " + chauffeurForReservation.getLastName());
        System.out.println("Âge : " + chauffeurForReservation.getAge());
        System.out.println("Année d'embauche : " + chauffeurForReservation.getHiringYear());
        System.out.println("Adresse : " + chauffeurForReservation.getAddress());
        System.out.println("ID : " + chauffeurForReservation.getId());

        System.out.println("\n\033[34m" + "Détails du trajet :" + "\033[0m");
        System.out.println("Ville de départ : " + trajet.getDepartureCity());
        System.out.println("Ville d'arrivée : " + trajet.getArrivalCity());
        System.out.println("Kilométrage au départ : " + trajet.getDepartureKilometer());
        System.out.println("Kilométrage à l'arrivée : " + trajet.getArrivalKilometer());
    }
}