package json.com.create_json;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class StudentTest {

    @Test
    public void testStudentInitialization() {
        ArrayList<String> subjects = new ArrayList<>();
        subjects.add("Mathematics");
        subjects.add("Physics");

        Student student = new Student("Alice", 22, subjects);
        assertEquals("Alice", student.getName());
        assertEquals(22, student.getAge());
        assertEquals(subjects, student.getSubjects());
    }

    @Test
    public void testToJson() {
        ArrayList<String> subjects = new ArrayList<>();
        subjects.add("Mathematics");
        subjects.add("Physics");

        Student student = new Student("Alice", 22, subjects);
        String expectedJson = "{\"name\":\"Alice\",\"age\":22,\"subjects\":[\"Mathematics\",\"Physics\"]}";
        assertEquals(expectedJson, student.toJson());
    }
}

