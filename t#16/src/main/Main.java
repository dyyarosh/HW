package main;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.LogManager;
import java.io.File;
import port.Port;
import ship.Ship;
import warehouse.Container;

public class Main {
	private static final Logger logger = Logger.getRootLogger();

	public static void main(String[] args) throws InterruptedException {
		//LoggerContext context = (LoggerContext) LogManager.getContext(false);
		//File file = new File("src/log4j2-test.properties");


		//context.setConfigLocation(file.toURI());
		logger.setLevel(Level.TRACE);


		int warehousePortSize = 15;
		List<Container> containerList = new ArrayList<Container>(warehousePortSize);
		for (int i=0; i<warehousePortSize; i++){
			containerList.add(new Container(i));
		}
		
		Port port = new Port(2, 90);
		port.getPortWarehouse().addContainer(containerList);
		
		
		containerList = new ArrayList<Container>(warehousePortSize);
		for (int i=0; i<warehousePortSize; i++){
			containerList.add(new Container(i+30));
		}
		Ship ship1 = new Ship("Ship1", port, 90);
		ship1.getShipWarehouse().addContainer(containerList);
		
		containerList = new ArrayList<Container>(warehousePortSize);
		for (int i=0; i<warehousePortSize; i++){
			containerList.add(new Container(i+60));
		}
		Ship ship2 = new Ship("Ship2", port, 90);
		ship2.getShipWarehouse().addContainer(containerList);
		
		containerList = new ArrayList<Container>(warehousePortSize);
		for (int i=0; i<warehousePortSize; i++){
			containerList.add(new Container(i+60));
		}
		Ship ship3 = new Ship("Ship3", port, 90);
		ship3.getShipWarehouse().addContainer(containerList);	
		
		
		new Thread(ship1).start();		
		new Thread(ship2).start();		
		new Thread(ship3).start();
		

		Thread.sleep(3000);
		
//		ship1.interrupt();
	//	ship2.interrupt();
		//ship3.interrupt();
		ship1.stopThread();
		ship2.stopThread();
		ship3.stopThread();

	}

}
