![Java](https://img.shields.io/badge/Java-17-red.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.1-green.svg)

공유캘린더 API서버 프로젝트입니다.

# Documents
- [DB관계도](https://www.erdcloud.com/d/6TxZcQS8C6p4hpzbx)
- [기획서]()

# Branch
기본적으로 git-flow 전략을 따릅니다
```
 - `master`: 기준이 되는 브랜치로 제품을 배포하는 브랜치 입니다.

 - `develop`: 개발 브랜치로 개발자들이 이 브랜치를 기준으로 각자 작업한 기능들을 합칩니다(Merge).

 - `feature/`: 단위 기능을 개발하는 브랜치로 기능 개발이 완료되면 develop 브랜치에 합칩니다.
  - `default`: 단위 기능 개발을 위한 최소한의 의존성을 제공하는 브랜치 입니다. 패키지 의존성 추가가 있는 경우만 해당 브랜치의 빌드 관리 도구에 Update 합니다. 이 브랜치는 제거되지 않습니다.
  - `${taskNum}_${featureName}`: 네이밍 규칙은 깃헙 이슈 번호_신규 개발 기능의 명칭으로 생성합니다. 기능 개발 완료 후 develop 에 병합 후 제거됩니다.
  
 - `hotfix/`: master 브랜치로 배포를 했는데 버그가 생겼을 떄 긴급 수정하는 브랜치 입니다.
  - `${issueNum}`: 네이밍 규칙은 깃헙 이슈 번호로 생성합니다. master 반영 후 제거됩니다.
```

# Commit Rules
```
NEW: 신규 파일 및 기능 추가
IMP: 기능 개선
SCH: 설정 변경
CLN: 코드 정리 및 리팩토링
BUG: 버그 픽스
TST: 테스트
DOC: 문서작업
RMV: 삭제

ex) NEW: 사용자 서비스 추가
```

# SWAGGER
```
 - LOCAL: http://localhost:8080/swagger-ui/index.html#/
```

# Reference

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Gradle](https://docs.gradle.org/current/userguide/userguide.html)
- [Jasypt Converter](https://www.devglan.com/online-tools/jasypt-online-encryption-decryption)

---