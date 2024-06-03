### 프로젝트 제목
# 이슈 관리 시스템

### 간단한 설명
소프트웨어 개발 과정에서 조직/단체의 필요에 따라 이슈를 체계적으로 관리하는 시스템입니다. JIRA, TRAC, Bugzilla, Backlog 등의 기존 서비스를 분석하여 핵심 기능을 구현하였습니다.
Spring boot, React-vite, Mysql 8.0, Hibernate를 사용하였습니다.

### 배지(Badges)
![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![License](https://img.shields.io/badge/license-MIT-blue)

### 목차
- [프로젝트 목적](#프로젝트-목적)
- [설치](#설치)
- [사용법](#사용법)
- [기여](#기여)
- [라이선스](#라이선스)
- [작성자 정보](#작성자-정보)
- [연락처](#연락처)

### 프로젝트 목적
이 이슈 관리 시스템은 소프트웨어 개발 과정에서 조직/단체의 필요에 의해 이슈 목록과 내용 등을 체계적으로 관리하는 소프트웨어의 일종입니다. JIRA, TRAC, Bugzilla, Backlog 등 기존에 존재하는 서비스 구조와 핵심 기능을 충분히 분석한 후, 이슈를 등록하고 관리하는 핵심 기능을 추출하여 프로젝트 내에서 구현하였습니다. 객체지향 분석과 설계 개념을 적극적으로 활용하고, 타당한 근거를 통해 설계를 진행하며 이를 기록하였습니다. 
설계/구현 시 UI와 응용 로직을 분리하여 재사용성을 높이는 것을 목표로 하고 기능 확장과 설계 개선 활동이 잘 이루어졌다는 것을 JUnit을 이용해 테스트케이스를 만들고 적절히 문서화하였습니다. 
시스템에 저장된 데이터는 영속하는 저장소에 보관됩니다. Web 인터페이스를 통해 소프트웨어가 동작하도록 만드는 것입니다.

### 설치

이 프로젝트를 설치하려면 다음 명령어를 사용하세요:

```bash
git clone https://github.com/daneck99/-.git
cd src/main/java/com/Software_Engineering/Software_Eng
npm install
```

### 사용법

프로젝트를 사용하는 방법은 다음과 같습니다:

```java
import com.Software_Engineering.Software_Eng;

public class Main {
    public static void main(String[] args) {
        IssueManagementSystem ims = new IssueManagementSystem();
        ims.createIssue("Issue title", "Issue description");
        ims.listIssues();
    }
}
```

### 라이선스

이 프로젝트는 MIT 라이선스를 따릅니다. 자세한 내용은 [LICENSE](LICENSE)를 참고하세요.

### 작성자 정보

- **작성자**: 양희목
- **GitHub**: [Hemok01](https://github.com/Hemok01)

### 연락처

질문이나 피드백이 있으시면 daneck99@gmail.com으로 연락주세요.

