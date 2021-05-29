package com.amo.rest;

import com.amo.database.ConnectionManager;
import com.amo.database.SampleAccessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRESTController {

    @GetMapping("/hello")
    public SampleResponse greeting(@RequestBody SampleRequest req) {
        SampleAccessor a = new SampleAccessor(ConnectionManager.getConnection());
        int generatedId = a.insert(req.name);
        return new SampleResponse("Hello " + req.name + ", you are request id: " + generatedId + ".");
    }
}
