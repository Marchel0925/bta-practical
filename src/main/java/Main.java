import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        SupportedValuesService supportedValuesService = new SupportedValuesService();

        String url = "src/main/resources/text_0.txt";

        if (args.length > 0 && supportedValuesService.isSupported(args[0])) {
            if (args[0].endsWith(".txt")) {
                url = args[0];
            } else {
                url = "src/main/resources/text_" + args[0] + ".txt";
            }
        }

        FrequencyService frequencyService = new FrequencyService(Paths.get(url));
        frequencyService.outputFrequencyMap();
    }
}
