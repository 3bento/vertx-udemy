package com.ebento.vertx.core.services.verticles.deployment.a;

import com.ebento.vertx.core.services.verticles.deployment.a.aa.VerticleAA;
import com.ebento.vertx.core.services.verticles.deployment.a.aa.VerticleAB;
import com.ebento.vertx.core.services.verticles.deployment.a.aa.VerticleAC;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class VerticleA extends AbstractVerticle {
  @Override
  public void start(final Promise<Void> startPromise) {
    System.out.println("Start " + getClass().getName());
    vertx.deployVerticle(new VerticleAA());
    vertx.deployVerticle(new VerticleAB());
    vertx.deployVerticle(new VerticleAC());
    startPromise.complete();
  }
}
