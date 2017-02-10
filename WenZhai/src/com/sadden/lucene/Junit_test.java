package com.sadden.lucene;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Junit_test {
	private Lucene_test luc;
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
		Lucene_fuction luc2 = new Lucene_fuction();
		Lucene_fuction luc3 = new Lucene_fuction();
		luc.test_function();
		luc2.test_function();
		luc3.test_function();
	}
	
	
	
	
	@After
	public void delete()
	{
		
	}
}
