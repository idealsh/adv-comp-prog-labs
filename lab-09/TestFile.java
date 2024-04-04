import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

class TestFile {

  public HashMap<String, int[]> read_scores(String filename) throws FileNotFoundException, IOException {
    String filePath = "all_student_scores/" + filename;
    BufferedReader reader = new BufferedReader(new FileReader(filePath));

    HashMap<String, int[]> scores = new HashMap<>();

    String line = reader.readLine();
    line = reader.readLine(); // discard the first line
    while (line != null) {
      String[] values = line.split(",");
      int[] scoreArray = new int[5];

      for (int i = 1; i <= scoreArray.length; i++) {
        scoreArray[i - 1] = Integer.valueOf(values[i]);
      }
      scores.put(values[0], scoreArray);
      line = reader.readLine();
    }

    reader.close();

    return scores;
  }

  public int getTotalScore(HashMap<String, int[]> scores, String studentID) {
    int totalScore = 0;
    for (int score : scores.get(studentID)) {
      totalScore += score;
    }

    return totalScore;
  }

  public HashSet<String> getEditedStudentID(String filename) throws IOException {
    String filePath = "all_student_scores/" + filename;
    BufferedReader reader = new BufferedReader(new FileReader(filePath));

    HashSet<String> edited = new HashSet<>();

    String line = reader.readLine();
    line = reader.readLine(); // discard the first line
    while (line != null) {
      String[] values = line.split(",");

      edited.add(values[0]);
      line = reader.readLine();
    }

    reader.close();

    return edited;
  }

  public void createNewEditedScore(String scoresFilename, String editedFilename, String newFilename)
      throws IOException {
    HashMap<String, int[]> scores = read_scores(scoresFilename);

    String editedPath = "all_student_scores/" + editedFilename;
    BufferedReader reader = new BufferedReader(new FileReader(editedPath));

    String line = reader.readLine();
    line = reader.readLine(); // discard the first line
    while (line != null) {
      String[] values = line.split(",");

      String idToModify = values[0];
      int indexToChange = Integer.valueOf(values[1]) - 1;
      int newValue = Integer.valueOf(values[2]);

      int[] newScoreArray = scores.get(idToModify);
      newScoreArray[indexToChange] = Integer.valueOf(newValue);

      line = reader.readLine();
    }

    reader.close();

    String newFilePath = "all_student_scores/" + newFilename;
    BufferedWriter writer = new BufferedWriter(new FileWriter(newFilePath));

    writer.write("ID,Quiz1,Quiz2,Quiz3,Quiz4,Quiz5" + "\n");
    for (String id : scores.keySet()) {
      int[] scoresArray = scores.get(id);
      writer.write(id);

      for (int i = 0; i < scoresArray.length; i++) {
        writer.write("," + scoresArray[i]);
      }

      writer.write("\n");
    }
    writer.close();
  }
}