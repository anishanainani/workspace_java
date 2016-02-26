import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("C:/dictionary"));
		String word = "";
		
		RwayTrie rt = new RwayTrie(256);
		int i = 0;
		while((word = bf.readLine())!=null){
			rt.insert(word, i);
			++i;
		}
		bf.close();
		
		System.out.println(rt.search("ANISHA"));
		System.out.println(rt.search("ABECEDARIAN"));
		
		rt.delete("ABERRANTLY");
		
		System.out.println(rt.search("ABECEDARIAN"));
		
//		Iterable<String> words = rt.words();
//		for(String w : words){
//			System.out.println(w);
//		}
		
		Iterable<String> prefixes = rt.keysWithPrefix("ANISHA");
		for(String w : prefixes){
			System.out.println(w);
		}
		
		System.out.println(rt.longestPrefix("ABERRATIONS"));
	}

}
