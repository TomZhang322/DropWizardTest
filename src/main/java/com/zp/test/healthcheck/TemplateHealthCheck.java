package com.zp.test.healthcheck;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by Administrator on 2016/11/15.
 */
public class TemplateHealthCheck extends HealthCheck {
    private final String template;

    protected TemplateHealthCheck(String template) {
//        super("template");
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template,"TEST");
        if(!saying.contains("TEST")){
            return Result.unhealthy("template doesn't include a name!");
        }
        return Result.healthy();
    }
}
