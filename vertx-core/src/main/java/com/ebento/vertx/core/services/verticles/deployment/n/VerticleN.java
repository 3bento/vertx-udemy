package com.ebento.vertx.core.services.verticles.deployment.n;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class VerticleN extends AbstractVerticle {
  @Override
  public void start(final Promise<Void> startPromise) throws Exception {
    System.out.println("[+] Start " + config().toString() + " on thread " + Thread.currentThread().getName());
    startPromise.complete();
  }

  @Override
  public void stop(final Promise<Void> stopPromise) throws Exception {
    System.out.println("[-] Stop " + this.getClass().getName() + " on thread " + Thread.currentThread().getName());
    stopPromise.complete();
  }
}
