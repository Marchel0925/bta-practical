import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Service for creating
public class FrequencyService {
    private String pathToFile;

    private Map<Character, Integer> frequencyMap;

    public FrequencyService(String textFileName) throws IOException {
        this.pathToFile = "src/main/resources/" + textFileName + ".txt";
        getTextFrequency();
    }


    private void getTextFrequency() throws IOException {
        this.frequencyMap = new HashMap<>();

        Path path = Paths.get(pathToFile);
        Scanner scanner = new Scanner(path);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            char[] lineChars = line.toCharArray();
            for (char c : lineChars) {
                // Since the task specifies that we find the frequency of letter that are in the english alphabet
                // there are no blank spaces and punctuation symbols.
                if (c != ' ' && Character.isLetter(c)){
                    if (frequencyMap.containsKey(c)) {
                        int value = frequencyMap.get(c);
                        frequencyMap.put(c, value + 1);
                    } else {
                        frequencyMap.put(c, 1);
                    }
                }
            }
        }
        scanner.close();
    }

    public void outputFrequencyMap() {
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("\"" + entry.getKey() + "\" : " + entry.getValue());
        }
    }

    public void updatePath(String textFile) throws IOException {
        this.pathToFile = "src/main/resources/" + textFile + ".txt";
        getTextFrequency();
    }

    public String getPathToFile() {
        return pathToFile;
    }


    public Map<Character, Integer> getFrequencyMap() {
        return frequencyMap;
    }
}
