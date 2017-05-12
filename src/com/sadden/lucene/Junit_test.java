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
//		Picture pic =new Picture("User1", "SA123", "2017-4-24" ,"URL", "Test");
//		Picture pic2 = new Picture("User1", "SA123", "2017-4-24", "URL", "Update");
		String content = "a car is an egg but no car can beat me in the wind, when I got pig car, car can be killed";
		Picture pic3 = new Picture("User1", "SA456", "2017-4-24", "URL", "KeyTest");
		pic3.setContent(content);
//		luc.update_PicID2("SA123", pic2);
		
		
//		luc.queryIndex_PicID("SA456");
//		luc.AddIndex2(pic3);
		luc.GetKeyContent("SA456");
		luc.GetKeyContent("SA456");
		luc.readIndex();
//		
		

	        
	        
	}
	
	

	
	@After
	public void delete()
	{
		
	}
}
