import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Main {
    public static void main(String[] args) {
        try {
            // Create a SAXParserFactory instance
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Parse the XML file with the custom handler
            StudentHandler handler = new StudentHandler();
            saxParser.parse("resource/students.xml", handler);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}