package json.com.create_json_car;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car("Toyota", "Camry", 2022);
        System.out.println("Car in JSON format: " + car.toJson());
	}

}
