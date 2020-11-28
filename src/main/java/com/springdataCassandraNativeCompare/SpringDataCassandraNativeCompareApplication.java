package com.springdataCassandraNativeCompare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@ComponentScan({"com.springdataCassandraNativeCompare*"})
@EntityScan({"com.springdataCassandraNativeCompare.*" })
@EnableCassandraRepositories("com.springdataCassandraNativeCompare.springData")
public class SpringDataCassandraNativeCompareApplication {



    public static void main(String[] args) {
        SpringApplication.run(SpringDataCassandraNativeCompareApplication.class, args);


    }






}
