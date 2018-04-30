package com.gett.automation.server.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author eladaz (eladaz@gett.com)
 * Created on 29/04/2018.
 */
@EnableWebMvc
@Configuration
@ComponentScan({"com.gett.automation.server.ctrl"})
public class Config {
}
