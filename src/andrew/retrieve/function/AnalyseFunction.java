package andrew.retrieve.function;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.SortField.Type;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

import andrew.retrieve.structure.Corpus;
import andrew.retrieve.structure.PageRank;
import andrew.retrieve.structure.Paper;
import andrew.retrieve.structure.Vocabulary;


public class AnalyseFunction {

	//Address configuration
	public String MagPaperDir="F:";
	public String ArxivSourceDir="G:/ArxivData/Arxiv/Arxiv";
	public String IndexDir="G:/ArxivData/Index";
	public String PaperIndexDir=IndexDir+"/Paper";
	public String AbstractIndexDir=IndexDir+"/Abstract";
	public String refDir="E:";
	
	public String tsdir="G:/ArxivData/03/col";
	public String tidir="G:/ArxivData/TAIndex";
	 
	public boolean CreateMode=false;
	
	//Processing tools to be initiated
	IndexWriterConfig iwc;
	Corpus corpus;
	//special markup
	public static String DIV=" #dddddsssssddddd# ";
	
	
	//test data
	double tp=0.0;
	double tc=0.0;
	static int K=800;
	static double FIX=0.48;
	//lda test data
	double ldatp=0.0;
	double ldatc=0.0;
	double[][] phi;
	double[][] theta;
	
	ArrayList<String> cit;
	
	public void readPhi() throws NumberFormatException, IOException{
		phi=readMatrix("phi");
	}
	public void readTheta() throws NumberFormatException, IOException{
		theta=readMatrix("theta");
	}
	
	public AnalyseFunction(){
		init();
	}

	public void init(){
		//create or confirm directories
		File sf=new File(ArxivSourceDir);
		File nf=new File(IndexDir);
		if(!sf.exists()){
			sf.mkdir();
		}
		if(!nf.exists()){
			nf.mkdir();
		}
		//initialize tools
		Analyzer ana=new StandardAnalyzer();
		iwc=new IndexWriterConfig(ana);
		if(CreateMode==true)iwc.setOpenMode(OpenMode.CREATE);
		else iwc.setOpenMode(OpenMode.CREATE_OR_APPEND);
		corpus=new Corpus();
	}
	
