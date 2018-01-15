package com.taf_automation.core.configurations;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
@ComponentScan(basePackages = "com.taf_automation.core.repositories")
public class AppConfiguration {

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }

    @Bean
    public MongoDbFactory mongoDbFactory() {
        return new SimpleMongoDbFactory(mongoClient(), "test-selenium");
    }

    @Bean
    public MongoClient mongoClient() {
        return new MongoClient(new MongoClientURI("mongodb://rajesh:rajesh1234@ec2-18-218-111-99.us-east-2.compute.amazonaws.com:27017/test-selenium"));
    }

}
