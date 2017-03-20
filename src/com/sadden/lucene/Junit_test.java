package com.sadden.lucene;

import java.util.ArrayList;

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
		Lucene_fuction luc = new Lucene_fuction();
		OCR_function ocr = new OCR_function();
		String result = null;
		ArrayList<Picture> PicList = new ArrayList<>();
		PicList = luc.queryIndex_Tag("topic");
		for(Picture pic:PicList){
			result=ocr.ReadPicture(pic, 0);
			
		}
		System.out.println(result);
		
	}
	
	
	
	
	@After
	public void delete()
	{
		
	}
}
