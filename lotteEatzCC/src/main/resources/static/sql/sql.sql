DROP TABLE users_Table CASCADE CONSTRAINTS;
DROP TABLE coupons_Table CASCADE CONSTRAINTS;
DROP TABLE store_Table CASCADE CONSTRAINTS;
DROP TABLE menu_Table CASCADE CONSTRAINTS;
DROP TABLE myCoupon_Table CASCADE CONSTRAINTS;
DROP TABLE myStore_Table CASCADE CONSTRAINTS;
DROP TABLE myMenu_Table CASCADE CONSTRAINTS;
DROP TABLE event_Table CASCADE CONSTRAINTS;
DROP TABLE productsCategory_Table CASCADE CONSTRAINTS;
DROP TABLE products_Table CASCADE CONSTRAINTS;
DROP TABLE notice_Table CASCADE CONSTRAINTS;
DROP TABLE faq_Table CASCADE CONSTRAINTS;
DROP TABLE movie_Table CASCADE CONSTRAINTS;

create table users_Table (
    "id" number generated as identity primary key,
    "name" VARCHAR2(30) NOT NULL,
    "phone" VARCHAR2(50) NOT NULL,
    "userId" VARCHAR2(20) NOT NULL,
    "password" VARCHAR2(30) NOT NULL,
    "birth" DATE NOT NULL,
    "createdAt" timestamp default sysdate,
    "member" VARCHAR2(20)
);

create table coupons_Table (
    "id" number generated as identity primary key,
    "title" VARCHAR2(200) NOT NULL,
    "brand" VARCHAR2(20) NOT NULL,
    "utilization" VARCHAR2(30) NOT NULL,
    "comp" VARCHAR2(30) NOT NULL,
    "image" VARCHAR2(500) NOT NULL,
    "regularPrice" NUMBER(10) NOT NULL,
    "discountPrice" NUMBER(10) NOT NULL,
    "quantity" NUMBER(10),
    "startDate" DATE NOT NULL,
    "endDate" DATE NOT NULL,
	"productInfo" VARCHAR2(2000),
	"placeInfo" VARCHAR2(2000),
	"precautions" VARCHAR2(2000),
	"recommendation" CHAR(1)
);
create table store_Table (
    "id" number generated as identity primary key,
   	"storeName" VARCHAR2(200) NOT NULL,
	"brand" VARCHAR2(20) NOT NULL,
	"address" VARCHAR2(200),
   	"storeRunning" VARCHAR2(50),
   	"deliveryRunning" VARCHAR2(50),
   	"TakeoutRunning" VARCHAR2(50),
   	"delivery" CHAR(1),
   	"pickUp" CHAR(1),
   	"allDay" CHAR(1),
   	"parking" CHAR(1),
   	"wifi" CHAR(1),
   	"deliveryTip" number(7) NOT NULL,
   	"MinimumAmount" number(7) NOT NULL,
   	"available" CHAR(1)
);
create table menu_Table (
    "id" number generated as identity primary key,
   	"menuName" VARCHAR2(200) NOT NULL,
   	"brand" VARCHAR2(20) NOT NULL,
   	"category" VARCHAR2(20) NOT NULL,
   	"image" VARCHAR2(200) NOT NULL,
   	"weight" NUMBER(10),
   	"calories" NUMBER(10),
   	"protein" NUMBER(10),
   	"sodium" NUMBER(10),
   	"sugar" NUMBER(10),
   	"saturatedFat" NUMBER(10),
   	"allergy" VARCHAR2(200),
   	"origin" VARCHAR2(200)
);
create table productsCategory_Table (
    "id" number generated as identity primary key,
   	"majorTitle" VARCHAR2(50) NOT NULL,
	"subTitle" VARCHAR2(50) NOT NULL,   	
   	"brand" VARCHAR2(20) NOT NULL
);

create table products_Table (
    "id" number generated as identity primary key,
   	"categorySubTitle" VARCHAR2(50) NOT NULL,
   	"productName" VARCHAR2(100) NOT NULL,
   	"subTitle" number,
   	"image" VARCHAR2(200) NOT NULL,
   	"regularPrice" NUMBER(10),
    "discountPrice" NUMBER(10),
   	"discountInfo" VARCHAR2(500),
   	"productInfo" VARCHAR2(3000),
   	"productNotice" VARCHAR2(3000),
   	"deliveryNotice" VARCHAR2(3000),
   	"orderIndex" number(10) NOT NULL,
   	"mainDisplay" CHAR(1),
   	"suggestion" CHAR(1),
   	constraint fk_subtitle_id_Category foreign key ("subTitle") references productsCategory_Table("id")
);

create table myCoupon_Table (
    "user_id" NUMBER NOT NULL,
    "coupon_id" NUMBER NOT NULL,
    "availability" CHAR(1) NOT NULL,
   	"createdAt" TIMESTAMP default sysdate,
    constraint fk_user_id_to_myCoupon foreign key ("user_id") references users_Table("id"),
    constraint fk_coupon_id_to_myCoupon foreign key ("coupon_id") references coupons_Table("id")
);
create table myStore_Table (
    "user_id" NUMBER NOT NULL,
    "store_id" NUMBER NOT NULL,
   	"createdAt" TIMESTAMP default sysdate,
    constraint fk_user_id_myStore foreign key ("user_id") references users_Table("id"),
    constraint fk_store_id_myStore foreign key ("store_id") references store_Table("id")
);
create table myMenu_Table (
    "user_id" NUMBER NOT NULL,
    "menu_id" NUMBER NOT NULL,
   	"createdAt" TIMESTAMP default sysdate,
    constraint fk_user_id_myMenu foreign key ("user_id") references users_Table("id"),
    constraint fk_menu_id_myMenu foreign key ("menu_id") references menu_Table("id")
);
create table event_Table (
    "id" number generated as identity primary key,
   	"title" VARCHAR2(30) NOT NULL,
   	"brand" VARCHAR2(20) NOT NULL,
   	"titleImage" VARCHAR2(200) NOT NULL,
   	"startEndDate" VARCHAR2(100) NOT NULL,
   	"description" VARCHAR2(1000) NOT NULL,
 	"termination" CHAR(1),
 	"mainDisplay" CHAR(1),
 	"mainTopDisplay" CHAR(1),
 	"mainTopImage" VARCHAR2(200),
 	"mainTopModalImage" VARCHAR2(200)
);

create table notice_Table (
    "id" number generated as identity primary key,
   	"brand" VARCHAR2(20) NOT NULL,
   	"title" VARCHAR2(30) NOT NULL,
   	"description" VARCHAR2(2000) NOT NULL,
	"createdAt" timestamp default sysdate
);

create table faq_Table (
    "id" number generated as identity primary key,
    "brand" VARCHAR2(20) NOT NULL,
   	"question" VARCHAR2(200) NOT NULL,
   	"answer" VARCHAR2(200) NOT NULL,
   	"orderIndex" number(10) NOT NULL
); 

create table movie_Table (
    "id" number generated as identity primary key,
    "brand" VARCHAR2(20) NOT NULL,
   	"title" VARCHAR2(200) NOT NULL,
   	"url" VARCHAR2(200) NOT NULL,
   	"createdAt" timestamp default sysdate,
   	"mainDisplay" CHAR(1)
);

