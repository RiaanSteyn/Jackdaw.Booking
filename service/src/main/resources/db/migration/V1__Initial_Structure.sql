CREATE TABLE room(
    `id` INT NOT NULL AUTO_INCREMENT,
    `description` TEXT NOT NULL,
    `price` FLOAT NOT NULL,
    `beds` INT NOT NULL,
    PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE guest(
    `id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(35) NOT NULL,
    `surname` VARCHAR(35) NOT NULL,
    `cellphone_number` VARCHAR(128) NOT NULL,
    `email` VARCHAR(50) NOT NULL,
    PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE booking(
    `id` INT NOT NULL AUTO_INCREMENT,
    `guest_id` INT NOT NULL,
    `room_id` INT NOT NULL,
    `check_in_date` DATETIME NOT NULL,
    `check_out_date` DATETIME NOT NULL,
    `deposit_amount` FLOAT,
    `total` FLOAT,
    PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE bed(
    `id` INT NOT NULL AUTO_INCREMENT,
    `description` TEXT NOT NULL,
    `size` INT NOT NULL,
    `beds` INT NOT NULL,
    PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;