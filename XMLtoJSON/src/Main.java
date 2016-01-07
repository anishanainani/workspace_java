import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;


public class Main {


    public static void main(String[] args) throws IOException {
//       BufferedReader bf = new BufferedReader(new FileReader("C:/Users/Anisha/Desktop/insert_book_copies.sql"));
//       String line = "";
//       Random rg = new Random();
//       HashSet<String> list = new HashSet<String>();
//       while((line = bf.readLine())!=null){
//    	   String[] in = line.split(",");
//    	   if(!list.contains(in[0])){
//    		   list.add(in[0]);
//    		   int n1 = rg.nextInt((20 - 5) + 1) + 5;
//    		   int n2 = rg.nextInt((20 - 5) + 1) + 5;
//    		   System.out.println(in[0]+","+n1+","+n2+","+(n1+n2)+");");
//    	   }
//    	   
//       }
    	
    	BufferedReader bf = new BufferedReader(new FileReader("C:/Users/Anisha/Desktop/insert_book.sql"));
        String line = "";
        Random rg = new Random();
        
        while((line = bf.readLine())!=null){
     	   String[] in = line.split(",");
     	   double n1 = rg.nextDouble()*100;
     	  String formato = String.format("%.2f",n1);
     	   System.out.println(in[0]+","+in[1].split("\\)")[0]+","+formato+");");
     	   }
     	   
        }
    
}
