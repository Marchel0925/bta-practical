import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Default value for text file
        // We are going to later transform this value to "text_" value
        String fileIndex = "0";
        SupportedValuesService supportedValuesService = new SupportedValuesService();

        if (args.length > 0 && supportedValuesService.isSupported(args[0])) {
            fileIndex = args[0];
        }

        FrequencyService frequencyService = new FrequencyService("text_" + fileIndex );
        frequencyService.outputFrequencyMap();

        frequencyService.updatePath("text_" + 1);
        frequencyService.outputFrequencyMap();
    }
}
