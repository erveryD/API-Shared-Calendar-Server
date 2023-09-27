package domain.apiserver.calendar.entity;

import domain.apiserver.core.entity.RootEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "calendar")
public class Calendar extends RootEntity {

  @Column(name = "name")
  private String name;

}
