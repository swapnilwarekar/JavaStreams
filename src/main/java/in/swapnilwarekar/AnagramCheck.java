package in.swapnilwarekar;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AnagramCheck {
    public static void main(String[] args) {
        String s1 = "Google";
        String s2 = "gellgo";
        System.out.println(checkAnanagram(s1, s2));

    }

    public static boolean checkAnanagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        s1 = s1.replace("\\s","").toLowerCase();
        s2 = s2.replace("\\s", "").toLowerCase();

        String sorted1 = Arrays.stream(s1.split("")).sorted().collect(Collectors.joining());
        String sorted2 = Arrays.stream(s2.split("")).sorted().collect(Collectors.joining());
        System.out.println(sorted1+" "+sorted2);
        return sorted1.equals(sorted2);
    }
}
