package org.iodsp.tadxmock.resource.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasicAuth {

    @JsonProperty("dsp_id")
    private String dspId;

    private String token;
}
