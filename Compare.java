// Object class


class A {  // extends Object
    int i; // =0
    A () {
        this(100); // call another constructor. Must be the first line in body.
    }
    A (int i) {
        this.i = i;    
    }

    public int getI() {  // polymorthic!
        return i;
    }

    static public void demo(A a) {  // polymorthic!
        System.out.println("Demo: a'getI: " + a.getI());  // which getI() ???
    }

}

class B extends A {  // B is A
    int i = 500;

    @Override
    public int getI() {
        return i;
    }
}




public class Compare {
    public static void main(String[] args) {
        A a1 = new A();
        System.out.println(a1.i);
        A a2 = new A(200);
        System.out.println(a2.i);

        B b1 = new B();
        System.out.println(b1.i);
        System.out.println("A's i: "+ ((A)b1).i );  // casting: change type definition

        System.out.println(b1.getI());
        System.out.println("A's getI() ?: "+  ((A)b1).getI() );  // casting: change type definition

        A.demo(a1);
        A.demo(b1);

    }    
}
