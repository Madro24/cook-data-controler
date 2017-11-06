package com.madro.cook.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
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
   
		AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(amazonAWSCredentials)).withRegion("us-west-2").build();
		if (!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
			amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
		}
		return amazonDynamoDB;
	}

	@Bean
	public AWSCredentials amazonAWSCredentials() {
	    // Or use an AWSCredentialsProvider/AWSCredentialsProviderChain
		return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
	}
    
}