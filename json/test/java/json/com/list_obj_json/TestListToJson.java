package json.com.list_obj_json;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestListToJson {
	@Test
	public void testingJsonData() {
		List<Car>car = Arrays.asList(
				new Car("Tesla","Model",2),
				new Car("BMW","T5",3),
				new Car("Fortuner","fortune",5))
				;
		String jsonArray = ListToJson.convertToJson(car);
		String expectation ="[{\"brand\":\"Tesla\",\"model\":\"Model\",\"year\":2},{\"brand\":\"BMW\",\"model\":\"T5\",\"year\":3},{\"brand\":\"Fortuner\",\"model\":\"fortune\",\"year\":5}]";
		assertEquals(expectation,jsonArray);
	}
}
