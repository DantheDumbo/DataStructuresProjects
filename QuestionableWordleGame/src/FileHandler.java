import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileHandler {
    private Scanner scan = null;


    public void openFile() throws FileNotFoundException, Exception {
        File f = new File("5-LetterWords.txt");
        scan = new Scanner(f);
    }
    public void run() {
        try {
            openFile(); // opens file for reading
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found. Exiting.");
            System.exit(1);
        } catch (Exception e) {
            System.out.println("Unknown Error. Exiting.");
            System.exit(2);
        }
    }


    public String getRandomWord() {
        run();
        String line = scan.nextLine();
        int randomNumber = (int)((Math.random()*5757)+1);
        for (int i=0; i < randomNumber; i++) {
            line = scan.nextLine();
        }
        return "niger";
    }


    public boolean checkIfWordInBank(String userWord) {
        run();
        String line = scan.nextLine();
        for (int i=0; i<5756; i++) {
            line = scan.nextLine();
            if (line.equals(userWord)) {
                return true;
            }
        }
        return false;
    }


}
