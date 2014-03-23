package estruturas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;	
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


public class Arquivo {
	//Path path = Paths.get("C:/Users/Walmira/finout.txt");
	
  	//Charset utf8 = StandardCharsets.UTF_8;
	
	BufferedWriter w = null ;
	BufferedReader r = null;
	// abertura do arquivo para leitura
	public void openfileread() throws FileNotFoundException{
		r = new BufferedReader(new FileReader("finfout"));
	}
	// abertura do arquivo para escrita
	public void openfilewrite() throws IOException{
		w = new BufferedWriter(new FileWriter("finfout",true));
	}
  	
  		
	public void writefile(String nome, String telefone) throws IOException{
		
	//	BufferedWriter w = null ;
		try {
			//	w = new BufferedWriter(new FileWriter("finfout",true));
			System.out.println(" vai gravar nome = " + nome);
			;
			w.write(nome);
			w.newLine();
				
			w.write(telefone);		
			w.newLine();
			
		//	w.flush();
		//	w.close();
		} catch (IOException e) {
			System.out.println("erro na escrita");
		} finally {
			if (w != null) {
				w.close();
			}
		}
	}
	public String readfile() throws FileNotFoundException{
	  	
		
	//	String line = null;
		ListaEncadeada lista = new ListaEncadeada();
	//	BufferedReader r = null;
	//	r = new BufferedReader(new FileReader("finfout"));
		try {
            	
			
			return r.readLine();
				 
//		while (line != null) {
	//			System.out.println("linha1 =" + line);
	//			lista.append(line);
	//	  		line = r.readLine();
				
		//		System.out.println("linha2 =" + line);
		//		lista.append(line);
		//		line = r.readLine();
  	//		}
  		} catch (IOException e) {
			System.out.println("erro na leitura");
		}
	//	lista.print();
		return null;
	
	}
}




