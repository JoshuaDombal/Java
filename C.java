
import java.util.*;

public class C {


    public static void main(String[] args) {

        String r = "aa";
        String m = "aab";

        boolean answer = canConstruct(r, m);
        System.out.println(answer);

    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> ransom = new HashMap<>();
        Map<Character, Integer> mag = new HashMap<>();

        int ransLength = ransomNote.length();
        int magLength = magazine.length();

        // Creates hashmap for ransomNote
        for (int i = 0; i < ransLength; i++) {
            if (!ransom.containsKey(ransomNote.charAt(i))) {
                ransom.put(ransomNote.charAt(i), 1);
            } else {
                ransom.put(ransomNote.charAt(i), ransom.get(ransomNote.charAt(i))+1);
            }
        }
        // Creates hashmap for magazine
        for (int i = 0; i < magLength; i++) {
            if (!mag.containsKey(magazine.charAt(i))) {
                mag.put(magazine.charAt(i), 1);
            } else {
                mag.put(magazine.charAt(i), mag.get(magazine.charAt(i) + 1));
            }
        }

        if (ransom.size() > mag.size()) {
            System.out.println(ransom.size() + " " + mag.size());
            return false;
        } else {
            for (Character character : ransom.keySet()) {
                System.out.println(character);
                int num = ransom.get(character);
                if (mag.containsKey(character)) {
                    if (num > mag.get(character)) {
                        System.out.println("First");
                        return false;
                    }
                } else {
                    System.out.println("Second");
                    return false;
                }

            }
        }

        return true;


    }
}
