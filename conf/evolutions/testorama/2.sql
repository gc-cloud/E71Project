# --- Sample dataset

# --- !Ups

insert into category (id,name) values (  1,'Network');
insert into category (id,name) values (  2,'Telecomm');
insert into category (id,name) values (  3,'Policies');


insert into question (id,name,category_id) values (  1,'List 3 phones',2);
insert into question (id,name,category_id) values (  2,'What is PRI',1);
insert into question (id,name,category_id) values (  3,'What is MPLS',1);
insert into question (id,name,category_id) values (  4,'How to file an expense report',3);


insert into answer (id,name) values (  1,'iPhone, Galaxy, Ericsson');
insert into answer (id,name) values (  2,'A type of network');
insert into answer (id,name) values (  3,'Itemize tax and food');



# --- !Downs

delete from category;
delete from question;
delete from answer;