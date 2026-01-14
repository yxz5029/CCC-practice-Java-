import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestRepeatingSubstring {
    public static void main0(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inpt = sc.nextLine();
        sc.close();
        int length = 0;
        for (int i = 0; i < inpt.length() - 1; i++) {
            char ch = inpt.charAt(i);
            for (int j = i + 1; j < inpt.length(); j++) {
                char ch2 = inpt.charAt(j);
                if (ch == ch2) {
                    length = Math.max(findSameArrays(ch, ch2, inpt, i + 1, j + 1), length);
                }
            }
        }
        System.out.println(length);
    }

    static Integer findSameArrays(Character ch, Character ch2, String inpt, Integer i, Integer j) {
        int length = 1;
        while (i < inpt.length() && j < inpt.length()) {
            if (inpt.charAt(i) == inpt.charAt(j)) {
                length += 1;
            } else {
                break;
            }
            i += 1;
            j += 1;
        }
        return length;
    }


    // Set: HashSet.add(e): true or false

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inpt = sc.nextLine();
        sc.close();

        Set<String> seen = new HashSet<>();
        int longest = 0; 
        int start = 0;
        while (start+longest < inpt.length()) {
            String sub = inpt.substring(start, start+longest+1);
            if (seen.add(sub)) {
                start++; // next substring, same length
            }
            else {
                longest++;
                start = 0;
                seen.clear();
            }

        }
        System.out.println(longest);
    }


}
