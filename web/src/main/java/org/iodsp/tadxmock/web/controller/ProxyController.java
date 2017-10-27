package org.iodsp.tadxmock.web.controller;

import org.iodsp.tadxmock.web.dto.ReturnObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

public class ProxyController<T, G> extends BaseController {
    Logger logger = LoggerFactory.getLogger(ProxyController.class);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ReturnObject list(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize,
                             @RequestParam(required = false) Integer isAll) {
        Map<String, Integer> params = new HashMap<>();
        params.put("page", page);
        params.put("pageSize", pageSize);
        params.put("isAll", isAll);
        ReturnObject returnObject = getOAuth2RestTemplate().getForObject(getResourceConfig().getResetResourceUrl()
                        + getControllerUrl() + "/list?page={page}&pageSize={pageSize}&isAll={isAll}",
                ReturnObject.class, params);
        return returnObject;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ReturnObject add(@RequestBody T data) {
        return post(data, getControllerUrl() + "/add");
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ReturnObject update(@RequestBody T data) {
        return post(data, getControllerUrl() + "/update");
    }

    protected String getControllerUrl() {
        RequestMapping requestMapping = this.getClass().getAnnotation(RequestMapping.class);
        String url = "";
        if (requestMapping != null && requestMapping.value().length != 0) {
            url += requestMapping.value()[0];
        }
        return url;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestParam(required = true) String ids) {
        Map<String, String> params = new HashMap<>();
        params.put("ids", ids);
        getOAuth2RestTemplate().delete(getResourceConfig().getResetResourceUrl() +
            getControllerUrl() + "/delete?ids={ids}", params);
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ReturnObject info(@RequestParam(required = true) G id) {
        Map<String, G> params = new HashMap<>();
        params.put("id", id);
        ReturnObject returnObject = getOAuth2RestTemplate().getForObject(getResourceConfig().getResetResourceUrl() +
            getControllerUrl() + "/info?id={id}", ReturnObject.class, params);
        return  returnObject;
    }
}
