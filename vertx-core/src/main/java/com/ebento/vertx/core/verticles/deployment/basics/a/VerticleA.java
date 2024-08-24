package com.ebento.vertx.core.verticles.deployment.basics.a;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class VerticleA extends AbstractVerticle {
  @Override
  public void start(final Promise<Void> startPromise) {
    System.out.println("[+] Start " + getClass().getName() + " on thread " + Thread.currentThread().getName());
//    vertx.deployVerticle(new VerticleAA());
//    vertx.deployVerticle(new VerticleAB());
//    vertx.deployVerticle(new VerticleAC());
    startPromise.complete();
  }

  @Override
  public void stop(final Promise<Void> stopPromise) {
    System.out.println("[-] Stop " + getClass().getName() + " on thread " + Thread.currentThread().getName());
    stopPromise.complete();
  }
}
