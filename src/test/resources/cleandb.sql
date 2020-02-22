SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS users;
CREATE TABLE `users` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `username` varchar(15) DEFAULT NULL,
                         `password` varchar(30) DEFAULT NULL,
                         `firstname` varchar(25) DEFAULT NULL,
                         `lastname` varchar(30) DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `user_username_uindex` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO users VALUES (1,'Thadius','password','Chad','Thunderjock'),(2,'Biggums','password','Honk','Biggumsworth'),
                         (3,'Kurumu','vampireslayer','Arsim','Odza');


DROP TABLE IF EXISTS `tasks`;
CREATE TABLE `tasks` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `user_id` int(11) NOT NULL,
                         `task` varchar(300) DEFAULT NULL,
                         `completion` tinyint(1) DEFAULT '0',
                         PRIMARY KEY (`id`),
                         KEY `tasks_user_id_fk` (`user_id`),
                         CONSTRAINT `tasks_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='User Task List';

INSERT INTO tasks VALUES (0, 1, 'Talk to Piety', 0),(0, 2, 'Kill Kitava', 0);

SET FOREIGN_KEY_CHECKS = 1;
