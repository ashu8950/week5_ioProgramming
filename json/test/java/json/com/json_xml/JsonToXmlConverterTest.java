package json.com.json_xml;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.JSONObject;
import org.json.XML;
import org.junit.jupiter.api.Test;

public class JsonToXmlConverterTest {

    @Test
    public void testJsonToXmlConversion() {
        String jsonString = """
        {
            "name": "Alice",
            "age": 30,
            "city": "New York"
        }
        """;

        JSONObject jsonObject = new JSONObject(jsonString);
        String actualXml = XML.toString(jsonObject, "root");

        assertTrue(actualXml.contains("<root>"));
        assertTrue(actualXml.contains("<name>Alice</name>"));
        assertTrue(actualXml.contains("<age>30</age>"));
        assertTrue(actualXml.contains("<city>New York</city>"));
        assertTrue(actualXml.contains("</root>"));
    }
}
