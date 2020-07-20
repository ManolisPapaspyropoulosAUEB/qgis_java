package controllers;

import akka.actor.ActorSystem;
import org.apache.xmlbeans.impl.common.XPath;
import scala.concurrent.ExecutionContext;
import scala.concurrent.duration.Duration;

import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

public class CodeBlockTask {

    private final ActorSystem actorSystem;
    private final XPath.ExecutionContext executionContext;

    @Inject
    public CodeBlockTask(ActorSystem actorSystem, XPath.ExecutionContext executionContext) {
        this.actorSystem = actorSystem;
        this.executionContext = executionContext;

        this.initialize();
    }




    private void initialize() {
        this.actorSystem
                .scheduler()
                .schedule(
                        Duration.create(10, TimeUnit.SECONDS), // initialDelay
                        Duration.create(1, TimeUnit.MINUTES), // interval
                        () -> System.out.println("Running block of code"),
                        (ExecutionContext) this.executionContext);
    }
}