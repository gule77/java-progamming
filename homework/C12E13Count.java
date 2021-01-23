import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class C12E13Count {
	public static void main(String[] args) throws IOException{
		int option = JOptionPane.YES_OPTION;
		while (option == JOptionPane.YES_OPTION){
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT FILE", "txt");
			chooser.setFileFilter(filter);
			try{
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File selectedFile = chooser.getSelectedFile();
					Scanner fileScanner = new Scanner(selectedFile);
					int lines = 0;
					int words = 0;
					int characters = 0;
					while (fileScanner.hasNextLine()) {
						String line = fileScanner.nextLine();
						Scanner lineScanner = new Scanner(line);
						while(lineScanner.hasNext()) {
							String word = lineScanner.next();
							characters += word.length();
							words++;
						}
						lines++;
						lineScanner.close();
					}
					option = JOptionPane.showConfirmDialog(null,"File " + chooser.getSelectedFile().getName() + " has\n"
							+ characters + " characters\n"
							+ words + " words\n"
							+ lines + " lines\n"
							+ "\nDo you want to continue?");
					fileScanner.close();
				}else {
					option = JOptionPane.showConfirmDialog(null,"No file selected!" + "\nDo you want to continue?");
				}
			}catch (FileNotFoundException e) {
				option = JOptionPane.showConfirmDialog(null,"File not found!" + "\nDo you want to continue?");
			}
		}
	}
}
