package _Tools.Absolute_Path_Traversal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

public class FixCode {

	public static void main(String[] args) throws FileNotFoundException {
		File absDir = new File("").getAbsoluteFile();
		String path = "ini/KGIBranch.properties";
		File quickReqDir = new File(Paths.get(absDir.toString(), path).toString());
		System.out.println(quickReqDir.getAbsolutePath().toString());

		File quickReqDir2 = new File(Paths.get("", path).toString());
		System.out.println(quickReqDir2.getAbsolutePath().toString());
		

		

	}
	

}
