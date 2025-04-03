package json.com.object_json;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

public class ListToJsonConverterBasicTest {
    @Test
    public void testConvertListToJson_withValidList() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Alice", 25));
        personList.add(new Person("Bob", 30));

        String actualJson = ListToJsonConverter.convertListToJson(personList);

        // Check if the JSON string is not null and contains both Alice and Bob
        assertNotNull(actualJson, "JSON conversion should not return null.");
        assertTrue(actualJson.contains("\"name\" : \"Alice\""), "Expected 'Alice' in JSON.");
        assertTrue(actualJson.contains("\"age\" : 25"), "Expected 'age' 25 for Alice.");
        assertTrue(actualJson.contains("\"name\" : \"Bob\""), "Expected 'Bob' in JSON.");
        assertTrue(actualJson.contains("\"age\" : 30"), "Expected age 30 for Bob.");
    }

    @Test
    public void testConvertListToJson_withEmptyList() {
        List<Person> personList = new ArrayList<>();

        String actualJson = ListToJsonConverter.convertListToJson(personList);

        // An empty list should produce an empty JSON array
        assertEquals("[ ]", actualJson.trim(), "Expected empty JSON array.");
    }

    @Test
    public void testConvertListToJson_withSingleElement() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Charlie", 28));

        String actualJson = ListToJsonConverter.convertListToJson(personList);

        // Ensure the JSON contains Charlie's data
        assertNotNull(actualJson, "JSON conversion should not return null.");
        assertTrue(actualJson.contains("\"name\" : \"Charlie\""), "Expected 'Charlie' in JSON.");
        assertTrue(actualJson.contains("\"age\" : 28"), "Expected 'age' 28 for Charlie.");
    }

    @Test
    public void testConvertListToJson_withNullList() {
        List<Person> personList = null;

        String actualJson = ListToJsonConverter.convertListToJson(personList);

        // Check that null input should return null or an empty array, depending on design
        assertNull(actualJson, "Converting a null list should return null.");
    }
}

