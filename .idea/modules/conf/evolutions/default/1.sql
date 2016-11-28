# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table category (
  id                            bigint not null,
  name                          varchar(255),
  constraint pk_category primary key (id)
);
create sequence category_seq;

create table exam (
  id                            bigint not null,
  name                          varchar(255),
  constraint pk_exam primary key (id)
);
create sequence exam_seq;

create table question (
  id                            bigint not null,
  name                          varchar(255),
  answer1                       varchar(255),
  answer2                       varchar(255),
  answer3                       varchar(255),
  answer4                       varchar(255),
  correct_answer                varchar(255),
  answer_description            varchar(255),
  category_id                   bigint,
  constraint pk_question primary key (id)
);
create sequence question_seq;

create table question_exam (
  question_id                   bigint not null,
  exam_id                       bigint not null,
  constraint pk_question_exam primary key (question_id,exam_id)
);

alter table question add constraint fk_question_category_id foreign key (category_id) references category (id) on delete restrict on update restrict;
create index ix_question_category_id on question (category_id);

alter table question_exam add constraint fk_question_exam_question foreign key (question_id) references question (id) on delete restrict on update restrict;
create index ix_question_exam_question on question_exam (question_id);

alter table question_exam add constraint fk_question_exam_exam foreign key (exam_id) references exam (id) on delete restrict on update restrict;
create index ix_question_exam_exam on question_exam (exam_id);


# --- !Downs

alter table question drop constraint if exists fk_question_category_id;
drop index if exists ix_question_category_id;

alter table question_exam drop constraint if exists fk_question_exam_question;
drop index if exists ix_question_exam_question;

alter table question_exam drop constraint if exists fk_question_exam_exam;
drop index if exists ix_question_exam_exam;

drop table if exists category;
drop sequence if exists category_seq;

drop table if exists exam;
drop sequence if exists exam_seq;

drop table if exists question;
drop sequence if exists question_seq;

drop table if exists question_exam;

