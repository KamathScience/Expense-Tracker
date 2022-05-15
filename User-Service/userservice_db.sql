drop database ccuserdb;
drop user ccuser;
create user ccuser with password 'password';
create database ccuserdb with template=template0 owner=ccuser;
\connect ccuserdb;
alter default privileges grant all on tables to ccuser;
alter default privileges grant all on sequences to ccuser;

create table cc_users(
    user_id integer primary key not null,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    email varchar(30) not null,
    password text not null,
    invite_code text,
    partner integer
);
alter table cc_users add constraint relation_user_fk
foreign key (partner) references cc_users(user_id);


create sequence cc_users_seq increment 1 start 1;


CREATE OR REPLACE function cc_users_insert( )
RETURNS TRIGGER AS $$
DECLARE
    new_code TEXT;
BEGIN

    LOOP
        new_code := LOWER(SUBSTRING(MD5(''||NOW()::TEXT||RANDOM()::TEXT) FOR 8));
        BEGIN
        UPDATE cc_users SET invite_code = new_code WHERE user_id = NEW.user_id;
            EXIT;
        EXCEPTION WHEN unique_violation THEN

        END;
    END LOOP;
    RETURN NULL;
END;
$$ LANGUAGE PLPGSQL;



--
CREATE TRIGGER unique_code_trigger AFTER INSERT ON cc_users
FOR EACH ROW EXECUTE PROCEDURE cc_users_insert();

