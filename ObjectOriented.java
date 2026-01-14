import java.util.ArrayList;
import java.util.List;

class ObjectOriented {
    static public void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.setWidth(100);
        r1.setHeight(200);

        System.out.println(r1);



        double a = r1.area();

        Rectangle r2 = new Rectangle(200, 100);

        double b = r2.area();

        List<Shape> shapes = new ArrayList<>();
        
        shapes.add(new Circle());
        shapes.add(new Rectangle());

        List<Rectangle> rectangles = new ArrayList<>();
        //rectangles.add(new Circle()); // Circle is not Rectangle
        rectangles.add(new Rectangle());

        String str = r1.toString();


    }   
}


/*
 * 
 * 
 * In Java Object class, we have:
 *      int hashCode();
 *      String toString();
 *      boolean equals(Object that);
 * 
 * 
 * 
 * 
 */




abstract class Shape {    // In Java, Shape extends Object

    public abstract double area(); // how to calculate ?

}




// complete by you
class Circle extends Shape {  // inheritance: IS_A, Circle is a Shape

    //Math.i;

    // state
    // diameter, radius;

    // constructor

    // getter & setter

    // behaviour

    public double area() {
        throw new RuntimeException(" this method is not implemented ");
    }
}



class Rectangle extends Shape {

    static String desc = "this variable is not belong to instance";

    // state

    private int width;  // instance field, instance variable, property, default to 0
    private int h = 10;

    public Rectangle() {  // constructor
    }
    public Rectangle(int width, int height) {  // constructor, overload
        this.width = width;
        this.h = height;
    }


    public int getWidth() {  // getter
        return width;
    }
    public void setWidth(int width) {  // setter
        this.width = width;
    }

    public int getHeight() {  // property name: height
        return h;
    }
    public void setHeight(int height) {  // setter
        h = height;
    }


    // behaviour

    // method
    public double area() {
        return width * h;
    }

    @Override
    public String toString() {
        return "My width: " + width + ", height: " + h;
    }
}





/*
 * 
 What are those class members?
    two kinds:  class members (static member) and instance members
    a member is one of "field" (variable)  or "method" (function)

    Combine above, we have:
        class field         (static field)  (static variable)
        class method        (static method) (static function)
        instance field      (instance variable)
        instance method     (instance function)

 * 
  Example：
        Create classes for accounts of a Bank:

 * 
 */
class Account{
    private String accountNum;  // instance variable belongs to Account instance
    private double balance = 0;

    public Account(String num) {
        accountNum = num;
    }

    public static void deposit(Account account, int amount){
        account.balance += amount;
    }

    public void deposit(double amount){
        balance += amount;
    }
    public void withdraw(double amount) throws Exception {
        if (balance >= amount) {
            balance -= amount;
        }
        else {
            throw new Exception("balance not enough");
        }
    }
}

class Demo {
    public static void main(String[] args) throws Exception {
        Account amy = new Account("00012345");
        Account bob = new Account("00023456");

        //amy.acountNum = 123;
        //bob.acountNum = 234;

        //amy.balance = 10;  // ten dollars
        //bob.balance = 20;

        Account.deposit(bob, 30); // static method
        bob.deposit(30); // instance method
        amy.deposit(30); // instance method
        amy.withdraw(5); // instance
    }

}
