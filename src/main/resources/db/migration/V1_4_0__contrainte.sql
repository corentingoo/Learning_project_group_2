
create index INDEX_INSCRIPTION_USER on users (id_user);
create index INDEX_INSCRIPTION_FORMATION on formations (formation_id);

alter table inscriptions add constraint FK_insc_form foreign key (student_id) references users (id_user);
alter table inscriptions add constraint FK_insc_us foreign key (formation_id) references formations (formation_id);
