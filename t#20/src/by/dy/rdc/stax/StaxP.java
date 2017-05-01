package by.dy.rdc.stax;

import by.dy.rdc.bean.Item;
import by.dy.rdc.bean.Status;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;



public class StaxP {

    public static List<Item> process(XMLStreamReader reader) throws XMLStreamException {
        List<Item> itemList = new ArrayList<Item>();
        Item item = null;
        String elementName ="";
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = reader.getLocalName();
                //    System.out.println(elementName);
                    switch (elementName) {
                        case "Item":
                            item = new Item();
                            break;
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty()) {
                        break;
                    }
                    switch (elementName) {
                        case "Name":
                            item.setName(text);
                            break;
                        case "OwnerId":
                            item.setOwnerId(Integer.parseInt(text));
                            break;
                        case "Price":
                            item.setPrice(Double.parseDouble(text));
                            break;
                        case "Id":
                            item.setId(Integer.parseInt(text));
                            break;
                        case "Status":
                            item.setStatus(Status.valueOf(text));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName=  reader.getLocalName();
                    switch (elementName) {
                        case "Item":
                            itemList.add(item);
                  //          System.out.print("Item added");
                    }
            }
        }
        return itemList;
    }

}
