package com.lyne.common;

import com.lyne.metric.CustomMetric;
import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Common配置中心
 *
 * @author nn_liu
 * @Created 2017-06-30-18:59
 */
@Configuration
public class CommonConfig {

    @Bean
    public PublicMetrics appMetrics() {
        return new CustomMetric();
    }

}
