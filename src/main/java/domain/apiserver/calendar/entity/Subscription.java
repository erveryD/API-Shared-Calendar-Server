package domain.apiserver.calendar.entity;

import domain.apiserver.core.entity.ChildEntity;
import domain.apiserver.core.entity.RootEntity;
import domain.apiserver.core.repository.DomainRepository;
import domain.apiserver.member.entity.Member;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "subscription")
public class Subscription {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id", referencedColumnName = "id")
  private Member member;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "calendar_id", referencedColumnName = "id")
  private Calendar calendar;

}
