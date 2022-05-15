drop database ccpurchasesdb;
drop user ccpurchases;
create user ccpurchases with password 'password';
create database ccpurchasesdb with template=template0 owner=ccpurchases;
\connect ccpurchasesdb;
alter default privileges grant all on tables to ccpurchases;
alter default privileges grant all on sequences to ccpurchases;

create table cc_categories(
    category_id integer primary key not null,
    user_id integer not null,
    title varchar(20) not null,
    description varchar(50) not null
);


create table cc_transactions(
    transaction_id integer primary key not null,
    category_id integer not null,
    user_id integer not null,
    amount numeric(10,2)  not null,
    note varchar(50) not null,
    transaction_date bigint not null
);
alter table cc_transactions add constraint trans_cat_fk
foreign key (category_id) references cc_categories(category_id);

create sequence cc_categories_seq increment 1 start 1;
create sequence cc_transactions_seq increment 1 start 1;
