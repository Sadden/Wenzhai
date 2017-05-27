package andrew.retrieve.structure;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
/**
 * a set of documents
 * 语料库，也就是文档集合
 *
 * @author hankcs
 */
public class Corpus
{
	DocPath docPath;
    List<int[]> documentList;
    Vocabulary vocabulary;
    

    public Corpus()
    {
    	docPath=new DocPath();
        documentList = new LinkedList<int[]>();
        vocabulary = new Vocabulary();
    }

    public int[] addDocument(List<String> document,String path)
    {
        int[] doc = new int[document.size()];
        int i = 0;
        for (String word : document)
        {
            doc[i++] = vocabulary.getId(word, true);
        }
        documentList.add(doc);
        docPath.getId(path,true);
        return doc;
    }

    public int[][] toArray()
    {
        return documentList.toArray(new int[0][]);
    }

    public int getVocabularySize()
    {
        return vocabulary.size();
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder();
        for (int[] doc : documentList)
        {
            sb.append(Arrays.toString(doc)).append("\n");
        }
        sb.append(vocabulary);
        return sb.toString();
    }

    /**
     * Load documents from disk
     *
     * @param folderPath is a folder, which contains text documents.
     * @return a corpus
     * @throws IOException
     */
    public static Corpus load(String folderPath) throws IOException
    {
        Corpus corpus = new Corpus();
        File folder = new File(folderPath);
        for (File file : folder.listFiles())
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            String line;
            List<String> wordList = new LinkedList<String>();
            while ((line = br.readLine()) != null)
            {
                String[] words = line.split(" ");
                for (String word : words)
                {
                    if (word.trim().length() < 2) continue;
                    wordList.add(word);
                }
            }
            br.close();
            corpus.addDocument(wordList,file.getPath());
        }
        if (corpus.getVocabularySize() == 0) return null;

        return corpus;
    }
    

    public Vocabulary getVocabulary()
    {
        return vocabulary;
    }

    public DocPath getDocPath(){
    	return docPath;
    }
    public int[][] getDocument()
    {
        return toArray();
    }

    /*Path变量指文档集合所在的文件夹*/
    public static int[] loadDocument(String path, Vocabulary vocabulary) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        List<Integer> wordList = new LinkedList<Integer>();
        while ((line = br.readLine()) != null)
        {
            String[] words = line.split(" ");
            for (String word : words)
            {
                if (word.trim().length() < 2) continue;
                Integer id = vocabulary.getId(word);
                if (id != null)
                    wordList.add(id);
            }
        }
        br.close();
        int[] result = new int[wordList.size()];
        int i = 0;
        for (Integer integer : wordList)
        {
            result[i++] = integer;
        }
        return result;
    }

    public void writeRecord(String folder) throws IOException{
    	BufferedWriter pathWriter=new BufferedWriter(new FileWriter(new File(folder+"/DocPath")));
    	BufferedWriter vocWriter=new BufferedWriter(new FileWriter(new File(folder+"/Vocabulary")));
    	String[] voc=vocabulary.id2wordMap;
    	for(int i=0;i<voc.length;i++){
    		vocWriter.write(voc[i]+"\n\r");
    	}
    	vocWriter.close();
    	String[] path=docPath.id2pathMap;
    	for(int j=0;j<path.length;j++){
    		pathWriter.write(path[j]+"\n\r");
    	}
    	pathWriter.close();
    	
    }

    public void readRecord(String folder) throws IOException{
    	BufferedReader pathReader=new BufferedReader(new FileReader(new File(folder+"/DocPath")));
    	BufferedReader vocReader=new BufferedReader(new FileReader(new File(folder+"/Vocabulary")));
    	String temp="";
    	for(temp=pathReader.readLine();temp!=null;temp=pathReader.readLine()){
    		docPath.getId(temp, true);
    	}
    	for(temp=vocReader.readLine();temp!=null;temp=vocReader.readLine()){
    		vocabulary.getId(temp,true);
    	}
    	pathReader.close();
    	vocReader.close();
    
    	System.out.println(docPath.size());
    	System.out.println(vocabulary.size());
    	
    }

}
