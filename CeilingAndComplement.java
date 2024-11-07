import java.util.Scanner;

public class CeilingAndComplement 
{

    public static void main(String[] args) {
        try (Scanner userEntry = new Scanner(System.in)) {
            System.out.println("Enter a double value:");
            double enteredValue = userEntry.nextDouble();

            int roundedUpValue = getRoundedUpValue(enteredValue);
            System.out.println("Rounded up value: " + roundedUpValue);

            String twosComplementRepresentation = getComplement(roundedUpValue);
            System.out.println("2's complement: " + twosComplementRepresentation);
        }
    }

    private static int getRoundedUpValue(double number) {
        return (int) Math.ceil(number);
    }

    private static String getComplement(int number) {
        int bits = 32; // assuming 32-bit integer
        String binaryRepresentation = Integer.toBinaryString(number);
        binaryRepresentation = String.format("%" + bits + "s", binaryRepresentation).replace(' ', '0');

        StringBuilder complement = new StringBuilder();
        for (int i = 0; i < bits; i++) {
            complement.append(binaryRepresentation.charAt(i) == '0' ? '1' : '0');
        }

        complement = new StringBuilder(complement.toString());
        for (int i = 0; i < bits; i++) {
            if (complement.charAt(i) == '0') {
                complement.setCharAt(i, '1');
                break;
            } else {
                complement.setCharAt(i, '0');
            }
        }

        return complement.toString();
    }
}