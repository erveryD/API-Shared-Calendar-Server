package domain.apiserver.calendar.service;

import domain.apiserver.calendar.entity.Subscription;
import domain.apiserver.calendar.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public void save(Subscription subscription) {
        subscriptionRepository.save(subscription);
    }

}
