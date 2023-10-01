package domain.apiserver.member.entity;

import domain.apiserver.calendar.entity.Subscription;
import domain.apiserver.core.entity.RootEntity;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class Member extends RootEntity {

  @OneToMany(
      fetch = FetchType.LAZY,
      cascade = CascadeType.ALL)
  @JoinColumn(name = "member_id")
  private Set<Subscription> subscriptions = new LinkedHashSet<>();

  @Column(name = "name")
  private String name;

  @Column(name = "phone")
  private String phone;

}
