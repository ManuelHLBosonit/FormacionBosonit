package com.block6pathvariableheaders.controller;

import com.block6pathvariableheaders.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Controller {

    Response response = new Response();
    @PostMapping("/object")
    public String object(@RequestBody String json){
        response.setBody(json);
        return json;
    }

    @GetMapping("/user/{id}")
    public String user(@PathVariable(value="id")String id){
        return "Hola!!! " + id;
    }

    @PutMapping("/post")
    public Map<String, Object> post(@RequestParam Map<String, String> requestParams) {
        Map<String, Object> map = new HashMap<>();

        for (String key : requestParams.keySet()) {
            String value = requestParams.get(key);
            map.put(key, value);
        }
        List<String> param = new ArrayList<>(map.keySet());
        response.setRequestParams(param);
        return map;
    }

    @GetMapping("/header")
    public String header(@RequestHeader(value = "h1", required = false) Optional<String> h1, @RequestHeader(value = "H2" , required = false) Optional<String> h2){
        List<String> header = new ArrayList<>();

        if (h1.isPresent()) header.add(h1.get());

        if (h2.isPresent()) header.add(h2.get());

        response.setHeaders(header);
        return ((h1.isEmpty())? " " : h1.get().toString()) + " " + ((h2.isEmpty())? " " : h2.get().toString());
    }

    @PostMapping("/all1")
    public Response all1(){
        return response;
    }

    @PostMapping("/all")
    public Response all(
                        @RequestBody(required = false) String body,
                        @RequestHeader(value = "h1", required = false) Optional<String> h1, @RequestHeader(value = "H2" , required = false) Optional<String> h2,
                        @RequestParam Map<String, String> requestParams) {


        List<String> header = new ArrayList<>();

        if (h1.isPresent()) header.add(h1.get());

        if (h2.isPresent()) header.add(h2.get());

        List<String> requestParamList = new ArrayList<>(requestParams.values());

        Response response = new Response(body, header, requestParamList);

        return response;
    }

}
