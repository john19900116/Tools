package _Tools.TestPoi;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class AMain {
	public static void main(String[] args) throws BiffException, IOException {
		// 指定Excel檔案路徑
		File file = new File("file/DAILY_STATEMENT_8084088_20230911.xls");

		// 創建工作簿
		Workbook workbook = Workbook.getWorkbook(file);

		// 獲取第一個工作表
		Sheet sheet = workbook.getSheet(0);

		// 遍歷所有行
		for (int i = 0; i < sheet.getRows(); i++) {
			// 遍歷所有列
			for (int j = 0; j < sheet.getColumns(); j++) {
				// 讀取單元格值
				Cell cell = sheet.getCell(j, i);
				String cellValue = cell.getContents();
				System.out.print(cellValue + "\t");
			}
			System.out.println();
		}

		// 關閉工作簿
		workbook.close();
	}
}
