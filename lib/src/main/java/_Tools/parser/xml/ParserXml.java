package _Tools.parser.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import _Tools.parser.xml.bean.FFProductBase;

public class ParserXml {
	public static void main(String[] args) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(FFProductBase.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		FFProductBase ffProductBase = (FFProductBase) jaxbUnmarshaller.unmarshal(
				new File("C:\\Users\\0012252\\Desktop\\Tools\\workSpace\\Tools\\Tools\\config\\FFProductBase.xml"));
		System.out.println(ffProductBase.toString());

	}

}
