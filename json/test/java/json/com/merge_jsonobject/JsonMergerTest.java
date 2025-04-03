package json.com.merge_jsonobject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.junit.jupiter.api.Test;

public class JsonMergerTest {

    @Test
    public void testMergeJsonFiles() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode json1 = objectMapper.readTree(new File(
            "C:\\Users\\DELL\\Desktop\\IOProgramming\\json\\src\\main\\java\\json\\com\\merge_jsonobject\\file1.json"));
        JsonNode json2 = objectMapper.readTree(new File(
            "C:\\Users\\DELL\\Desktop\\IOProgramming\\json\\src\\main\\java\\json\\com\\merge_jsonobject\\file2.json"));
        JsonNode mergeJson = objectMapper.readTree(new File(
            "C:\\Users\\DELL\\Desktop\\IOProgramming\\json\\src\\main\\java\\json\\com\\merge_jsonobject\\merge.json"));

        // Merging JSON objects
        ObjectNode merged = JsonMerger.mergeJson(json1, json2);
        merged.setAll((ObjectNode) mergeJson);

        // Saving the merged result to a temporary file
        String mergedFilePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\json\\src\\main\\java\\json\\com\\merge_jsonobject\\test_merged.json";
        objectMapper.writeValue(new File(mergedFilePath), merged);

        // Verifying the merged content
        File mergedFile = new File(mergedFilePath);
        assertTrue(mergedFile.exists(), "Merged file should exist");

        // Reading the merged file for validation
        JsonNode actualMerged = objectMapper.readTree(mergedFile);

        // Validate that the merged object contains expected keys and values
        assertEquals("Alice", actualMerged.get("name").asText());
        assertEquals(28, actualMerged.get("age").asInt());
        assertEquals("New York", actualMerged.get("city").asText());

        // Clean up the temporary merged file after the test
        Files.deleteIfExists(Paths.get(mergedFilePath));

        System.out.println("Test Passed: Merged JSON content is correct.");
    }
}
