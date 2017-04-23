package com.sadden.lucene;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexOptions;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import sadden.wenzahi.IK.MyIKAnalyzer;

public class Lucene_fuction {
	public Directory directory;

	public Analyzer analyzer;

	public IndexWriterConfig config;

	public IndexWriter writer;

	public IndexReader reader;

	public Picture pic_pre1;
	public Picture pic_pre2;


	/**
	 * Add a new picture into lucene index.
	 * @param pic the new picture
	 */
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
			doc.add(new TextField("UserID", pic.getUserId(), Store.YES));
			doc.add(new TextField("PicID", pic.getPicId(), Store.YES));
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
	
	/**
	 * use IKAnalyzer to add index
	 * @param pic
	 */
	public void AddIndex2(Picture pic) {
		try {
			if (writer == null) {
				directory = FSDirectory.open(Paths.get("G:\\Lucene_index"));
				Analyzer smcAnalyzer = new MyIKAnalyzer();
				config = new IndexWriterConfig(smcAnalyzer);
				writer = new IndexWriter(directory, config);
			}
			System.out.println("*************Add new picture**************");
			pic.show();
			Document doc = new Document();
			doc.add(new TextField("UserID", pic.getUserId(), Store.YES));
			doc.add(new TextField("PicID", pic.getPicId(), Store.YES));
			doc.add(new StringField("Time", pic.getTime(), Store.YES));
			doc.add(new StringField("URL", pic.getURL(), Store.YES));
			doc.add(new TextField("tag", pic.getTag(), Store.YES));
			
	        // 新建FieldType,用于指定字段索引时的信息
	        FieldType type = new FieldType();
	        // 索引时保存文档、词项频率、位置信息、偏移信息
	        type.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
	        type.setStored(true);// 原始字符串全部被保存在索引中
	        type.setStoreTermVectors(true);// 存储词项量
	        type.setTokenized(true);// 词条化
	        
			doc.add(new Field("Content", pic.getContent(), type));

			writer.addDocument(doc);
			writer.commit();
			writer.close();
			directory.close();
			System.out.println("writer closed");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

	/**
	 * read all the index in lucene
	 */
	public void readIndex() {
		try {
			if (reader == null) {
				System.out.println("reader is null, new reader");
				directory = FSDirectory.open(Paths.get("G:\\Lucene_index"));
				reader = DirectoryReader.open(directory);
			}
			System.out.println("max num:" + reader.maxDoc());
			System.out.println("index num:" + reader.numDocs());
			// ɾ���˵�������
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
			// ��ѯ�ĸ��ֶ�
			QueryParser parse = new QueryParser("Content", analyzer);
			// ��ѯ�ؼ���
			Query query = parse.parse(Content);
			System.out.println("**************query:"+query);
			TopDocs topDocs = searcher.search(query, 1000);
			// ��ײ��� query for socredoc[]
			ScoreDoc[] hits = topDocs.scoreDocs;
			if (hits.length == 0) {
				System.out.println("no result");
				reader.close();
				return PicList;
			} else {
				for (int i = 0; i < hits.length; i++) {
					// build for each scoredoc
					ScoreDoc hit = hits[i];
					 // ȡ����document�Ķ���id
		            int docID = hit.doc;

		            // ��ضȵ÷�
		            float score = hit.score;
		            
		            System.out.println("ID:"+docID);
		            System.out.println("score:"+score);
					// get the doc from each scoredoc
					Document hitDoc = searcher.doc(hit.doc);
					// ����յ÷���������Ҫ�� �ؼ��ֵĸ����Ȩֵ������
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
			// ������
			// IndexSearcher searcher = getSearcher();
			analyzer = new StandardAnalyzer();
			if (reader == null) {
				System.out.println("reader is null, new reader");
				directory = FSDirectory.open(Paths.get("G:\\Lucene_index"));
				reader = DirectoryReader.open(directory);
			}
			IndexSearcher searcher = new IndexSearcher(reader);
			// ��ѯ�ĸ��ֶ�
			QueryParser parse = new QueryParser("tag", analyzer);
			// ��ѯ�ؼ���
			Query query = parse.parse(tag);
			TopDocs topDocs = searcher.search(query, 1000);
			// ��ײ��� query for socredoc[]
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
					// ����յ÷���������Ҫ�� �ؼ��ֵĸ����Ȩֵ������
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

	
	public ArrayList<Picture> queryIndex_PicID(String PicID) {
		ArrayList<Picture> PicList = new ArrayList<>();
		try {
			// ������
			// IndexSearcher searcher = getSearcher();
			analyzer = new StandardAnalyzer();
			if (reader == null) {
				System.out.println("reader is null, new reader");
				directory = FSDirectory.open(Paths.get("G:\\Lucene_index"));
				reader = DirectoryReader.open(directory);
			}
			IndexSearcher searcher = new IndexSearcher(reader);
			// ��ѯ�ĸ��ֶ�
			QueryParser parse = new QueryParser("PicID", analyzer);
			// ��ѯ�ؼ���
			Query query = parse.parse(PicID);
			TopDocs topDocs = searcher.search(query, 1000);
			// ��ײ��� query for socredoc[]
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
			// ��ѯ�ĸ��ֶ�
			QueryParser parse = new QueryParser("UserID", analyzer);
			// ��ѯ�ؼ���
			Query query = parse.parse(UserID);
			TopDocs topDocs = searcher.search(query, 1000);
			// ��ײ��� query for socredoc[]
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
					
					// ����յ÷���������Ҫ�� �ؼ��ֵĸ����Ȩֵ������
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
	 * ����ȫ��ɾ��
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

			// ���µ�ʱ�򣬻��ԭ���Ǹ�����ɾ�����������һ������
			writer.updateDocument(term, doc);
			writer.commit();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * update the picture with IKAnalyzer
	 * @param PicID
	 * to find original picture
	 * @param newpic
	 * new picture 
	 */
	public void update_PicID2(String PicID, Picture newpic) {
		try {
			if (writer == null) {
				directory = FSDirectory.open(Paths.get("G:\\Lucene_index"));
				Analyzer smcAnalyzer = new MyIKAnalyzer();
				config = new IndexWriterConfig(smcAnalyzer);
				writer = new IndexWriter(directory, config);
			}
			Term term = new Term("PicID", PicID);
			Document doc = new Document();
			doc.add(new StringField("UserID", newpic.getUserId(), Field.Store.YES));
			doc.add(new StringField("PicID", newpic.getPicId(), Field.Store.YES));
			doc.add(new StringField("Time", newpic.getTime(), Field.Store.YES));
			doc.add(new StringField("URL", newpic.getURL(), Field.Store.YES));
			doc.add(new StringField("tag", newpic.getTag(), Field.Store.YES));
			
			  // 新建FieldType,用于指定字段索引时的信息
	        FieldType type = new FieldType();
	        // 索引时保存文档、词项频率、位置信息、偏移信息
	        type.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
	        type.setStored(true);// 原始字符串全部被保存在索引中
	        type.setStoreTermVectors(true);// 存储词项量
	        type.setTokenized(true);// 词条化
	        
			doc.add(new Field("Content", newpic.getContent(), type));
			
			// ���µ�ʱ�򣬻��ԭ���Ǹ�����ɾ�����������һ������
			writer.updateDocument(term, doc);
			writer.commit();
			writer.close();
			directory.close();
			System.out.println("update writer closed");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	
}
