package com.example.demo.useless;

import io.opentelemetry.extension.annotations.WithSpan;
import org.springframework.stereotype.Component;

@Component
public class UseLess4 {

    @WithSpan
    public void soninho() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
