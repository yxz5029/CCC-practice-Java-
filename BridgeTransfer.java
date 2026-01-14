import java.util.LinkedList;
import java.util.Scanner;

public class BridgeTransfer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxw = sc.nextInt();
        int noc = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>(); 
        int sum = 0;
        for (int i = 0; i < noc; i++) {
            int nw = sc.nextInt();
            sum += nw;
            if(i >= 4){
                sum -= list.removeFirst();
            }
            list.add(i, nw);
            if(sum > maxw){
                System.out.println(i);
                break;
            }else if(i == noc-1){
                System.out.println(noc);
            }
        }
        sc.close();
        /* 
        sc.close();
        if (noc > 4) {
            int sum = list.get(0) + list.get(1) + list.get(2) + list.get(3);
            if(sum < maxw){
            for (int i = 4; i < noc; i++) {
                sum -= list.get(i - 4);
                sum += list.get(i);
                if (sum > maxw) {
                    System.out.println(i);
                } else if (i == noc - 1) {
                    System.out.println(noc);
                }
            }
        }else{
            System.out.println(4);
        }
        }else{
            int sum = 0;
            for(int i= 0; i < noc; i++){
                sum += list.get(i);
                if(sum  > maxw){
                    System.out.println(i);
                }else if(i == noc -1){
                    System.out.println(noc);
                }
            }
        }
        */
    }
}
