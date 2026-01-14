public class LongestBinarySubssequenceLessThanOrEqualToK {
    public static void main(String[] args){
        String s = "1001010";
        int k = 5;
        int pow = 1;
        int value = 0;
        int length = 0;
        for(int i = s.length()-1; i >= 0; i--){
            char ch = s.charAt(i);
            if (ch == '0'){
                length++;
            }
            else if (value + pow <= k) {
                value += pow;
                length++;
            }
            pow <<= 1;
        }
        System.out.println(length);
    }
}
