package org.iodsp.tadxmock.api.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReturnObject {

    private Integer code = 0;

    // http code
    private Integer status = 200;

    private Object data;

    private String message = "";
}
