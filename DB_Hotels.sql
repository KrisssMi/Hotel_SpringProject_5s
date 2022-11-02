create database Hotels;
use Hotels;
use master;

CREATE TABLE Users
(
Id int primary key auto_increment,
IsAdmin bool NOT NULL default '0',
UserLogin varchar(25) NOT NULL UNIQUE,
UserPassword varchar(60)  NOT NULL UNIQUE,
EMail nvarchar(254)  NOT NULL UNIQUE
);


CREATE TABLE Hotels
(
Id int primary key auto_increment,
Rooms int NOT NULL,
Rating decimal(2,1) NOT NULL,
Description varchar(500) NOT NULL
);

CREATE TABLE Feedbacks
(
Id int primary key auto_increment,
UserId int NOT NULL,
HotelId int NOT NULL,
FeedbackDate date NOT NULL,
Comment varchar(500) NOT NULL,
foreign key (UserId) references Users(Id), 
foreign key (HotelId) references Hotels(Id)
)