delimiter $$

CREATE TABLE `admin_table` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `user_table` (
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `dateofbirth` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `contact_number` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `contact_number_UNIQUE` (`contact_number`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `tailor_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(45) NOT NULL,
  `address` varchar(100) NOT NULL,
  `contact_number` varchar(13) NOT NULL,
  `working_hours` varchar(20) NOT NULL,
  `available_services` varchar(150) NOT NULL,
  `courier` tinyint(1) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_id` (`user_id`),
  CONSTRAINT `tailor_table_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_table` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `dress_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dress_type` varchar(45) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category_id` (`category_id`),
  CONSTRAINT `fk_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `tailordresstypes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dress_type_id` int(11) NOT NULL,
  `tailor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `dress_type_id_idx` (`dress_type_id`),
  KEY `fk_tailor_id_idx` (`tailor_id`),
  CONSTRAINT `fk_dress_type_id` FOREIGN KEY (`dress_type_id`) REFERENCES `dress_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tailor_id` FOREIGN KEY (`tailor_id`) REFERENCES `tailor_table` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `measurements` (
  `top_fabric` varchar(45) DEFAULT NULL,
  `top_material` varchar(45) DEFAULT NULL,
  `top_duration` varchar(45) DEFAULT NULL,
  `top_length` varchar(45) DEFAULT NULL,
  `top_quantity` varchar(45) DEFAULT NULL,
  `neck` varchar(45) DEFAULT NULL,
  `waist` varchar(45) DEFAULT NULL,
  `chest` varchar(45) DEFAULT NULL,
  `shoulder_length` varchar(45) DEFAULT NULL,
  `bottom_fabric` varchar(45) DEFAULT NULL,
  `bottom_material` varchar(45) DEFAULT NULL,
  `bottom_duration` varchar(45) DEFAULT NULL,
  `bottom_length` varchar(45) DEFAULT NULL,
  `bottom_quantity` varchar(45) DEFAULT NULL,
  `hip` varchar(45) DEFAULT NULL,
  `knee_length` varchar(45) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_measurement_idx` (`order_id`),
  CONSTRAINT `order_measurement` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `placed_date` date NOT NULL,
  `exp_delivery_date` date NOT NULL,
  `delivered_date` date NOT NULL,
  `order_status` varchar(45) NOT NULL,
  `amount` float(8,2) NOT NULL,
  `pattern_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `tailor_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `pattern_id` (`pattern_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`pattern_id`) REFERENCES `pattern` (`idpat`) ON DELETE CASCADE,
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user_table` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8$$

delimiter $$

CREATE TABLE `pattern` (
  `idpat` int(11) NOT NULL AUTO_INCREMENT,
  `caption` varchar(45) NOT NULL,
  `pat` longblob,
  `cost` float(8,2) NOT NULL,
  `dressId` int(11) NOT NULL,
  PRIMARY KEY (`idpat`),
  KEY `dressId` (`dressId`),
  CONSTRAINT `pattern_ibfk_1` FOREIGN KEY (`dressId`) REFERENCES `tailordresstypes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8$$

