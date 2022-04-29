import static org.junit.Assert.*;
import org.junit.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void testGetLinks() throws IOException{
        
        Path fileName = Path.of();
        String content = Files.readString(fileName);
        ArrayList <String> result = new ArrayList<String>();
        
        assertEquals(result, MarkdownParse.getLinks(content));
    }
}