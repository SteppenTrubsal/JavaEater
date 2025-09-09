package com.javaeater;

import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        var app = Javalin.create(cfg -> {
            cfg.http.defaultContentType = "text/plain";
        });

        app.get("/ping", ctx -> ctx.result("pong"));

        Runtime.getRuntime().addShutdownHook(new Thread(app::stop));
        app.start(8080);
    }
}