//
// Copyright 2016 Amazon.com, Inc. or its affiliates (Amazon). All Rights Reserved.
//
// Code generated by AWS Mobile Hub. Amazon gives unlimited permission to 
// copy, distribute and modify it.
//
// Source code generated from template: aws-my-sample-app-android v0.10
//
package com.acalendar.acal.amazonaws.mobile.api;

/**
 * Client used to invoke Cloud Logic REST APIs.
 */
public interface CloudLogicAPI {
    /**
     * Invoke an Amazon API Gateway REST API.
     * @param request request
     * @return response
     */
    com.amazonaws.mobileconnectors.apigateway.ApiResponse execute(com.amazonaws.mobileconnectors.apigateway.ApiRequest request);

    /**
     * Provides the underlying custom SDK client, which must be downcast
     * in order to be used. Use this client to invoke APIs using specific
     * well-defined models. 
     * @return client which must be downcast to your own custom client class
     *         in the com.amazonaws.mobilehub.api.id... package.
     */
    Object getAPIClient();
}
