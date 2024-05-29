public class Exceptions {
    public static class InvalidBusNumberException extends Exception {
        public InvalidBusNumberException(String message) {
            super(message);
        }
    }
}
