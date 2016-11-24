# --- First database schema

# --- !Ups

create table category (
  id                        bigint(20) NOT NULL AUTO_INCREMENT,
  name                      varchar(255),
  constraint pk_category primary key (id))
;

create table question (
  id                        bigint(20) NOT NULL AUTO_INCREMENT,
  name                      varchar(255),
  category_id               bigint,
  answer1                   varchar(255),
  answer2                   varchar(255),
  answer3                   varchar(255),
  answer4                   varchar(255),
  correct_answer            varchar(255),
  answer_description        varchar(255),
  constraint pk_question primary key (id))
;

create table exam (
  id                        bigint(20) NOT NULL AUTO_INCREMENT,
  name                      varchar(255),
  constraint pk_exam primary key (id))
;

create table question_exam (
  exam_id                       bigint(20) NOT NULL,
  question_id                       bigint(20) NOT NULL,
  constraint pk_exam_question primary key (exam_id,question_id))
;

alter table question add constraint fk_question_category_1 foreign key (category_id) references category (id) on delete restrict on update restrict;
alter table question_exam add constraint fk_exam_question1 foreign key (exam_id) references exam (id) on delete restrict on update restrict;
alter table question_exam add constraint fk_exam_question2 foreign key (question_id) references question (id) on delete restrict on update restrict;
create index ix_question_category_1 on question (category_id);


# --- !Downs

SET FOREIGN_KEY_CHECKS=0;
drop table if exists question;
drop table if exists category;
drop table if exists exam;
drop table if exists exam_question;
drop table if exists question_exam
SET FOREIGN_KEY_CHECKS=1;