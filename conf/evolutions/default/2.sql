# --- Sample dataset

# --- !Ups

insert into category (id,name) values (  1,'Network');
insert into category (id,name) values (  2,'Telecomm');
insert into category (id,name) values (  3,'Policies');


insert into question (id,name,category_id,answer1,answer2,answer3,answer4,correct_answer)
values (  1,'List 3 phones',2,'nokia','motorola','samsung','all of the above','2');
insert into question (id,name,category_id,answer1,answer2,answer3,answer4,correct_answer)
values (  2,'What is PRI',1,'ans1','ans2','ans3','ans4','3');
insert into question (id,name,category_id,answer1,answer2,answer3,answer4,correct_answer)
values (  3,'What is MPLS',1,'ans1','ans2','ans3','ans4','1');
insert into question (id,name,category_id,answer1,answer2,answer3,answer4,correct_answer)
values (  4,'How to file an expense report',3,'ans1','ans2','ans3','ans4','4');

insert into exam (id,name) values (100,'Test Exam 1');
insert into exam (id,name) values (101,'Test Exam 2');

insert into question_exam (exam_id,question_id) values (100,1);
insert into question_exam (exam_id,question_id) values (100,2);
insert into question_exam (exam_id,question_id) values (100,3);
insert into question_exam (exam_id,question_id) values (101,3);
insert into question_exam (exam_id,question_id) values (101,4);

# --- !Downs


