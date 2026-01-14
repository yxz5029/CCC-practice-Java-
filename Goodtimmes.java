import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Goodtimmes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ottawatime = sc.nextInt();
        sc.close();
        System.out.println(ottawatime + " " + "in Ottawa.");
        System.out.println(ottawatime >= 300 ? ottawatime - 300 + " " + "in Victoria" : 2100 + ottawatime + " " + "in Victoria");
        System.out.println(ottawatime >= 200 ? ottawatime - 200 + " " + "in Edmonton" : 2200 + ottawatime + " " + "in Edmonton");
        System.out.println(ottawatime >= 100 ? ottawatime - 100 + " " + "in Winnipeg" : 2300 + ottawatime + " " + "in Winnipeg");
        System.out.println(ottawatime + " " + "in Toronto");
        System.out.println(ottawatime < 2300 ? ottawatime + 100 + " " + "in Halifax" : ottawatime - 2300 + " " + "in Halifax");
        int ten = 0;
        if(ottawatime >= 100){
             ten = ottawatime % 100;
             ottawatime = ottawatime - ten;
        }else{
             ten = ottawatime;
        }
        if (ten >= 30) {
            System.out.println(
                    ottawatime < 2230 ? ottawatime + 200 + ten - 30 + " " + "in St. John's" : 0 + ten - 60 + " " + "in St. John's");
        } else {
            System.out.println(ottawatime < 2230 ? ottawatime + 130 + " " + "in St. John's": ten + 30 + " " + "in St. John's");
        }

        /*
         * map.put("Ottawa",ottawatime);
         * if(ottawatime >= 300){
         * map.put("Victoria",ottawatime-300);
         * }
         * map.put("Edmonton",ottawatime);
         * map.put("Winnipeg",ottawatime);
         * map.put("Toronto",ottawatime);
         * map.put("Halifax",ottawatime);
         * map.put("St.John's",ottawatime);
         */
    }


    static String[] cities = {
        "Victoria",
        "Edmonton",
        "Winnipeg",
        "Toronto",
        "Halifax",
        " St. John's"
    };

    static int[] hours = {-3, -2, -1, 0, 1, 1};
    static int[] minutes = {0, 0, 0, 0, 0, 30};

    static void solve() {
        Scanner sc = new Scanner(System.in);
        final int time = sc.nextInt();
        sc.close();
        int hour = time/100;
        int minute = time%100;

        final String format = "%s in %s.%n";

        System.out.printf(format, time, "Ottawa");
        for (int i=0; i<cities.length; i++) {
            int m = minute + minutes[i];
            if (m > 59) {
                m -= 60;
                hour++;
            }
            int h = hour + hours[i];
            if (h < 0) {
                h += 24;
            }
            else if (h > 23) {
                h -= 24;
            }
            System.out.printf(format, h*100+m, cities[i]);
        }

    }


}
