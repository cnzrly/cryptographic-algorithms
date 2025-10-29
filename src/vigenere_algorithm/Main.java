import vigenere_algorithm.FileReaderUtil;
import vigenere_algorithm.PlainTextValidator;
import vigenere_algorithm.VigenereCipher;

void main() throws IOException {

    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter secret key: ");
    String key = scanner.nextLine();
    if (!PlainTextValidator.isValid(FileReaderUtil.readFile())) {
        System.err.println("Plain text can contain only English letters and digits!");
        return;
    }


    if (!PlainTextValidator.isValid(key)) {
        System.err.println("Key can contain only English letters and digits!");
        return;
    }

    String encrypted = VigenereCipher.encrypt(FileReaderUtil.readFile(), key);
    String decrypted = VigenereCipher.decrypt(encrypted, key);

    System.out.println();
    System.out.println("Plaintext:  " + FileReaderUtil.readFile());
    System.out.println("Key:        " + key);
    System.out.println("Encrypted:  " + encrypted);
    System.out.println("Decrypted:  " + decrypted);

    scanner.close();
}




