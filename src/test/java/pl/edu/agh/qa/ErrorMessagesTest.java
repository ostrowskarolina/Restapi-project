package pl.edu.agh.qa;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import static io.restassured.RestAssured.get;

public class ErrorMessagesTest {

    @Test
    public void noErrors() {
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=23210151184");

        List errors = response.path("errors");

        Assert.assertEquals(errors.isEmpty(), true);
    }

    @Test
    public void errorCodeINVL() {
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=102130463");

        String errorCode = response.path("errors[0].errorCode");

        Assert.assertEquals(errorCode, "INVL");
    }

    @Test
    public void errorCodeNBRQ() {
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=00213046zxc");

        String errorCode = response.path("errors[0].errorCode");

        Assert.assertEquals(errorCode, "NBRQ");
    }

    @Test
    public void errorCodeINVY() {
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=97331881620");

        String errorCode = response.path("errors[0].errorCode");

        Assert.assertEquals(errorCode, "INVY");
    }

    @Test
    public void errorCodeINVC() {
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=00220185490");

        String errorCode = response.path("errors[0].errorCode");

        Assert.assertEquals(errorCode, "INVC");
    }

    @Test
    public void errorCodeINVD() {
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=01993052563");

        String errorCode = response.path("errors[3].errorCode");

        Assert.assertEquals(errorCode, "INVD");
    }

    @Test
    public void errorCodeINVM() {
        Response response = get("https://peselvalidatorapitest.azurewebsites.net/api/Pesel?pesel=01993052563");

        String errorCode = response.path("errors[2].errorCode");

        Assert.assertEquals(errorCode, "INVM");
    }
}
