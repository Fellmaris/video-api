INSERT INTO videos (id, name, category, description, fullvideofilename, fullimagefilename) VALUES
('a5685360-e619-4b54-a26a-a1ec4ca53e45', 'Name1', 'Fire', 'First fire performance', '45188800_video1.mp4', '999851700_1806954.jpg'),
('15a95af7-8b83-4a08-8001-0f865db8ea27', 'Name2', 'Fire', 'Second fire performance', '519287100_video2.mp4', '999851700_1806954.jpg'),
('ebdee4f9-5763-4afc-85ed-98b2fdefb35f', 'Name3', 'Fire', 'Third fire performance', '300539500_video3.mp4', '999851700_1806954.jpg');


INSERT INTO users(id, username, name, surname, password) VALUES
('c2aa5f20-2441-40f8-8cce-d31dbd17bc84', 'user', 'Useris', 'Useriauskas',  '{bcrypt}$2a$10$amFqbdk0pe7wqp9ufEcHOu9t48Sp9NptByAqW0Ak5dTV9JHp/dapm'), /*pass->user*/
('bd8968db-ad2a-4dd0-a0ab-7eebcc05427e', 'admin', 'Adminas', 'Adminauskas', '{bcrypt}$2a$10$/kcDI78qGnRwg0R1ullGCerGpKuH1/7kxYHIYTrPa8GkLnlIZBW0K'); /*pass->admin*/


INSERT INTO roles(id, name) VALUES
('60dbb7bb-99a0-42eb-a837-8be6b697c074', 'USER'),
('3906c549-44bf-494b-9537-5e1658a029a8', 'ADMIN');

INSERT INTO users_roles(user_id, roles_id) VALUES
('c2aa5f20-2441-40f8-8cce-d31dbd17bc84', '60dbb7bb-99a0-42eb-a837-8be6b697c074'),
('bd8968db-ad2a-4dd0-a0ab-7eebcc05427e', '60dbb7bb-99a0-42eb-a837-8be6b697c074'),
('bd8968db-ad2a-4dd0-a0ab-7eebcc05427e', '3906c549-44bf-494b-9537-5e1658a029a8');
