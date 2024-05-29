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

        System.out.println("\n\033[34m" + "Details du bus :" + "\033[0m");
        System.out.println("Numero d'immatriculation : " + busForReservation.getNumImmatriculation());
        System.out.println("Capacité du réservoir : " + busForReservation.getCapaciteReservoir());
        System.out.println("Nombre de passager : " + busForReservation.getNbrPassager());
        System.out.println("Couleur : " + busForReservation.getCouleur());

        System.out.println("\n\033[34m" + "Détails du chauffeur :" + "\033[0m");
        System.out.println("Prenom : " + chauffeurForReservation.getFirstName());
        System.out.println("Nom : " + chauffeurForReservation.getNom());
        System.out.println("Age : " + chauffeurForReservation.getAge());
        System.out.println("Année d'embauche : " + chauffeurForReservation.getAnneeEmbauche());
        System.out.println("Adresse : " + chauffeurForReservation.getAddresse());
        System.out.println("ID : " + chauffeurForReservation.getId());

        System.out.println("\n\033[34m" + "Details du trajet :" + "\033[0m");
        System.out.println("Ville de depart : " + trajet.getVilleDepart());
        System.out.println("Ville d'arriver : " + trajet.getVilleArriver());
        System.out.println("Kilometrage au départ : " + trajet.getKillometrageDepart());
        System.out.println("Kilometrage a l'arriver : " + trajet.getKilometrageArriver());
    }
}