package json.com.valid_json;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class JSONValidatorTest {

    @Test
    public void testValidJsonFormat() {
        String validJson = "{\"name\":\"Alice\",\"age\":25,\"city\":\"New York\"}";
        assertTrue(JSONValidator.isValidJson(validJson), "Expected valid JSON format.");
    }

    @Test
    public void testInvalidJsonFormat() {
        String invalidJson = "{\"name\":\"Alice\",\"age\":\"twenty-five\",\"city\":New York}";
        assertFalse(JSONValidator.isValidJson(invalidJson), "Expected invalid JSON format.");
    }

    @Test
    public void testValidJsonStructure() {
        String validJson = "{\"name\":\"Alice\",\"age\":25,\"city\":\"New York\"}";
        assertFalse(JSONValidator.isValidStructure(validJson, Person.class), "Expected valid JSON structure.");
    }

    @Test
    public void testInvalidJsonStructure() {
        String invalidJson = "{\"name\":\"Alice\",\"age\":\"twenty-five\",\"city\":\"New York\"}";
        assertFalse(JSONValidator.isValidStructure(invalidJson, Person.class), "Expected invalid JSON structure.");
    }

    @Test
    public void testMissingFieldJson() {
        String missingFieldJson = "{\"name\":\"Alice\",\"age\":25}";
        assertFalse(JSONValidator.isValidStructure(missingFieldJson, Person.class), "Expected valid structure despite missing field.");
    }

    @Test
    public void testExtraFieldJson() {
        String extraFieldJson = "{\"name\":\"Alice\",\"age\":25,\"city\":\"New York\",\"country\":\"USA\"}";
        assertFalse(JSONValidator.isValidStructure(extraFieldJson, Person.class), "Expected valid structure despite extra field.");
    }

    @Test
    public void testEmptyJson() {
        String emptyJson = "{}";
        assertTrue(JSONValidator.isValidJson(emptyJson), "Expected valid empty JSON.");
        assertFalse(JSONValidator.isValidStructure(emptyJson, Person.class), "Expected invalid structure for empty JSON.");
    }

    @Test
    public void testNullJson() {
        String nullJson = null;
        assertFalse(JSONValidator.isValidJson(nullJson), "Expected invalid JSON when null.");
        assertFalse(JSONValidator.isValidStructure(nullJson, Person.class), "Expected invalid structure when null.");
    }
}
