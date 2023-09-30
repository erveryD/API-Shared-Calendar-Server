package domain.apiserver.calendar.service;

import domain.apiserver.calendar.api.dto.CalendarsResponse;
import domain.apiserver.calendar.repository.SubscriptionQueryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RetrieveCalendarService {

    private final SubscriptionQueryRepository subscriptionRepository;

    public List<CalendarsResponse> getSubscribedList(Long memberId) {
        return subscriptionRepository.findCalendarListByMemberId(memberId)
                .stream()
                .map(CalendarsResponse::of)
                .toList();
    }

}
