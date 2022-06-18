package com.github.rezzco.QATemplate;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelData {

	

	public static List<List<String>> getDate() {
		XSSFWorkbook wb =null;
		try {
			wb = loadFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			return extractData(wb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static XSSFWorkbook loadFile() throws IOException,FileNotFoundException {
		String path = System.getProperty("user.dir") + "\\resources\\userData.xlsx";
		File excelFile = new File(path);
		XSSFWorkbook wb = null;

		FileInputStream fis = new FileInputStream(excelFile);

		wb = new XSSFWorkbook(fis);

		return wb;
	}

	private static List<List<String>> extractData(XSSFWorkbook wb) {
		XSSFSheet sheet = wb.getSheetAt(0);
		Iterator<Row> rows = sheet.rowIterator();
		List<List<String>> data = new ArrayList<>();
		rows.next();
		while (rows.hasNext()) {
			Row r = rows.next();
			Iterator<Cell> cells = r.iterator();
			List<String> rowArr = new ArrayList<String>();
			while (cells.hasNext()) {
				Cell c = cells.next();
				if (c.getCellType().equals(CellType.NUMERIC)) {
					rowArr.add(String.valueOf(c.getNumericCellValue()));
				} else {
					rowArr.add(c.getStringCellValue());
				}
			}
			data.add(rowArr);
		}
		return data;

	}

}
