package com.nttdata.stepsdefinitions;

import com.nttdata.page.StorePage;
import com.nttdata.steps.LoginSteps;
import com.nttdata.steps.StoreSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class MyStoreStepdefs {

    StoreSteps storeSteps;

    private WebDriver driver;
    private StoreSteps myStoreSteps(WebDriver driver){
        return new StoreSteps(driver);
    }

    @Given("estoy en la pagina de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/");
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String contrasena) {
        storeSteps = new StoreSteps(driver);
        storeSteps.loginpage();
        storeSteps.typeUser(usuario);
        storeSteps.typePassword(contrasena);
        storeSteps.login();
        Assertions.assertEquals("Joshua Pazos", storeSteps.getName());
        screenShot();
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        storeSteps.goToMen(categoria, subcategoria);
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        storeSteps.agregarProductos(cantidad);
        screenShot();
    }

    @Then("valido en el popup la confirmacion del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        Assertions.assertEquals("\uE876Producto añadido correctamente a su carrito de compra", storeSteps.validarProductoAgregado());
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        Assertions.assertEquals("S/ 38.24", storeSteps.validarPrecio());
        screenShot();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        storeSteps.finalizarCompra();
        screenShot();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        Assertions.assertEquals("Carrito", storeSteps.validarTitulo());
        screenShot();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        Assertions.assertEquals("S/ 38.24", storeSteps.validarPrecioFinal());
        screenShot();
    }


}
