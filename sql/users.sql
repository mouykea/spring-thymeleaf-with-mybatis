/*
Navicat PGSQL Data Transfer

Source Server         : mybatisDB
Source Server Version : 90400
Source Host           : localhost:5432
Source Database       : postgres
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90400
File Encoding         : 65001

Date: 2017-06-27 16:47:55
*/


-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS "public"."users";
CREATE TABLE "public"."users" (
"id" int4 DEFAULT nextval('users_id_seq'::regclass) NOT NULL,
"username" varchar(100) COLLATE "default",
"gender" varchar(10) COLLATE "default",
"email" varchar(100) COLLATE "default",
"phonenumber" varchar(100) COLLATE "default",
"status" varchar(100) COLLATE "default",
"user_hash" varchar(100) COLLATE "default",
"create_date" date DEFAULT ('now'::text)::date
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO "public"."users" VALUES ('1', ' toch nana', 'Male', 'keamouy9@gmail.com', '010931244', null, 'e91bb3aa-e601-4c2e-9fb3-74f0597cb06f', '2017-06-27');
INSERT INTO "public"."users" VALUES ('2', 'admin', 'Male', 'amouylovely@gmail.com', '010931244', null, '75d9df2b-1ecd-4131-919b-c026c957cdfa', '2017-06-27');
INSERT INTO "public"."users" VALUES ('18', 'admin', 'Male', 'amouylovely@gmail.com', '010931244', null, '69a76307-fddf-491f-b33d-b0876a37d545', '2017-06-27');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table users
-- ----------------------------
ALTER TABLE "public"."users" ADD PRIMARY KEY ("id");
