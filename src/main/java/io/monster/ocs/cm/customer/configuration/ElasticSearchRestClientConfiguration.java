package io.monster.ocs.cm.customer.configuration;

import com.amazonaws.auth.AWS4Signer;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequestInterceptor;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


@Configuration
@EnableElasticsearchRepositories(basePackages = "io.monster.ocs.cm.customer.repository")
public class ElasticSearchRestClientConfiguration extends AbstractElasticsearchConfiguration {

    @Value("${aws.es.endpoint}")
    private String endpoint;

    @Value("${aws.es.region}")
    private String region;

    @Autowired
    private AWSCredentialsProvider credentialsProvider = null;

    @Bean
    public RestHighLevelClient elasticsearchClient() {
        AWS4Signer signer = new AWS4Signer();
        String serviceName = "es";
        signer.setServiceName(serviceName);
        signer.setRegionName(region);
        HttpRequestInterceptor interceptor = new AWSRequestSigningApacheInterceptor(serviceName, signer, credentialsProvider);
        return new RestHighLevelClient(RestClient
                .builder(HttpHost.create(endpoint))
                .setHttpClientConfigCallback(e -> e.addInterceptorLast(interceptor)));
    }
}