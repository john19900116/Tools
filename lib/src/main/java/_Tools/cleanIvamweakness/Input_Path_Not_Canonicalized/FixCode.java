package _Tools.cleanIvamweakness.Input_Path_Not_Canonicalized;

import java.io.File;
import java.nio.file.Paths;

public class FixCode {

	public static void main(String[] args) {
		 
		
		
        File f1 = new File(Paths.get(new File("").getAbsoluteFile().toString(),"ini/KGIBranch.properties").toString());

		System.out.println(f1.getAbsoluteFile());
		

      File f2 = new File(new File("").getAbsoluteFile(), "ini/KGIBranch.properties");
		System.out.println(f2.getAbsoluteFile());
	}

}
