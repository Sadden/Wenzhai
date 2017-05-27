package com.sadden.lucene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Word_function {

	public String path;
	
	public Word_function()
	{
		path = "res\\wordlist.txt";
	}
	public Word_function(String filepath)
	{
		path = filepath;
	}
	
	/**
	 * read all the txt 
	 */
	public void ReadFile() {
		String filepath = path;
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
	
	
	/**
	 * read all the Hamming distance in the wordlist, and return the 
	 * most similar word in the word list
	 * if there is no proper word to replace, the input word will be reserved
	 * 
	 * @param filepath
	 * @param word the target word
	 */
	public String FindMostLike(String word) 
	{
		String filepath = path;
		int len = word.length();
		String lineTxt = null;
		String mostLike = null;
		int mindistence = 100;
		
			File file = new File(filepath);
			// judge if the file is a file and exists
			if (file.isFile() && file.exists()) {
				try{
				InputStreamReader read = new InputStreamReader(new FileInputStream(file));
				BufferedReader bufferedReader = new BufferedReader(read);
				
				// read all the lines in the file
				while ((lineTxt = bufferedReader.readLine()) != null) {
					
					if(lineTxt.length() == len)
					{
//						System.out.println(lineTxt+"?");
						int distence = ShowHamming(lineTxt, word);
						if(distence < mindistence)
						{
							mindistence = distence;
							mostLike = lineTxt;
						}
					}
				}
				read.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				if(mostLike == null || mindistence > 3)
				{
					System.out.println("no match words");
					return word;
				}
				else
				{
					System.out.println("find the match word");
					return mostLike;
				}
				 
			} else {
				System.out.println("The file does not exist, return error");
				return "error";
			}
	}
	
	
	/**
	 * 
	 * @param str1
	 * @param str2
	 */
	public int ShowHamming(String str1,String str2)
	{
		int distance = 0;
		if(str1.length() != str2.length())
		{
			System.out.println("Two strings are not equally long");
			distance = 100;
		}
		else
		{
	        for(int i=0;i<str1.length();i++){  
	            if(str1.charAt(i)!=str2.charAt(i))
	            	distance++;  
	        }  
//			System.out.println("the Hamming distance is "+distance);
		}
		
		
		return distance;
	}
	
	
	
	
}
