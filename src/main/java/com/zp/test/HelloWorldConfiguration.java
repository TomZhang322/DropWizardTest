package com.zp.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;

/**
 * Created by zhangpeng on 2016/11/15.
 */
public class HelloWorldConfiguration extends Configuration {

    @NotEmpty //参数检查
    @JsonProperty //自动映射配置文件
    private String template;

    @NotEmpty
    @JsonProperty
    private String defaultName;

    public String getTemplate() {
        return template;
    }

    public String getDefaultName() {
        return defaultName;
    }

    @Override
    public AppConfigurationEntry[] getAppConfigurationEntry(String name) {
        return new AppConfigurationEntry[0];
    }
}
