package SeleniumDemo.tests;

import SeleniumDemo.pages.HomePage;
import SeleniumDemo.pages.OrderDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import SeleniumDemo.models.Customer;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {
        Customer customer = new Customer();
        customer.setEmail("specificemail@gmail.com");

        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .fillAddressDetails(customer,"Some random comment");

        Assert.assertEquals(orderDetailsPage.getOrderNotice().getText(),"Thank you. Your order has been received.");
        Assert.assertEquals(orderDetailsPage.getProductName().getText(),"Java Selenium WebDriver × 1");
    }

}
