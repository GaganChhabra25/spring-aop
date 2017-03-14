import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import services.CustomerService;

@ContextConfiguration(classes = AppConfig.class)
public class TestAOP extends AbstractTestNGSpringContextTests {

	@Autowired
	private CustomerService customerService;

	@Test(description = "Test @Before advice")
	public void testAspectBeforeAdvice() {
		customerService.findCustomer();
	}

	@Test(description = "Test @After advice")
	public void testAfterAdvice() {
		customerService.findCustomerById();
	}

	@Test(description = "Test @AfterThrowing advice")
	public void testAfterThrowing() throws Exception {
		customerService.findCustomerByAddress();
	}

	@Test(description = "Test @AfterReturning advice")
	public void testAfterReturniing() {
		customerService.findCustomerSalary();
	}

	@Test(description = "test @Around advice")
	public void testAroundAdvice() throws Throwable {
		customerService.findCustomerByName();
	}

	@Test(description = "Test retry Advice For single retry")
	public void testRetry() throws Throwable {
		customerService.customerRetry();
	}
}
