CREATE TABLE winylla.wines (
	id int NOT NULL AUTO_INCREMENT,
    wine_name varchar(100) NOT NULL,
    color varchar(60) NOT NULL,
    country varchar(30) NOT NULL,
    sugar_content varchar(30) NOT NULL,
    grape_sort varchar(60) NOT NULL,
    aging int NOT NULL check (aging between 0 and 299),
    PRIMARY KEY (id)
);

CREATE TABLE winylla.music (
	id int NOT NULL AUTO_INCREMENT,
    artist varchar(100) NOT NULL,
    album_name varchar(60) NOT NULL,
    genre varchar(30) NOT NULL,
    year_of_issue int NOT NULL check (year_of_issue between 0 and 100),
	PRIMARY KEY (id)
);

CREATE TABLE winylla.users (
	id int NOT NULL AUTO_INCREMENT,
	user_name varchar(100) NOT NULL,
    user_password varchar(3000) NOT NULL,
    first_name varchar(100) NOT NULL,
	last_name varchar(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE winylla.posts (
	id int NOT NULL AUTO_INCREMENT,
	user_id int,
    wine_id int,
    music_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) references winylla.users(id),
    FOREIGN KEY (wine_id) references winylla.wines(id),
    FOREIGN KEY (music_id) references winylla.music(id)
    );
    