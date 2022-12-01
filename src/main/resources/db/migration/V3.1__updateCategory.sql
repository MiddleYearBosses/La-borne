ALTER TABLE category
alter link type char(255);



update category
set link = 'https://cdn.discordapp.com/attachments/839269329190912041/1047931379788292187/createurs.jpg'
where id_category = 1
returning *;
update category
set link = 'https://cdn.discordapp.com/attachments/839269329190912041/1047935268902158397/vetements.jpg'
where id_category = 2
returning *;
update category
set link = 'https://cdn.discordapp.com/attachments/839269329190912041/1047935268470140978/divers.jpg'
where id_category = 3
returning *;
update category
set link = 'https://cdn.discordapp.com/attachments/839269329190912041/1047935268684058666/QR.jpg'
where id_category = 4
returning *;