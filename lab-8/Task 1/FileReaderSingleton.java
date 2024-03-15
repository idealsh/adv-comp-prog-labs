import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileReaderSingleton {
  private static FileReaderSingleton instance;
  private BufferedReader reader;

  private void openFile() {
    try {
      reader = new BufferedReader(new FileReader("data.txt"));
    } catch (FileNotFoundException e) {
      System.err.println("File data.txt not found");
    }
  }

  private FileReaderSingleton() {
    openFile();
  }

  public static FileReaderSingleton getInstance() {
    if (instance == null)
      instance = new FileReaderSingleton();

    return instance;
  }

  public String readLineFromFile() {
    try {
      if (reader == null)
        openFile();

      return reader.readLine();
    } catch (IOException e) {
      System.err.println("Failed to read line from file");
    }

    return null;
  }

  public void closeFile() {
    try {
      reader.close();
      reader = null;
    } catch (IOException e) {
      System.err.println("Failed to close file");
    }
  }
}