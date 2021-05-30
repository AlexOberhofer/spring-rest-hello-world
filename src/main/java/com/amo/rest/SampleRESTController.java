package com.amo.rest;

import com.amo.data.PingResponse;
import com.amo.data.SampleRequest;
import com.amo.data.SampleResponse;
import com.amo.database.ConnectionManager;
import com.amo.database.SampleAccessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SampleRESTController {
    private static final String API_BASENAME = "api/";

    //curl -X POST \
    //  -H "Content-type: application/json" \
    //  -H "Accept: application/json" \
    //  -d '{"name":"Curl"}' \
    //  "http://localhost:8080/api/hello"
    @PostMapping(API_BASENAME + "/hello")
    public SampleResponse helloAPI(@RequestBody SampleRequest req) {
        SampleAccessor a = new SampleAccessor(ConnectionManager.getConnection());
        int generatedId = a.insert(req.name);
        return new SampleResponse("Hello " + req.name + ", you are request id: " + generatedId + ".");
    }

    //curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/api/ping
    @GetMapping(API_BASENAME +"/ping")
    public PingResponse pong() {
        return new PingResponse("API Responded at " + new Date(System.currentTimeMillis()).toString());
    }

}
