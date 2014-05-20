package org.cloudfoundry.identity.uaa.servicebroker.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import java.util.Arrays;
import javax.annotation.Resource;

@Configuration
@EnableAutoConfiguration
@EnableOAuth2Client
@ComponentScan(basePackages = { "org.cloudfoundry.community.servicebroker", "org.cloudfoundry.identity.uaa.servicebroker" })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Resource
    @Qualifier("accessTokenRequest")
    private AccessTokenRequest accessTokenRequest;

    @Bean
//    @Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
    public OAuth2RestTemplate uaaRestTemplate() {
        return new OAuth2RestTemplate(uaa(), new DefaultOAuth2ClientContext(accessTokenRequest));
    }

    @Bean
    public ClientCredentialsResourceDetails uaa() {
        ClientCredentialsResourceDetails uaa = new ClientCredentialsResourceDetails();
        uaa.setId("uaa");
        uaa.setClientId("admin");
        uaa.setClientSecret("adminsecret");
        uaa.setAccessTokenUri("http://localhost:8080/uaa/oauth/token");
        uaa.setScope(Arrays.asList("clients.read", "clients.write"));
        return uaa;
    }
}