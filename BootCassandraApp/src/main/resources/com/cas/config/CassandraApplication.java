/**
 * Author: Shivam_Chandel
 * Comments: Start of our application
 */
package com.cas.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@ComponentScan({ "com.cas.controller, com.cas.service" })
@EnableCassandraRepositories("com.cas.repository")
@Import(CassandraConfiguration.class)

public class CassandraApplication {

	public static void main(String[] args) {
		SpringApplication.run(CassandraApplication.class, args);

	}

}
