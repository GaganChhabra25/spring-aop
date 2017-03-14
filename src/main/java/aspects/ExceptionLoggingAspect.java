package aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionLoggingAspect {

	final static Logger logger = Logger.getLogger(LoggingAspect.class);
	private String methodName;

	@AfterThrowing(value = "SystemArchitecture.Repository() || SystemArchitecture.Services()", throwing = "exception")
	public void logException(JoinPoint joinPoint, Exception exception) {
		this.methodName = joinPoint.getSignature().getName();
		logger.info("*** Exception occurs. Logged for method = " + methodName);
		logger.info("Exception = ", exception);
		//logger.error("Fuck", exception);
	}
}
