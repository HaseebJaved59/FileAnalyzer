import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileAnalyzer {
    public static void main(String[] args) {
        String fileName = "input.txt"; 
        int vowels = 0, consonants = 0, digits = 0, uppercase = 0, lowercase = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                char character = (char) ch;
                if (Character.isDigit(character)) {
                    digits++;
                } else if (Character.isLetter(character)) {
                    if (Character.isUpperCase(character)) {
                        uppercase++;
                        if (isVowel(character)) {
                            vowels++;
                        } else {
                            consonants++;
                        }
                    } else {
                        lowercase++;
                        if (isVowel(character)) {
                            vowels++;
                        } else {
                            consonants++;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Number of vowels in the file: " + vowels);
        System.out.println("Number of consonants in the file: " + consonants);
        System.out.println("Number of digits in the file: " + digits);
        System.out.println("Number of uppercase letters in the file: " + uppercase);
        System.out.println("Number of lowercase letters in the file: " + lowercase);
    }

    private static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
