package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JavaToPython {
    public static String translate(List<String> allLines) {
        // translate and store python code in a StringBuilder
        StringBuilder pythonCode = new StringBuilder();

        int indent = 0;
        String className = "";
        for (String line : allLines) {
            // remove leading and trailing whitespace
            String strippedLine = line.strip();

            //if is class
            if(strippedLine.startsWith("class")){
                int contentStart = strippedLine.indexOf(' ') + 1;
                int contentEnd = strippedLine.lastIndexOf('{');
                String content = strippedLine.substring(contentStart, contentEnd);
                //remove any whitespace
                content = content.strip();
                pythonCode.append("class ").append(content).append(":\n");
                className = content;
            }
            // if is main
            else if (strippedLine.startsWith("public static void main")) {
                String spaces = " ".repeat(indent*4);
                pythonCode.append(spaces).append("def main():\n");
            }
            // if is print statement
            else if (strippedLine.startsWith("System.out.println")) {
                int contentStart = strippedLine.indexOf('(') + 1;
                int contentEnd = strippedLine.lastIndexOf(')');
                String content = strippedLine.substring(contentStart, contentEnd);
                String spaces = " ".repeat(indent*4);
                pythonCode.append(spaces).append("print(").append(content).append(")\n");
            }

            if(strippedLine.contains("{")){
                indent++;
            }
            if(strippedLine.contains("}")){
                indent--;
            }
        }

        // add main function call
        pythonCode.append("\nif __name__ == \"__main__\":\n");
        pythonCode.append("    ").append(className).append(".main()\n");

        return pythonCode.toString();
    }

    public static List<String> printOriginal(String file){
        //store java code line by line
        List<String> allLines = new ArrayList<>();
        try {
            allLines = Files.readAllLines(Paths.get(file));
            //print original code
            System.out.println("Original Java Code:\n");
            for(String line : allLines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return allLines;
    }

    public static void main(String[] args) {
        String file = "src/main/code";

        //print original code
        List<String> allLines = printOriginal(file);

        //print translated code
        System.out.println("\nTranslated Python Code:\n\n" + translate(allLines));
    }
}
