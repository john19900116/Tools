package _Tools.testlombok;

public class Main {

	public static void main(String[] args) {
		Custermer custermer = Custermer.builder().name("John").build();
		System.out.println(custermer);
	}

}
