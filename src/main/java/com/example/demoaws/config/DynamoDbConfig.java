package com.example.demoaws.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
public class DynamoDbConfig {

  public static final String REGION = "ap-southeast-2";
  public static final String SERVICE_ENDPOINT = String.format("dynamodb.%s.amazonaws.com", REGION);
  public static final String ACCESS_KEY = "AKIA4MDHJLOQAIPFULQE";
  public static final String SECRET_KEY = "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";

//  @Bean
//  public AmazonDynamoDB amazonDynamoDB() {
//    AmazonDynamoDB amazonDynamoDB
//        = new AmazonDynamoDBClient(amazonAWSCredentials());
//
//    if (!SERVICE_ENDPOINT.isEmpty()) {
//      amazonDynamoDB.setEndpoint(SERVICE_ENDPOINT);
//    }
//
//    return amazonDynamoDB;
//  }
//
//  @Bean
//  public AWSCredentials amazonAWSCredentials() {
//    return new BasicAWSCredentials(
//        ACCESS_KEY, SECRET_KEY);
//  }

  @Bean
  DynamoDBMapper dynamoDBMapper() {

    return new DynamoDBMapper(buildAmazonDynamoDB());
  }

  private AmazonDynamoDB buildAmazonDynamoDB() {
    return AmazonDynamoDBClientBuilder.standard()
        .withEndpointConfiguration(
            new EndpointConfiguration(SERVICE_ENDPOINT, REGION)
        )
        .withCredentials(
            new AWSStaticCredentialsProvider(
                new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY)
            )
        )
        .build();
  }
}
