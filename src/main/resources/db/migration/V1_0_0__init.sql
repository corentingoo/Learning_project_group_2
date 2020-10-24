create table roles (
    id_user bigint not null,
    role varchar(255) not null
) engine=InnoDB;

create table users (
    id_user bigint not null,
    account_non_expired bit,
    account_non_locked bit,
    credentials_non_expired bit,
    enabled bit,
    firstname varchar(255) not null,
    lastname varchar(255) not null,
    password varchar(255) not null,
    username varchar(255) not null,
    primary key (id_user)
) engine=InnoDB;

create index INDEX_USER_ROLE on roles (id_user);

alter table users add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);
alter table roles add constraint FK40d4m5dluy4a79sk18r064avh foreign key (id_user) references users (id_user);