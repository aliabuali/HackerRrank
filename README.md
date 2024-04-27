# HackerRrank
# Roman Numeral Converter
<img width="771" alt="Screenshot 2024-04-27 at 10 56 47 PM" src="https://github.com/aliabuali/HackerRrank/assets/48154810/b21f8f07-0c02-4184-8b7c-3d1c0b629f3b">
<img width="767" alt="Screenshot 2024-04-27 at 10 56 59 PM" src="https://github.com/aliabuali/HackerRrank/assets/48154810/722dd8e4-7f9b-43dc-b30d-71193fcf583c">

import java.util.*;
import java.util.stream.Collectors;

public class Solution{

    public static List<String> romanizer(List<Integer> numbers) {
        // Map of Roman numerals
        LinkedHashMap<Integer, String> romanNumeralsMap = new LinkedHashMap<>();
        romanNumeralsMap.put(1000, "M");
        romanNumeralsMap.put(900, "CM");
        romanNumeralsMap.put(500, "D");
        romanNumeralsMap.put(400, "CD");
        romanNumeralsMap.put(100, "C");
        romanNumeralsMap.put(90, "XC");
        romanNumeralsMap.put(50, "L");
        romanNumeralsMap.put(40, "XL");
        romanNumeralsMap.put(10, "X");
        romanNumeralsMap.put(9, "IX");
        romanNumeralsMap.put(5, "V");
        romanNumeralsMap.put(4, "IV");
        romanNumeralsMap.put(1, "I");

        // Convert numbers to Roman numerals
        return numbers.stream()
            .map(number -> {
                StringBuilder roman = new StringBuilder();
                for (var entry : romanNumeralsMap.entrySet()) {
                    while (number >= entry.getKey()) {
                        roman.append(entry.getValue());
                        number -= entry.getKey();
                    }
                }
                return roman.toString();
            })
            .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbersCount = Integer.parseInt(scanner.nextLine().trim());
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numbersCount; i++) {
            numbers.add(Integer.parseInt(scanner.nextLine().trim()));
        }

        List<String> result = romanizer(numbers);

        result.forEach(System.out::println);
        scanner.close();
    }
}
