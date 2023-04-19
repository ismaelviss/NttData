package com.ismaelviss.nttdata.adapter.in.web;

import com.ismaelviss.nttdata.common.WebAdapter;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@Api(tags = "Movement")
@RestController
@Validated
@RequestMapping(value = "/v1/movimientos")
public class MovementController {
}
