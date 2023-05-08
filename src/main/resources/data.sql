INSERT INTO `person` (
    `id`,
    `address`,
    `dni_number`,
    `id_dni_type`,
    `id_person_type`,
    `mail`,
    `name`,
    `password`,
    `phone`,
    `surname`,
    `token_password`
  )
VALUES
  (
    '1',
    'st 123 # 456',
    '123',
    '1',
    '1',
    'email@some.com',
    'Name',
    '$2a$10$GlsGSNhkbVon6ZOSNMptOu5RikedRzlCAhMa7YpwvUSS0c88WT99S',
    '1234567890',
    'Surname',
    NULL
  );




INSERT INTO `user` (`id_person`, `id_role`) VALUES ('1', '1');


INSERT INTO `role` (`id`, `description`, `name`) VALUES ('1', 'ADMIN', 'ADMIN');
INSERT INTO `role` (`id`, `description`, `name`) VALUES ('2', 'OWNER', 'OWNER');
INSERT INTO `role` (`id`, `description`, `name`) VALUES ('3', 'EMPLOYEE', 'EMPLOYEE');
INSERT INTO `role` (`id`, `description`, `name`) VALUES ('4', 'CUSTOMER', 'CUSTOMER');