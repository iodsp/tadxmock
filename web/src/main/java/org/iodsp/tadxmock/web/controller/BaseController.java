package org.iodsp.tadxmock.web.controller;

import lombok.Getter;
import lombok.Setter;
import org.iodsp.tadxmock.web.config.ResourceConfig;
import org.iodsp.tadxmock.web.dto.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Component
public abstract class BaseController {
    @Autowired
    private ResourceConfig resourceConfig;

    @Autowired
    private OAuth2RestTemplate oAuth2RestTemplate;

    protected <T> ReturnObject post(T data, String url) {
        ReturnObject returnObject = getOAuth2RestTemplate().postForObject(getResourceConfig().getResetResourceUrl() + url,
                    data, ReturnObject.class);
        return returnObject;
    }
}
