package pl.edu.agh.qa;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;

public class IsPeselValidTest {

    @Test
    public void isPeselValid(){
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=00321208484");

        boolean isValid = response.path("isValid");

        Assert.assertEquals(isValid, true);
    }

    @Test
    public void isPeselNotValid(){
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=000000000");

        boolean isValid = response.path("isValid");

        Assert.assertEquals(isValid, false);
    }
}
