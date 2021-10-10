package se.redbridge.academy.serverless;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "messages")
public class Message {
  @Id
  @Column(name = "id")
  private Long id;
  @Column(name = "message")
  private String message;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @PrePersist
  private void generateId() {
    id = new Random().nextLong();
  }
}
