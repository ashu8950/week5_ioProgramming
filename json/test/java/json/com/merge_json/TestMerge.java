package json.com.merge_json;

import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.Test;

public class TestMerge {
	@Test
	public void testMerging() {
		
		JSONObject obj1 = new JSONObject();
		JSONObject obj2 = new JSONObject();
		obj1.put("name","ashu" );
		obj1.put("age", 21);
		obj2.put("age",23);
		JSONObject merge = JSONMerger.merge(obj1, obj2);
		assertEquals(23,merge.get("age"));
		assertEquals("ashu",merge.get("name"));
	}
}
