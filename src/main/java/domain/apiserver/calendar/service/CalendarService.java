package domain.apiserver.calendar.service;

import domain.apiserver.calendar.entity.Calendar;
import domain.apiserver.calendar.repository.CalendarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CalendarService {

    private final CalendarRepository calendarRepository;

    public void save(Calendar calendar) {
        calendarRepository.save(calendar);
    }

}

