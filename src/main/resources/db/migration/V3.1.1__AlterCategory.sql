ALTER TABLE category
    ADD CONSTRAINT uc_category_link UNIQUE (link);

ALTER TABLE category
    ADD CONSTRAINT uc_category_name_category UNIQUE (name_category);

