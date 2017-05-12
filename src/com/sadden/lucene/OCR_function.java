package com.sadden.lucene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

public class OCR_function {

	/**
	 * 
	 * @param pic
	 *            the taget picture
	 * @param flag
	 *            int parameter, 0 for English and 1 for Chinese
	 * @return
	 */

	public String ReadPicture(String realpath, int flag) {
		String OcrLangData = null;
		String result = null;
		if (flag == 0) {
			System.out.println("in English");
			OcrLangData = "-l eng";
		} else {
			System.out.println("in Chinese");
			OcrLangData = "-l chi_sim";
	//		OcrLangData = "-l New1 nobatch";
		}
		String OcrCommand = "tesseract";
		Runtime runtime = Runtime.getRuntime();
		String URL = realpath;
		String outPath = URL.substring(0, URL.lastIndexOf("."));
		String command = OcrCommand + " " + URL + " " + outPath + " " + OcrLangData;
		try {
			Process ps = runtime.exec(command);
			ps.waitFor();
			result = ReadFile(outPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * to read content from file text
	 * 
	 * @param outpath
	 *            the file URL
	 * @return read result
	 */
	public String ReadFile(String OutPath) {
		// ��ȡ�ļ�
		File file = new File(OutPath + ".txt");
		BufferedReader bufReader;
		String result = "no";
		try {
			bufReader = new BufferedReader(new FileReader(file));
			String temp = "";
			StringBuffer sb = new StringBuffer();
			while ((temp = bufReader.readLine()) != null) {
				sb.append(temp);
			}
			// ���ֽ��
			result = sb.toString();
			if (StringUtils.isNotBlank(result)) {
			//	result = result.replaceAll(" ", "");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

}
