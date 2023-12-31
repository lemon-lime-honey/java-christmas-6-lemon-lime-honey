# 구현할 기능
- [X] 이벤트 구현
    - [X] 크리스마스 디데이 할인
        - 12월 1일부터 크리스마스 당일 한정
        - 1,000원으로 시작해 매일 100원씩 할인액 증가
    - [X] 평일 할인
        - 일~목 할인
        - 디저트 메뉴 하나당 2,023원 할인
    - [X] 주말 할인
        - 금, 토 할인
        - 메인 메뉴 하나당 2,023원 할인
    - [X] 특별 할인
        - 이벤트 달력에 별이 있으면 총 주문 금액에서 1,000원 할인
        - 별: 빨간날
    - [X] 증정 이벤트
        - **할인 전** 총 주문 금액이 12만원 이상일 때 샴페인 1병 증정
- [X] 이벤트 배지
    - 총 혜택 금액에 따른 배지
    - 오천 원 이상: 별
    - 만 원 이상: 트리
    - 이만 원 이상: 산타
- [X] 이벤트 제한
    - 총 주문 금액 10,000원 이상부터 적용
    - 음료만 주문 시 주문 불가(주문 할 수 없다고 적혀있음)
    - 메뉴: 한 번에 최대 20개까지(총 수량)
- [X] 입력
    - [X] 식당 방문일 입력 받기
        - [X] 1 이상 31 이하 정수만 가능
        - [X] 에러 메시지: [ERROR] 유효하지 않은 날짜입니다. 다시 입력해주세요.
    - [X] 주문할 메뉴와 수량 입력 받기
        - [X] 메뉴판에 있는 메뉴 한정
        - [X] 수량은 1 이상만 입력
        - [X] 형식이 예시(메뉴1-수량1,메뉴2-수량2,...)와 같아야 함
        - [X] 중복 메뉴 입력 불가
        - [X] 에러 메시지: [ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.
- [X] 출력
    - [X] 주문 메뉴 출력
        - 순서 자유
    - [X] 총 혜택 금액 = 할인 금액 합계 + 증정 메뉴 가격
    - [X] 총 혜택 금액에 따라 배지 이름 다르게
        - 배지가 부여되지 않는 경우 **없음**으로 표기
    - [X] 할인 전 총 주문 금액 출력
    - [X] 할인 후 예상 결제 금액 출력
    - [X] 증정 메뉴 출력
        - 해당하지 않는 경우 **없음**으로 표기
    - [X] 혜택 내역
        - [X] 고객에게 적용된 이벤트 내역 한정
        - [X] 적용된 이벤트가 없다면 혜택 내역 **없음**으로 표기
        - 여러 이벤트 적용 시 순서 자유