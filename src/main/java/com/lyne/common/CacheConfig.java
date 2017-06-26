package com.lyne.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.web.client.RestTemplate;

/**
 * Created by nn_liu on 2017/6/23.
 */

@Configuration
@EnableCaching
public class CacheConfig {

    /*@Autowired
    private RestTemplate restTemplate = null;*/

    public static void main(String[] args) {

        // 创建一个ExpressionParser对象，用于解析表达式
        ExpressionParser parser = new SpelExpressionParser();
        // 使用直接量表达式
        Expression exp = parser.parseExpression("'###60'");
        System.out.println(exp.getValue(String.class));
        exp = parser.parseExpression("6.9");
        System.out.println(exp.getValue(Double.class));
    }

}
