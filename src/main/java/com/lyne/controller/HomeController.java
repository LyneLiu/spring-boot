package com.lyne.controller;


import com.google.common.base.Function;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimaps;
import com.lyne.bo.PrdBean;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by nn_liu on 2017/5/17.
 */

@RestController
public class HomeController {

    @RequestMapping("/home")
    public String index(ModelMap map){
        map.addAttribute("name","luffy");
        map.addAttribute("desc","sea world");
        return "json";
    }

    @Test
    public void testMethod() {
        /* 日期处理 */
        /*Calendar calendar = Calendar.getInstance();
        Date currDate = calendar.getTime();
        calendar.add(Calendar.MONDAY,3);
        Date futureDate = calendar.getTime();
        System.out.println(currDate);
        System.out.println(futureDate);

        Schedule schedule = new Schedule();
        schedule.setDepartureDate(new Date(1495036800000l).toString());
        System.out.println(schedule.getDepartureDate());
        System.out.println(new Date(1495036800000l));*/

        /* guava map处理 */
        List<PrdBean> prdBeans = new ArrayList<>();
        PrdBean prdBean01 = new PrdBean();
        prdBean01.setAddr("shanghai");
        prdBean01.setName("lyne");
        PrdBean prdBean02 = new PrdBean();
        prdBean02.setAddr("shanghai");
        prdBean02.setName("luffy");
        prdBeans.add(prdBean01);
        prdBeans.add(prdBean02);

        ImmutableMultimap<String, PrdBean> opsMap = Multimaps.index(prdBeans,indexPrdBean());

        //ImmutableMap<String, PrdBean> opsMapUnique = Maps.uniqueIndex(prdBeans,indexPrdBean());

        System.out.println("=======================================");
        for (Map.Entry<String,PrdBean> entry: opsMap.entries()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        /*System.out.println("=======================================");
        for (Map.Entry<String, PrdBean> entry: opsMapUnique.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }*/
        
        System.out.println(opsMap.get("shanghai").asList().size());
        System.out.println(opsMap.get("test").isEmpty());


        //System.out.println("T");

        /* BigDecimal处理 */
        /*BigDecimal big1 = new BigDecimal(400.000);
        BigDecimal big2 = new BigDecimal(400.000);
        System.out.println(big1 == big2);
        System.out.println(big1.compareTo(big2));*/
    }

    private Function<? super PrdBean,String> indexPrdBean() {
        return new Function<PrdBean, String>() {
            @Override
            public String apply(PrdBean prdBean) {
                return prdBean.getAddr();
            }
        };
    }

}
