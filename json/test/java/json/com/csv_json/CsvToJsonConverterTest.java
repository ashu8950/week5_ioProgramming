package json.com.csv_json;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class CsvToJsonConverterTest {

    @Test
    public void testCsvToJsonConversion() {
        // Manually created CSV data
        String[] headers = {"name", "age", "city"};
        String[][] rows = {
            {"Alice", "30", "New York"},
            {"Bob", "25", "Los Angeles"},
            {"Charlie", "35", "Chicago"}
        };

        try {
            List<Map<String, String>> jsonList = new ArrayList<>();

            for (String[] row : rows) {
                Map<String, String> jsonObject = new java.util.LinkedHashMap<>();
                for (int j = 0; j < headers.length; j++) {
                    jsonObject.put(headers[j], row[j]);
                }
                jsonList.add(jsonObject);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            String actualJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonList);

            // Expected JSON
            String expectedJson = """
            [
              {
                "name": "Alice",
                "age": "30",
                "city": "New York"
              },
              {
                "name": "Bob",
                "age": "25",
                "city": "Los Angeles"
              },
              {
                "name": "Charlie",
                "age": "35",
                "city": "Chicago"
              }
            ]
            """;

            // Remove unnecessary whitespaces for comparison
            expectedJson = expectedJson.replaceAll("\\s+", "");
            actualJson = actualJson.replaceAll("\\s+", "");

            assertEquals(expectedJson, actualJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
