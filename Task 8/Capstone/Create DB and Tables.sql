create database if not exists poiseprojects_db;

create table ERFNumbers
(Address varchar(100),
ERFNumber varchar(10),
primary key(Address));

create table Architects
(Name varchar(50),
Tel varchar(10),
Email varchar(50),
Address varchar(100),
primary key(Name));

create table Customers
(Name varchar(50),
Tel varchar(10),
Email varchar(50),
Address varchar(100),
primary key(Name));

create table Contractors
(Name varchar(50),
Tel varchar(10),
Email varchar(50),
Address varchar(100),
primary key(Name));

create table Projects
(Number varchar(15) UNIQUE,
Name varchar(50),
BuildingType varchar(50),
Address varchar(100),
TotalFee float,
PaidToDate float,
DeadLine Date,
CompletionDate Date,
ContractorName varchar(50) UNIQUE,
ArchitectName varchar(50) UNIQUE,
CustomerName varchar(50) UNIQUE,
Finalised varchar(5),
primary key (Number),
foreign key (Address) references ERFNumbers(Address),
foreign key (ContractorName) references Contractors(Name),
foreign key (ArchitectName) references Architects(Name),
foreign key (CustomerName) references Customers(Name));

insert into ERFNumbers values('123 Cherry street', '32452');
insert into ERFNumbers values('144 Dave ave', '14867');
insert into ERFNumbers values('987 Micheal Lane', '54871');
select * from ERFNumbers;

insert into Contractors values('Micheal', '0765472987', 'micheal@concor.co.za', '741 6th Lane');
insert into Contractors values('Sandra', '0748695214', 'sandra@wecontract.co.za', '7 Greek street');
insert into Contractors values('Margret', '078742536', 'margret@hello.co.za', '58 Bacon street');
select * from Contractors;

insert into Architects values('Matt', '0642518794', 'matthew@techbizz.co.za', '55 Pie Road');
insert into Architects values('Sally', '0613524687', 'Sally@architects.co.za', '6556 Main road');
insert into Architects values('Peter', '0872546983', 'peter@petertects.co.za', '874 Kudo Ave');
select * from Architects;

insert into Customers values('Jesse', '0846521365', 'jesse@gmail.com', '8547 Tent lane');
insert into Customers values('Brandon', '0845211478', 'brnadon5@gmail.com', '18 Black Street');
insert into Customers values('Hendry', '0775841236', 'hendry215@gmail.com', '154 Mankin Lane');
select * from Customers;

insert into projects values(
'1001',
'House Jesse',
'House',
'123 Cherry street',
2000000,
1000000,
'2022-08-21',
NULL,
'Micheal',
'Matt',
'Jesse',
'false');

insert into projects values(
'1002',
'Apartment Brandon',
'Apartment',
'144 Dave ave',
1500000,
300000,
'2022-08-21',
NULL,
'Sandra',
'Sally',
'Brandon',
'false');

insert into projects values(
'1003',
'House Hendry',
'House',
'987 Micheal Lane',
3000000,
750000,
'2022-09-29',
NULL,
'Margret',
'Peter',
'Hendry',
'false');