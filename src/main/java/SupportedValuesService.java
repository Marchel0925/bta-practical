// Separate service class to check if provided text file value is a supported
// It is good practice to keep the main method as clean as possible
public class SupportedValuesService {
    private final String[] allowedValues = {"0", "1", "2"};

    public boolean isSupported(String value) {
        if (value == null) {
            return  false;
        }
        if (value.endsWith(".txt")) {
            return true;
        } else if (value.length() == 1) {
            for (String s : allowedValues) {
                if (s.equals(value)) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

}
