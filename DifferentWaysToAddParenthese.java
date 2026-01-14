import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class DifferentWaysToAddParenthese {

    static List<Integer> calc(String expr) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < expr.length(); i++) {
            if (!Character.isDigit(expr.charAt(i))) {
                List<Integer> right = calc(expr.substring(i + 1));
                List<Integer> left = calc(expr.substring(0, i));
                for(int r = 0; r < right.size();r++){
                    for(int l = 0; l < left.size(); l++){
                        switch(expr.charAt(i)){
                            case '+': result.add(left.get(l)+right.get(r)); break;
                            case '-': result.add(left.get(l)-right.get(r)); break;
                            case '*': result.add(left.get(l)*right.get(r)); break;
                        }

                    }
                }
            }
        }
        if(result.isEmpty()){
            result.add(Integer.parseInt(expr));
        }
        return result;
    }


    public static void main(String[] args){
        String expression = "2*3-4*5"; // 2*3-4*5 // 2*3-4*5+3*2+6*88
        System.out.println(calc(expression));
    }
}
