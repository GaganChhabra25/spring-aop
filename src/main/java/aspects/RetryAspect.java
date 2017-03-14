package aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RetryAspect {

	final static Logger logger = Logger.getLogger(RetryAspect.class);
	private String methodName;
	private Integer count = 0;

	@Around("SystemArchitecture.Services()")
	public Object retry(ProceedingJoinPoint joinPoint) throws Throwable {
		count++;
		this.methodName = joinPoint.getSignature().getName();
		logger.info("**** Entring retry method = " + methodName + " = " + count);
		try {
			logger.info("***** First call to method**********");
			return joinPoint.proceed();
		} catch (Throwable exception) {
			logger.info("***** Second call to method**********");
			return joinPoint.proceed();
		} finally {
			logger.info("**** Exiting retry method = " + methodName + " = " + count);
		}
	}

}
