CREATE TABLE posts
(
    id_post              BIGINT       NOT NULL,
    title                VARCHAR(255) NOT NULL,
    picture              VARCHAR(255) NOT NULL,
    description          VARCHAR(255),
    created_at           TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    category_id_category BIGINT,
    id_fix               BIGINT       NOT NULL,
    CONSTRAINT pk_posts PRIMARY KEY (id_post)
);

ALTER TABLE posts
    ADD CONSTRAINT uc_posts_picture UNIQUE (picture);

ALTER TABLE posts
    ADD CONSTRAINT FK_POSTS_ON_CATEGORY_ID_CATEGORY FOREIGN KEY (category_id_category) REFERENCES category (id_category);



