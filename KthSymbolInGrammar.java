import java.util.ArrayList;

public class KthSymbolInGrammar {
    public static void main(String[] args){
        int n = 3;
        int k = 2;
        int total = 1;
        ArrayList<Integer>[] list = new ArrayList[n];
        list[0] = new ArrayList<>();
        list[0].add(0);
        int mid = 0;
        if(n*k > 1) {
            w:for (int i = 1; i < n; i++) {
                list[i] = new ArrayList<>();
                if(i > 1) {
                    list[i].addAll(list[i-1]);
                }
                for (int j = mid; j < total; j++) {
                    if(i + 1 == n && j+1 == k){
                        break w;
                    }
                    if (list[i - 1].get(j) == 0) {
                        list[i].add(0);
                        list[i].add(1);
                    } else {
                        list[i].add(1);
                        list[i].add(0);
                    }
                }
                total *= 2;
                mid = list[i-1].size();
            }
        }
        System.out.println(list[n-1].get(k-1));
    }

    /*


1    0
2    0       1
3    0   1   1   0
4    0 1 1 0 1 0 0 1
5    0 1 1 0 1 0 0 1 1 0 0 1 0 1 1 0
     1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6
6    01101001100101101001011001101001
     12345678901234567890123456789012
               (11+1)/2

    */
    static int find(int n, int k){
        if(n == 1){
            return 0;
        }
        if(k % 2 == 0){
            return find(n-1, k/2) == 1? 0: 1;
        }
        return find(n-1, (k+1)/2);

    }
}
