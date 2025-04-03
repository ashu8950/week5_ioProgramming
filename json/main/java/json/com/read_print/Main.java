package json.com.read_print;

import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "C:\\Users\\DELL\\Desktop\\IOProgramming\\json\\src\\main\\java\\json\\com\\read_print\\file.json";
		try {
			
			Map<String,Object>map = JsonProcessor.getJsonData(filePath);
			for(Map.Entry<String, Object>hm:map.entrySet()) {
				System.out.println("Key: "+hm.getKey()+" "+"Value"+hm.getValue());
			}
			
		}catch(Exception e) {
			e.getMessage();
		}
	}

}
