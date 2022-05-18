package SAX_Parser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = null;
        try {
            saxParser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        CatalogHandler catalogHandler = new CatalogHandler();

        try {
            saxParser.parse("src/main/resources/catalog.xml", catalogHandler);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        List<Book> result = catalogHandler.getCatalog();

        for (Book book : result) {
            System.out.println(book);
        }
    }
}
