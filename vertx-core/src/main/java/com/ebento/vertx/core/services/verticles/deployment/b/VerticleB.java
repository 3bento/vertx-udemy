package com.ebento.vertx.core.services.verticles.deployment.b;

import com.ebento.vertx.core.services.verticles.deployment.b.bb.VerticleBA;
import com.ebento.vertx.core.services.verticles.deployment.b.bb.VerticleBB;
import com.ebento.vertx.core.services.verticles.deployment.b.bb.VerticleBC;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class VerticleB extends AbstractVerticle {

  @Override
  public void start(final Promise<Void> startPromise) {
    System.out.println("[+] Start " + getClass().getName());
//    vertx.deployVerticle(new VerticleBA());
//    vertx.deployVerticle(new VerticleBB());
//    vertx.deployVerticle(new VerticleBC());
    startPromise.complete();
  }

  @Override
  public void stop(final Promise<Void> stopPromise) {
    System.out.println("[-] Stop " + getClass().getName());
    stopPromise.complete();
  }
}
