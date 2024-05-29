import java.util.Scanner;

public class Trajet {
    private String departureCity;
    private String arrivalCity;
    private double departureKilometer;
    private double arrivalKilometer;
    private Bus bus;

    public Trajet(String departureCity, String arrivalCity, double departureKilometer, double arrivalKilometer, Bus bus) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureKilometer = departureKilometer;
        this.arrivalKilometer = arrivalKilometer;
        this.bus = bus;
    }

    public Bus getBus() {
        return this.bus;
    }

    public String getDepartureCity() {
        return this.departureCity;
    }

    public String getArrivalCity() {
        return this.arrivalCity;
    }

    public double getDepartureKilometer() {
        return this.departureKilometer;
    }

    public double getArrivalKilometer() {
        return this.arrivalKilometer;
    }

    public static Trajet createTrajet(Scanner scanner, Bus bus, Trajet[] trajets) {
        System.out.print("Ville de départ : ");
        String departureCity = scanner.nextLine();
        System.out.print("Ville d'arrivée : ");
        String arrivalCity = scanner.nextLine();
        System.out.print("Kilométrage au départ : ");
        double departureKilometer = scanner.nextDouble();
        System.out.print("Kilométrage à l'arrivée : ");
        double arrivalKilometer = scanner.nextDouble();
        scanner.nextLine(); // Pour consommer le '\n' laissé par nextDouble()

        Trajet trajet = new Trajet(departureCity, arrivalCity, departureKilometer, arrivalKilometer, bus);

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
        System.out.println("Departure City: " + departureCity);
        System.out.println("Arrival City: " + arrivalCity);
        System.out.println("Departure Kilometer: " + departureKilometer);
        System.out.println("Arrival Kilometer: " + arrivalKilometer);
        System.out.println("Bus Characteristics: ");
    }
}