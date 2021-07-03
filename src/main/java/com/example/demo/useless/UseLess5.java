package com.example.demo.useless;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import org.springframework.stereotype.Component;

@Component
public class UseLess5 {

    private final Tracer tracer = GlobalOpenTelemetry.getTracer("name");

    public void soninho() {

        Span span = tracer.spanBuilder("SpanName").startSpan();
        try (Scope scope = span.makeCurrent()) {
           //Seu código
            // { }
        } catch (Throwable t) {
            span.setStatus(StatusCode.ERROR, "Change it to your error message");
        } finally {
            span.end(); // closing the scope does not end the span, this has to be done manually
        }
    }

}
