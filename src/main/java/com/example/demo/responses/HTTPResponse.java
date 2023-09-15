package com.example.demo.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class HTTPResponse {
    protected String message;
}
