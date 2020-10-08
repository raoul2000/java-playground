package raoul2000.java.play;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        String javaVersion = System.getProperty("java.version");

        System.out.println("Hello World! " + args[0]);
        System.out.println("java.version = " + javaVersion);
        System.out.println("raoul2000.myProperty = " + System.getProperty("raoul2000.myProperty", "(default value)"));

    }
}
