package com.ebento.vertx.core.verticles.deployment.basics.a.aa;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class VerticleAB extends AbstractVerticle {
  @Override
  public void start(final Promise<Void> startPromise) {
    System.out.println("Start "+ getClass().getName());
    startPromise.complete();
  }
}
