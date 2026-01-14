import java.util.HashSet;
import java.util.Set;

public class NumberOfEqualCountSubstrings {
    public static void main(String[] args){
        String s = "aaabcbbcc";
        int count = 3;
        int result = 0;
        for(int unique = 1; unique < s.length(); unique++){
            int sublen = count*unique;
            StringBuilder substr = new StringBuilder();
            Set<Character> set = new HashSet<>();
            for(int i = 0; i < s.length(); i++) {
                if(i+1>sublen){
                    if(!substr.substring(1).contains(substr.charAt(0)+"")){
                        set.remove(substr.charAt(0));
                    }

                    substr.append(s.charAt(i));
                    substr.delete(0,1);
                    set.add(s.charAt(i));
                }else{
                    substr.append(s.charAt(i));
                    set.add(s.charAt(i));
                }
                if(set.size() == unique && substr.length() == sublen){
                    result ++;
                }

            }
        }
        System.out.println(result);
        // 1. find out how many unique chars
        // 2. for substring contains uniq=1 to totalUniques (unique chars)
        //      uniq*count substring length
        //      for i=0 to s.length
        //             process this char s(i)
        //
        //             if i>=sublen to have s(i) in substring, we need to remove substring's first char
        //
        //             if (match condition for the substring) result++;


    }
}
