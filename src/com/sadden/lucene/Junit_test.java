package com.sadden.lucene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Junit_test {

	@Before
	public void init(){
		
	}
//	@Test
//	public void test_luncene_query_tag() {
//		Lucene_test lucen;
//		lucen = new Lucene_test(); 
//	//    lucen.createIndex();
//	  lucen.readIndex();
////	  lucen.queryIndex_Tag("tank");
//	  
////	  lucen.deleteIndex();
//	}
	
	@Test 
	public void luc_cop()
	{

		Lucene_fuction luc =new Lucene_fuction();
		luc.readIndex();
		
	}
	
	
	public String WashOutCH(String OcrResult)
	{
		String FinResult = null;
	    int n = 0;
	    for(int i = 0; i < OcrResult.length(); i++) {
	        n = (int)OcrResult.charAt(i);
	        if(19968 <= n && n <40869) {
	        	//the nth character in string is Chinese
	            OcrResult=OcrResult.substring(0, i)+OcrResult.substring(i+1);
	            i--;
	        }
	    }
		FinResult = OcrResult;
		
		return FinResult;
	}
	
	
	@After
	public void delete()
	{
		
	}
}
