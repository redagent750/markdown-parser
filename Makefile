
MarkdownParse.class: MarkdownParse.java
	javac MarkdownParse.java

# MarkdownParseTest.java: MarkdownParse.class
# 	javac MarkdownParseTest.java

MarkdownParseTest.class: MarkdownParseTest.java MarkdownParse.class
	javac -cp ".;lib\junit-4.12.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java   
	
Test: MarkdownParseTest.class
	java -cp ".;lib/junit-4.12.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest 


