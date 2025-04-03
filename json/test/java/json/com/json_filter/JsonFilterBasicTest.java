package json.com.json_filter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class JsonFilterBasicTest {

    @Test
    public void testFilterByAge_validInput() {
        String jsonArray = """
        [
            {"name": "Alice", "age": 25},
            {"name": "Bob", "age": 30},
            {"name": "Charlie", "age": 28},
            {"name": "David", "age": 22}
        ]
        """;

        String filteredJson = JsonFilter.filterByAge(jsonArray, 25);

        assertNotNull(filteredJson, "Filtered JSON should not be null.");
        assertTrue(filteredJson.contains("Bob"), "Should contain person with age 30.");
        assertTrue(filteredJson.contains("Charlie"), "Should contain person with age 28.");
        assertFalse(filteredJson.contains("Alice"), "Should not contain person with age 25.");
        assertFalse(filteredJson.contains("David"), "Should not contain person with age 22.");
    }

    @Test
    public void testFilterByAge_emptyArray() {
        String jsonArray = "[]";

        String filteredJson = JsonFilter.filterByAge(jsonArray, 25);

        assertNotNull(filteredJson, "Filtered JSON should not be null.");
        assertEquals("[]", filteredJson.trim(), "Expected an empty JSON array.");
    }

    @Test
    public void testFilterByAge_allAgesBelowThreshold() {
        String jsonArray = """
        [
            {"name": "Eve", "age": 20},
            {"name": "Frank", "age": 22}
        ]
        """;

        String filteredJson = JsonFilter.filterByAge(jsonArray, 25);

        assertNotNull(filteredJson, "Filtered JSON should not be null.");
        assertEquals("[]", filteredJson.trim(), "Expected an empty JSON array.");
    }

    @Test
    public void testFilterByAge_allAgesAboveThreshold() {
        String jsonArray = """
        [
            {"name": "George", "age": 30},
            {"name": "Helen", "age": 35}
        ]
        """;

        String filteredJson = JsonFilter.filterByAge(jsonArray, 25);

        assertNotNull(filteredJson, "Filtered JSON should not be null.");
        assertTrue(filteredJson.contains("George"), "Should contain person with age 30.");
        assertTrue(filteredJson.contains("Helen"), "Should contain person with age 35.");
    }

    @Test
    public void testFilterByAge_nullInput() {
        String filteredJson = JsonFilter.filterByAge(null, 25);

        assertNull(filteredJson, "Null input should return null.");
    }
}

