package in.swapnilwarekar;

import java.util.stream.IntStream;

public class PalindromCheck {
    public static void main(String[] args) {
        String s1 = "madam";

        String lowered = s1.toLowerCase();
        boolean isPalindrom = IntStream.range(0, s1.length()/2).allMatch(i-> lowered.charAt(i) == lowered.charAt(lowered.length()-i-1));
        System.out.println(isPalindrom);
    }
}
