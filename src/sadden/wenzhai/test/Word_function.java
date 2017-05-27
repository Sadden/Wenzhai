package sadden.wenzhai.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Word_function {

	/**
	 * read all txt file
	 * 
	 * @param filepath
	 */
	public void ReadFile(String filepath) {
		try {
			File file = new File(filepath);
			// judge if the file is a file and exists
			if (file.isFile() && file.exists()) {
				InputStreamReader read = new InputStreamReader(new FileInputStream(file));
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				// read all the lines in the file
				while ((lineTxt = bufferedReader.readLine()) != null) {
					System.out.println(lineTxt);
				}
				read.close();
			} else {
				System.out.println("The file does not exist");
			}
		}

		catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
	}
}
