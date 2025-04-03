package json.com.read_return;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class JsonReaderTest {

    @Test
    public void testReadAndExtractFields() {
        // Path to the JSON file (make sure the file is available at this location)
        String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\json\\src\\main\\java\\json\\com\\read_return\\user.json";

        // Expected values
        String expectedName = "John Doe";
        String expectedEmail = "john.doe@example.com";

        // Reading JSON and checking if the name and email are extracted correctly
        User user = JsonReader.readAndExtractField(filePath);
        
        assertNotNull(user);  // Ensure the user object is not null
        assertEquals(expectedName, user.getName());
        assertEquals(expectedEmail, user.getEmail());
    }
}

