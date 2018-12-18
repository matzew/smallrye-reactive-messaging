package io.smallrye.reactive.messaging.example.eventclouds;

import io.smallrye.reactive.messaging.cloudevents.CloudEventMessage;
import io.smallrye.reactive.messaging.cloudevents.CloudEventMessageBuilder;
import io.smallrye.reactive.messaging.http.HttpMessage;
import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyCloudEventProcessor {


  @Incoming("source")
  @Outgoing("to-http")
  public HttpMessage<CloudEventMessage> process(CloudEventMessage<String> message) {

    System.out.println("yoyo");

//    return HttpMessage.HttpMessageBuilder.<CloudEventMessage<String>>create()
//
//      .withMethod("PUT")
//      .withPayload(CloudEventMessageBuilder.from(message)
//        .build())
//      .withHeader("Content-Type", "application/json")
//
//      .build();

    return HttpMessage.HttpMessageBuilder.<CloudEventMessage>create()
      .withMethod("PUT")
      .withPayload(message)
      .withHeader("Content-Type", "application/json")
      .build();

//  public CloudEventMessage<String> process(CloudEventMessage<String> message) {
//    return CloudEventMessageBuilder.from(message)
//      .data("Hello " + message.getPayload()).build();
  }
}
