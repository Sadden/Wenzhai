package sadden.wenzhai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sadden.lucene.Lucene_fuction;
import com.sadden.lucene.Lucene_test;
import com.sadden.lucene.Picture;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

@SuppressWarnings("serial")
public class SearchTag_result extends HttpServlet {

	String tag; // Search tag
	
	
	public SearchTag_result()
	{
		
		super();


		Picture example1 = new Picture("Sadden","Test Picture", 
				"2016-12-27", "C:\\Users\\lenovo\\Desktop\\±œ…Ë\\≤‚ ‘Õº∆¨\\3.jpg", 
				"Engineer");
	Lucene_test lucc = new Lucene_test();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Lucene_fuction luc;
//		System.out.println("before new luc");
//		luc = new Lucene_fuction();
//		System.out.println("after new luc");
		// TODO Auto-generated method stub
		if (request.getParameter("tag") != null) {
			tag = (String) request.getParameter("tag");
		}

		// print result
		System.out.println("tag is " + tag);

		// if the user is an administer
		if (tag.equals("0")) {
			System.out.println("tag is 0, return to admin_index");
			PrintWriter out = response.getWriter();
			out.println("<h1>Empty tag found!</h1>");
			out.println("<a href=" + "/WenZhai/admin_index.jsp" + ">Return to admin_index</a>");

		}
		else{
			ArrayList<Picture> PicList = new ArrayList<>();

//			PicList=luc.queryIndex_Tag(tag);
         		request.setAttribute("PictureList",PicList);
			//	response.sendRedirect("/Weapay/done_order.jsp");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/admin_result.jsp");
				dispatcher.forward(request, response);
		}
	}
	
	//fill the result in the picture list 
	void SearchTag(String tag, ArrayList<Picture> PicList)
	{
	//	Lucene_fuction luc = new Lucene_fuction();
	//	PicList=luc.queryIndex_Tag(tag);
		
	}
	
	
	
	

}
