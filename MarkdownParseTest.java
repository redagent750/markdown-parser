import static org.junit.Assert.*;
import org.junit.*;
import java.nio.file.Files;
import java.util.*;
import java.nio.file.Path;
import java.io.IOException;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void testGetLinks() throws IOException{
        
        Path fileName = Path.of("C:/Users/kenny/Documents/GitHub/markdown-parser/test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = new MarkdownParse().getLinks(content);
	    assertEquals(List.of(),links); 
    }

    @Test
    public void snippetTest1() throws IOException{
        Path fileName = Path.of("C:/Users/kenny/Documents/GitHub/markdown-parser/snippet1.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = new MarkdownParse().getLinks(content);
	    assertEquals(List.of("`google.com","google.com","ucsd.edu"),links); 
    }
    @Test
    public void SnippetTest2() throws IOException{
        Path fileName = Path.of("C:/Users/kenny/Documents/GitHub/markdown-parser/test-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = new MarkdownParse().getLinks(content);
	    assertEquals(List.of("a.com","a.com(())","example.com"),links); 
    }
    @Test
    public void snippetTest3() throws IOException{
        Path fileName = Path.of("C:/Users/kenny/Documents/GitHub/markdown-parser/snippet3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = new MarkdownParse().getLinks(content);
	    assertEquals(List.of("https://www.twitter.com","https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule",
        "https://cse.ucsd.edu/"),links); 
    }
}