package json.com.filter_json;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestFilter {
	@Test
	public void testingFilerData() throws JsonProcessingException {
		List<User>user = Arrays.asList(new User("ashu",30),new User("Raman",26),new User("shivam",24));
		String jsonArray = JsonConverter.convertJson(user);
		int conditionAge = 25;
		String jsonArrayFilter = JsonFilter.filterData(jsonArray, conditionAge);
		 // Deserialize the filtered JSON to a list of User objects
	    ObjectMapper objectMapper = new ObjectMapper();
	    List<User> filteredUsers = objectMapper.readValue(jsonArrayFilter, new TypeReference<List<User>>() {});

	    // Assert the age of the first filtered user
	    assertEquals(30, filteredUsers.get(0).getAge());
	    assertEquals(26, filteredUsers.get(1).getAge());
	}
}
