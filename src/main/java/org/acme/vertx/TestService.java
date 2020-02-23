package org.acme.vertx;

public class TestService {
    public String synchMethod(String name) throws InterruptedException {
        Thread.sleep(1999);
        System.out.println("In TestService, Thread id, "+Thread.currentThread().getId()+" , Name :"+Thread.currentThread().getName());
        return "Hello " + name;
    }
}
