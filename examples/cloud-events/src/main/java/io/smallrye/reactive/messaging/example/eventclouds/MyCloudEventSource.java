package io.smallrye.reactive.messaging.example.eventclouds;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import io.smallrye.reactive.messaging.cloudevents.CloudEventMessage;
import io.smallrye.reactive.messaging.cloudevents.CloudEventMessageBuilder;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.reactivestreams.Publisher;

import javax.enterprise.context.ApplicationScoped;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class MyCloudEventSource {

  @Outgoing("source")
  public Publisher<CloudEventMessage<String>> source() {

    return Flowable.interval(250, TimeUnit.MILLISECONDS)
      .observeOn(Schedulers.computation())
      .map(l -> new CloudEventMessageBuilder<String>()
        .id(UUID.randomUUID().toString())
        .type("counter")
        .source(new URI("local://timer"))
        .contentType("text/plain")
        .time(ZonedDateTime.now())
        .data(Long.toString(l))
        .build());
  }
}
