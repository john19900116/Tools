package _Tools.parser.symbol;

public class ParserString2 {

	public static void main(String[] args) {
		String ordId = "2023072561656219";
		String OrderID = ordId.substring(11) + ordId.substring(0, 11);
		System.out.println(OrderID);
	}

}
