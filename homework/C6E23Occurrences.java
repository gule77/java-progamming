import javax.swing.*;

public class C6E23Occurrences {
	public static int count(String str, char a){
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == a) count++;
		}
		return count;
	}
	
	public static void isString(String Str) throws Exception {
		if(Str.length()<1) {
			throw new Exception("Empty String!\n");
		}
		for (int i = 0; i < Str.length(); i++) {
			if (!Character.isLetter(Str.charAt(i))) {
				throw new Exception("Invalid String!\n"
						+ "You can only enter letters!\n");
			}
		}
	}
	
	public static void isCharacter(String Ch) throws Exception {
		if(Ch.length()<1) {
			throw new Exception("Empty character!\n");
		}
		if(!Character.isLetter(Ch.charAt(0))||Ch.length()!=1) {
			throw new Exception("Invalid character!\n"
					+ "You can only enter letters!\n");
		}
	}

	public static void main(String[] args) {
		int option = JOptionPane.YES_OPTION;
		while (option == JOptionPane.YES_OPTION) {
			try {
				String STR = JOptionPane.showInputDialog("Enter a string(only letters):");
				isString(STR);
				String str=STR;
				String A = JOptionPane.showInputDialog("Enter a character(only letters):");
				isCharacter(A);
				char a=A.charAt(0);
				int r=count(str,a);
				option = JOptionPane.showConfirmDialog(null,"The occurrences is " + r + "\nDo you want to continue?");
			}catch (Exception e) {
				String outputStr = e.getMessage()+"Do you want to continue? ";
				option = JOptionPane.showConfirmDialog(null, outputStr);
			}
		}
	}
}
