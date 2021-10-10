package se.redbridge.academy.serverless;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RequestScoped
public class DB {
  @PersistenceContext
  private EntityManager em;

  public Message getMessage() {
    final var qry = em.createQuery("select m from Message m", Message.class);
    return qry.getSingleResult();
  }

  @Transactional
  public void deleteMessage(Long id) {
    final var message = em.find(Message.class, id);
    em.remove(message);
  }
}
