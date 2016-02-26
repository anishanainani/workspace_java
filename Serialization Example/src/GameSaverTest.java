import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class GameSaverTest {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		GameCharacter one = new GameCharacter(50, "Elf " , new String[]{"bow", "sword", "dust" }) ;
		GameCharacter two = new GameCharacter (200, "Troll " , new String[]{"bare hands" , "big ax"}) ;
		GameCharacter three =new GameCharacter(120, "Magician", new String[]{"spells" ,"invisibility"}) ;
		
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("mygame.ser"));
		os.writeObject(one);
		os.writeObject(two);
		os.writeObject(three);
		os.close();
		
		one = null;
		two = null;
		three = null;
		
		ObjectInputStream is = new ObjectInputStream(new FileInputStream("mygame.ser"));
		GameCharacter oneRestore = (GameCharacter)is.readObject();
		GameCharacter twoRestore = (GameCharacter)is.readObject();
		GameCharacter threeRestore = (GameCharacter)is.readObject();
		is.close();
		
		System.out.println("One's type : "+ oneRestore.getType());
		System.out.println("Two's type : "+ twoRestore.getType());
		System.out.println("Three's type : "+ threeRestore.getType());
	}

}
