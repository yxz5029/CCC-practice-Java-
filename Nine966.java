import java.util.Scanner;

public class Nine966 {

    static boolean isRotatable1(String num) {
        // 123: return false
        // 96: true
        // 609: true
        boolean tf = true;
        char[] nums = num.toCharArray();
        switch (nums.length) {
            case 1:
                return tf = nums[0] == 1|| nums[0] == 8;
            case 2:
                tf = nums[0] == nums[1] && (nums[0] == 1 || nums[0] == 8) || nums[0] == 6 && nums[1] == 9
                        || nums[0] == 9 && nums[1] == 6;
                return tf;
            case 3:
                tf = (nums[0] == nums[2] && (nums[0] == 1 || nums[0] == 8) || nums[0] == 6 && nums[2] == 9
                        || nums[0] == 9 && nums[2] == 6) && nums[1] == 0 || nums[1] == 8 || nums[1] == 1;
                return tf;
            case 4:
                tf = (nums[0] == nums[3] && (nums[0] == 1 || nums[0] == 8) || nums[0] == 6 && nums[3] == 9
                        || nums[0] == 9 && nums[3] == 6) && nums[1] == nums[2] && (nums[1] == 1 || nums[1] == 8)
                        || (nums[1] == 6 && nums[2] == 9 || nums[1] == 9 && nums[2] == 6);
                return tf;
            case 5:
                tf = (nums[0] == nums[4] && (nums[0] == 1 || nums[0] == 8) || nums[0] == 6 && nums[4] == 9
                        || nums[0] == 9 && nums[4] == 6)
                        && (nums[1] == nums[3] && (nums[1] == 1 || nums[1] == 8) || nums[1] == 6 && nums[3] == 9
                                || nums[1] == 9 && nums[3] == 6)
                        && (nums[2] == 0 || nums[2] == 1 || nums[2] == 8);
                return tf;
        }
       return tf;
    }

    public static void main(String[] args) {
        System.out.println("Enter the lower bound of the interval:");
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        System.out.println("Enter the upper bound of the interval:");
        int v1 = sc.nextInt();
        sc.close();
        int total = 0;
        for (int i = v; i <= v1; i++) {
            boolean tf = isRotatable(i + "");
            if (tf == true) {
                total++;
            }
        }
        System.out.println("The number of the rotatable numbers is:" + total);
        System.out.println(total);

    }



    static boolean isRotatable(String num) {
        
        char[] digits = num.toCharArray();
        for (char ch : digits) {
            switch(ch) {
                case '2': // fall through
                case '3': // fall through
                case '4': // fall through
                case '5': // fall through
                case '7': return false;
            }
        }

        if (digits.length%2 != 0) {
            char ch = digits[digits.length/2];
            if (ch == '6' || ch == '9') {
                return false;
            }
        }        

        for (int i=0; i < digits.length/2; i++) {
            char left = digits[i];
            char right = digits[digits.length-i-1];

            if (left == '6' && right == '9' || left == '9' && right == '6') {
                continue;
            }

            if (left != right) {
                return false;
            }

            if (left == '6' || left == '9') {
                return false;
            }
        }

        return true;
    }
}
