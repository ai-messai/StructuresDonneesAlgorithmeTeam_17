package src;

public class Exceptions {

    public static class InvalidBusNumberException extends Exception {
        public InvalidBusNumberException(String message) {
            super(message);
        }
    }

    public static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }

    public static class NoTrajetFoundException extends Exception {
        public NoTrajetFoundException(String message) {
            super(message);
        }
    }

    public static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    public static class InvalidPassengerCountException extends Exception {
        public InvalidPassengerCountException(String message) {
            super(message);
        }
    }

    public static class InvalidColorException extends Exception {
        public InvalidColorException(String message) {
            super(message);
        }
    }

    public static class InvalidDriverNameException extends Exception {
        public InvalidDriverNameException(String message) {
            super(message);
        }
    }

    public static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }

    public static class InvalidHiringYearException extends Exception {
        public InvalidHiringYearException(String message) {
            super(message);
        }
    }

    public static class InvalidAddressException extends Exception {
        public InvalidAddressException(String message) {
            super(message);
        }
    }
}
