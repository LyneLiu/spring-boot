package com.lyne.bo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * Created by nn_liu on 2017/5/18.
 */

@Component
public class SubPrdBean implements Serializable {

    @NotNull
    private String school;


}
