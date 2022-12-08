create table if not exists roles (
    id_user bigint not null,
    role varchar(255) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table if not exists users (
    id_user bigint not null AUTO_INCREMENT,
    account_non_expired bit,
    account_non_locked bit,
    credentials_non_expired bit,
    enabled bit,
    firstname varchar(255) not null,
    lastname varchar(255) not null,
    password varchar(255),
    username varchar(255) not null,
    email varchar(255) not null,
    token varchar(50),
    primary key (id_user)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create index INDEX_USER_ROLE on roles (id_user);

alter table users add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);
alter table roles add constraint FK40d4m5dluy4a79sk18r064avh foreign key (id_user) references users (id_user);