package com.sbosoft.dineease.tables;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages = {"com.sbosoft.dineease.tables"})
@EnableWebFlux
@EnableSwagger2
public class TablesApplication {
	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TablesApplication.class)){
			context.getBean(DisposableServer.class).onDispose().block();
		}
	}

	@Bean
	public DisposableServer disposableServer(ApplicationContext context) {
		HttpHandler handler = WebHttpHandlerBuilder
				.applicationContext(context).build();
		ReactorHttpHandlerAdapter adapter
				= new ReactorHttpHandlerAdapter(handler);
		HttpServer httpServer = HttpServer.create().host("localhost").port(8080);
		return httpServer.handle(adapter).bindNow();
	}
}
