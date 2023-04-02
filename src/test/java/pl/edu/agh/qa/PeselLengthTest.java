package pl.edu.agh.qa;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;

public class PeselLengthTest {

    @Test
    public void peselLenghtCorrect () {
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=23210151184");

        String pesel = response.path("pesel");

        Assert.assertEquals(pesel.length(), 11);
    }
}
