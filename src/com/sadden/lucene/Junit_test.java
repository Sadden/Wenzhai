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
	
	@Test 
	public void luc_cop()
	{
		Lucene_fuction luc = new Lucene_fuction();
		Picture pic = new Picture("admin", "20", "2017-3-15", "C:\\Users\\lenovo\\Desktop\\±œ…Ë\\≤‚ ‘Õº∆¨\\3.jpg", "man");
		luc.readIndex();
//		luc.AddIndex(pic);

	}
	
	
	
	
	@After
	public void delete()
	{
		
	}
}
