package mono;

public class Caesar {
	
	public static char shift(char c, int key) {
		return (char) ( ( ( c - 65 + key ) % 26 ) + 65 );
	}
	
	// mode 0 : encrypt; mode 1 : decrypt
	public static String caesar(String arg, int key, int mode) {
		String result="";
		for(int i=0; i<arg.length(); i++) {
			char c = arg.charAt(i);
			result += mode==0 ? shift(c, key) : shift(c, 26-key);
		}
		return result;
	}
	
	// keyword = SWORDFISH
	public static String vigenere(String arg, String keyword) {
		String result="";
			
			result += shift( arg.charAt(0), 'S'-65 ); // S
			result += shift( arg.charAt(1), 'W'-65 ); // W
			result += shift( arg.charAt(2), 'O'-65 ); // W
			// ..
			
		return result;
	}
	
	public static void main(String[] args) {
		String plain = "VENIVIDIVICI";
		
		String cipher = caesar(plain, 3, 0);
		System.out.println(cipher);
		
		System.out.println( caesar( cipher, 3, 2) );
		
		System.out.println( vigenere( plain, "SWORDFISH" ));
	}
}