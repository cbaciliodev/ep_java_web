package pe.mil.ejercito.ms.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "pe.mil.ejercito.ms.services.impl" })
public class AppConfig {

}
