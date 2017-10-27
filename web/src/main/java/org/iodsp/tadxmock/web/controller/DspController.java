package org.iodsp.tadxmock.web.controller;

import org.iodsp.tadxmock.web.dto.DspBase;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/dsp")
public class DspController extends ProxyController<DspBase, String> {
}
