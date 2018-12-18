package io.smallrye.reactive.messaging.http.converters;

import io.smallrye.reactive.messaging.cloudevents.CloudEventMessage;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.buffer.Buffer;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class CloudEventSerializer extends Serializer<CloudEventMessage> {



  @Override
  public CompletionStage<Buffer> convert(CloudEventMessage payload) {
    return CompletableFuture.completedFuture(new Buffer(Json.encodeToBuffer(payload)));
  }

  @Override
  public Class<? extends CloudEventMessage> input() {
    return CloudEventMessage.class;
  }

}
