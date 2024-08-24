package com.ebento.vertx.core.verticles.deployment.basics.b.bb;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class VerticleBC extends AbstractVerticle {
  @Override
  public void start(final Promise<Void> startPromise) {
    System.out.println("Start "+getClass().getName());
    startPromise.complete();
  }
}
