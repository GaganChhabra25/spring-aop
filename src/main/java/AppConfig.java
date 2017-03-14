import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"aspects", "services"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}
