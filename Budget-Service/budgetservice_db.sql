drop database ccbudgetdb;
drop user ccbudget;
create user ccbudget with password 'password';
create database ccbudgetdb with template=template0 owner=ccbudget;
\connect ccbudgetdb;
alter default privileges grant all on tables to ccbudget;
alter default privileges grant all on sequences to ccbudget;

create table cc_budget(
    budget_id integer primary key not null,
    user_id integer not null unique ,
    partner_id integer not null  ,
    budget  numeric(10,2)  not null,
    title varchar(20) not null,
    description varchar(50) not null
);

create sequence cc_budget_seq increment 1 start 1;