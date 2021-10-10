package se.redbridge.academy.serverless;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RequestScoped
public class DB {
  @PersistenceContext
  private EntityManager em;

  @Transactional
  public void persistMessage(final String message) {
    final var msg = new Message();
    msg.setMessage(message);
    em.persist(msg);
  }
}
