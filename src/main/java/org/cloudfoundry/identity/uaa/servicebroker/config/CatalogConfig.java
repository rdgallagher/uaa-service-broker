package org.cloudfoundry.identity.uaa.servicebroker.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cloudfoundry.community.servicebroker.model.Catalog;
import org.cloudfoundry.community.servicebroker.model.Plan;
import org.cloudfoundry.community.servicebroker.model.ServiceDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatalogConfig {
	
	@Bean
	public Catalog catalog() {		
		return new Catalog( Arrays.asList(
				new ServiceDefinition(
					"uaa",
					"UAA",
					"User Account and Authentication Service",
					true, 
					Arrays.asList(
							new Plan("uaa-plan",
									"Default UAA Plan",
									"This is a default UAA plan.  All services are created equally.",
									getPlanMetadata())),
					Arrays.asList("uaa"),
					getServiceDefinitionMetadata(),
					null)));
	}
	
/* Used by Pivotal CF console */	
	
	private Map<String,Object> getServiceDefinitionMetadata() {
		Map<String,Object> sdMetadata = new HashMap<String,Object>();
		sdMetadata.put("displayName", "UAA");
		sdMetadata.put("imageUrl","http://cdn.ebaumsworld.com/picture/digiti/guard-cat.jpg");
		sdMetadata.put("longDescription","User Account and Authentication Service");
		sdMetadata.put("providerDisplayName","Pivotal");
		sdMetadata.put("documentationUrl","https://github.com/cloudfoundry/uaa");
		sdMetadata.put("supportUrl","https://github.com/cloudfoundry/uaa");
		return sdMetadata;
	}
	
	private Map<String,Object> getPlanMetadata() {		
		Map<String,Object> planMetadata = new HashMap<String,Object>();
		planMetadata.put("costs", getCosts());
		planMetadata.put("bullets", getBullets());
		return planMetadata;
	}
	
	private List<Map<String,Object>> getCosts() {
		Map<String,Object> costsMap = new HashMap<String,Object>();
		
		Map<String,Object> amount = new HashMap<String,Object>();
		amount.put("usd", new Double(0.0));
	
		costsMap.put("amount", amount);
		costsMap.put("unit", "MONTHLY");
		
		return Arrays.asList(costsMap);
	}
	
	private List<String> getBullets() {
		return Arrays.asList("Shared UAA Service");
	}
	
}