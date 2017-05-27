package andrew.retrieve.function;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;






public class HarvestFunction {
	
	
	
	

	String fURL="https://export.arxiv.org/oai2?verb=Identify";
	String nURL="https://export.arxiv.org/oai2?verb=ListRecords&resumptionToken=";
	
	 String resumptionToken;
	
	String addr="collection";
	
	List<String> FileList;
	
	public  boolean init(){
		File dir=new File(addr);
		if(!dir.exists()){
			dir.mkdir();
		}
		return true;
	}
	
	public boolean fresh(int num){
		File dir=new File(addr+"/"+num);
		if(!dir.exists()){
			dir.mkdir();
		}
		return true;
	}
	
	public boolean crawlURL(String url) throws MalformedURLException{
		URL add=new URL(url);
		return true;
	}
	
	public boolean writeFile(){
		return true;
	}
	
	public static void main(String[] args) {
		
		
		
		
		// TODO Auto-generated method stub

		HarvestFunction hf=new HarvestFunction();
		hf.init();
		String url=hf.fURL;
		URL u;
		try {
			u = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("url failed");
			return;
		}
		HttpURLConnection uConnection = null;
		try {
			System.out.println("Opening connection···");
			uConnection = (HttpURLConnection)u.openConnection();
			System.out.println("connection opened successfully!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("connection failed!");
			return;
		}
		try {
			System.out.println("start reading···");
			InputStream in=uConnection.getInputStream();
			InputStreamReader isr=new InputStreamReader(in);
			BufferedReader br=new BufferedReader(isr);
			for(int i=0;i<10;i++){
				
				System.out.println(br.readLine());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
