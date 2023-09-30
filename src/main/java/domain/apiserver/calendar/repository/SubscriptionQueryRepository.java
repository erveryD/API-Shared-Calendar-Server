package domain.apiserver.calendar.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import domain.apiserver.calendar.entity.Calendar;
import domain.apiserver.calendar.entity.QCalendar;
import domain.apiserver.calendar.entity.QSubscription;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class SubscriptionQueryRepository {

    private final JPAQueryFactory queryFactory;
    private final QSubscription qSubscription = QSubscription.subscription;
    private final QCalendar qCalendar = QCalendar.calendar;

    public List<Calendar> findCalendarListByMemberId(Long memberId) {

        return queryFactory.select(qCalendar)
                .from(qSubscription)
                .where(qSubscription.member.id.eq(memberId))
                .stream()
                .toList();
    }

}
