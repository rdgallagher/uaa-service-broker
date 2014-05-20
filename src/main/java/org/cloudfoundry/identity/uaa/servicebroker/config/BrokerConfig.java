package org.cloudfoundry.identity.uaa.servicebroker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/** 
 * Force the base spring boot packages to be searched for dependencies.
 * 
 * @author sgreenberg
 *
 */

@Configuration
@ComponentScan(basePackages = "org.cloudfoundry.identity.uaa.servicebroker")
public class BrokerConfig {

}
