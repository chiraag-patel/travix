package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.config.ApiKeyConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiKeyConfigTest {

    @Autowired
    ApiKeyConfig apiKeyConfig;

    @Test
    public void testConfig(){
        Assert.assertEquals("Error property key different to actual","p5Yvp3MKF5Xg2v9a", apiKeyConfig.getCrazyAirApi());
        Assert.assertEquals("Error property key different to actual","VyC5ew2yZTdukFra", apiKeyConfig.getToughJetApi());
    }

}
