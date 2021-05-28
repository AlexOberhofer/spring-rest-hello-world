package com.amo.restserviceexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRESTController {
    private static final int id = -1;

    @GetMapping("/hello")
    public SampleResponse greeting(@RequestBody SampleRequest req) {
        return new SampleResponse(id, "Hello from Spring REST API " + req.name);
    }
}
