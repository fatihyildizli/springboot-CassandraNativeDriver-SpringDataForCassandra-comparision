package com.springdataCassandraNativeCompare.cassandraNative.config;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import com.datastax.oss.driver.api.core.config.DefaultDriverOption;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
import com.datastax.oss.driver.internal.core.util.concurrent.BlockingOperation;
import com.datastax.oss.driver.internal.core.util.concurrent.CompletableFutures;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;
import java.time.Duration;
import java.util.concurrent.CompletionStage;

/**
 * @author Fatih Yıldızlı
 */
@Configuration
@ConfigurationProperties
public class CassandraConfig {


    private static final String CASSANDRA_BOOTSTRAP_SERVER_IP = "127.0.0.1";
    private static final Integer CASSANDRA_BOOTSTRAP_SERVER_PORT = 9042;
    private static final String CASSANDRA_LOCALDATACENTER = "datacenter1";

    private static CqlSessionBuilder cqlSessionBuilder() {

        CqlSessionBuilder builder = CqlSession.builder();

        builder.addContactPoint(new InetSocketAddress(CASSANDRA_BOOTSTRAP_SERVER_IP,
                CASSANDRA_BOOTSTRAP_SERVER_PORT));
        builder.withLocalDatacenter(CASSANDRA_LOCALDATACENTER);

        DriverConfigLoader loader = DriverConfigLoader.programmaticBuilder()
                .withDuration(DefaultDriverOption.REQUEST_TIMEOUT, Duration.ofSeconds(60))
                .build();
        builder.withConfigLoader(loader);

        return builder;
    }

    private static CompletionStage<CqlSession> cqlSessionCompletionStage = cqlSessionBuilder().buildAsync();

    public static CqlSession getCqlSession() {
        BlockingOperation.checkNotDriverThread();
        return CompletableFutures.getUninterruptibly(cqlSessionCompletionStage);
    }
}
