package org.iodsp.tadxmock.web.controller;

import org.iodsp.tadxmock.web.dto.DspConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/dsp_config")
public class DspConfigController extends ProxyController<DspConfig, String> {
}
