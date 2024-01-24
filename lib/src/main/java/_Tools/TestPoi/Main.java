package _Tools.TestPoi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Main {
	private static final String filePath = "file/";
	private static final String fileName = "DAILY_STATEMENT_8084088_20230911-2.xls";

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// 指定Excel檔案路徑
		File file = new File(filePath + fileName);
		FileInputStream inputStream = new FileInputStream(file);

		// 創建工作簿
		Workbook workbook = WorkbookFactory.create(inputStream);

		// 獲取第一個工作表
		Sheet sheet = workbook.getSheetAt(0);

		// 遍歷所有行
		for (Row row : sheet) {
			// 遍歷所有列
			for (Cell cell : row) {
				// 讀取單元格值
				String cellValue = cell.getStringCellValue();
				System.out.print(cellValue + "\t");
			}
			System.out.println();
		}

		// 關閉工作簿和輸入流
		workbook.close();
		inputStream.close();
	}

}
