public class Homework1514 {
    public static void main(String[] args) {
        int[] v = shuffle(new int[] { 2, 5, 1, 3, 4, 7 }, 3);
        System.out.println(v);
        boolean v1 = canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 2);
        System.out.println(v1);
        boolean v2 = validMountainArray(new int[] { 0, 3, 2, 1 });
        System.out.println(v2);
        int v3 = largestUnlqueNumber(new int[] { 5, 7, 3, 9, 4, 9, 8, 3, 1 });
    }

    static int[] shuffle(int[] nums, int n) {
        int r = n - 1;
        for (int u = 1; u < nums.length; u += 2) {
            for (int x = 1; x < r; x += 2) {
                for (int i = n; i < nums.length - 2; i++) {
                    int o;
                    int h = nums[u];
                    o = nums[u + 1];
                    nums[x] = nums[i];
                    nums[x + 1] = h;
                }
            }
        }
        return nums;
    }

    //[1,2,3,4,5,6], 3
    //[1,4,2,5]

    static int[] shuffle1(int[] nums, int n) {
        int[] result = new int[2*n];
        for (int u = 0; u < n; u++) {
            result[u*2] = nums[u];
            result[u*2+1] = nums[u+n];
        }
        return result;
    }

    static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) {
            return (n + flowerbed[0]) <= 1;
        }

        for (int i = 0; i < flowerbed.length - 1; i++) {
            if ((i == 0 || flowerbed[i - 1] == 0) && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        if (flowerbed[flowerbed.length - 2] == 0 && flowerbed[flowerbed.length - 1] == 0) {
            n--;
        }
        return n <= 0;

    }

    static boolean validMountainArray(int[] arr) {
        int j = 0;
        while (j < arr.length - 1 && arr[j] < arr[j + 1]) {
            j++;
        }
        if (j == 0 || j == arr.length - 1) {
            return false;
        }

        while (j < arr.length - 1 && arr[j] > arr[j + 1]) {
            j++;
        }

        if (j == arr.length - 1) {
            return true;
        } else {
            return false;
        }

        // return j == arr.length - 1;
    }

    static int largestUnlqueNumber(int[] nums) {
        int[] counts = new int[nums.length]; // Java already set to 0
        /* not necessary in Java
        for (int i = 0; i <= 1000; i++) {
            counts[i] = 0;
        }
         */
        for (int j = 0; j < nums.length; j++) {
            counts[nums[j]]++;
        }
        for (int i = 1000; i >= 0; i--) {
            if (counts[i] == 1) {
                return i;
            }
        }
        return -1;
    }
}
