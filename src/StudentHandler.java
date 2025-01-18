import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class StudentHandler extends DefaultHandler {
    private String currentElement = "";
    private String name, id, studentClass;

    @Override
    public void startElement(String uri, String localName
            , String qName, Attributes attributes)
            throws SAXException {
        currentElement = qName; // Store the current element name
//        System.out.println("Starting element -> " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        String value = new String(ch, start, length).trim();
        if (!value.isEmpty()) { // Ignore whitespace
            switch (currentElement) {
                case "Name":
                    name = value;
                    break;
                case "ID":
                    id = value;
                    break;
                case "Class":
                    studentClass = value;
                    break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName
            , String qName) throws SAXException {
//        System.out.println("Ending element -> " + qName);
        if (qName.equals("Student"))
            System.out.println(qName + " Name: " + name + ", ID: " + id + ", Class: " + studentClass);

        currentElement = ""; // Reset the current element
    }
}
