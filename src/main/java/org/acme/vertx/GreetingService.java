package org.acme.vertx;

import io.quarkus.vertx.ConsumeEvent;
import io.vertx.core.VertxOptions;
import io.vertx.reactivex.core.Vertx;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.opentracing.Traced;

@Traced
@ApplicationScoped
public class GreetingService {
    @ConsumeEvent("greeting")
    public String greeting(String name) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("In TestService, Thread id, "+Thread.currentThread().getId()+" , Name :"+Thread.currentThread().getName());
        return "Hello " + name;
    }
    
}