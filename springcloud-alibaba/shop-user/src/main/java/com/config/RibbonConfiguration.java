package com.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.client.config.IClientConfigKey;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @program: springcloud-alibaba
 * @Date: 2020-06-14 8:58
 * @Author: code1990
 * @Description:
 */
@Component
public class RibbonConfiguration implements IClientConfig {

    @Bean
    public IRule ribbonRule(IClientConfig config) {
        // 随机算法
        return new RandomRule();
    }

    @Override
    public boolean containsProperty(IClientConfigKey arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <T> T get(IClientConfigKey<T> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T get(IClientConfigKey<T> arg0, T arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getClientName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getNameSpace() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, Object> getProperties() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getProperty(IClientConfigKey arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getProperty(IClientConfigKey arg0, Object arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean getPropertyAsBoolean(IClientConfigKey arg0, boolean arg1) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getPropertyAsInteger(IClientConfigKey arg0, int arg1) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getPropertyAsString(IClientConfigKey arg0, String arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void loadDefaultValues() {
        // TODO Auto-generated method stub

    }

    @Override
    public void loadProperties(String arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public String resolveDeploymentContextbasedVipAddresses() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> IClientConfig set(IClientConfigKey<T> arg0, T arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setProperty(IClientConfigKey arg0, Object arg1) {
        // TODO Auto-generated method stub

    }
}
