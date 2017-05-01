package by.dy.rdc.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.dy.rdc.bean.Item;
import by.dy.rdc.bean.Status;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class Main {
    public static void main(String[] args) throws SAXException, IOException{

        DOMParser parser = new DOMParser();
        parser.parse("src/by/dy/rdc/main/resources/Items.xml");
        Document document = parser.getDocument();
        Element root = document.getDocumentElement();
        List<Item> itemList = new ArrayList<Item>();
        NodeList foodNodes = root.getElementsByTagName("Item");
        Item item = null;
        for (int i = 0; i < foodNodes.getLength(); i++) {
            item = new Item();
            Element itemElement = (Element) foodNodes.item(i);
            item.setId(Integer.parseInt(getSingleChild(itemElement, "Id").getTextContent().trim()));
            item.setOwnerId((Integer.parseInt(getSingleChild(itemElement, "OwnerId").getTextContent().trim())));
            item.setName(getSingleChild(itemElement, "Name").getTextContent().trim());
            item.setPrice(Double.parseDouble(getSingleChild(itemElement, "Price").getTextContent().trim()));
            item.setStatus(Status.valueOf(getSingleChild(itemElement, "Status").getTextContent().trim()));
            itemList.add(item);
        }
        for (Item f: itemList) {
            System.out.println(f.toString());
        }
    }
    private static Element getSingleChild(Element element, String childName){
        NodeList nlist = element.getElementsByTagName(childName);
        Element child = (Element) nlist.item(0);
        return child;
    }
}