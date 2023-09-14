package com.block6pathvariableheaders.model;

import java.util.ArrayList;
import java.util.List;

public class Response {
    private String body;

    private List<String> headers;

    private List<String> requestParams;

    public Response(String body, List<String> headers, List<String> requestParams) {
        this.body = body;
        this.headers = headers;
        this.requestParams = requestParams;
    }

    public Response() {
        this.body = "";
        this.headers = new ArrayList<>();
        this.requestParams = new ArrayList<>();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public List<String> getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(List<String> requestParams) {
        this.requestParams = requestParams;
    }

    @Override
    public String toString() {
        return "Response{" +
                "body='" + body + '\'' +
                ", headers=" + headers +
                ", requestParams=" + requestParams +
                '}';
    }
}
