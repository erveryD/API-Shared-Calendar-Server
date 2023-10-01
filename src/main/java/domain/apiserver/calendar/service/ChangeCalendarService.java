package domain.apiserver.calendar.service;

import domain.apiserver.calendar.entity.Calendar;
import domain.apiserver.calendar.entity.Subscription;
import domain.apiserver.core.exception.BaseBadRequestException;
import domain.apiserver.member.entity.Member;
import domain.apiserver.member.service.RetrieveMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ChangeCalendarService {

    private final RetrieveMemberService retrieveMemberService;
    private final CalendarService calendarService;
    private final SubscriptionService subscriptionService;

    public void create(Calendar calendar) {
        calendarService.save(calendar);
    }

    /**
     * 캘린더 생성 및 구독 매핑 메서드
     *
     * @param name 캘린더 이름
     * @param memberId 멤버 ID
     * @throws BaseBadRequestException 멤버가 존재하지 않음
     */
    public void createCalendarAndSubscribe(String name, Long memberId) {
        Member member = retrieveMemberService.findByMemberId(memberId);
        Calendar calendar = Calendar.create(name);

        create(calendar);
        subscriptionService.save(Subscription.create(member, calendar));
    }

}
