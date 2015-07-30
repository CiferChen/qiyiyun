import java.util.Scanner;


public class Tool2 {

	/**
	 * input params to test params
	 * @param args
	 */
	public static void main(String[] args) {
		
		while(true){
			Scanner sc = new Scanner(System.in);
			String str1 = sc.nextLine();
			String []strs = str1.split(",");
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < strs.length; i++) {
				sb.append(",");
				sb.append("\"");
				sb.append(strs[i]);
				sb.append("\":\"\"");
			}
			
			System.out.println(sb.toString());
		}
		
	}

}
