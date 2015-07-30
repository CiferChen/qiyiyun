import java.util.Scanner;


public class Tool {

	/**
	 * db params to input params
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true){
			
		
		String str = sc.next();
		
		char []chararray = str.toCharArray();
		
		for (int i = 0; i < chararray.length; i++) {
			if(chararray[i]=='_'){
				chararray[i+1] = (char)(chararray[i+1] - 32);
			}
		}
		
		str = new String(chararray);
		
		System.out.println(str.replaceAll("_", ""));
		}
	}

}
