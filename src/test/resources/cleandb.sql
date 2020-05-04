SET FOREIGN_KEY_CHECKS = 0;


--
-- Table structure for table `builds`
--

DROP TABLE IF EXISTS `builds`;
CREATE TABLE `builds` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `user_id` int DEFAULT NULL,
                          `username` varchar(300) DEFAULT NULL,
                          `build` varchar(300) DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          KEY `builds_users_id_fk` (`user_id`),
                          CONSTRAINT `builds_users_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `builds`
--

INSERT INTO `builds` VALUES (1,1,'thadius','My build will be a critical based cleave build! It will work like this...'),(2,3,'kurumu','I don\'t know what my build will be just yet.');

--
-- Table structure for table `itemsAPI`
--

DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `itemid` int DEFAULT NULL,
                            `name` varchar(300) DEFAULT NULL,
                            `image` varchar(600) DEFAULT NULL,
                            `category` varchar(300) DEFAULT NULL,
                            `type` varchar(300) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `itemsAPI`
--

INSERT INTO `items` VALUES (1,259,'Voidforge','http://web.poecdn.com/image/Art/2DItems/Weapons/TwoHandWeapons/TwoHandSwords/Starforge.png?scale=1&w=2&h=4','weapon','twosword');

--
-- Table structure for table `items_builds_join`
--

DROP TABLE IF EXISTS `items_builds_join`;
CREATE TABLE `items_builds_join` (
                                     `id` int NOT NULL AUTO_INCREMENT,
                                     `buildid` int DEFAULT NULL,
                                     `itemid` int DEFAULT NULL,
                                     PRIMARY KEY (`id`),
                                     KEY `join_builds_id_fk` (`buildid`),
                                     KEY `join_items_id_fk` (`itemid`),
                                     CONSTRAINT `join_builds_id_fk` FOREIGN KEY (`buildid`) REFERENCES `builds` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                     CONSTRAINT `join_items_id_fk` FOREIGN KEY (`itemid`) REFERENCES `items` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `items_builds_join`
--

INSERT INTO `items_builds_join` VALUES (1,1,1),(2,2,1);

--
-- Table structure for table `ranks`
--

DROP TABLE IF EXISTS `ranks`;
CREATE TABLE `ranks` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `title` varchar(30) DEFAULT NULL,
                         `username` varchar(15) DEFAULT NULL,
                         `user_id` int DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         KEY `ranks_users_id_fk` (`user_id`),
                         CONSTRAINT `ranks_users_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `ranks`
--

INSERT INTO `ranks` VALUES (1,'admin','biggums',2);

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
CREATE TABLE `tasks` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `user_id` int NOT NULL,
                         `username` varchar(300) DEFAULT NULL,
                         `task` varchar(300) DEFAULT NULL,
                         `completion` tinyint(1) DEFAULT '0',
                         PRIMARY KEY (`id`),
                         KEY `tasks_user_id_fk` (`user_id`),
                         CONSTRAINT `tasks_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='User Task List';

--
-- Dumping data for table `tasks`
--

INSERT INTO `tasks` VALUES (1,1,'thadius','Talk to Piety',0),(2,2,'biggums','Kill Kitava',0),(3,2,'biggums','Reach act 6',0);

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `username` varchar(15) DEFAULT NULL,
                         `password` varchar(300) DEFAULT NULL,
                         `firstname` varchar(25) DEFAULT NULL,
                         `lastname` varchar(30) DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `user_username_uindex` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` VALUES (1,'thadius','password1','Chad','Thunderjock'),(2,'biggums','password2','Honk','Biggumsworth'),(3,'kurumu','password3','Arsim','Odza');


SET FOREIGN_KEY_CHECKS = 1;
