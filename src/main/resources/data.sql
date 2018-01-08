drop database contrader;
create database contrader;

use contrader;

create table if not EXISTS contrader.gomme(
  id_gomme int(20) NOT NULL AUTO_INCREMENT,
  model varchar(50),
  manufacturer varchar(50),
  price float,
  width float,
  height float,
  diameter float,
  weight float,
  speed varchar(3),
  season varchar(50),
  type_vehicle varchar(50),
  quantity varchar(10),
  PRIMARY KEY (id_gomme)
);


insert into contrader.gomme (model, manufacturer, price, width, height, diameter, weight, speed, season, type_vehicle, quantity)
values ('Trelleborg-B50','Trelleborg',200.50,20,20,20,20,'M','Invernali','moto',20);
insert into contrader.gomme (model, manufacturer, price, width, height, diameter, weight, speed, season, type_vehicle, quantity)
values ('Trelleborg-B60','Trelleborg',100.50,30,30,30,30,'M','Estivi','auto',30);
insert into contrader.gomme (model, manufacturer, price, width, height, diameter, weight, speed, season, type_vehicle, quantity)
values ('Trelleborg-B70','Trelleborg',300.50,50,50,50,50,'W','Quattro Stagioni','commerciale',40);
insert into contrader.gomme (model, manufacturer, price, width, height, diameter, weight, speed, season, type_vehicle, quantity)
values ('Pirelli Hard','Pirelli',50.50,60,60,60,60,'W','Invernali','commerciale',50);
insert into contrader.gomme (model, manufacturer, price, width, height, diameter, weight, speed, season, type_vehicle, quantity)
values ('Pirelli Soft','Pirelli',150.50,30,30,30,30,'W','Invernali','moto',60);
insert into contrader.gomme (model, manufacturer, price, width, height, diameter, weight, speed, season, type_vehicle, quantity)
values ('Pirelli Ultra-Soft','Pirelli',134.50,50,50,50,50,'M','Estivi','auto',70);

