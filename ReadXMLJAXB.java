package com.nc.xmlprocess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ReadXMLJAXB {
	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		JAXBContext jContext = JAXBContext.newInstance(ProductCollection.class);
		FileReader reader = new FileReader(new File("src/sample.xml"));
		
		Unmarshaller unmarshaller = jContext.createUnmarshaller();
		ProductCollection coll = (ProductCollection) unmarshaller.unmarshal(reader); //unmarshaller converts xml to java object
		for(Product prod : coll.getProdList()){
			System.out.println(prod);
		}
	}
}
