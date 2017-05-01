package by.dy.rdc.main;
import by.dy.rdc.bean.*;
import by.dy.rdc.stax.StaxP;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import by.dy.rdc.sax.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import static java.awt.SystemColor.menu;

public class Main  extends DefaultHandler    {
    public static void main(String[] args)  throws Exception  {

        System.out.println("SAX");
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SaxP saxp = new SaxP();
            parser.parse(new File("src/by/dy/rdc/main/resources/Items.xml"), saxp);

        List<Item> itemList = saxp.getResult();
        for (Item item : itemList) {
            System.out.println(item.toString());
        }
        } catch (SAXException e) {
            e.printStackTrace();
        }



         		System.out.println("StAX");
         		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
         		try {
             			InputStream input = new FileInputStream("src/by/dy/rdc/main/resources/Items.xml");
             			XMLStreamReader readerStAX = inputFactory.createXMLStreamReader(input);
             			List<Item> itemListStax = StaxP.process(readerStAX);
             			for (Item item : itemListStax) {
                 				System.out.println(item.toString());
                 			}
             		} catch (XMLStreamException e) {
             			e.printStackTrace();
             		}


}
}