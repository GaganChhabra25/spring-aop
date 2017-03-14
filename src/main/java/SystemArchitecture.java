import org.aspectj.lang.annotation.Pointcut;

public class SystemArchitecture {

	/*================== ANNOTATION LEVEL =======================*/

	@Pointcut("execution(* (@org.springframework.stereotype.Repository *).*(..))")
	public void Repository() {
	}

	@Pointcut("execution(* (@org.springframework.stereotype.Service *).*(..))")
	public void Services() {
	}

/*	================== PACKAGE LEVEL ==========================*/

	@Pointcut("execution(* repository..*Repository.*(..))")
	public void RepositoryPackage() {
	}

	@Pointcut("execution(* services..*Service.*(..))")
	public void ServicesPackage() {
	}
}
