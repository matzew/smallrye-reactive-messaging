package io.smallrye.reactive.messaging.example.eventclouds;

import io.smallrye.reactive.messaging.http.HttpMessage;
import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

//@ApplicationScoped
public class MyCloudEventSink {

//  @Incoming("result")
//  @Outgoing("to-http")
//  public HttpMessage<JsonObject> receive(String payload) {
//    System.out.println("Received: " + payload);
//
//    return HttpMessage.HttpMessageBuilder.<JsonObject>create()
//      .withMethod("PUT")
//      .withPayload(new JsonObject().put("value", payload.toUpperCase()))
//      .withHeader("Content-Type", "application/json")
//      .build();
//
//
//  }
}
