package org.itstep.lukas.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Order(2)
public class SecurityInit extends AbstractSecurityWebApplicationInitializer {

}
