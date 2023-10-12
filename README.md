## 개인 프로젝트
# 호텔예약시스템
![메인페이지](https://github.com/orthh/HotelReservation/assets/107793363/7a9c3cef-a1e4-4948-b0ed-634d6ad7f9e1)
<br>

## 📅 프로젝트 기간
2023-07-24 ~ 2023-08-09
<br>

## ⭐ 기능
*  객실 예약
*  객실 예약취소
*  예약내역, 상세예약내역 확인
*  전체 객실 조회
*  객실타입 변경
*  객실 삭제
*  객실 추가
*  전체 객실타입 조회
*  객실타입 수정
*  객실타입 삭제
*  객실 추가
<br>

## 🖥 시연 영상

https://github.com/orthh/HotelReservation/assets/107793363/251475df-a285-4c53-803c-f75f203b958f


## 일부 코드
- 호텔 예약 (랜덤 방배정)
![호텔예약](https://github.com/orthh/HotelReservation/assets/107793363/3518ef1a-c57f-450b-acbf-6be28fd9a256)

- JPA 엔터티
  
![reservationsEntity](https://github.com/orthh/HotelReservation/assets/107793363/87270d86-ef2c-471a-badc-fb699ff4827a)

## ⛏ 기술스택
- springboot
- bootstrap
- thymeleaf
- JPA
- mariadb
<br>



## ⚙ 서비스 흐름도
![서비스흐름도](https://github.com/orthh/HotelReservation/assets/107793363/6a7234ce-8eb1-4651-a3c4-fb04a3af88c8)

<br>

## 📌 ER다이어그램
![erd](https://github.com/orthh/HotelReservation/assets/107793363/199ed859-0c4f-463f-8e29-99e58d745e76)

<br>

## DB 저장목록
- 사용자는 편의상 한명으로 지정(추후 추가예정)
![users](https://github.com/orthh/HotelReservation/assets/107793363/c83c6dc6-be46-42c6-bec9-bc8d16878200)
![reservations](https://github.com/orthh/HotelReservation/assets/107793363/d52cb128-3224-4912-8993-29b74b53ff22)
![reservationDetails](https://github.com/orthh/HotelReservation/assets/107793363/42c06044-b032-4f76-921b-ac04d327b16c)
![rooms](https://github.com/orthh/HotelReservation/assets/107793363/6f23df3c-b261-4f08-829f-bd7d467fb133)
![roomTypes](https://github.com/orthh/HotelReservation/assets/107793363/111f2288-2588-41a9-9d3e-b0b88edfb58a)



<br>

## 🤾‍♂️ 트러블슈팅
![트러플슈팅사진](https://github.com/orthh/HotelReservation/assets/107793363/d4ff5087-7a7c-4817-a172-0d0a296d33c8)
객실타입 삭제시 연관된 객실로 인해 foreign key 무결성 제약조건 발생하여
CASCADE 삭제 하는 등의 방법이 있지만,
그 방법은 관리자입장에서 데이터 삭제의 위험이 있기 때문에, 그 객실타입에 연관된
객실의 객실타입을 null 값으로 지정




