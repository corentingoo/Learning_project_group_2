ALTER TABLE formations
    Add date_debut varchar(25),
    Add date_fin varchar(25),
    Add teacher bigint;


alter table formations add constraint fk_teacher foreign key(teacher) references users(id_user) on delete CASCADE;


