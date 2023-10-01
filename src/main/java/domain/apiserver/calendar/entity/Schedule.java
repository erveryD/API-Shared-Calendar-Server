package domain.apiserver.calendar.entity;

import domain.apiserver.calendar.enums.Colors;
import domain.apiserver.core.entity.ChildEntity;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "schedule")
public class Schedule extends ChildEntity {

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "calendar_id", referencedColumnName = "id")
  private Calendar calendar;

  @Column(name = "title")
  private String title;

  @Column(name = "content")
  private String content;

  @Column(name = "date")
  private LocalDate date;

  @Column(name = "color")
  private Colors color;

}
