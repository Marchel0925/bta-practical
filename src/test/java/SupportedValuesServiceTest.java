import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SupportedValuesServiceTest {

    private SupportedValuesService supportedValuesService;

    @Before
    public void setUp() {
        this.supportedValuesService = new SupportedValuesService();
    }

    @Test
    public void givenArrayOfSupportedValues_whenCallingIsSupported_thenReturnTrue() {
        final String[] allowedValues = {"0", "1", "2"};

        for (String val: allowedValues) {
            boolean isSupported = supportedValuesService.isSupported(val);
            Assert.assertTrue(isSupported);
        }
    }

    @Test
    public void givenArrayOfUnsupportedValues_whenCallingIsSupported_thenReturnFalse() {
        final String[] unsupportedValues = {"10", "null", null};

        for (String val: unsupportedValues) {
            boolean isSupported = supportedValuesService.isSupported(val);
            Assert.assertFalse(isSupported);
        }
    }
}
