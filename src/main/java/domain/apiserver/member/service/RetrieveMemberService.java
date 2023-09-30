package domain.apiserver.member.service;

import domain.apiserver.core.enums.Errors;
import domain.apiserver.core.exception.BaseBadRequestException;
import domain.apiserver.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RetrieveMemberService {

    private final MemberService memberService;

    public Member findByMemberId(Long memberId) {
        return memberService.findById(memberId)
                .orElseThrow(() -> new BaseBadRequestException(Errors.NOT_FOUND_MEMBER));
    }

}
