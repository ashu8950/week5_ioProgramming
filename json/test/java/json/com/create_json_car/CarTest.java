package json.com.create_json_car;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void testCarInitialization() {
        Car car = new Car("Toyota", "Camry", 2021);
        assertEquals("Toyota", car.getBrand());
        assertEquals("Camry", car.getModel());
        assertEquals(2021, car.getYear());
    }

    @Test
    public void testCarToJson() {
        Car car = new Car("Toyota", "Camry", 2021);
        String expectedJson = "{\"brand\":\"Toyota\",\"model\":\"Camry\",\"year\":2021}";
        assertEquals(expectedJson, car.toJson());
    }
}

