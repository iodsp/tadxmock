package org.iodsp.tadxmock.resource.controller;

import org.iodsp.tadxmock.resource.dto.DspBase;
import org.iodsp.tadxmock.resource.dto.DspConfig;
import org.iodsp.tadxmock.resource.dto.PageList;
import org.iodsp.tadxmock.resource.dto.ReturnObject;
import org.iodsp.tadxmock.resource.exceptions.BaseExceptionEnums;
import org.iodsp.tadxmock.resource.exceptions.ServiceException;
import org.iodsp.tadxmock.resource.mapper.DspMapper;
import org.iodsp.tadxmock.resource.service.DspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dsp_config")
public class DspConfigController extends BaseController {

    @Autowired
    DspService dspService;

    @Autowired
    DspMapper dspMapper;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ReturnObject update(@RequestBody DspConfig dspConfig) {
        try {
            dspService.saveConfig(dspConfig);
        } catch (ServiceException e) {
            throw e;
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ServiceException(BaseExceptionEnums.UPDATE_EXCEPTION);
        }
        ReturnObject returnObject = new ReturnObject();
        returnObject.setData(dspConfig);
        return returnObject;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ReturnObject info(@RequestParam(required = true) String id) {
        ReturnObject returnObject = new ReturnObject();
        DspConfig dspConfig;
        try {
            dspConfig = dspService.infoConfig(id);
        } catch (ServiceException e) {
            throw e;
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ServiceException(BaseExceptionEnums.PARAM_EXCEPTION);
        }
        returnObject.setData(dspConfig);
        return  returnObject;
    }
}
