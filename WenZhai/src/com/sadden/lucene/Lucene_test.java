package com.sadden.lucene;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Lucene_test {
	public Directory directory;  
	  
	public Analyzer analyzer;  
	  
	public IndexWriterConfig config;  
	  
	public IndexWriter writer;  
	    
	public IndexReader reader;  
	
	public Picture pic_pre1;
	public Picture pic_pre2;
	
	public Lucene_test() {
			 try {  
				 
				 //prepare for the initialization
				 pic_pre1 = new Picture("Admin","init_1", "2016-12-26", "C:\\Users\\lenovo\\Desktop\\����\\����ͼƬ\\1.jpg", "BigTank");
				 pic_pre2 = new Picture("Admin","init_2", "2016-12-27", "C:\\Users\\lenovo\\Desktop\\����\\����ͼƬ\\2.jpg", "SmallVehicle");
				 
			      //���ش洢  
			      directory = FSDirectory.open(Paths.get("G:\\Lucene_index"));  
			      //�ڴ�洢  
			      //directory = new RAMDirectory();  
			      //��ʼ���ִ���  
			      analyzer = new StandardAnalyzer();  
			      //config  
			      config = new IndexWriterConfig(analyzer);  
			      //index writer  
			      writer = new IndexWriter(directory, config);  
			      //index reader  
			      reader = DirectoryReader.open(directory);  
			    } catch (IOException e) {  
			      e.printStackTrace();  
			    }  
	} 
	
	
	public void createIndex(){  	   
		 try {  
		 
		     //add init1
		      Document doc1 = new Document();  
		      Document doc2 = new Document();
		      
		        doc1.add(new StringField("UserID", pic_pre1.getUserId(), Field.Store.YES));  
		        doc1.add(new StringField("PicID", pic_pre1.getPicId() , Field.Store.YES));  
		        doc1.add(new StringField("Time", pic_pre1.getTime() , Field.Store.YES));
		        doc1.add(new StringField("URL", pic_pre1.getURL() , Field.Store.YES));
		        doc1.add(new StringField("tag", "tank" , Field.Store.YES));
		        
		        doc2.add(new StringField("UserID", pic_pre2.getUserId(), Field.Store.YES));  
		        doc2.add(new StringField("PicID", pic_pre2.getPicId() , Field.Store.YES));  
		        doc2.add(new StringField("Time", pic_pre2.getTime() , Field.Store.YES));
		        doc2.add(new StringField("URL", pic_pre2.getURL() , Field.Store.YES));
		        doc2.add(new StringField("tag", "ship" , Field.Store.YES));
		        
		        System.out.println(pic_pre1.getTag());
		        System.out.println(pic_pre2.getTag());
 
		        writer.addDocument(doc1);  
		        writer.addDocument(doc2);  
		       
		      writer.commit();  
		    } catch (IOException e) {  
		      e.printStackTrace();  
		    }  
		}  
	//list all index
	public void readIndex(){  
	    System.out.println("max num:"+reader.maxDoc());  
	    System.out.println("index num:"+reader.numDocs());  
	    //ɾ���˵�������  
	    System.out.println("delete index num:"+reader.numDeletedDocs());  
	  }  
	
	//rebuild the searcher & check the builder
	public IndexSearcher getSearcher(){  
		 try {  
		      IndexReader newReader = DirectoryReader.openIfChanged((DirectoryReader)reader);  
		      if(newReader != null){  
		        reader.close();  
		        reader = newReader;  
		      }  
		    } catch (IOException e) {  
		      e.printStackTrace();  
		    }  
		 return new IndexSearcher(reader);  
		}  
	
	
	//query 
	public void queryIndex_Tag(String tag){  
		 try {   
		      //������  
		      IndexSearcher searcher = getSearcher();  
		      //��ѯ�ĸ��ֶ�  
		      QueryParser parse = new QueryParser("tag", analyzer);  
		      //��ѯ�ؼ���  
		      Query query = parse.parse(tag);  
		      TopDocs topDocs = searcher.search(query, 1000);  
		    
		      //��ײ���  query for socredoc[]
		      ScoreDoc[] hits = topDocs.scoreDocs;  
		       if(hits.length==0)
		       {
		    	   System.out.println("no result");
		       }
		      for (int i = 0; i < hits.length; i++) {  
		        //build for each scoredoc 
		    	  ScoreDoc hit = hits[i];  
		        //get the doc from each scoredoc
		        Document hitDoc = searcher.doc(hit.doc);  
		        //������յ÷���������Ҫ�� �ؼ��ֵĸ�����Ȩֵ������  
		        showResult(hit, hitDoc);
		       
		      }  
		    } catch (IOException e) {  
		      e.printStackTrace();  
		    } catch (ParseException e) {  
		      e.printStackTrace();  
		    }  
		}  
	
	public void showResult(ScoreDoc hit, Document hitDoc)
	{
		System.out.println(hit.doc+"---->"+hit.score);
		System.out.println("UserID: "+ hitDoc.get("UserID"));
		System.out.println("PicID: "+ hitDoc.get("PicID"));
		System.out.println("Time: "+ hitDoc.get("Time"));
		System.out.println("URL: "+ hitDoc.get("URL"));
		System.out.println("Tag: "+ hitDoc.get("tag"));
	}
	
	/** 
	* ����ȫ��ɾ�� 
	*/  
	public void deleteAllIndex(){  
	 try {  
	      writer.deleteAll();  
	      writer.commit();  
	    } catch (IOException e) {  
	      e.printStackTrace();  
	    }  
	}  
	/** 
	* ����ɾ�� 
	*/  
	public void deleteIndex(){  
	 try {  
	      Term[] terms = new Term[1];  
	      Term term = new Term("PicID", "init_1");  
	      terms[0] = term;  
	     
	      //��idΪ init_1
	      //Ҳ���Դ�һ��Query������󣬽�Query���ҵĽ��ɾ����  
	      writer.deleteDocuments(terms);  
	      //deleteDocuments  
	      writer.commit();  
	    } catch (IOException e) {  
	      e.printStackTrace();  
	    }  
	}  
	
	
//	/** 
//	* �������� 
//	*/  
//	public void updateIndex(){  
//	 try {  
//	      Term term = new Term("id", "2");  
//	      Document doc = new Document();  
//	      doc.add(new StringField("id", ids[1], Field.Store.YES));  
//	      doc.add(new StringField("name", "lsup", Field.Store.YES));  
//	      doc.add(new StringField("email", emails[1], Field.Store.YES));  
//	      doc.add(new IntField("fileSize", fileSizes[1], Field.Store.YES));  
//	      doc.add(new TextField("content", contents[1], Field.Store.NO));  
//	        
//	      //���µ�ʱ�򣬻��ԭ���Ǹ�����ɾ������������һ������  
//	      writer.updateDocument(term, doc);  
//	        
//	      writer.commit();  
//	    } catch (IOException e) {  
//	      e.printStackTrace();  
//	    }  
//	}  
}
