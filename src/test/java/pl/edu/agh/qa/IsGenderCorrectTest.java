package pl.edu.agh.qa;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;

public class IsGenderCorrectTest {

    @Test
    public void isGenderCorrect() {
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=23210151184");

        String gender = response.path("gender");

        Assert.assertEquals(gender, "Female");
    }
}
