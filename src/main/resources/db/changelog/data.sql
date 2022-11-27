insert into customer
values (1,'Человек1', 'Адрес1'),
       (2,'Человек2', 'Адрес2'),
       (3,'Человек3', 'Адрес3'),
       (4,'Человек4', 'Адрес4'),
       (5,'Человек5', 'Адрес5'),
       (6,'Человек6', 'Адрес6');

insert into category
values (1, null, 'Игрушки'),
       (2, 1, 'Конструктор'),
       (3, 1, 'Машины'),
       (4, null, 'Одежда'),
       (5, 4, 'Платья'),
       (6, 4, 'Рубашки');

insert into product
values (1, 2, 'Конструктор1', true, 105.22, 10),
       (2, 2, 'Конструктор2', true, 199.99, 10),
       (3, 3, 'Грузовик1', true, 97.55, 10),
       (4, 5, 'Платье1', true, 205.36, 10),
       (5, 6, 'Рубашка1', true, 230.78, 10),
       (6, 6, 'Рубашка2', true, 200.75, 10);
insert into delivery
values (1,'Самовывоз'),
       (2, 'Курьером');

insert into order_status
values (1, null,'Оформлен'),
       (2, null,'Принят'),
       (3, null,'Оплачен'),
       (4, null,'Получен'),
       (5, 1,'Готов к выдаче'),
       (6, 2,'Передан курьеру');




