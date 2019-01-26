package br.com.peixeurbano.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * Peixe Urbano Simple Store. <br>
 * The main class that contains the entry-point of the web application.<br>
 * This launches an embedded web server.
 * 
 * @author ryanpadilha <ryan.padilha@peixeurbano.com>
 * @version 0.1
 *
 */
@SpringBootApplication
public class SimpleStoreApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleStoreApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Starting Simple Store Application");
		SpringApplication.run(SimpleStoreApplication.class, args);
	}

	@Bean
	public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory, MongoMappingContext context) {
		MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), context);
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));

		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, converter);
		return mongoTemplate;
	}

}
