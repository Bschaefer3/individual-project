DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `username` varchar(15) DEFAULT NULL,
                        `password` varchar(30) DEFAULT NULL,
                        `firstname` varchar(25) DEFAULT NULL,
                        `lastname` varchar(30) DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `user_username_uindex` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `user` VALUES (1,'Thadius','password','Chad','Thunderjock'),(2,'Biggums','password','Honk','Biggumsworth'),
                          (3,'Kurumu','vampireslayer','Arsim','Odza');


