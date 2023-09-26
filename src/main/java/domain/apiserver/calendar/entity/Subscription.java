package domain.apiserver.calendar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Subscription {

  @Id
  @GeneratedValue
  private Long id;

}
