package aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import services.CustomerService;

@Component
@Aspect
public class LoggingAspect {

	private String methodName;

	final static Logger logger = Logger.getLogger(LoggingAspect.class);


	// Fully qulaified name to get the pointcuts, otherwise error
	//@Before("SystemArchitecture.Services() || SystemArchitecture.Repository()")
	@Before("SystemArchitecture.ServicesPackage() || SystemArchitecture.RepositoryPackage()")
	public void entering(JoinPoint joinPoint) {
		this.methodName = joinPoint.getSignature().getName();
		logger.info("***Entering method***" + methodName);
	}

	//@After("SystemArchitecture.Services() || SystemArchitecture.Repository()")
	@After("SystemArchitecture.ServicesPackage() || SystemArchitecture.RepositoryPackage()")
	public void exiting(JoinPoint joinPoint) {
		this.methodName = joinPoint.getSignature().getName();
		logger.info("***Exiting method***" + methodName);
	}

	@Around("execution(void findCustomerByName())")
	public void aroundMessage(ProceedingJoinPoint joinPoint) {
		this.methodName = joinPoint.getSignature().getName();
		logger.info("****Entering method : " + methodName + ": Before Method Execution");
		try {
			CustomerService object = (CustomerService) joinPoint.proceed();
			logger.info("** Customer service  Name = **" + object.toString());
		} catch (Throwable ex) {
			logger.info("** Exception in  method *** = " + methodName);
		}

		logger.info("****Exiting method : " + methodName + ": After Method Execution");
	}

	@AfterReturning(value = "execution(Integer findCustomerSalary())", returning = "result")
	public void logResult(Integer result) {
		System.out.println("***Result***  = " + result);
	}

}
