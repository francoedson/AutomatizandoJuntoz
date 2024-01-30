package com.nttdata.stepsdefinitions;

import com.nttdata.page.DeliveryFreePage;
import com.nttdata.page.ShoppingCartPage;
import com.nttdata.steps.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JuntozStepdefs {
    private WebDriver driver;
    private Scenario scenario;


    @Before(order = 0)
    public void setUp(){
        //setUp
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

    @Given("El usuario abre el navegador e ingresa a la página de Juntoz")
    public void elUsuarioAbreElNavegadorEIngresaALaPáginaDeJuntoz() {
        driver.get("https://www.juntoz.com/");
        screenShot();
    }

    @When("doy click en iniciar sesion para navegar al login")
    public void doyClickEnIniciarSesionParaNavegarAlLogin() {
        MainSteps mainSteps= new MainSteps(driver);
        mainSteps.goPageLogin();
        screenShot();
    }
    @And("El usuario inicia sesión con las credenciales usuario: {string} y contraseña: {string}")
    public void elUsuarioIniciaSesiónConLasCredencialesUsuarioYContraseña(String user, String pass) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.typeUser(user);
        loginSteps.typePassword(pass);
        loginSteps.login();
        screenShot();
    }

    @Then("El usuario debe ser autenticado exitosamente encontrando su {string} en algún elemeto de la página")
    public void elUsuarioDebeSerAutenticadoExitosamenteEncontrandoSuEnAlgúnElemetoDeLaPágina(String expectName) {
        MenuSteps menuSteps=new MenuSteps(driver);
        String name =  menuSteps.getMyName();
        //prueba: validamos el nombre de la cuenta
        Assertions.assertEquals(expectName, name);
        screenShot();
    }

    @When("El usuario haya inciaido sesión navega a la categoría de Envio Gratis")
    public void elUsuarioHayaInciaidoSesiónNavegaALaCategoríaDeEnvioGratis() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        MenuSteps menuSteps=new MenuSteps(driver);
        menuSteps.goDeliveryFree();
        screenShot();
    }

    @And("Debo haber más de una tarjeta de productos en la página")
    public void deboHaberMásDeUnaTarjetaDeProductosEnLaPágina() {
        DeliveryFreeSteps deliveryFreeSteps=new DeliveryFreeSteps(driver);
        int itemsListSize = deliveryFreeSteps.getItemSize();
        //prueba: validar que al menos exista un item
        screenShot();
        Assertions.assertTrue(itemsListSize > 0, "El tamaño de la lista es: " + itemsListSize);

    }

    @And("Agregar un producto al carrito")
    public void agregarUnProductoAlCarrito() {
        DeliveryFreeSteps deliveryFreeSteps=new DeliveryFreeSteps(driver);
        deliveryFreeSteps.addShoppingCart();
        screenShot();
    }

    @Then("El usuario se dirige al carrito de compras")
    public void elUsuarioSeDirigeAlCarritoDeCompras() {
        DeliveryFreeSteps deliveryFreeSteps=new DeliveryFreeSteps(driver);
        deliveryFreeSteps.goShoppingCart();
        screenShot();
    }

    @And("Verifica que haya más de un elemeto en la página")
    public void verificaQueHayaMásDeUnElemetoEnLaPágina() {
        ShoppingCartSteps shoppingCartSteps=new ShoppingCartSteps(driver);
        int itemsListSize = shoppingCartSteps.getProductsSize();
        //prueba: validar que al menos exista un producto
        screenShot();
        Assertions.assertTrue(itemsListSize > 0, "El tamaño de la lista es: " + itemsListSize);
    }
    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

}
