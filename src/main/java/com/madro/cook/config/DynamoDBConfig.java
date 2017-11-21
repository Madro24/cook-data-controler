package com.madro.cook.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;


@Configuration
@EnableDynamoDBRepositories
  (basePackages = "com.madro.cook.data.dynamodb.repositories")
public class DynamoDBConfig {
 
    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;
 
    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;
 
    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;
 
    @Bean
	public AmazonDynamoDB amazonDynamoDB(AWSCredentials amazonAWSCredentials) {
   
    	
    		AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(amazonAWSCredentials));
    		
		if (!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
			builder.setEndpointConfiguration(new EndpointConfiguration(amazonDynamoDBEndpoint, "us-west-2"));
			//amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
		}
		AmazonDynamoDB amazonDynamoDB = builder.build();
		return amazonDynamoDB;
	}

	@Bean
	public AWSCredentials amazonAWSCredentials() {
	    // Or use an AWSCredentialsProvider/AWSCredentialsProviderChain
		return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
	}
    
}