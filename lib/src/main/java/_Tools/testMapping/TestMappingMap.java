package _Tools.testMapping;

import java.util.HashMap;

public class TestMappingMap {
	private static HashMap<String, String> ClOrdID_To_OrigClOrdID = new HashMap<>();

	public static void main(String[] args) {
		ClOrdID_To_OrigClOrdID.put("20230815-00001-00004", "20230815-00001-00001");
		ClOrdID_To_OrigClOrdID.put("20230815-00001-00009", "20230815-00001-00004");
		ClOrdID_To_OrigClOrdID.put("20230815-00001-000015", "20230815-00001-00009");

		System.out.println(getMonClordId("20230815-00001-000015"));

	}

	private static String getMonClordId(String clordId) {
		String clOrdID = clordId;
		while (ClOrdID_To_OrigClOrdID.containsKey(clOrdID)) {
			clOrdID = ClOrdID_To_OrigClOrdID.get(clOrdID);
		}

		return clOrdID;
	}

}
