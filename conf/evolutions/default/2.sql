# --- Sample dataset

# --- !Ups

insert into category (id,name) values (  1,'Agile/Scrum');
insert into category (id,name) values (  2,'Software Design');
insert into category (id,name) values (  3,'Cloud Computing');


insert into question (id,name,category_id,answer1,answer2,answer3,answer4,correct_answer,answer_description)
values (  1,'What is the main reason for the Scrum Master to be at the Daily Scrum?',1,'To make sure every team member answers the three questions','They do not have to be there','To write down any changes to the Sprint Backlog','To gather status and progress information to report to management','2','Self-explanatory');
insert into question (id,name,category_id,answer1,answer2,answer3,answer4,correct_answer,answer_description)
values (  2,'The maximum length of the Sprint Review (its time-box) is:',1,'2 hours','4 hours for a monthly Sprint.  For shorter sprints it is usually shorter.','As long as needed','1 day','2','Self-explanatory');
insert into question (id,name,category_id,answer1,answer2,answer3,answer4,correct_answer,answer_description)
values (  3,'Who is responsible for managing the progress of work during a Sprint?',1,'The Development Team','The Scrum Master','The Product Owner','The most junior member of the team','1','Self-explanatory');
insert into question (id,name,category_id,answer1,answer2,answer3,answer4,correct_answer,answer_description)
values (  4,'The optimal size of a work team is: ',1,'6+3 people','10-12 people','enough people to share a box of donuts','4.6 people','4','Self-explanatory');
insert into question (id,name,category_id,answer1,answer2,answer3,answer4,correct_answer,answer_description)
values (  5,'What does the M stand for in the MVC design framework?',2,'movies','motorola','money','model','4','Self-explanatory');
insert into question (id,name,category_id,answer1,answer2,answer3,answer4,correct_answer,answer_description)
values (  6,'Which of the below are types of software design patterns?',2,'Algorithm strategy','Computational','Execution','All of the above','4','Self-explanatory');
insert into question (id,name,category_id,answer1,answer2,answer3,answer4,correct_answer,answer_description)
values (  7,'What does UML stand for?',2,'Unified Models Linguistics','Ultra Mode Language','Ultron Mods Language','Unified Modeling Language','4','Self-explanatory');
insert into question (id,name,category_id,answer1,answer2,answer3,answer4,correct_answer,answer_description)
values (  8,'Which of the following are object-oriented programming languages?',2,'Java','C++','Ruby','All of the above','4','Self-explanatory');
insert into question (id,name,category_id,answer1,answer2,answer3,answer4,correct_answer,answer_description)
values (  9,'Which of the following are major cloud computing vendors?',3,'Amazon Web Services','Microsoft','IBM','all of the above','4','Self-explanatory');
insert into question (id,name,category_id,answer1,answer2,answer3,answer4,correct_answer,answer_description)
values (  10,'Which is an example of SaaS?',3,'Heroku','Node.js','Django','None of the above','1','Self-explanatory');
insert into question (id,name,category_id,answer1,answer2,answer3,answer4,correct_answer,answer_description)
values (  11,'What is not a benefit of using cloud services?',3,'Can have files saved locally and therefore safely','Potentially incur lower costs','Can scale applications in a manner impossible with resources of local machine','disaster recovery','1','Self-explanatory');
insert into question (id,name,category_id,answer1,answer2,answer3,answer4,correct_answer,answer_description)
values (  12,'Which of the following will occur when an EC2 instance in a VPC with an associated Elastic IP is stopped and started?',3,'The Elastic IP will be dissociated from the instance','All data on instance-storage devices will be lost and the underlying host for the instance is changed','The ENI (Elastic Network Interface) is detached','All data on EBS (Elastic Block Store) devices will be lost','2','Self-explanatory');

insert into exam (id,name) values (100,'Agile/Scrum Exam');
insert into exam (id,name) values (101,'Software Design Exam');
insert into exam (id,name) values (102,'Cloud Computing Exam');
insert into exam (id,name) values (103,'Uber All-Inclusive Exam');


insert into question_exam (exam_id,question_id) values (100,1);
insert into question_exam (exam_id,question_id) values (100,2);
insert into question_exam (exam_id,question_id) values (100,3);
insert into question_exam (exam_id,question_id) values (100,4);
insert into question_exam (exam_id,question_id) values (101,5);
insert into question_exam (exam_id,question_id) values (101,6);
insert into question_exam (exam_id,question_id) values (101,7);
insert into question_exam (exam_id,question_id) values (101,8);
insert into question_exam (exam_id,question_id) values (102,9);
insert into question_exam (exam_id,question_id) values (102,10);
insert into question_exam (exam_id,question_id) values (102,11);
insert into question_exam (exam_id,question_id) values (102,12);
insert into question_exam (exam_id,question_id) values (103,1);
insert into question_exam (exam_id,question_id) values (103,2);
insert into question_exam (exam_id,question_id) values (103,3);
insert into question_exam (exam_id,question_id) values (103,4);
insert into question_exam (exam_id,question_id) values (103,5);
insert into question_exam (exam_id,question_id) values (103,6);
insert into question_exam (exam_id,question_id) values (103,7);
insert into question_exam (exam_id,question_id) values (103,8);
insert into question_exam (exam_id,question_id) values (103,9);
insert into question_exam (exam_id,question_id) values (103,10);
insert into question_exam (exam_id,question_id) values (103,11);
insert into question_exam (exam_id,question_id) values (103,12);


# --- !Downs



