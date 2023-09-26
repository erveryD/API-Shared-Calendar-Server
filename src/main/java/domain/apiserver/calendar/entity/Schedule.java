package domain.apiserver.calendar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Schedule {

  @Id
  @GeneratedValue
  private Long id;

}
