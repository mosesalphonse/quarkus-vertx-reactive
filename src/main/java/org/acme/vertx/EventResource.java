package org.acme.vertx;

import io.vertx.axle.core.eventbus.EventBus;
import io.vertx.axle.core.eventbus.Message;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.concurrent.CompletionStage;

@Path("/vertx")
public class EventResource {
    @Inject EventBus bus;
    @GET
    @Path("/async/{name}")
    public CompletionStage<String> hello(@PathParam("name") String name) {
        System.out.println("In Non-Blocking mode, Thread id, "+Thread.currentThread().getId()+" , Name :"+Thread.currentThread().getName());
       return bus.<String>send("greeting", name)
               .thenApply(Message::body);
    }
    @GET
    @Path("/sync/{name}")
    public String helloSynch(@PathParam("name") String name) throws InterruptedException {
        System.out.println("In Blocked mode, Thread id, "+Thread.currentThread().getId()+" , Name :"+Thread.currentThread().getName());
        return new TestService().synchMethod(name).toString();
    }
}