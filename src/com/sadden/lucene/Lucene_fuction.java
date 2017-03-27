package com.sadden.lucene;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
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
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Lucene_fuction {
	public Directory directory;

	public Analyzer analyzer;

	public IndexWriterConfig config;

	public IndexWriter writer;

	public IndexReader reader;

	public Picture pic_pre1;
	public Picture pic_pre2;


	
	public void AddIndex(Picture pic) {
		try {
			if (writer == null) {
				directory = FSDirectory.open(Paths.get("G:\\Lucene_index"));
				analyzer = new StandardAnalyzer();
				config = new IndexWriterConfig(analyzer);
				writer = new IndexWriter(directory, config);
			}
			System.out.println("*************Add new picture**************");
			pic.show();
			Document doc = new Document();
			doc.add(new StringField("UserID", pic.getUserId(), Store.YES));
			doc.add(new StringField("PicID", pic.getPicId(), Store.YES));
			doc.add(new StringField("Time", pic.getTime(), Store.YES));
			doc.add(new StringField("URL", pic.getURL(), Store.YES));
			doc.add(new TextField("tag", pic.getTag(), Store.YES));
			doc.add(new TextField("Content", pic.getContent(), Store.YES));

			writer.addDocument(doc);
			writer.commit();
			writer.close();
			System.out.println("writer closed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// list all index
	public void readIndex() {
		try {
			if (reader == null) {
				System.out.println("reader is null, new reader");
				directory = FSDirectory.open(Paths.get("G:\\Lucene_index"));
				reader = DirectoryReader.open(directory);
			}
			System.out.println("max num:" + reader.maxDoc());
			System.out.println("index num:" + reader.numDocs());
			// 删除了的索引数
			System.out.println("delete index num:" + reader.numDeletedDocs());
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * query index in Content
	 * 
	 * @param Content
	 * @return query result in ArrayList<Picture>
	 * @throws IOException
	 */
	public ArrayList<Picture> queryIndex_Content(String Content) {
		ArrayList<Picture> PicList = new ArrayList<>();
		try {
			analyzer = new StandardAnalyzer();
			if (reader == null) {
				System.out.println("reader is null, new reader");
				directory = FSDirectory.open(Paths.get("G:\\Lucene_index"));
				reader = DirectoryReader.open(directory);
			}
			IndexSearcher searcher = new IndexSearcher(reader);
			// 查询哪个字段
			QueryParser parse = new QueryParser("Content", analyzer);
			// 查询关键字
			Query query = parse.parse(Content);
			System.out.println("**************query:"+query);
			TopDocs topDocs = searcher.search(query, 1000);
			// 碰撞结果 query for socredoc[]
			ScoreDoc[] hits = topDocs.scoreDocs;
			if (hits.length == 0) {
				System.out.println("no result");
				reader.close();
				return PicList;
			} else {
				for (int i = 0; i < hits.length; i++) {
					// build for each scoredoc
					ScoreDoc hit = hits[i];
					 // 取对象document的对象id
		            int docID = hit.doc;

		            // 相关度得分
		            float score = hit.score;
		            
		            System.out.println("ID:"+docID);
		            System.out.println("score:"+score);
					// get the doc from each scoredoc
					Document hitDoc = searcher.doc(hit.doc);
					// 结果按照得分来排序。主要由 关键字的个数和权值来决定
					showResult(hit, hitDoc);
					addResult(hit, hitDoc, PicList);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return PicList;
	}

	/**
	 * query index in tag
	 * 
	 * @param tag
	 * @return query result in ArrayList<Picture>
	 */
	public ArrayList<Picture> queryIndex_Tag(String tag) {
		ArrayList<Picture> PicList = new ArrayList<>();
		try {
			// 搜索器
			// IndexSearcher searcher = getSearcher();
			analyzer = new StandardAnalyzer();
			if (reader == null) {
				System.out.println("reader is null, new reader");
				directory = FSDirectory.open(Paths.get("G:\\Lucene_index"));
				reader = DirectoryReader.open(directory);
			}
			IndexSearcher searcher = new IndexSearcher(reader);
			// 查询哪个字段
			QueryParser parse = new QueryParser("tag", analyzer);
			// 查询关键字
			Query query = parse.parse(tag);
			TopDocs topDocs = searcher.search(query, 1000);
			// 碰撞结果 query for socredoc[]
			ScoreDoc[] hits = topDocs.scoreDocs;
			if (hits.length == 0) {
				System.out.println("no result");
				reader.close();
				return PicList;
			} else {
				for (int i = 0; i < hits.length; i++) {
					// build for each scoredoc
					ScoreDoc hit = hits[i];
					// get the doc from each scoredoc
					Document hitDoc = searcher.doc(hit.doc);
					// 结果按照得分来排序。主要由 关键字的个数和权值来决定
					showResult(hit, hitDoc);
					addResult(hit, hitDoc, PicList);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return PicList;
	}

	
	
	/**
	 * query index in UserID
	 * 
	 * @param Content
	 * @return query result in ArrayList<Picture>
	 * @throws IOException
	 */
	public ArrayList<Picture> queryIndex_UserID(String UserID) {
		ArrayList<Picture> PicList = new ArrayList<>();
		try {
			analyzer = new StandardAnalyzer();
			if (reader == null) {
				directory = FSDirectory.open(Paths.get("G:\\Lucene_index"));
				reader = DirectoryReader.open(directory);
			}
			IndexSearcher searcher = new IndexSearcher(reader);
			// 查询哪个字段
			QueryParser parse = new QueryParser("UserID", analyzer);
			// 查询关键字
			Query query = parse.parse(UserID);
			TopDocs topDocs = searcher.search(query, 1000);
			// 碰撞结果 query for socredoc[]
			ScoreDoc[] hits = topDocs.scoreDocs;
			if (hits.length == 0) {
				System.out.println("no result");
				reader.close();
				return PicList;
			} else {
				for (int i = 0; i < hits.length; i++) {
					// build for each scoredoc
					ScoreDoc hit = hits[i];
					// get the doc from each scoredoc
					Document hitDoc = searcher.doc(hit.doc);
					
					// 结果按照得分来排序。主要由 关键字的个数和权值来决定
					showResult(hit, hitDoc);
					addResult(hit, hitDoc, PicList);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return PicList;
	}
	
	
	
	/**
	 * show the content & fields of a result hit
	 * 
	 * @param hit
	 * @param hitDoc
	 */
	public void showResult(ScoreDoc hit, Document hitDoc) {
		System.out.println(hit.doc + "---->" + hit.score);
		System.out.println("UserID: " + hitDoc.get("UserID"));
		System.out.println("PicID: " + hitDoc.get("PicID"));
		System.out.println("Time: " + hitDoc.get("Time"));
		System.out.println("URL: " + hitDoc.get("URL"));
		System.out.println("Tag: " + hitDoc.get("tag"));
		System.out.println("Content: " + hitDoc.get("Content"));
	}

	/**
	 * Add hit document into Picturelist
	 * 
	 * @param hit
	 * @param hitDoc
	 * @param PicList
	 */
	public void addResult(ScoreDoc hit, Document hitDoc, ArrayList<Picture> PicList) {

		String UserID = hitDoc.get("UserID");
		String PicID = hitDoc.get("PicID");
		String Time = hitDoc.get("Time");
		String URL = hitDoc.get("URL");
		String Tag = hitDoc.get("tag");
		String Content = hitDoc.get("Content");
		Picture PicResult = new Picture(UserID, PicID, Time, URL, Tag);
		PicResult.setContent(Content);
		PicList.add(PicResult);

	}

	/**
	 * 索引全部删除
	 */
	public void deleteAllIndex() {
		try {
			writer.deleteAll();
			writer.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * delete the term with tag
	 * 
	 * @param tag
	 */
	public void delete_tag(String tag) {
		try {
			if (writer == null) {
				directory = FSDirectory.open(Paths.get("G:\\Lucene_index"));
				analyzer = new StandardAnalyzer();
				config = new IndexWriterConfig(analyzer);
				writer = new IndexWriter(directory, config);
			}
			Term term = new Term("tag", tag);
			writer.deleteDocuments(term);
			writer.commit();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * delete the term with picId
	 * 
	 * @param PicID
	 */
	public void delete_PicID(String PicID) {
		try {
			if (writer == null) {
				directory = FSDirectory.open(Paths.get("G:\\Lucene_index"));
				analyzer = new StandardAnalyzer();
				config = new IndexWriterConfig(analyzer);
				writer = new IndexWriter(directory, config);
			}
			Term term = new Term("PicID", PicID);
			writer.deleteDocuments(term);
			writer.commit();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * update the Picture
	 * 
	 * @param PicID
	 *            to find original Picture
	 * @param newpic
	 *            new picture
	 */
	public void update_PicID(String PicID, Picture newpic) {
		try {
			if (writer == null) {
				directory = FSDirectory.open(Paths.get("G:\\Lucene_index"));
				analyzer = new StandardAnalyzer();
				config = new IndexWriterConfig(analyzer);
				writer = new IndexWriter(directory, config);
			}
			Term term = new Term("PicID", PicID);
			Document doc = new Document();
			doc.add(new StringField("UserID", newpic.getUserId(), Field.Store.YES));
			doc.add(new StringField("PicID", newpic.getPicId(), Field.Store.YES));
			doc.add(new StringField("Time", newpic.getTime(), Field.Store.YES));
			doc.add(new StringField("URL", newpic.getURL(), Field.Store.YES));
			doc.add(new StringField("tag", newpic.getTag(), Field.Store.YES));
			doc.add(new StringField("Content", newpic.getContent(), Field.Store.YES));

			// 更新的时候，会把原来那个索引删掉，重新生成一个索引
			writer.updateDocument(term, doc);
			writer.commit();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
