
MarkdownParse.class: MarkdownParse.java
	javac MarkdownParse.java

MarkdownParseTest.java: MarkdownParse.class
	javac MarkdownParseTest.java

MarkdownParseTest.class: MarkdownParseTest.java MarkdownParse.class
	java MarkdownParseTest test-file.md

Test: MarkdownParseTest.class
	java MarkdownParseTest

