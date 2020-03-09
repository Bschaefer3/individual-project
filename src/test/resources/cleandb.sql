SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `builds`;
CREATE TABLE `builds` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `user_id` int(11) DEFAULT NULL,
                          `build` varchar(300) DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          KEY `builds_users_id_fk` (`user_id`),
                          CONSTRAINT `builds_users_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `itemsAPI`;
CREATE TABLE `itemsAPI` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `item_id` int(11) DEFAULT NULL,
                            `name` varchar(300) DEFAULT NULL,
                            `description` varchar(300) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `items_builds_join`;
CREATE TABLE `items_builds_join` (
                                     `id` int(11) NOT NULL AUTO_INCREMENT,
                                     `build_id` int(11) DEFAULT NULL,
                                     `item_id` int(11) DEFAULT NULL,
                                     PRIMARY KEY (`id`),
                                     KEY `table_name_builds_id_fk` (`build_id`),
                                     KEY `table_name_itemAPI_id_fk` (`item_id`),
                                     CONSTRAINT `table_name_builds_id_fk` FOREIGN KEY (`build_id`) REFERENCES `builds` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                     CONSTRAINT `table_name_itemAPI_id_fk` FOREIGN KEY (`item_id`) REFERENCES `itemsAPI` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `ranks`;
CREATE TABLE `ranks` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `title` varchar(30) DEFAULT NULL,
                         `username` varchar(15) DEFAULT NULL,
                         `user_id` int(11) DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         KEY `ranks_users_id_fk` (`user_id`),
                         CONSTRAINT `ranks_users_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO ranks VALUES (0, 'admin', 'Biggums', 2);


DROP TABLE IF EXISTS `stashAPI`;
CREATE TABLE `stashAPI` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `item_id` int(11) DEFAULT NULL,
                            `stashcode` int(11) DEFAULT NULL,
                            `playercode` int(11) DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            KEY `stashAPI_itemsAPI_id_fk` (`item_id`),
                            CONSTRAINT `stashAPI_itemsAPI_id_fk` FOREIGN KEY (`item_id`) REFERENCES `itemsAPI` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `tasks`;
CREATE TABLE `tasks` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `user_id` int(11) NOT NULL,
                         `task` varchar(300) DEFAULT NULL,
                         `completion` tinyint(1) DEFAULT '0',
                         PRIMARY KEY (`id`),
                         KEY `tasks_user_id_fk` (`user_id`),
                         CONSTRAINT `tasks_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='User Task List';

INSERT INTO `tasks` VALUES (1,1,'Talk to Piety',0),(2,2,'Kill Kitava',0),(3,2,'Reach act 6',0);


DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `username` varchar(15) DEFAULT NULL,
                         `password` varchar(300) DEFAULT NULL,
                         `firstname` varchar(25) DEFAULT NULL,
                         `lastname` varchar(30) DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `user_username_uindex` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `users` VALUES (1,'thadius','password1','Chad','Thunderjock'),(2,'biggums','password2','Honk','Biggumsworth'),(3,'kurumu','password3','Arsim','Odza');

SET FOREIGN_KEY_CHECKS = 1;
