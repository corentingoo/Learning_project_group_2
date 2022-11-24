ALTER TABLE formations
    Add date_debut date,
    Add date_fin date,
    Add teacher bigint;


alter table formations add constraint fk_teacher foreign key(teacher) references users(id_user) on delete CASCADE;


