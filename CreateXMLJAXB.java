package com.nc.xmlprocess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class CreateXMLJAXB {
	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		JAXBContext jContext = JAXBContext.newInstance(ProductCollection.class);
		ProductCollection productCollection = new ProductCollection();
		Product p1 = new Product();
		p1.setId("1000");
		p1.setName("Laptop");
		p1.setPrice("35000");
		p1.setQty("20");
		Product p2 = new Product();
		p2.setId("1001");
		p2.setName("LED");
		p2.setPrice("45000");
		p2.setQty("10");
		productCollection.getProdList().add(p1);
		productCollection.getProdList().add(p2);
		Marshaller marshaller = jContext.createMarshaller(); //Marshaller converts java to xml
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); //for formatted output
		marshaller.marshal(productCollection, new PrintWriter(new File("src/jxb.xml")));
	}
}
