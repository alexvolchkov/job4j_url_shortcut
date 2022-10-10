create table if not exists person (
    id serial primary key not null,
    username text unique,
    password text
);

create table if not exists role (
    id serial primary key not null,
    name text
);

create table if not exists person_role (
    person_id int not null references person(id),
    role_id int not null references role(id)
);

create table if not exists url (
    id serial primary key not null,
    url text,
    code text,
    count_statistic int
);


