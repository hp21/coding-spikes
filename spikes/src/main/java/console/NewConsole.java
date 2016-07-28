package console;

import java.io.Console;

public class NewConsole {
    public static void main(String[] args) {
        Console console = System.console();            // #1: get a Console

        char[] pw;
        pw = console.readPassword("%s", "pw: ");       // #2: return a char[]

        for (char ch : pw)
            console.format("%console ", ch);                   // #3: format output

        console.format("\n");

        MyUtility mu = new MyUtility();
        while (true) {
            String name = console.readLine("%s", "input?: ");   // #4: return a String
            console.format("output: %s \n", mu.doStuff(name));
        }
    }
}

class MyUtility {                            // #5: class to test
    String doStuff(String arg1) {
        // stub code
        return "result is " + arg1;
    }
} 