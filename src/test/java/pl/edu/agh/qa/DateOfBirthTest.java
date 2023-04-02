package pl.edu.agh.qa;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;

public class DateOfBirthTest {

    @Test
    public void isYearCorrect() {
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=23210151184");

        String dateOfBirth = response.path("dateOfBirth");

        Assert.assertEquals(dateOfBirth.substring(0, 4), "2023");
    }

    @Test
    public void isMonthCorrect() {
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=00120185490");

        String dateOfBirth = response.path("dateOfBirth");

        Assert.assertEquals(dateOfBirth.substring(5, 7), "12");
    }

    @Test
    public void isDayCorrect() {
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=00213046323");

        String dateOfBirth = response.path("dateOfBirth");

        Assert.assertEquals(dateOfBirth.substring(8, 10), "30");
    }
}