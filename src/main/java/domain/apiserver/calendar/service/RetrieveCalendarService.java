package domain.apiserver.calendar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RetrieveCalendarService {

//  private final SubscriptionQueryRepository subscriptionRepository;
//
//  public void test() {
//    subscriptionRepository.findCalendarListByMemberId(1L);
//  }

}
