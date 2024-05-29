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

}
