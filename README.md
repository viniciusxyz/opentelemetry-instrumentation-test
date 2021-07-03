## Opentelemetry Demo

**Flag Java Agent**

-javaagent:c:/opentelemetry-javaagent-all.jar

**Environments**

```bash
OTEL_TRACES_EXPORTER=zipkin
OTEL_METRICS_EXPORTER=none
OTEL_EXPORTER_ZIPKIN_ENDPOINT=http://localhost:9411/api/v2/spans
OTEL_RESOURCE_ATTRIBUTES=service.name=banking1
```

#### WithSpan

Pode ser utilizado para adicionar novos spans na instrumentação automática 

```java
@WithSpan
public void soninho() {
    try {
        Thread.sleep(10);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
```

- Depende de:

```xml
<dependency>
    <groupId>io.opentelemetry</groupId>
    <artifactId>opentelemetry-extension-annotations</artifactId>
</dependency>
```


#### Manual Instrumentation

Pode ser utilizado para adicionar novos spans na instrumentação automática

```java
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
```

- Depende de:

```xml
<dependency>
    <groupId>io.opentelemetry</groupId>
    <artifactId>opentelemetry-api</artifactId>
</dependency>
```