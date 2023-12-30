DROP TABLE users_table;

DROP TABLE menu_Table;

CREATE TABLE users_table (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    userId VARCHAR(20) NOT NULL UNIQUE,
    userPassword VARCHAR(1000) NOT NULL,
    birth DATE NOT NULL,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    member VARCHAR(20)
);
create user java@localhost identified by '1234';

CREATE TABLE menu_table (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    menuName VARCHAR(200) NOT NULL,
    brand VARCHAR(100) NOT NULL,
    category VARCHAR(20) NOT NULL,
    image VARCHAR(1000) NOT NULL,
    weight VARCHAR(200),
    calories VARCHAR(200),
    protein VARCHAR(200),
    sodium VARCHAR(200),
    sugar VARCHAR(200),
    saturatedFat VARCHAR(200),
    allergy VARCHAR(200),
    origin VARCHAR(200),
    price VARCHAR(255),
    mainMenu VARCHAR(30),
    hotMenu VARCHAR(30)
);

INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('새우베이컨버거', '롯데리아', '햄버거', '/images/menu/새우베이컨버거.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '5,800', 'a', '추천');

INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('불고기 베이컨', '롯데리아', '햄버거', '/images/menu/불고기베이컨.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '5,800', 'b', '추천');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('더블 한우불고기', '롯데리아', '햄버거', '/images/menu/더블한우불고기.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '12,400', 'b', '추천');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('더블 클래식치즈버거(버터빈)', '롯데리아', '햄버거', '/images/menu/클래식치즈버거.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '5,800', 'b', '추천');

INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('더블 치킨버거', '롯데리아', '햄버거', '/images/menu/더블치킨버거.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '5,800', 'b', '추천');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('더블 데리버거', '롯데리아', '햄버거', '/images/menu/더블데리버거.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '5,800', 'b', '추천');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('한우 트리플머쉬룸', '롯데리아', '햄버거', '/images/menu/한우트리플머쉬룸.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '5,800', 'b', '추천');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('한우불고기', '롯데리아', '햄버거', '/images/menu/한우불고기.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '8,400', 'a', '추천');

INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('한우불고기', '롯데리아', '햄버거', '/images/menu/한우불고기.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '8,400', 'b', 'a');

INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('빅불', '롯데리아', '햄버거', '/images/menu/빅불.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '5,800', 'b', 'b');

INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('모짜렐라 인 더 버거 베이컨', '롯데리아', '햄버거', '/images/menu/모짜렐라인더버거베이컨.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '7,400', 'a', '추천');


INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('깡돼후 돼지후라이드', '롯데리아', '디저트', '/images/menu/돼지후라이드.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '5,800', 'b', '추천');

INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('포테이토', '롯데리아', '디저트', '/images/menu/포테이토.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '1,800', 'b', 'a');

INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('양념감자', '롯데리아', '디저트', '/images/menu/양념감자.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,300', 'b', 'a');

INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('포테이토(L)', '롯데리아', '디저트', '/images/menu/포테이토(L).png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,300', 'b', 'a');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('웨지 포테이토', '롯데리아', '디저트', '/images/menu/웨지포테이토.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,300', 'b', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('치즈스틱', '롯데리아', '디저트', '/images/menu/치즈스틱.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,300', 'a', 'b');

INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('롱치즈스틱', '롯데리아', '디저트', '/images/menu/롱치즈스틱.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,300', 'b', 'a');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('치킨너겟', '롯데리아', '디저트', '/images/menu/치킨너겟.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,300', 'b', 'a');

INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('화이어윙', '롯데리아', '치킨', '/images/menu/화이어윙.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,300', 'b', 'a');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('치킨휠레', '롯데리아', '치킨', '/images/menu/치킨휠레.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,300', 'b', 'a');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('치킨 1조각', '롯데리아', '치킨', '/images/menu/치킨1조각.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,300', 'b', 'a');

INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('패밀리팩', '롯데리아', '치킨', '/images/menu/패밀리팩.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,300', 'b', 'b');

INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('순살치킨 하프팩(11조각)', '롯데리아', '치킨', '/images/menu/하프팩.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,300', 'b', 'a');

INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('순살치킨 풀팩(22조각)', '롯데리아', '치킨', '/images/menu/풀팩.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,300', 'b', 'a');


INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('캐모마일 티', '롯데리아', '음료', '/images/menu/캐모마일.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,300', 'b', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('애플 캐모마일 티', '롯데리아', '음료', '/images/menu/애플캐모마일.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,300', 'b', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('콜라', '롯데리아', '음료', '/images/menu/콜라.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,300', 'b', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('사이다', '롯데리아', '음료', '/images/menu/사이다.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,300', 'b', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('제로슈거콜라', '롯데리아', '음료', '/images/menu/제로콜라.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,300', 'b', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('자두쿨 에이드', '롯데리아', '음료', '/images/menu/자두쿨.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,300', 'b', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('복숭아 홍차 에이드(R)', '롯데리아', '음료', '/images/menu/복숭아홍차.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,300', 'b', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('아이스티', '롯데리아', '음료', '/images/menu/아이스티.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,300', 'b', 'b');

INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('소프트콘', '롯데리아', '아이스샷', '/images/menu/소프트콘.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '900', 'b', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('토네이도 초코쿠키', '롯데리아', '아이스샷', '/images/menu/초코쿠키.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,800', 'b', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('토네이도 스트로베리', '롯데리아', '아이스샷', '/images/menu/스트로베리.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,800', 'b', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('토네이도 허쉬초코', '롯데리아', '아이스샷', '/images/menu/허쉬초코.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,800', 'b', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('선데아이스크림 플레인', '롯데리아', '아이스샷', '/images/menu/선데이플레인.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,800', 'b', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('선데아이스크림 스트로베리', '롯데리아', '아이스샷', '/images/menu/선데이스트로베리.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,800', 'b', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('선데 허쉬초코', '롯데리아', '아이스샷', '/images/menu/선데허쉬초코.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,800', 'b', 'b');

INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('선데 허쉬초코', '롯데리아', '아이스샷', '/images/menu/선데허쉬초코.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '2,800', 'b', 'b');

INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('공항 ㆍ역사에서 만나는 미식 라운지', '플레:이팅', '아이스샷', '/images/menu/역사에서 만나는 미식 라운지.jpeg', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '', 'a', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('병원에서 만나는 미식 테이블', '플레:이팅', '아이스샷', '/images/menu/병원에서 만나는 미식 테이블.jpeg', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '', 'a', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('레저시설에서 만나는 미식 스테이지', '플레:이팅', '아이스샷', '/images/menu/레저시설에서 만나는 미식 스테이지.jpeg', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '', 'a', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('맛에 다함이 없다! 일본정통라멘', '플레:이팅', '아이스샷', '/images/menu/맛에 다함이 없다! 일본정통라멘.jpeg', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '', 'a', 'b');

INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('크랩&쉬림프', '엔제리너스', '아이스샷', '/images/menu/크랩&쉬림프.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '7,300', 'a', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('오리지널불고기', '엔제리너스', '아이스샷', '/images/menu/오리지널불고기.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '7,300', 'a', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('바질 쉬림프', '엔제리너스', '아이스샷', '/images/menu/바질 쉬림프.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '7,300', 'a', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('에그마요', '엔제리너스', '아이스샷', '/images/menu/에그마요.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '7,300', 'a', 'b');

INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('스노위 홀리데이 더즌', '크리스피크림 도넛', '아이스샷', '/images/menu/스노위 홀리데이 더즌.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '22,500', 'a', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('오리지널 글레이즈드', '크리스피크림 도넛', '아이스샷', '/images/menu/오리지널 글레이즈드.jpeg', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '1,900', 'a', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('스노위 홀리데이 하프더즌', '크리스피크림 도넛', '아이스샷', '/images/menu/스노위 홀리데이 하프더즌.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '15,500', 'a', 'b');
INSERT INTO menu_table (menuName, brand, category, image, weight, calories, protein, sodium, sugar, saturatedFat, allergy, origin, price, mainMenu, hotMenu)
VALUES ('스노위 홀리데이 더즌', '크리스피크림 도넛', '아이스샷', '/images/menu/스노위 홀리데이 더즌.png', '200g', '500kcal', '25g', '1g', '10g', '5g', '없음', '한국', '22,500', 'a', 'b');
