package _Tools.testCopyOnWriteArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
	private static List<String> data = new ArrayList<String>();

	public static void main(String[] args) {
		data.add("1");
		data.add("2");
		data.add("3");
		data.add("4");
		data.add("5");
		CopyOnWriteArrayList<String> pb3732List = new CopyOnWriteArrayList<>(data);
		for (String d : pb3732List) {
			System.out.println("d : " + d);
			if ("2".equals(d)) {
				data.remove(4);
			}

		}
		System.out.println("data : " + data);
		System.out.println("pb3732List : " + pb3732List);

	}

}
