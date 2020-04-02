package com.ep.api.tests;

import java.nio.charset.Charset;

import com.ep.api.tests.intefaces.Helpers;
import com.ep.api.tests.models.RestClient;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootConfiguration()
@ComponentScan(basePackages = "com.ep.api.tests")
@EnableConfigurationProperties


public abstract class BaseTest implements Helpers {



  public static RestClient epRestClient;

  @Value("${url}")
  public String url;
  @Value("${user}")
  public String user;
  @Value("${password}")
  protected String password;


  private final static Logger log = org.slf4j.LoggerFactory.getLogger(BaseTest.class);

  @Rule
  public TestName name = new TestName();

  @Before
  public void setUp() {
    RestTemplate epRestTemplate = new RestTemplate();
    epRestClient = new RestClient(epRestTemplate, url);
    epRestTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
    epRestTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(user, password));

  }

  @After
  public void cleanUp() {

  }

  @Override
  public void verifyStatusCode(long expectedStatus){
      Assert.assertEquals(expectedStatus, epRestClient.getStatusCode());
  }

  @Override
  public void logout(){
        RestTemplate epRestTemplate = new RestTemplate();
        epRestClient = new RestClient(epRestTemplate, url);
        epRestTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        epRestTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(null, null));
    }

    @Override
    public void login(){
        RestTemplate epRestTemplate = new RestTemplate();
        epRestClient = new RestClient(epRestTemplate, url);
        epRestTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        epRestTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(user, password));
    }
}
