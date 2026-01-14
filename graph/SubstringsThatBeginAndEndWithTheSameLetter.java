package graph;

import java.util.Arrays;

public class SubstringsThatBeginAndEndWithTheSameLetter {
    public static void main(String[] args){
        String s = "a";
        char[] s1 = s.toCharArray();
        int[] alphabet = new int[26];
        for(char l : s1){
            alphabet[l-'a'] += 1;
        }
        int sum = 0;
        for(int num : alphabet){
            sum += num*(num+1)/2;   //
        }
        System.out.println(sum);
    }
}
//  a... a .... aea.
//  1    1+2    1+2+3    1+2+3+4=10