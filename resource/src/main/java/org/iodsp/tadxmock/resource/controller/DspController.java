package org.iodsp.tadxmock.resource.controller;

import org.iodsp.tadxmock.resource.dto.DspBase;
import org.iodsp.tadxmock.resource.dto.PageList;
import org.iodsp.tadxmock.resource.dto.ReturnObject;
import org.iodsp.tadxmock.resource.exceptions.BaseExceptionEnums;
import org.iodsp.tadxmock.resource.exceptions.ServiceException;
import org.iodsp.tadxmock.resource.mapper.DspMapper;
import org.iodsp.tadxmock.resource.service.DspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/dsp")
public class DspController extends BaseController {

    @Autowired
    DspService dspService;

    @Autowired
    DspMapper dspMapper;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ReturnObject add(@RequestBody DspBase dspBase) {
        try {
            dspService.save(dspBase);
        } catch (ServiceException e) {
            throw e;
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ServiceException(BaseExceptionEnums.ADD_EXCEPTION);
        }
        ReturnObject returnObject = new ReturnObject();
        returnObject.setData(dspBase);
        return returnObject;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ReturnObject update(@RequestBody DspBase dspBase) {
        try {
            dspService.save(dspBase);
        } catch (ServiceException e) {
            throw e;
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ServiceException(BaseExceptionEnums.UPDATE_EXCEPTION);
        }
        ReturnObject returnObject = new ReturnObject();
        returnObject.setData(dspBase);
        return returnObject;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ReturnObject list(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize,
                             @RequestParam(required = false) Integer isAll) {
        ReturnObject returnObject = new ReturnObject();

        PageList pageList = this.getListPage(() -> {
            return dspMapper.find();
        }, (isAll != null && isAll == 1), page, pageSize);

        returnObject.setData(pageList);
        return returnObject;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ReturnObject info(@RequestParam(required = true) String id) {
        ReturnObject returnObject = new ReturnObject();
        DspBase dspBase;
        try {
            dspBase = dspService.info(id);
        } catch (ServiceException e) {
            throw e;
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ServiceException(BaseExceptionEnums.PARAM_EXCEPTION);
        }
        returnObject.setData(dspBase);
        return  returnObject;
    }

    @Transactional
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestParam(required = true) String ids) {
        List<String> deleteIds = Arrays.asList(ids.trim().split(","));
        if (deleteIds.isEmpty()) {
            throw new ServiceException(BaseExceptionEnums.PARAM_EXCEPTION);
        }

        ReturnObject returnObject = new ReturnObject();

        deleteIds.forEach(id -> {
            try {
                dspService.delete(id);
            } catch (Throwable e) {
                e.printStackTrace();
                throw new ServiceException(BaseExceptionEnums.NO_SUCH_EXCEPTION);
            }
        });
    }
}
