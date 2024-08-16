package com.ebento.vertx.core.services.verticles.deployment.b.bb;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class VerticleBB extends AbstractVerticle {
  @Override
  public void start(final Promise<Void> startPromise) {
    System.out.println("Start "+getClass().getName());
    startPromise.complete();
  }
}
