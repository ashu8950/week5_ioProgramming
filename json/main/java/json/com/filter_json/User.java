package json.com.filter_json;

public class User {
	private String name;
	private int age;
	User(){
		
	}
	User(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
}
