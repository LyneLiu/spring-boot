package com.lyne.common;

import com.lyne.metric.CustomMetric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.actuate.metrics.export.MetricExportProperties;
import org.springframework.boot.actuate.metrics.repository.redis.RedisMetricRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * Common配置中心
 *
 * @author nn_liu
 * @Created 2017-06-30-18:59
 */
@Configuration
public class CommonConfig {


    @Autowired
    private MetricExportProperties export;

    /**
     * public metric
     * @return
     */
    @Bean
    public PublicMetrics appMetrics() {
        return new CustomMetric();
    }

    @Bean
    @ExportMetricWriter
    public RedisMetricRepository redisMetricWriter(RedisConnectionFactory connectionFactory) {
        return new RedisMetricRepository(connectionFactory,
                this.export.getRedis().getPrefix(), this.export.getRedis().getKey());
    }
}
