package homework.classLoading;

public class Demo {
 
    private static class Child {

    }


    // all classes are loaded by ClassLoader

    public static void main(String[] args) {

        show(Demo.class);
        show(Child.class);
        show(Integer.class);
        show(String.class); // loaded by Bootstrapclassloader

        
    }

    static void show(Class<?> aClass) {
        System.out.printf("Class name: %s, classLoader: %s%n", aClass.getName(), aClass.getClassLoader());
    }

}
