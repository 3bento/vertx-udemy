package com.ebento.vertx.core.services.verticles.deployment;

import com.ebento.vertx.core.services.verticles.deployment.a.VerticleA;
import com.ebento.vertx.core.services.verticles.deployment.b.VerticleB;
import com.ebento.vertx.core.services.verticles.deployment.n.VerticleN;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

import java.util.UUID;

public class MainVerticle extends AbstractVerticle {

  public static void main(String[] args) {
    final Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle(), whenDeployed -> {
      System.out.println("[~] Deployed " + MainVerticle.class.getName() + " on thread " + Thread.currentThread().getName());
//      vertx.undeploy(whenDeployed.result());
    });

  }

  @Override
  public void start(final Promise<Void> startPromise) {
    System.out.println("[+] Start " + getClass().getName() + " on thread " + Thread.currentThread().getName());

    vertx.deployVerticle(new VerticleB(), whenDeployed -> {
      System.out.println("[~] Deployed " + VerticleB.class.getName() + " on thread " + Thread.currentThread().getName());
      vertx.undeploy(whenDeployed.result());
    });

    vertx.deployVerticle(new VerticleA(), whenDeployed -> {
      System.out.println("[~] Deployed " + VerticleA.class.getName() + " on thread " + Thread.currentThread().getName());
      vertx.undeploy(whenDeployed.result());
    });

    vertx.deployVerticle(VerticleN.class.getName(), new DeploymentOptions()
      .setInstances(4)
      .setConfig(new JsonObject()
        .put("id", UUID.randomUUID().toString())
        .put("name", VerticleN.class.getName())
      )
    );

    startPromise.complete();
  }

  @Override
  public void stop(final Promise<Void> stopPromise) {
    System.out.println("[-] Stop " + getClass().getName());
    stopPromise.complete();
  }
}
