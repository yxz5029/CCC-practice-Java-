package homework.emma;//package homework.emma;

import java.beans.IndexedPropertyDescriptor;
import java.lang.reflect.Array;
import java.nio.channels.ReadPendingException;

import javax.security.auth.kerberos.KerberosCredMessage;
import java.util.regex.Pattern;

public class Homework17 {

    public static void main(String[] args) {

        int v = powerOfTwo(4);
        // console.log
        System.out.println("v is " + v);
        removeVowels("hello world");
        toUppercase("hello world");
        printRightTriangle(4);
        biggestLetter("ada");
        totalRotatables("HELLOW");
        int v2 = fibonacc(10);
        System.out.println(v2);
        int v3 = sumOfDigits(34);
        System.out.println(v3);
        hailstone(11);
        int[] v4 = runningSum(new int[] { 1, 2, 3, 4 });
        System.out.println(v4);
        int[] v5 = smallerNumbersThanCurrent(new int[] { 6, 5, 4, 8 });
        System.out.println(v5);
    }

    //
    // function powerOfTwo(n)
    static int powerOfTwo(int n) {

        if (n == 0) {
            return 1;
        }

        return 2 * powerOfTwo(n - 1);
    }

    static void printRightTriangle(int n) {
        if (n == 1) {
            System.out.println("*");
            return;
        }

        printRightTriangle(n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();

    }

    static String VOWELS = "aeiouAEIOU";

    // givne a string, use the same method to calculate substring(1), add 1 if the
    // first char is vowel
    //
    // totalVowels("abcdefg"): totalVowels("bcdefg") + (is "a" a vowel ? 1 : 0)

    /*
     * static int totalVowels(String str) {
     * if (str.isEmpty()) {
     * return 0;
     * }
     * 
     * // charAt(index): str = "abcdefg", str.charAt(0)='a', str.charAt(3)='d';
     * 
     * 
     * char ch = str.charAt(0);
     * String fstr = "" + ch;
     * int vs = VOWELS.contains(fstr) ? 1 : 0;
     * 
     * //String sss = VOWELS.substring(2);
     * 
     * if (str.length() > 1) {
     * String substr = str.substring(1); // str = "abcdefg",
     * str.substring(1)="bcdefg", str.substring(2, 4)="cd"
     * vs += totalVowels(substr);
     * }
     * 
     * return vs;
     * }
     */

    static String removeVowels(String str) {
        if (str.isEmpty()) {
            return str;
        }
        String ch = str.charAt(0) + "";
        /*
         * String result;
         * if (VOWELS.contains("" + ch)){
         * result = "";
         * }
         * else {
         * result = ch+"";
         * }
         */
        String result = VOWELS.contains(ch) ? "" : ch;

        if (str.length() > 1) {
            String substr = str.substring(1);
            result += removeVowels(substr);
        }

        return result;
    }

    static String words = "abcdefghijklmnopqrstuvwxyz";
    private static int abcdefghijklmnopqrstuvwxyz; // this is a variable

    /*
     * str.matches("[aeiou]"); // regex match and find are different
     * words.contains(str);
     * words.indexOf(ch); // return -1: not found. >=0 foud its index
     */

    static char toUppercase(char ch) {
        if ('a' <= ch && ch <= 'z') {
            ch = (char) ('A' + (ch - 'a')); // casting
        }
        return ch;
    }

    static String toUppercase(String str) { // str="abc": n-problem. What is n-1 problem? check first cha: 'a'? "bc"
        if (str.isEmpty()) {
            return str;
        }

        /*
         * String result = toUppercase(str.substring(1));
         * 
         * if (words.contains(ch)) {
         * result = toUppercase(ch) + result;
         * }else {
         * result = ch + result;
         * }
         */

        /*
         * a += b；
         * a = a + b;
         * a = b + a;
         */

        String result = toUppercase(str.charAt(0)) + "";
        if (str.length() > 1) {
            result += toUppercase(str.substring(1));
        }
        return result;
    }

    static char[] wordnum = new char[abcdefghijklmnopqrstuvwxyz]; // equals to create an 0-sized array
    static String wordnum2 = "abcdefghijklmnopqrstuvwxyz";

    static char biggestLetter(String str) {
        if (str.isEmpty()) {
            return ' ';
        }

        char result = str.charAt(0);
        if (str.length() > 1) {
            String substring = str.substring(1);
            char biggest = biggestLetter(substring);
            if (result < biggest) {
                result = biggest;
            }
        }
        return result;
    }

    static String letters = "HINOSXZ";

    static int totalRotatables(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        char ch = str.charAt(0);
        int vs = letters.indexOf(ch) >= 0 ? 1 : 0;

        if (str.length() > 1) {
            String substr = str.substring(1);
            vs += totalRotatables(substr);
        }
        return vs;
    }

    static int fibonacc(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibonacc(n - 1) + fibonacc(n - 2);
    }

    static int sumOfDigits(int n) {
        if (n < 10) {
            return n;
        }
        int d = n % 10;
        int t = n / 10;
        return sumOfDigits(t) + d;

    }

    static void hailstone(int n) {
        if (n == 1) {
            System.out.println(1);
        }
        if (n % 2 == 0) {
            System.out.println(n / 2);
        }
        if (n % 2 != 0) {
            System.out.println(3 * n + 1);
        }
    }

    static int[] runningSum(int[] nums) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = nums[i] + sums[i - 1];
        }
        return sums;
    }

    /*
     * int x[]; // from C/C++
     * int[] x; // preferred
     * int[] x = new int[30]; // element is 0
     * int[] x = {1,2,3,4,5};
     * 
     * multi-dimension
     * [
     * [1, 2, 3, 4, 5],
     * [4, 5, 6],
     * [6, 7]
     * ]
     * 
     * int[][] d2 = new int[3][];
     */

    static int numIdenticalPairs(int[] nums) {
        //
        int[][] d2 = { // d2[i]
                { 1, 2 },
                { 3, 4 },
                { 3, 4 },
                { 3, 4 },
                { 3, 4 }
        };

        int[][] index = new int[nums.length * nums.length][2];
        int n = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    index[n] = new int[] { i, j };
                    n++;
                }
            }
        }
        return n;
    }

    static int max(int[] arr) {
        int n = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (n < arr[i]) {
                n = arr[i];
            }
        }
        return n;
    }

    static boolean[] kidsWithCandies(int[] candies, int extraCandies) {
        boolean[] check = new boolean[candies.length];
        int max = max(candies);
        for (int i = 0; i < candies.length; i++) {
            if ((candies[i] + extraCandies) >= max) {
                check[i] = true;
            } else {
                check[i] = false;
            }
        }
        return check;
    }

    static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] newarray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newarray[i] = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    newarray[i]++;
                }
            }
        }
        return newarray;
    }

    static int sumOddlengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (i%2==0 && i >= 2) {
                for (int order = 3; order < arr.length - 2; order++) {
                    for (int j = i; j < order + 2; j++) {
                        sum = sum + arr[j];
                    }
                }
            }
        }
        return sum;
    }


/*
【1， 2， 3， 4， 5, 6, 7】
0, 1, 2, 3, 4
((i + 1) * (arr.length - i) + 1 ) / 2
i=0: 3
 =1: 4
 =2：5
 =3: 4
  
1，
   2, 
      3,
         4, 
            5, 
              6, 
                7
1, 2, 3
   2, 3, 4
      3, 4, 5
         4, 5, 6
            5, 6, 7
1, 2, 3, 4, 5
   2, 3, 4, 5, 6
      3, 4, 5, 6, 7

 */



static int sumOddlengthSubarrays1(int[] arr) {
    int sum = 0;

    for (int k = 1; k <= arr.length; k+=2) { // subarray's length
        for (int i = 0; i < arr.length-k; i++) { // starting index of a subarray
            for (int j = i; j < i+k; j++) { // subarray [i, i+k)，
                sum = sum + arr[j];
            }
        }
    }
    return sum;
}
}
/*
static int sumOddlengthSubarrays2(int[] arr) {
    int sum = 0;

    for (int i = 0; i < arr.length; i++) { // starting index of a subarray
        int repeat = ((i + 1) * (arr.length - i) + 1 ) / 2;
        sum = repeat * arr[i];
    }

    return sum;
}
 */
