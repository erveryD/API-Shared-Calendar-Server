package domain.apiserver.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 최상위 도메인 레포지토리
 */
@NoRepositoryBean
public interface DomainRepository<Entity extends DomainRepository, IDENTITY>
    extends JpaRepository<Entity, IDENTITY>, JpaSpecificationExecutor<Entity>,
    QuerydslPredicateExecutor<Entity> {

}
