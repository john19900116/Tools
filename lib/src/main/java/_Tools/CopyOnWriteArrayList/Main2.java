package _Tools.CopyOnWriteArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main2 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("apple");
		list.add("banana");
		list.add("orange");

		// 将普通List转换为CopyOnWriteArrayList
		CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>(list);

		// 在多线程环境下使用CopyOnWriteArrayList
		new Thread(() -> {
			list.add("grape");
			System.out.println("Thread 1 added a new element");
		}).start();

		new Thread(() -> {
			list.remove("banana");
			System.out.println("Thread 2 removed an element");
		}).start();

		// 主线程读取CopyOnWriteArrayList
		for (String str : copyOnWriteArrayList) {
			System.out.println(str);
		}
	}

}
