package com.ebento.vertx.core.verticles.deployment.basics.b;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class VerticleB extends AbstractVerticle {

  @Override
  public void start(final Promise<Void> startPromise) {
    System.out.println("[+] Start " + getClass().getName() + " on thread " + Thread.currentThread().getName());
//    vertx.deployVerticle(new VerticleBA());
//    vertx.deployVerticle(new VerticleBB());
//    vertx.deployVerticle(new VerticleBC());
    startPromise.complete();
  }

  @Override
  public void stop(final Promise<Void> stopPromise) {
    System.out.println("[-] Stop " + getClass().getName() + " on thread " + Thread.currentThread().getName());
    stopPromise.complete();
  }
}
