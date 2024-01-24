package _Tools.testMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
	public static final HashMap<String, String> ClOrdId_To_PB3708 = new HashMap<>();

	public static void main(String[] args) {

		ClOrdId_To_PB3708.put("1", "A");
		ClOrdId_To_PB3708.put("2", "B");
		ClOrdId_To_PB3708.put("3", "C");
		Set<String> keys = ClOrdId_To_PB3708.keySet() ;
		for (String k : keys) {
			if ("2".equals(k)) {
				ClOrdId_To_PB3708.remove(k);
			}
			System.out.println(ClOrdId_To_PB3708.get(k));

		}

	}

}
