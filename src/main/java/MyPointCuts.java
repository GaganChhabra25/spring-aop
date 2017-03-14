import org.aspectj.lang.annotation.Pointcut;

public class MyPointCuts {

	@Pointcut("execution(* *(..))")
	public void pointCutForAllMethods() {
		// Empty pointcut
	}
}
