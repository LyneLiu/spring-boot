package com.lyne.metric;

import com.lyne.Application;
import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 通过PublicMetrics实现自定义的度量信息
 *
 * @author nn_liu
 * @Created 2017-06-30-18:49
 */
@Component public class CustomMetric implements PublicMetrics {

    @Override public Collection<Metric<?>> metrics() {
        List<Metric<?>> metrics = new ArrayList<Metric<?>>();
        metrics.add(
                new Metric<Long>("spring.startup-date", Application.getContext().getStartupDate()));
        metrics.add(new Metric<Integer>("spring.bean.definitions",
                Application.getContext().getBeanDefinitionCount()));
        metrics.add(new Metric<Integer>("spring.beans",
                Application.getContext().getBeanNamesForType(Object.class).length));
        return metrics;
    }

}
