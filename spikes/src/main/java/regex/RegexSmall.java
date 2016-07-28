package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegexSmall {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("ab");      // the expression
        Matcher m = p.matcher("abaaabaxxxadsaba");       // the source
        while (m.find()) {
            System.out.print(m.start() + " ");
        }

        System.out.println();

        System.out.println(m.replaceFirst("qqrq"));


//        ====================================

        p = Pattern.compile("aba");
        m = p.matcher("abaaaba");       // the source

        while (m.find()) {
            System.out.print(m.start() + " " + m.end() + " / ");
        }

//            ============================


        System.out.println("\n2");

        p = Pattern.compile("aba*");
        m = p.matcher("abaaabaaba");       // the source

        while (m.find()) {
            System.out.print(m.start() + " " + m.end() + " / ");
        }

        System.out.println("\n");

        p = Pattern.compile("aba*?");
        m = p.matcher("abaaabaaba");       // the source

        while (m.find()) {
            System.out.print(m.start() + " " + m.end() + " / ");
        }
    }
}