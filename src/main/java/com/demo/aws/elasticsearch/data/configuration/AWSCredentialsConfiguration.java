package com.demo.aws.elasticsearch.data.configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSCredentialsConfiguration {

    @Value("${aws.es.accessKey:}")
    private String esAccessKey = null;

    @Value("${aws.es.secretKey:}")
    private String esSecretKey = null;

    @Bean
    public DefaultAWSCredentialsProviderChain awsDynamoCredentialsProviderDevelopment() {
//        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(
//                esAccessKey, esSecretKey));
        return new DefaultAWSCredentialsProviderChain();
    }
}