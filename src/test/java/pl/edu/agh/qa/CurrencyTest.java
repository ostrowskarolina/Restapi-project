package pl.edu.agh.qa;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;

public class CurrencyTest {

    @Test
    public void testGetRequest_ResponseStatusCodeOk() {
        Response response = get("https://api.nbp.pl/api/exchangerates/rates/A/EUR");

        Assert.assertEquals(response.statusCode(), 200);
    }
}
