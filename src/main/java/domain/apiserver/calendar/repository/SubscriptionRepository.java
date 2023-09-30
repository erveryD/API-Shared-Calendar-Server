package domain.apiserver.calendar.repository;

import domain.apiserver.calendar.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
