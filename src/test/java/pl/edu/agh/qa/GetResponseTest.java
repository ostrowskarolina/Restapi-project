package pl.edu.agh.qa;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;

public class GetResponseTest {

    @Test
    public void testGetRequest_ResponseStatusCodeOk() {
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=12312312312");

        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void testGetRequest_ResponseStatusCodeNotOk() {
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=");

        Assert.assertEquals(response.statusCode(), 400);

    }
}
