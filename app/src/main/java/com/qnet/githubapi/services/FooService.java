package com.qnet.githubapi.services;

public class FooService {

    DemoService demo;

    public FooService(DemoService demo) {
        this.demo = demo;
    }

    public DemoService getDemo() {
        return demo;
    }

    public void setDemo(DemoService demo) {
        this.demo = demo;
    }
}
