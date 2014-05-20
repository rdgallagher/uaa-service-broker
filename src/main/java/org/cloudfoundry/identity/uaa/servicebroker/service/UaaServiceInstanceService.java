/*******************************************************************************
 *     Cloud Foundry 
 *     Copyright (c) [2009-2014] Pivotal Software, Inc. All Rights Reserved.
 *
 *     This product is licensed to you under the Apache License, Version 2.0 (the "License").
 *     You may not use this product except in compliance with the License.
 *
 *     This product includes a number of subcomponents with
 *     separate copyright notices and license terms. Your use of these
 *     subcomponents is subject to the terms and conditions of the
 *     subcomponent's license, as noted in the LICENSE file.
 *******************************************************************************/
package org.cloudfoundry.identity.uaa.servicebroker.service;

import org.cloudfoundry.community.servicebroker.exception.ServiceBrokerException;
import org.cloudfoundry.community.servicebroker.exception.ServiceInstanceExistsException;
import org.cloudfoundry.community.servicebroker.model.ServiceDefinition;
import org.cloudfoundry.community.servicebroker.model.ServiceInstance;
import org.cloudfoundry.community.servicebroker.service.ServiceInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UAA implementation to provision services. Provisioning a service does the following:
 * - Provisions a client for the app in the UAA with a pre-setup redirect URI
 */
@Service
public class UaaServiceInstanceService implements ServiceInstanceService {

    @Autowired
    private OAuth2RestTemplate uaaRestTemplate;

    @Override
    public List<ServiceInstance> getAllServiceInstances() {
        return null;
    }

    @Override
    public ServiceInstance createServiceInstance(ServiceDefinition service, String serviceInstanceId, String planId,
                                                 String organizationGuid, String spaceGuid) throws ServiceInstanceExistsException, ServiceBrokerException {

        // TODO: Return new ServiceInstanceExistsException if service instance exists

        BaseClientDetails clientDetails = new BaseClientDetails(serviceInstanceId, "", "", "authorization_code,refresh_token", "", "");
        clientDetails.setClientSecret(serviceInstanceId + "secret");

        clientDetails = uaaRestTemplate.postForObject("http://localhost:8081/uaa/oauth/clients", clientDetails, BaseClientDetails.class);

        // TODO: Store ServiceInstance in repository

        return new ServiceInstance(serviceInstanceId, service.getId(), planId, organizationGuid, spaceGuid, "");
    }

    @Override
    public ServiceInstance getServiceInstance(String id) {
        return null;
    }

    @Override
    public ServiceInstance deleteServiceInstance(String id) throws ServiceBrokerException {
        return null;
    }
}
