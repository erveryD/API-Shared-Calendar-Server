package domain.apiserver.core.entity;

import domain.apiserver.core.enums.YesOrNo;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@MappedSuperclass
public abstract class RootEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @CreatedBy
  @Column(name = "create_id", nullable = false, updatable = false)
  protected String createId;

  @CreatedDate
  @Column(name = "create_dt", nullable = false, updatable = false)
  protected LocalDateTime createDt;

  @LastModifiedBy
  @Column(name = "update_id", nullable = false)
  protected String updateId;

  @LastModifiedDate
  @Column(name = "update_id", nullable = false)
  protected LocalDateTime updateDt;

  @Column(name = "use_yn", nullable = false, columnDefinition = "char(1) default 'Y'")
  protected YesOrNo uesYn = YesOrNo.Yes;

}
