package com.github.rezzco.QATemplate;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	List<List<String>> ls = ExcelData.getDate();
		String[][] data = new String[ls.size()][ls.get(0).size()];

		for (int i = 0; i < ls.size(); i++) {
			System.out.println(ls.get(i).size());
			for (int j = 0; j < ls.get(i).size(); j++) {
				data[i][j] = ls.get(i).get(j);
				System.out.println(data[i][j]);
			}
		}
		
    }
}
