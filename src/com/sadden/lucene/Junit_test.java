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
	//	luc.delete_tag("man");
		luc.readIndex();
		
	}
	
	
	
	
	@After
	public void delete()
	{
		
	}
}
