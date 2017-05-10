package by.dy.rdc.sax;

import by.dy.rdc.bean.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import java.util.ArrayList;
import java.util.List;


public class SaxP extends DefaultHandler{
    private List<Item> itemList = new ArrayList<Item>();
    private Item item;
    private StringBuilder text;
    String thisElement = "";// куда исчез атрибут доступа?

    public List<Item> getResult(){
        return itemList;
    }

    @Override
    public void startDocument() throws SAXException {// не нужные методы писать не нужно
        System.out.println("Start parse XML...");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        text = new StringBuilder();
        thisElement = qName;
        if (thisElement.equals("Item")) {// константная неименованная строка
            item = new Item();
        }

    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = qName;

        if (thisElement.equals("Id")) {
            item.setId(Integer.parseInt(text.toString()));
        }

        if (thisElement.equals("Name")) {
            item.setName(text.toString());
        }
        if (thisElement.equals("Price")) {
            item.setPrice(Double.parseDouble(text.toString()));
        }

        if (thisElement.equals("Status")) {
            item.setStatus(Status.valueOf(text.toString()));
        }

        if (thisElement.equals("Item")) {
            itemList.add(item);
        }

        thisElement = "";
        text.append("");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        text.append(ch, start, length);

    }


    @Override
    public void endDocument() {System.out.println("Stop parse XML...");
    }
}
