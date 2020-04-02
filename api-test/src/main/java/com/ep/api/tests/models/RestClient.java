package com.ep.api.tests.models;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;

import org.springframework.http.*;
import org.springframework.web.client.*;


public class RestClient {
  private final static Logger log = org.slf4j.LoggerFactory.getLogger(RestClient.class);


  private String url;
  private RestTemplate rest;
  private HttpStatus status;
  private int statusCode;
  private static String COOKIE = "";
  private String responseBody;

  public RestClient(RestTemplate rest, String url) {
    this.rest = rest;
    this.url = url;
  }


  public RestTemplate template() {
    return rest;
  }

  public JSONObject postObject(String uri, String json) {

    JSONObject jsonBody = null;
    log.info("input post body: "+json);
    HttpEntity<String> requestEntity;
     if(json==null) {
       requestEntity = new HttpEntity<>(createHeaders());
     }else{
       requestEntity = new HttpEntity<>(json, createHeaders());
     }
    ResponseEntity<String> responseEntity;
     try {
      responseEntity = rest.exchange(uri, HttpMethod.POST, requestEntity, String.class);
      setStatusCode(responseEntity.getStatusCodeValue());
         setStatus(responseEntity.getStatusCode());

         if (responseEntity.getBody() != null) {
             jsonBody = new JSONObject(responseEntity.getBody());
             log.info("response json body :"+jsonBody);
         }
     } catch (final HttpClientErrorException e) {
      setStatus(e.getStatusCode());
      setStatusCode(e.getStatusCode().value());
      setResponseBody(e.getResponseBodyAsString());
      log.info(e.getResponseBodyAsString());
      try{
        jsonBody =new  JSONObject(e.getResponseBodyAsString());
      }catch(JSONException jex){
        log.info("no json body response");
      }
    } catch (final UnknownHttpStatusCodeException e) {
      setStatusCode(e.getRawStatusCode());
      log.info(e.getResponseBodyAsString());
      setResponseBody(e.getResponseBodyAsString());
      return null;
  }
    return jsonBody;
  }




  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
    this.statusCode = status.value();
  }


  private HttpHeaders createHeaders() {
    final HttpHeaders headers = new HttpHeaders();
    if (COOKIE != null) {
      headers.set(HttpHeaders.COOKIE, COOKIE);
    }
    headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
    headers.add("Content-Type", "application/json");
    headers.add("Accept", "application/json");
    return headers;
  }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    protected RestTemplate getRest() {
    return rest;
  }

  public static String getCOOKIE() {
    return COOKIE;
  }

  public static void setCOOKIE(String COOKIE) {
    RestClient.COOKIE = COOKIE;
  }

  public int getStatusCode() {
    return statusCode;
  }

  private void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getResponseBody() {
    return responseBody;
  }

  private void setResponseBody(String responseBody) {
    this.responseBody = responseBody;
  }
}
