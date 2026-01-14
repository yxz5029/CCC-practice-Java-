public class NumberOfDivisibleSubstrings {
    public static void main(String[] agrs){
        String word = "asdf";
        String[] map = {"ab","cde","fgh","ijk","lmn","opq","rst","uvw","xyz"};
        int[] alphabet = new int[26];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < map[i].length(); j++){
                alphabet[map[i].charAt(j)-'a'] = i+1;
            }
        }
        int result = 0;
        int[] sum = new int[word.length()+1];

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            sum[i+1] += sum[i]+alphabet[ch-'a'];
        }

        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
                //result += (sum[j+1]-sum[i])%(j+1-i) == 0? 1:0;
            }
        }

        for(int i = 1; i <= word.length();i++){
            for(int j = 0; j < i; j++){
               result += (sum[i]-sum[j])%(i-j) == 0 ? 1:0;
            }
        }
        System.out.println(result);
    }

    static int val(char ch) {
        return 9 - ('z'-ch)/3;
    }
}
