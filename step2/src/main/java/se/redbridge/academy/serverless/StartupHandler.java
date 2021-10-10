package se.redbridge.academy.serverless;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.logging.Logger;

@ApplicationScoped
public class StartupHandler {
  private static final Logger LOG = Logger.getLogger(StartupHandler.class.getName());

  @Inject
  private RMQ rmq;
  @Inject
  private DB db;

  @PostConstruct
  private void readAndPush() {
    LOG.info("Arrived at readAndPush()");

    // FIXME Handle if there are more rows
    final var m = db.getMessage();
    rmq.sendThisMessage(m.getMessage());
    db.deleteMessage(m.getId());

    System.exit(0); // we can leave now ;)
  }

  public void onStart(@Observes @Initialized(ApplicationScoped.class) Object ignored) {
    // ignored
  }
}
