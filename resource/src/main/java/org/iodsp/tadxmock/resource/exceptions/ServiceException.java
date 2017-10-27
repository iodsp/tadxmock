package org.iodsp.tadxmock.resource.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceException extends RuntimeException {
    private ExceptionEnums exceptionEnums;

    public ServiceException(ExceptionEnums exceptionEnums) {
        this.exceptionEnums = exceptionEnums;
    }
}
