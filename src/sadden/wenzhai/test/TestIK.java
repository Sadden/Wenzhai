package sadden.wenzhai.test;

import java.io.IOException;
import java.io.StringReader;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class TestIK {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
        String text="fuckyou man 我是你妹的 assh飞艇";  
        StringReader sr=new StringReader(text);  
        IKSegmenter ik=new IKSegmenter(sr, true);  
        Lexeme lex=null;  
        while((lex=ik.next())!=null){  
            System.out.print(lex.getLexemeText()+"|");  
        }
	}

}
