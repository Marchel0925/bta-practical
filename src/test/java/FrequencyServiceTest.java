import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FrequencyServiceTest {

    private FrequencyService frequencyService;

    @Before
    public void setUp() throws IOException {
        String textFile = "text_0";
        this.frequencyService = new FrequencyService(textFile);
        assertSetUp(textFile);
    }

    @Test
    public void givenFrequencyMapSize_whenComparedToDistinctCharSizeInFile_thenBothSizesShouldBeEqual() throws IOException {
        Integer distinctCharsSize = getDistinctSize();

        Assert.assertNotEquals(0, (long) distinctCharsSize);

        Integer frequencyMapSize = this.frequencyService.getFrequencyMap().size();

        Assert.assertEquals(distinctCharsSize, frequencyMapSize);
    }

    @Test
    public void givenFrequencyMapValueSum_whenComparedToFileFullLength_thenFrequencyMapValueSumShouldBeLower() throws IOException {
        Integer fileCharLength = getFullFileLength();

        Assert.assertNotEquals(0, (long) fileCharLength);

        long valueSum = getFrequencyValueSum();

        Assert.assertNotEquals((long) fileCharLength, valueSum);
    }

    @Test
    public void givenEachFrequencyMaps_whenComparedToOtherFrequencyMaps_thenEachValueShouldNotBeEqualToPrevious() throws IOException {
        String previousPath = frequencyService.getPathToFile();
        Map<Character, Integer> previousMap = frequencyService.getFrequencyMap();
        for (int i = 2; i <= 2; i ++) {
            String textFile = "text_" + i;
            frequencyService.updatePath(textFile);
            // Assert that path has been changed and maps don't match
            Assert.assertNotEquals(previousPath, frequencyService.getPathToFile());
            Assert.assertNotEquals(previousMap, frequencyService.getFrequencyMap());


            previousPath = frequencyService.getPathToFile();
            previousMap = frequencyService.getFrequencyMap();

        }
    }

    private void assertSetUp(String textFile) {
        Assert.assertNotNull(frequencyService.getFrequencyMap());
        Assert.assertEquals("src/main/resources/" + textFile + ".txt", frequencyService.getPathToFile());
    }

    private Integer getDistinctSize() throws IOException {
        Set<Character> distinctChars = new HashSet<>();

        Path path = Paths.get(this.frequencyService.getPathToFile());
        Scanner scanner = new Scanner(path);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            char[] lineChars = line.toCharArray();
            for (char c : lineChars) {
                if (c != ' ' && Character.isLetter(c)) {
                    distinctChars.add(c);
                }
            }
        }
        scanner.close();
        return distinctChars.size();
    }

    private Integer getFullFileLength() throws IOException {
        int length = 0;
        Path path = Paths.get(this.frequencyService.getPathToFile());
        Scanner scanner = new Scanner(path);
        while(scanner.hasNextLine()){
            length += scanner.nextLine().length();

        }
        scanner.close();
        return length;
    }

    private long getFrequencyValueSum() {
        long valueSum = 0;
        for (Map.Entry<Character, Integer> entry : this.frequencyService.getFrequencyMap().entrySet()) {
            valueSum += entry.getValue();
        }

        return valueSum;
    }
}
