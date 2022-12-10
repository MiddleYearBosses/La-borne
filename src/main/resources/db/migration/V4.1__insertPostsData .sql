CREATE TABLE posts
(
    id_post              SERIAL PRIMARY KEY,
    title                VARCHAR(255) NOT NULL,
    picture              VARCHAR(255) NOT NULL,
    description          VARCHAR(255),
    created_at           TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    category_id_category BIGINT
);

ALTER TABLE posts
    ADD CONSTRAINT uc_posts_picture UNIQUE (picture);

ALTER TABLE posts
    ADD CONSTRAINT FK_POSTS_ON_CATEGORY_ID_CATEGORY FOREIGN KEY (category_id_category) REFERENCES category (id_category);


insert into posts(title, picture, description, created_at,category_id_category) values ('Lyssia','https://cdn.discordapp.com/attachments/839269329190912041/1050787287203577967/moi.jpg','Ajoutez moi !','2022-12-09','1');
insert into posts(title, picture, description, created_at,category_id_category) values ('Pull Serpentard','https://cdn.discordapp.com/attachments/839269329190912041/1050739626790367252/pull.jpg','Pull Serpentard réalisé par mes soins ! Servez-vous!','2022-12-09','2');
insert into posts(title, picture, description, created_at,category_id_category) values ('Cape Serpentard','https://cdn.discordapp.com/attachments/839269329190912041/1050739540391886869/cape.jpg','Cape Serpentard réalisé par mes soins ! Servez-vous!','2022-12-09','2');
insert into posts(title, picture, description, created_at,category_id_category) values ('Sol en pierre','https://cdn.discordapp.com/attachments/839269329190912041/1050739539968274513/sol2.jpg','Sol en îerre réalisé par mes soins ! Servez-vous!','2022-12-09','3');
