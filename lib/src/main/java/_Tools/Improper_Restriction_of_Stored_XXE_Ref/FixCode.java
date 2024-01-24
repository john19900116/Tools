//package _Tools.Improper_Restriction_of_Stored_XXE_Ref;
//
//public class FixCode {
//
//	public static void main(String[] args) {
//		final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//		XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
//		// These 2 properties are the key
//		xmlInputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
//		xmlInputFactory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
//		// Your stream reader for the xml string
//		final XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new StringReader(yourXMLStringGoesHere));
//		final NsIgnoringXmlReader nsIgnoringXmlReader = new NsIgnoringXmlReader(xmlStreamReader);
//		// Done with unmarshalling the XML safely
//		final YourObject obj = (YourObject) unmarshaller.unmarshal(nsIgnoringXmlReader);
//	}
//
//}
