package org.iodsp.tadxmock.web.config;

import org.iodsp.tadxmock.web.dto.Exception;
import org.iodsp.tadxmock.web.dto.ReturnObject;
import org.iodsp.tadxmock.web.exceptions.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public ReturnObject jsonErrorHandler(HttpServletRequest req, ServiceException exception) {
        ReturnObject returnObject = new ReturnObject();
        returnObject.setCode(exception.getExceptionEnums().getCode());
        returnObject.setMessage(exception.getExceptionEnums().getMessage());
        Exception exceptionData = new Exception();
        exceptionData.setUrl(req.getRequestURL().toString());
        returnObject.setData(exceptionData);
        return returnObject;
    }
}
