import javax.swing.*;

public class C6E18Checkpassword {

	public static void isValid(String password) throws Exception {
		boolean isPassword = isLength(password) && isLettersAndDigits(password) &&isTwoDigits(password);
		if(!isPassword) {
			throw new Exception("Invalid Password!\n");
		}
	}
	
	public static boolean isLength(String password) {
		final int validlen = 8;
		if(password.length() < validlen) {
			return false;
		}else {
			return true;
		}
	}

	public static boolean isLettersAndDigits(String password) {
		for (int i = 0; i < password.length(); i++) {
			if (!Character.isLetter(password.charAt(i))&&!Character.isDigit(password.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isTwoDigits(String password) {
		final int mindigits = 2;
		int Digits = 0;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i))) {
				Digits++;
			}
			if (Digits >= mindigits) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int option = JOptionPane.YES_OPTION;
		while (option == JOptionPane.YES_OPTION){
			try {
				String password = JOptionPane.showInputDialog("Please enter a password, rules are as follows:\n" + 
						" ¡ö A password must have at least eight characters.\n" + 
						" ¡ö A password consists of only letters and digits.\n" + 
						" ¡ö A password must contain at least two digits.");
				isValid(password);
				option = JOptionPane.showConfirmDialog(null,"Valid Password!\n" + "Do you want to continue?");
			} catch (Exception e) {
				String outputStr = e.getMessage()+"Password rules are as follows:\n" + 
						" ¡ö A password must have at least eight characters.\n" + 
						" ¡ö A password consists of only letters and digits.\n" + 
						" ¡ö A password must contain at least two digits.\n" +"Do you want to continue? ";
				option = JOptionPane.showConfirmDialog(null, outputStr); 
			}
		}
	}
}
