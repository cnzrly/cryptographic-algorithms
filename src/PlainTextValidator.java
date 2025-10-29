public class PlainTextValidator {
    public static boolean isValid(String text) {
        return text.matches("[a-zA-Z0-9\\s]+");
    }

}
