package com.example.demo.controller;

import com.example.demo.useless.*;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ContaService {

    private final Tracer tracer = GlobalOpenTelemetry.getTracer("name");

    @Autowired
    UseLess1 useLess1;

    @Autowired
    UseLess2 useLess2;

    @Autowired
    UseLess3 useLess3;

    @Autowired
    UseLess4 useLess4;

    @Autowired
    UseLess5 useLess5;

    @GetMapping
    public String teste() {
        Span span = tracer.spanBuilder("AddEntToebd").startSpan();
        span.setAttribute("ENDTOEND", UUID.randomUUID().toString());
        span.end();
        useLess1.soninho();
        useLess2.soninho();
        useLess3.soninho();
        useLess4.soninho();
        useLess5.soninho();
        return "teste";
    }

}
