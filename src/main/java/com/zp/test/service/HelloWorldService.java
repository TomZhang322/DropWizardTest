package com.zp.test.service;

import com.zp.test.HelloWorldConfiguration;
import com.zp.test.healthcheck.TemplateHealthCheck;
import com.zp.test.resources.HelloWorldResource;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by Administrator on 2016/11/15.
 */
public class HelloWorldService extends Service<HelloWorldConfiguration> {

    //服务入口
    public static void main(String[] args) throws Exception {
        new HelloWorldService().run(args);
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        //指定配置文件的名字
        bootstrap.setName("helloWorld");
    }

    @Override
    public void run(HelloWorldConfiguration helloWorldConfiguration, Environment environment) throws Exception {
        final String template = helloWorldConfiguration.getTemplate();
        final String defaultName = helloWorldConfiguration.getDefaultName();
        environment.addResource(new HelloWorldResource(template,defaultName));
        environment.addHealthCheck(new TemplateHealthCheck(template));
    }
}
