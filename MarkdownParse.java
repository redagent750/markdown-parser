//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;

        while(currentIndex < markdown.length()) {

            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            int ExMark = markdown.indexOf("!",openBracket-1);
            currentIndex = closeParen + 1;        

            if(openBracket == -1 || openParen == -1 || closeParen == -1){
                break;
            }else if( ExMark == openBracket -1){
                currentIndex = openBracket + 1;
            } else if(openParen != closeBracket -1){
                currentIndex = closeBracket + 1;
            }else{
                toReturn.add(markdown.substring(openParen +1, closeParen));
            }
        }
        return toReturn;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
   	    System.out.println(links);         
           //javac -cp .:lib/junit-4.12.jar;lib\hamcrest-core-1.3.jar MarkdownParseTest.java

           //java -cp .;lib/junit-4.12.jar;lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest  
           //javac -cp .:lib\junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
           
    }
}

//scp WhereAmI.java cs15lsp22aer@ieng6.ucsd.edu:~/
//java MarkdownParse test-file.md