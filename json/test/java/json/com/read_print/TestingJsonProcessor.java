package json.com.read_print;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

public class TestingJsonProcessor {
	@Test
	public  void testJsonProcessor() throws Exception {
		String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\json\\src\\main\\java\\json\\com\\read_print\\file.json";
		Map<String,Object>hm = JsonProcessor.getJsonData(filePath);
		for(Map.Entry<String, Object>e:hm.entrySet()) {
			assertEquals("users",e.getKey());
		}
	}
}
