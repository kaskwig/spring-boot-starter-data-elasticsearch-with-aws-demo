package io.monster.ocs.cm.customer.configuration;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSCredentialsConfiguration {

    @Bean
    public DefaultAWSCredentialsProviderChain awsDynamoCredentialsProviderDevelopment() {
        return new DefaultAWSCredentialsProviderChain();
    }
}
