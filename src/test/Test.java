package test;
import main.JavaToPython;

import java.util.List;


public class Test {
    public static void main(String[] args) {
        String file1 = "src/test/test1";
        String file2 = "src/test/test2";
        String file3 = "src/test/test3";
        String file4 = "src/test/test4";
        String file5 = "src/test/test5";
        String file6 = "src/test/test6";

        List<String> allLines1 = JavaToPython.printOriginal(file1);
        System.out.println("\nTranslated Python Code:\n\n" + JavaToPython.translate(allLines1));

        List<String> allLines2 = JavaToPython.printOriginal(file2);
        System.out.println("\nTranslated Python Code:\n\n" + JavaToPython.translate(allLines2));

        List<String> allLines3 = JavaToPython.printOriginal(file3);
        System.out.println("\nTranslated Python Code:\n\n" + JavaToPython.translate(allLines3));

        List<String> allLines4 = JavaToPython.printOriginal(file4);
        System.out.println("\nTranslated Python Code:\n\n" + JavaToPython.translate(allLines4));

        List<String> allLines5 = JavaToPython.printOriginal(file5);
        System.out.println("\nTranslated Python Code:\n\n" + JavaToPython.translate(allLines5));

        List<String> allLines6 = JavaToPython.printOriginal(file6);
        System.out.println("\nTranslated Python Code:\n\n" + JavaToPython.translate(allLines6));
    }
}
