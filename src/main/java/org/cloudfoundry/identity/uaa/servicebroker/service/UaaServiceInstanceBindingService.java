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
import org.cloudfoundry.community.servicebroker.exception.ServiceInstanceBindingExistsException;
import org.cloudfoundry.community.servicebroker.model.ServiceInstance;
import org.cloudfoundry.community.servicebroker.model.ServiceInstanceBinding;
import org.cloudfoundry.community.servicebroker.service.ServiceInstanceBindingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

/**
 * UAA implementation to bind services. Binding a service does the following:
 * - Retrieves the client details for the app
 */
@Service
public class UaaServiceInstanceBindingService implements ServiceInstanceBindingService {

    @Autowired
    private OAuth2RestTemplate uaaRestTemplate;

    @Override
    public ServiceInstanceBinding createServiceInstanceBinding(String bindingId,
                                                               ServiceInstance serviceInstance,
                                                               String serviceId,
                                                               String planId,
                                                               String appGuid)
            throws ServiceInstanceBindingExistsException, ServiceBrokerException {

        // TODO: Return details for existing app client


        return null;
    }

    @Override
    public ServiceInstanceBinding getServiceInstanceBinding(String id) {
        return null;
    }

    @Override
    public ServiceInstanceBinding deleteServiceInstanceBinding(String id) throws ServiceBrokerException {
        return null;
    }
}
