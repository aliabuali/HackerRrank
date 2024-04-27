import java.util.*;

class Result {

    public static List<Integer> getOneBits(int n) {
        // Create a StringBuilder to hold the binary representation
        StringBuilder binary = new StringBuilder();
        // List to store the positions of '1' bits
        List<Integer> positions = new ArrayList<Integer>();

        // Convert the integer to binary representation
        while (n != 0) {
            // Use bitwise AND to check if the least significant bit is '1' or '0'
            binary.insert(0, (n & 1));
            n >>>= 1; // Use unsigned shift to handle all bits correctly
        }

        // First element is the number of '1' bits
        int onesCount = 0;
        // Iterate over the binary representation to find '1' bits
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                onesCount++;
                // Add the position of the '1' bit to the list
                // Position is calculated from the left, starting with 1
                positions.add(i + 1);
            }
        }

        // The result should contain the count of '1's followed by the positions
        List<Integer> result = new ArrayList<Integer>();
        result.add(onesCount);
        result.addAll(positions);

        return result;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> result = Result.getOneBits(n);

        for (int num : result) {
            System.out.println(num);
        }

        scanner.close();
    }
}