	public void writeMagPaperIndex(){
		FSDirectory direct=null;
		IndexWriter writer=null;
			
		try {
			direct=FSDirectory.open(Paths.get(PaperIndexDir));
			writer=new IndexWriter(direct,iwc);
		} catch (IOException e1) {
			
			e1.printStackTrace();
			return;
		}
		File f=new File(MagPaperDir+"/Papers.txt");
		try {
			BufferedReader br=new BufferedReader(new FileReader(f));
			String str="";
			String temp=br.readLine();
			System.out.println(temp);
			int iii=11;
			if(iii==1)return;
			System.out.println(f.length());
			for(int i=0;temp!=null;temp=br.readLine(),i++){
				if(i>500000)break;
				if(i%100000==0)System.out.println(i);
				//code
				Document doc=new Document();
				String code=temp.split("	")[0];
				String title=temp.split("	")[2];
				String year=temp.split("	")[3];
				String date=temp.split("	")[4];
				String doi=temp.split("	")[5];
				String venue=temp.split("	")[7];
				String journal=temp.split("	")[8];
				String conference=temp.split("	")[9];
				String rank=temp.split("	")[10];
				//System.out.println(id+" "+url);
				doc.add(new StringField("code", code, Field.Store.YES));
				doc.add(new StringField("title2", title, Field.Store.YES));
				doc.add(new TextField("title",new StringReader(title)));
				doc.add(new StringField("year",year,Field.Store.YES));
				doc.add(new StringField("date",date,Field.Store.YES));
				doc.add(new StringField("doi",doi,Field.Store.YES));
				doc.add(new StringField("venue",venue,Field.Store.YES));
				doc.add(new StringField("journal",journal,Field.Store.YES));
				doc.add(new StringField("conference",conference,Field.Store.YES));
				doc.add(new StringField("rank",rank,Field.Store.YES));
				writer.addDocument(doc);
				//System.out.println(title);
				//codeend
			}
			br.close();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeArxPaperIndex(){
		FSDirectory direct=null;
		IndexWriter writer=null;
			
		try {
			direct=FSDirectory.open(Paths.get(AbstractIndexDir));
			writer=new IndexWriter(direct,iwc);
		} catch (IOException e1) {
			
			e1.printStackTrace();
			return;
		}
		File folder=new File(ArxivSourceDir);
		int lll=0;
		int filenum=0;
		int cc=0;
		for(File f:folder.listFiles()){
			try {
				System.out.println(f.getName());
				BufferedReader br=new BufferedReader(new FileReader(f));
				String str="";
				String temp="";
				for(temp=br.readLine();temp!=null;temp=br.readLine()){
					//str=str+temp;
					int docnum=0;
					if(temp.contains("<metadata>")){
						String description="";
						String title="";
						String id="";
						String code="";
						String author="";
						String subject="";
						String date="";
						boolean ref=false;
						for(temp=br.readLine();temp!=null;temp=br.readLine()){
							if(temp.contains("</oai_dc:dc>")){
								break;
							}
							if(temp.contains("Comment:"))continue;
							if(temp.contains("<dc:description>")){
								for(String t=br.readLine();!t.contains("</dc:description>");t=br.readLine()){
									temp=temp+t;
								}
								description=temp.split(">")[1];
								//System.out.println(description);
								
							}
							if(temp.contains("<dc:title>")){
								title=temp.split(">")[1].split("</")[0];
								//ArrayList<String> comp=MagSearchTitle(title, 1);
//								if(comp.size()>0){
//									if(comp.get(0).equals(title.toLowerCase())){
//										ref=true;
//										System.out.println(comp);
//										code=comp.get(1);
//									}
//								}
								
							}
							if(temp.contains("<dc:creator>")){
								author=temp.split(">")[1].split("</")[0];
								
								
							}
							if(temp.contains("<dc:subject>")){
								subject=temp.split(">")[1].split("</")[0];
								
								
							}
							if(temp.contains("<dc:date>")){
								date=temp.split(">")[1].split("</")[0];
								
								
							}
							if(temp.contains("<dc:identifier"))id=temp.split(">")[1].split("</")[0];
						}
						if(id==""&&title==""){
							System.out.println("invalid");
							continue;
						}
						Document doc=new Document();
						doc.add(new StringField("identifier", id, Field.Store.YES));
						doc.add(new StringField("title", title, Field.Store.YES));
						doc.add(new TextField("description",new StringReader(description)));
						if(ref==true){
							doc.add(new StringField("code",code,Field.Store.YES));
							cc++;
							if(cc%100==0)System.out.println(cc);
						}
						writer.addDocument(doc);
						docnum++;
						if(docnum%1000==0)System.out.println(docnum);
					}
				}
				//System.out.println(str);
				filenum++;
				System.out.println("file "+filenum+" completed~");
				br.close();
			
			} catch (IOException e) {
			
				// TODO Auto-generated catch block
			
				e.printStackTrace();
				System.out.println("error");
				return;
		
			}
	
			
			
		}
		try {
			System.out.println("writer close");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
			

	}
	
	public void writeKddPaperIndex(){
		FSDirectory direct=null;
		IndexWriter writer=null;
			
		try {
			direct=FSDirectory.open(Paths.get(tidir));
			writer=new IndexWriter(direct,iwc);
		} catch (IOException e1) {
			
			e1.printStackTrace();
			return;
		}
		File folder=new File(tsdir);
		int filenum=0;
		for(File f:folder.listFiles()){
			try {
				//System.out.println(f.getName());
				BufferedReader br=new BufferedReader(new FileReader(f));
				String code="";
				String content="";
				String title="";
				String temp="";
				//System.out.println(f.getName());
				for(temp=br.readLine();temp!=null;temp=br.readLine()){
					
					if(temp.contains("Paper: hep-th/")){
						code=temp.split("/")[1];
						//System.out.println("code="+code);
					}
					else if(temp.contains("Title: ")){
						title=temp.split("Title: ")[1];
						//System.out.println("title="+title);
						for(temp=br.readLine();!temp.contains("\\\\");temp=br.readLine());
						for(temp=br.readLine();temp!=null;temp=br.readLine()){
							if(temp.contains("\\\\"))break;
							content=content+temp;
						}
						if(code.equals("0001020")){
							System.out.println("conten:"+content);
						}
						
					}
					
				}
				Document doc=new Document();
				doc.add(new StringField("code", code, Field.Store.YES));
				doc.add(new StringField("title", title, Field.Store.YES));
				doc.add(new TextField("content",new StringReader(content)));
				writer.addDocument(doc);
				br.close();	
				filenum++;
				if(filenum%1000==0)System.out.println(filenum);
			} catch (Exception e) {
			
				// TODO Auto-generated catch block
				System.out.println(f.getName());
				e.printStackTrace();
				return;
		
			}
	
			
			
		}
		try {
			System.out.println("writer close");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
			

	}
	
	@SuppressWarnings("resource")
	public void writeKddLDA() throws IOException{
		//BufferedWriter bw=new BufferedWriter(new FileWriter(new File("D:/ArxivData/03/split/phi.txt")));
		FSDirectory direct=null;
		IndexWriter writer=null;
		try {
			direct=FSDirectory.open(Paths.get(PaperIndexDir));
			writer=new IndexWriter(direct,iwc);
		} catch (IOException e1) {
			
			e1.printStackTrace();
			return;
		}
		File folder=new File(tsdir);
		//File folder2=new File("D:/Arxiv/03/split");
		int filenum=0;
		
		for(File f:folder.listFiles()){
			try {
				//System.out.println(f.getName());
				BufferedReader br=new BufferedReader(new FileReader(f));
				String code="";
				String content="";
				String title="";
				String temp="";
				//System.out.println(f.getName());
				for(temp=br.readLine();temp!=null;temp=br.readLine()){
					
					if(temp.contains("Paper: hep-th/")){
						code=temp.split("/")[1];
						//System.out.println("code="+code);
					}
					else if(temp.contains("Title: ")){
						title=temp.split("Title: ")[1];
						//System.out.println("title="+title);
						for(temp=br.readLine();!temp.contains("\\\\");temp=br.readLine());
						for(temp=br.readLine();temp!=null;temp=br.readLine()){
							if(temp.contains("\\\\"))break;
							content=content+temp;
						}
						
					}
					
				}
				Document doc=new Document();
				doc.add(new StringField("code", code, Field.Store.YES));
				doc.add(new StringField("title", title, Field.Store.YES));
				doc.add(new TextField("content",new StringReader(content)));
				writer.addDocument(doc);
				
				
				QueryParser parser=new QueryParser("content",new StandardAnalyzer());
				String q=QueryParser.escape(content);
				Query query=parser.parse(q);
				String queryString=query.toString().replaceAll("\\((.*?)\\)", "").replaceAll("content:", "");
				LinkedList<String> termList=new LinkedList<String>();
				String[] list=queryString.split(" ");
				for(int i=0;i<list.length;i++){
					termList.add(list[i]);
				}
				corpus.addDocument(termList,code);
				br.close();	
				filenum++;
				if(filenum%1000==0)System.out.println(filenum);
			} catch (Exception e) {
			
				// TODO Auto-generated catch block
				System.out.println(f.getName());
				e.printStackTrace();
				return;
		
			}

		}
		writer.close();
		System.out.println(corpus.getVocabularySize());
		System.out.println("Sampler");
        //LdaGibbsSampler ldaGibbsSampler = new LdaGibbsSampler(corpus.getDocument(), corpus.getVocabularySize());
        // 3. Train it
        System.out.println("Train"+K);
        //ldaGibbsSampler.gibbs(K);
        // 4. The phi matrix is a LDA model, you can use LdaUtil to explain it.
        //phi = ldaGibbsSampler.getPhi();
       // System.out.println(phi.length+" "+phi[0].length);
        //theta=ldaGibbsSampler.getTheta();
        System.out.println(theta.length+" "+theta[0].length);
        //writeMatrix(phi,"phi");
        //writeMatrix(theta,"theta");
        //corpus.writeRecord("D:/ArxivData/record");
        System.out.println("translate");
        //Map<String, Double>[] topicMap = LdaUtil.translate(phi, corpus.getVocabulary(), 10);
        System.out.println("Explain");
        //LdaUtil.explain(topicMap);
        System.out.println(theta.length);

	}
	
	public void writeMatrix(double[][] m,String name) throws IOException{
		BufferedWriter bw=new BufferedWriter(new FileWriter(new File("D:/ArxivData/record/"+name)));
		bw.write(m.length+"\n");
		for(int i=0;i<m.length;i++){
			bw.write(m[i].length+" ");
			for(int j=0;j<m[i].length;j++){
				bw.write(m[i][j]+" ");
			}
			bw.write("\n");
		}
		bw.close();
	}
	public double[][] readMatrix(String name) throws NumberFormatException, IOException{
		double[][] result;
		BufferedReader br=readFile(new File("D:/ArxivData/record/"+name));
		int row=Integer.parseInt(br.readLine());
		result=new double[row][];
		for(int i=0;i<row;i++){
			String[] str=br.readLine().split(" ");
			int column=Integer.parseInt(str[0]);
			result[i]=new double[column];
			for(int j=0;j<column;j++){
				result[i][j]=Double.parseDouble(str[j+1]);
			}
		}
		return result;
	}
	
	
	public void checkArxMag(){
		FSDirectory direct=null;
		IndexWriter writer=null;
		File folder=new File(ArxivSourceDir);
		int lll=0;
		int filenum=0;
		int count=0;
		for(File f:folder.listFiles()){
			try {
				System.out.println(f.getName());
				BufferedReader br=new BufferedReader(new FileReader(f));
				String str="";
				String temp="";
				for(temp=br.readLine();temp!=null;temp=br.readLine()){
					//str=str+temp;
					int docnum=0;
					if(temp.contains("<metadata>")){
						String description="";
						String title="";
						String id="";
						for(temp=br.readLine();temp!=null;temp=br.readLine()){
							if(temp.contains("</oai_dc:dc>")){
								break;
							}
							if(temp.contains("Comment:"))continue;
							if(temp.contains("<dc:description>")){
								for(String t=br.readLine();!t.contains("</dc:description>");t=br.readLine()){
									temp=temp+t;
								}
								description=temp.split(">")[1];
								//System.out.println(description);
								
							}
							if(temp.contains("<dc:title>")){
								title=temp.split(">")[1].split("</")[0];
								ArrayList<String> comp=MagSearchTitle(title, 1);
								if(comp.size()>0){
									if(comp.get(0).equals(title.toLowerCase())){
										System.out.println(comp.get(0)+comp.get(1)+comp.get(2));
										count++;
									}
								}
								
							}
							if(temp.contains("<dc:identifier"))id=temp.split(">")[1].split("</")[0];
						}
						if(id==""&&title==""){
							System.out.println("invalid");
							continue;
						}
						
					}
				}
				//System.out.println(str);
				filenum++;
				System.out.println("file "+filenum+" completed~");
				br.close();
			
			} catch (IOException e) {
			
				// TODO Auto-generated catch block
			
				e.printStackTrace();
				System.out.println("error");
				return;
		
			}
		}
	}
	
	public List<Paper> KddSearchTitleCode(String str,int n){
		List<Paper> list=new ArrayList<Paper>();
		if(str==null)return list;
		if(str.length()==0)return list;
		try {
			FSDirectory dir=FSDirectory.open(Paths.get(PaperIndexDir));
			IndexSearcher searcher=new IndexSearcher(DirectoryReader.open(dir));
			Analyzer analyzer=new StandardAnalyzer();
			QueryParser parser=new QueryParser("content",analyzer);
			String q=QueryParser.escape(str);
			Query query=parser.parse(q);
			//System.out.println(query);
			BooleanQuery bquery=new BooleanQuery();
			bquery.add(query,BooleanClause.Occur.MUST);
			SortField sortField = new SortField("year", Type.INT);
			//Sort sort=new Sort(sortField);
			TopDocs results=null;
			try{
				results=searcher.search(query,n);
			}catch(Exception e){
				System.out.println(n);
			}
			
			ScoreDoc[] hits=results.scoreDocs;
			//System.out.println(hits.length);
			//System.out.println("print");
			for(ScoreDoc hit:hits){
				Document d=searcher.doc(hit.doc);
				//System.out.println(d.get("code"));
				Paper p=new Paper();
				p.title=d.get("title");
				p.description=d.get("description");
				p.url=d.get("code");
				list.add(p);
				//list.add(d.get("code")+"###"+d.get("title")+"###"+"Author"+"###"+"Abstract"+"###"+"url");
			}
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(list.size());
		
		return list;
		
	}
	
	public void ArxSearchTitleUrl(String str,int n){
		try {
			FSDirectory dir=FSDirectory.open(Paths.get(AbstractIndexDir));
			System.out.println(DirectoryReader.open(dir).maxDoc());
			IndexSearcher searcher=new IndexSearcher(DirectoryReader.open(dir));
			Analyzer analyzer=new StandardAnalyzer();
			QueryParser parser=new QueryParser("description",analyzer);
			String q=QueryParser.escape(str);
			Query query=parser.parse(q);
			System.out.println(query);
			BooleanQuery bquery=new BooleanQuery();
			bquery.add(query,BooleanClause.Occur.MUST);
			SortField sortField = new SortField("year", Type.INT);
			//Sort sort=new Sort(sortField);
			
			TopDocs results=searcher.search(query,n);
			
			ScoreDoc[] hits=results.scoreDocs;
			System.out.println(hits.length);
			System.out.println("print");
			for(ScoreDoc hit:hits){
				Document d=searcher.doc(hit.doc);
				System.out.println(d.get("title")+" "+d.get("identifier")+"   "+hit.score);
				DirectoryReader reader=DirectoryReader.open(dir);
			}
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<String> MagSearchTitle(String str,int n){
		ArrayList<String> t=new ArrayList<String>();
		try {
			FSDirectory dir=FSDirectory.open(Paths.get(PaperIndexDir));
			System.out.println(DirectoryReader.open(dir).maxDoc());
			IndexSearcher searcher=new IndexSearcher(DirectoryReader.open(dir));
			Analyzer analyzer=new StandardAnalyzer();
			QueryParser parser=new QueryParser("title",analyzer);
			String q=QueryParser.escape(str);
			Query query=parser.parse(q);
			//System.out.println(query);
			BooleanQuery bquery=new BooleanQuery();
			bquery.add(query,BooleanClause.Occur.MUST);
			SortField sortField = new SortField("year", Type.INT);
			//Sort sort=new Sort(sortField);
			
			TopDocs results=searcher.search(query,n);
			
			ScoreDoc[] hits=results.scoreDocs;
			//System.out.println(hits.length);
			//System.out.println("print");
			
			int count=0;
			for(ScoreDoc hit:hits){
				Document d=searcher.doc(hit.doc);
				//System.out.println(d.get("title2")+" "+hit.score);
				if(count==0){
					t.add(d.get("title2"));
					t.add(d.get("code"));
					t.add(""+hit.score);
				}
				count++;
			}
			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	
	public void KddCheck(List<String> answer,List<String> result){
		if(result.size()==0||answer.size()==0){
			return;
		}
		
		int n=0;
		for(String s:answer){
			for(String r:result){
				if(s.equals((r))){
					//System.out.println("common"+r);
					n++;
				}
			}
		}
		float nn=(float)n;
		//System.out.println("P="+nn/result.size()*100+"% C="+nn/answer.size()*100+"%");
		
		tp=tp+nn/result.size();
		tc=tc+nn/answer.size();
	}
	
	public void KddCheckLda(List<String> answer,List<String> result){
		if(result.size()==0||answer.size()==0){
			return;
		}
		
		int n=0;
		for(String s:answer){
			for(String r:result){
				if(s.equals((r))){
					//System.out.println("common"+r);
					n++;
				}
			}
		}
		float nn=(float)n;
		System.out.println("P="+nn/result.size()*100+"% C="+nn/answer.size()*100+"%");
		
		ldatp=ldatp+nn/result.size();
		System.out.println("LDAtp="+ldatp);
		ldatc=ldatc+nn/answer.size();
		System.out.println("LDAtc="+ldatc);
	}
	
	
	public List<String> KddGetAnswer(String code){
		File f=new File("D:/ArxivData/03/hep-th-citations");
		List<String> answer=new ArrayList<String>();
		List<String> refer=new ArrayList<String>();
		try {
			BufferedReader br=new BufferedReader(new FileReader(f));
			String temp;
			for(temp=br.readLine();temp!=null;temp=br.readLine()){
				if(temp.contains(code)){
					String str1=temp.split(" ")[0];
					String str2=temp.split(" ")[1];
					if(!answer.contains(str1)) {
						answer.add(str1);
						//System.out.println(str1);
					}
					if(!answer.contains(str2)) {
						if(str1.contains(code)){
							refer.add(str2);
						}
						answer.add(str2);
						//System.out.println(str2);
					}
				}
			}
			br.close();
			br=new BufferedReader(new FileReader(f));
			
			for(String r:refer){
				for(temp=br.readLine();temp!=null;temp=br.readLine()){
					if(temp.contains(r)){
						String str1=temp.split(" ")[0];
						String str2=temp.split(" ")[1];
						if(!answer.contains(str1)) {
							answer.add(str1);
							//System.out.println(str1);
						}
					}
				}
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(answer.size());
		
		return answer;
	}
	
	
	
	public double cosineSimilarity(double[] vec1, double[] vec2){
		if(vec1.length!=vec2.length)return 0.0;
		double result=0.0;
		double sum=0.0;
		double molA=0.0;
		double molB=0.0;
		for(int p=0;p<vec1.length;p++){
			sum+=normalize(vec1)[p]*normalize(vec2)[p];
			molA+=normalize(vec1)[p]*normalize(vec1)[p];
			molB+=normalize(vec2)[p]*normalize(vec2)[p];
		}
		molA=Math.sqrt(molA);
		molB=Math.sqrt(molB);
		result=sum/(molA*molB);
		return result;
	}
	
	public void load() throws IOException{
		cit=new ArrayList<String>();
		File f=new File("D:/ArxivData/03/hep-th-citations");
		BufferedReader br=new BufferedReader(new FileReader(f));
		String temp;
		for(temp=br.readLine();temp!=null;temp=br.readLine()){
			cit.add(temp);
		}
		br.close();
		System.out.println("cit="+cit.size());
	}
	
	public List<String> pageRank(List<String> result,int num) throws NumberFormatException, IllegalArgumentException, IOException{
		List<String> sort;
		Set<String> edge=new HashSet<String>();
		Set<String> chosen=new HashSet<String>();
		List<String> single=new LinkedList<String>();
		for(String r:result){
			for(String c:cit){
				String a1=c.split(" ")[0];
				String a2=c.split(" ")[1];
				if(result.contains(a1)&&result.contains(a2)&&!a1.equals(a2)){
					edge.add(c);
					chosen.add(a1);
					chosen.add(a2);
				}
			}
			
		}
		//System.out.println(edge.size()+" "+chosen.size());
		PageRank pr=new PageRank();
		pr.initialize(chosen,edge);
		for(int k=0;k<3;k++){
			System.out.println("iteration "+(k+1));
			if(!pr.updateScore()){
				System.out.println("pause:"+k);
				break;
			}
		}
		sort=pr.sort(num);
		for(String r:result){
			if(!chosen.contains(r)){
				sort.add(r);
			}
		}
		return sort;
	}
	
	public void FirstTest(String[] args) throws NumberFormatException, IOException, ParseException {
		int n=100000;
		int count=0;
		System.out.println(tsdir);
		
		for(File f:(new File(tsdir).listFiles())){
			BufferedWriter cosWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("D:/ArxivData/cos"),true)));
			//System.out.println("Start!");
			String num=f.getName().split(".abs")[0];
			String str="";
			BufferedReader br=null;
			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(f),"utf8"));
			} catch (FileNotFoundException | UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			String temp = "";
			try {
				
				for(temp=br.readLine();temp!=null;temp=br.readLine()){
					if(temp.contains("Title: ")){
						for(temp=br.readLine();!temp.contains("\\\\");temp=br.readLine());
						for(temp=br.readLine();temp!=null;temp=br.readLine()){
							if(temp.contains("\\\\"))break;
							str=str+temp;
						}
					}
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("temp="+temp);
				return;
			}
			
			
			//double[] vec=queryTopicVector(str);
			//System.out.println("origin:"+f.getName());
			//List<String> result2=similarity(vec, 20);
			List<String> answer=KddGetAnswer(f.getName().split(".abs")[0]);
			if(answer.size()==0)continue;
			//System.out.println("search");
			//List<String> result=KddSearchTitleCode(str,200);
			//System.out.println("page");
			//result=pageRank(result,100);
			//KddCheck(result,answer);
			//KddCheckLda(result2,answer);
//			for(String code:answer){
//				//System.out.println(code);
//				int id=corpus.getDocPath().getId(code);
//				double[] mat=readMatrix("theta")[id];
//				double cos=cosineSimilarity(vec,mat);
//				System.out.println(cos);
//				cosWriter.write(""+cos+"\n");
//			}
			count++;
			cosWriter.close();
			int NN=5;
			if(count%NN==0){
				System.out.println(count);
				System.out.println("total P="+tp/NN*100+"%");
				System.out.println("total C="+tc/NN*100+"%");
				tp=0;
				tc=0;
				//System.out.println("and for LDA");
				//System.out.println("total P="+ldatp/count*100+"%");
				//System.out.println("total C="+ldatc/count*100+"%");
			}
			
			if(count==n){
				System.out.println(count);
				System.out.println("total P="+tp/count*100+"%");
				System.out.println("total C="+tc/count*100+"%");
				break;
			}
		}
	}
	
	
	public BufferedReader readFile(File file) throws FileNotFoundException{
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		return br;
	}
	
	public double[] queryTopicVector(String query) throws NumberFormatException, IOException, ParseException{
		QueryParser parser=new QueryParser("content",new StandardAnalyzer());
		Query q=parser.parse(parser.escape(query));
		String queryString=q.toString().replaceAll("\\((.*?)\\)", "").replaceAll("content:", "");
		String[] listString=queryString.split(" ");
		Vocabulary voc=corpus.getVocabulary();
		ArrayList<double[]> topicMatrix=new ArrayList<double[]>();
		for(int i=0;i<listString.length;i++){
			Integer id=voc.getId(listString[i]);
			if(id!=null){
				double[] v=new double[K];
				for(int k=0;k<K;k++){
					v[k]=phi[k][id];
				}
				topicMatrix.add(v);
			}
		}
		if(topicMatrix.size()==0){
			System.out.println("no result");
			return null;
		}
		double[] topicVector=new double[K];
		for(int i=0;i<K;i++){
			for(int j=0;j<topicMatrix.size();j++){
				double[] temp=topicMatrix.get(j);
				topicVector[i]+=temp[i];
			}
			topicVector[i]/=topicMatrix.size();
		}
		return topicVector;
	}
	
	public double[] normalize(double[] input){
		double[] result=new double[input.length];
		double sum=0.0;
		for(int i=0;i<input.length;i++){
			sum+=input[i];
		}
		double alpha=1/sum;
		for(int i=0;i<input.length;i++){
			result[i]=input[i]*alpha;
		}
		return result;
	}
	
	public List<String> similarity(double[] query,int num) throws NumberFormatException, IOException{
		List<String> result=new ArrayList<String>();
		
		double[] cos=new double[theta.length];
		int[] top=new int[num];
		for(int j=0;j<theta.length;j++){
			double sum=0.0;
			double molA=0.0;
			double molB=0.0;
			for(int p=0;p<K;p++){
				sum+=normalize(theta[j])[p]*normalize(query)[p];
				molA+=normalize(theta[j])[p]*normalize(theta[j])[p];
				molB+=normalize(query)[p]*normalize(query)[p];
			}
			molA=Math.sqrt(molA);
			molB=Math.sqrt(molB);
			cos[j]=sum/(molA*molB);
		}
		double max=1.0;
		for(int i=0;i<num;i++){
			for(int j=0;j<theta.length;j++){
				//System.out.println(cos[j]+" "+(FIX-cos[j]));
				if(Math.abs((FIX-cos[j]))<max){
					max=FIX-cos[j];
					top[i]=j;
					//System.out.println(max);
				}
				
			}
			//System.out.println("___");
			//System.out.println("no "+i+" and max="+max);
			cos[top[i]]=-99.0;
			max=1.0;
		}
		//corpus.readRecord("D:/ArxivData/record");
		for(int i=0;i<num;i++){
			result.add(corpus.getDocPath().getPath(top[i]));
		//	System.out.println(corpus.getDocPath().getPath(top[i]));
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException, ParseException{
		
		AnalyseFunction fun=new AnalyseFunction();
		//fun.writeMagPaperIndex();
		//fun.checkArxMag();
		//fun.writeArxPaperIndex();
		//fun.ArxSearchTitleUrl("Bitcoin Mining Decentralization via Cost Analysis", 5);
		//fun.MagSearchTitle("bitcoin economy", 5);
		//fun.writeKddLDA();
		//fun.corpus.readRecord("D:/ArxivData/record");
		//fun.readPhi();
		//fun.readTheta();
		//fun.load();
		//fun.FirstTest(null);
		///System.out.println("sss");
	List<Paper> list=fun.KddSearchTitleCode(null, 30);
		for(Paper s:list){
			System.out.println(s.title+" "+s.url);
		}
	//List<String>g  sort=fun.pageRank(list,20);
		
	}

}
