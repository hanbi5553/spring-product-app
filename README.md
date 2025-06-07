# 🛒 Spring Boot 상품 관리 웹 애플리케이션

Spring Boot + Spring Security 기반의 웹 애플리케이션으로, 회원가입 및 로그인, 상품 등록/수정/삭제 기능, 관리자 페이지 등을 구현했습니다.

## ✅ 주요 기능

### 1. 사용자 인증
- 회원가입, 로그인, 로그아웃
- 비밀번호는 `BCryptPasswordEncoder`로 암호화 저장
- Spring Security 기반 Role 분리 (`ROLE_USER`, `ROLE_ADMIN`)

### 2. 상품 관리
- 사용자(`ROLE_USER`)는 상품 목록 조회 가능
- 관리자(`ROLE_ADMIN`)는 상품 등록, 수정, 삭제 가능
- 유효성 검사: 빈 항목 불가, 가격은 0 이상

### 3. 관리자 전용 기능
- 전체 사용자 목록 확인 (URL: `/admin/users`)
- 관리자만 상품 수정/삭제 버튼 보임

## 💻 기술 스택

| 구성 요소         | 사용 기술                        |
|------------------|----------------------------------|
| 프레임워크       | Spring Boot 3.5.0                |
| 보안             | Spring Security                  |
| 템플릿 엔진      | Thymeleaf + Bootstrap            |
| 데이터베이스     | MySQL                            |
| ORM              | Spring Data JPA                  |
| 기타             | Lombok, Jakarta Validation       |


## 📝 실행 방법

```bash
./gradlew bootRun
접속 주소: http://localhost:8080
