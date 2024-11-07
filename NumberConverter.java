import java.util.Scanner;

public class NumberConverter {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) { //using try so that Scanner sc can create an object otherwise it was showing error
            System.out.println("Enter an integer:");
            int inputValue = sc.nextInt();

            if (isPrimeNumber(inputValue)) {
                System.out.println("Binary representation: " + convertToBinary(inputValue));
            } else {
                System.out.println("Octal representation: " + convertToOctal(inputValue));
            }
        }
    }

    private static boolean isPrimeNumber(int numberToCheck) {
        if (numberToCheck <= 1) {
            return false;
        }

        for (int divisor = 2; divisor <= Math.sqrt(numberToCheck); divisor++) {
            if (numberToCheck % divisor == 0) {
                return false;
            }
        }

        return true;
    }

    private static String convertToBinary(int decimalNumber) {
        StringBuilder binaryRepresentation = new StringBuilder();

        while (decimalNumber > 0) {
            binaryRepresentation.insert(0, decimalNumber % 2);
            decimalNumber /= 2;
        }

        return binaryRepresentation.toString();
    }

    private static String convertToOctal(int decimalNumber) {
        StringBuilder octalRepresentation = new StringBuilder();

        while (decimalNumber > 0) {
            octalRepresentation.insert(0, decimalNumber % 8);
            decimalNumber /= 8;
        }

        return octalRepresentation.toString();
    }
}