package com.sadden.lucene;

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
	
//	@Test 
//	public void luc_cop()
//	{
//
//		Lucene_fuction luc =new Lucene_fuction();
////		Picture pic =new Picture("User1", "SA123", "2017-4-24" ,"URL", "Test");
////		Picture pic2 = new Picture("User1", "SA123", "2017-4-24", "URL", "Update");
//		String content = "a car is an egg but no car can beat me in the wind, when I got pig car, car can be killed";
//		Picture pic3 = new Picture("User1", "SA456", "2017-4-24", "URL", "KeyTest");
//		pic3.setContent(content);
////		luc.update_PicID2("SA123", pic2);
//		
//		
////		luc.queryIndex_PicID("SA456");
////		luc.AddIndex2(pic3);
//		luc.GetKeyContent("SA456");
//		luc.GetKeyContent("SA456");
//		luc.readIndex();
////		        
//	}
//	
	@Test 
	public void test_luc()
	{
		
		Picture pic1 = new Picture("Sadden", "Test URL", "cat pig tiger");
		pic1.setPicId("Sadden123");
		pic1.setContent("a goed pig is a goed pig but a goed cat is not a good cat");
		Lucene_fuction luc = new Lucene_fuction();
		
		System.out.println(luc.CorrectContent("Sadden123"));

		

	}

	
	@After
	public void delete()
	{
		
	}
}
