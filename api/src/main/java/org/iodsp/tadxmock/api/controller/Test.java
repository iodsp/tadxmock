package org.iodsp.tadxmock.api.controller;

import org.iodsp.tadxmock.api.dto.ReturnObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    Logger logger = LoggerFactory.getLogger(Test.class);

    @Autowired
    OAuth2RestTemplate oAuth2RestTemplate;

    @RequestMapping(value = "/test")
    public ReturnObject index() {
        ReturnObject returnObject = oAuth2RestTemplate.getForObject("http://localhost:9992/dsp/list", ReturnObject.class);
        return returnObject;
    }
}
