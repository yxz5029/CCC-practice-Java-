import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.Collections;

public class CollectionsDemo {

    public static void main(String[] args) {

        long l = 33L;
        String svv = l+"+"+l+"="+l+l; // 33+33=3333
        svv = l+"+"+l+"="+(l+l); // 33+33=66





        Integer[] iia = new Integer[200]; // iia size is 200


        // in, out, err    // stream

        // out: System.out
        //              System.out.println('s');

        // in: System.in 
        Scanner sc = new Scanner(System.in);

        List<String> list = new ArrayList<>(1000000); // list: element can repeat, has sequence:   a,b,b,b,a
        Set<String> set = new HashSet<>();  // set: element cannot repeat, no sequence:  a,b
        Map<String, Integer> map = new HashMap<>(); // can find value by key. In this example, key is a string, value is an integer

        list.add("A1");
        list.add("A2");
        list.add(0, "A0");
        list.add("A1");
        list.add("A2");

        /*
        for (int i=0; i<list.size(); i++) {
            String v = list.get(i);
        }
        for (String v : list) {
            System.out.println("Value in list: " + v);
        }
        */
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println("Value in list: " + iter.next());
        }

        set.add("A1");
        set.add("A2");
        //set.add(0, "A0"); this is not supported
        set.add("A1");
        set.add("A2");
        System.out.println(set.size()); // should be 2
        for (String v : set) {
            System.out.println("Value in set: " + v);
        }
        iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println("Value in set: " + iter.next());
        }

        if (set.contains("A100")) {

        }

        map.put("key1", 123);
        map.put("key2", 345);
        map.put("key1", 321);  // new value replace old value
        Integer iv = map.get("key1"); // return 321 
        int ii = iv; // from Integer to int, automatically. This is known as unboxing
        iv = 666; // from int to Integer automatically. This is known as boxing
        iv = map.get("key2"); // return 345
        iv = map.get("key0"); // return null

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            String k = e.getKey();
            Integer v = e.getValue();
        }
        
        Stack<String> stack = new Stack<>();
        stack.push("A1");
        stack.push("A2");
        String vv = stack.pop(); // vv is A2. "A2" is removed from stack
        stack.push("A3"); // in stack, we have two values: A3, A1


        // sorting:
        Collections.sort(list);

        // Array:
        String[] sa = {
            "B1",
            "B2",
            "B3"
        };

        list = Arrays.asList(sa);  // convert array to a list

        Arrays.sort(sa); // how to sort array

        sa = list.toArray(new String[list.size()]);


    }



}   

/*
        Set, List are Collection
        Stack, Queue, PriorityQueue: get by priority

        Array:
            1. add/delete at first position has worest performance. At the end is very fast
            2. get by index is fastest, a constant
            3. size is fixed. Cannot grow。 Memory is pre-allocated
            We use array for read, stack

        List:
        ArrayList: inside, use array
                Look at Array

        LinkedList: Like a train.
                1. Get by index is slow, not constant
                2. Add/Remove at head or tail is very fast, a constant
                3. size is dynamic, do not need pre-allocate memory, no limit.
                3. Insert is fast if you have the node pointer in the list where new node will be inserted at
                We use it for queue, stack


        Set:
            TreeSet: sorted by value 
            HashSet: require hashCode (Every Java object has hashCode)



        List iteration: 
                for (int i=0; i<size; i++) {  // iterate by index
                    l.get(i);
                }
                
                for(Integer val : list) { // without index

                }

                Iterator iter = collection.iterator();
                while (iter.hasNext()) {
                    Object val = iter.next();
                }




 *  Map iteration:
 *          Set<Map.Entry<String, Integer>> entries =  map.entrySet();
 *          for (Map.Entry<String, Integer> e : map.entrySet()) {
 *                  String k = e.getKey();
 *                  Integer val = e.getValue();
 *           }
 * 
 * 
 * 
 */


