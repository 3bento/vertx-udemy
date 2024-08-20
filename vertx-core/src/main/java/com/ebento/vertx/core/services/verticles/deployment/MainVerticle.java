package com.ebento.vertx.core.services.verticles.deployment;

import com.ebento.vertx.core.services.verticles.deployment.a.VerticleA;
import com.ebento.vertx.core.services.verticles.deployment.b.VerticleB;
import com.ebento.vertx.core.services.verticles.deployment.n.VerticleN;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class MainVerticle extends AbstractVerticle {

  private static final Logger LOG = LogManager.getLogger();

  public static void main(String[] args) {
    final Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle(), whenDeployed -> {
      System.out.println("[~] Deployed " + MainVerticle.class.getName() + " on thread " + Thread.currentThread().getName());
//      vertx.undeploy(whenDeployed.result());
    });

  }

  @Override
  public void start(final Promise<Void> startPromise) {
    LOG.debug("[+] Start {} on thread {}", getClass().getName(), Thread.currentThread().getName());

    vertx.deployVerticle(new VerticleB(), whenDeployed -> {
      LOG.debug("[~] Deployed {} on thread {}", VerticleB.class.getName(), Thread.currentThread().getName());
      vertx.undeploy(whenDeployed.result());
    });

    vertx.deployVerticle(new VerticleA(), whenDeployed -> {
      LOG.debug("[~] Deployed {} on thread {}", VerticleA.class.getName(), Thread.currentThread().getName());
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
    LOG.debug("[-] Stop {}", getClass().getName());
    stopPromise.complete();
  }
}
