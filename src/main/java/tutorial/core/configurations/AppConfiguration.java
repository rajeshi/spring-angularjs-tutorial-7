package tutorial.core.configurations;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
@ComponentScan(basePackages = "tutorial.core.repositories")
public class AppConfiguration {

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }

    @Bean
    public MongoDbFactory mongoDbFactory() {
        return new SimpleMongoDbFactory(mongoClient(), "taf-db");
    }

    @Bean
    public MongoClient mongoClient() {
        return new MongoClient(Arrays.asList(new ServerAddress("ds237855.mlab.com", 37855)),
                 Arrays.asList(MongoCredential.createScramSha1Credential("rajesh23427", "taff-db", "Test123".toCharArray())));
    }

}
