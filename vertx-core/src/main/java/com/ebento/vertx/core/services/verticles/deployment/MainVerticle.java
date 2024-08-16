package com.ebento.vertx.core.services.verticles.deployment;

import com.ebento.vertx.core.services.verticles.deployment.a.VerticleA;
import com.ebento.vertx.core.services.verticles.deployment.b.VerticleB;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;

public class MainVerticle extends AbstractVerticle {

  public static void main(String[] args) {
    final Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle());
  }

  @Override
  public void start(final Promise<Void> startPromise) {
    System.out.println("Start" + getClass().getName());
    vertx.deployVerticle(new VerticleA());
    vertx.deployVerticle(new VerticleB());
    startPromise.complete();
  }
}
