package vigenere_algorithm;

public class VigenereCipher {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int RANGE = ALPHABET.length();

    public static String encrypt(String plainText, String key) {
        StringBuilder cipherText = new StringBuilder();

        plainText = plainText.toUpperCase();
        key = key.toUpperCase();

        int keyIndex = 0;
        for (char ch : plainText.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                int textIndex = ALPHABET.indexOf(ch);
                int keyShift = ALPHABET.indexOf(key.charAt(keyIndex % key.length()));
                int cipherIndex = (textIndex + keyShift) % RANGE;
                cipherText.append(ALPHABET.charAt(cipherIndex));
                keyIndex++;
            } else {
                cipherText.append(ch);
            }
        }

        return cipherText.toString();
    }

    public static String decrypt(String cipherText, String key) {
        StringBuilder plainText = new StringBuilder();

        cipherText = cipherText.toUpperCase();
        key = key.toUpperCase();

        int keyIndex = 0;
        for (char ch : cipherText.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                int cipherIndex = ALPHABET.indexOf(ch);
                int keyShift = ALPHABET.indexOf(key.charAt(keyIndex % key.length()));
                int textIndex = (cipherIndex - keyShift + RANGE) % RANGE;
                plainText.append(ALPHABET.charAt(textIndex));
                keyIndex++;
            } else {
                plainText.append(ch);
            }
        }

        return plainText.toString();
    }
}
