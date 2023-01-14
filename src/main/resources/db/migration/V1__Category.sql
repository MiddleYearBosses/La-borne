CREATE TABLE IF NOT EXISTS category  (
                                         id_category SERIAL PRIMARY KEY,
                                         name_category varchar(15),
                                         link varchar(62)
);

insert into category(name_category,link)  values ('Stylistes','img/createurs.jpg');
insert into category(name_category,link)  values ('Vêtements','img/vetements.jpg');
insert into category(name_category,link)  values ('Divers','img/divers.jpg');
insert into category(name_category,link)  values ('QR codes','img/QR.jpg');
