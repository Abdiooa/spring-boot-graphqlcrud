insert into organization (name) values ('Test1');
insert into organization (name) values ('Test2');
insert into organization (name) values ('Test3');
insert into organization (name) values ('Test4');
insert into organization (name) values ('Test5');
insert into department (name, organization_id) values ('Test1', 1);
insert into department (name, organization_id) values ('Test2', 1);
insert into department (name, organization_id) values ('Test3', 1);
insert into department (name, organization_id) values ('Test4', 2);
insert into department (name, organization_id) values ('Test5', 2);
insert into department (name, organization_id) values ('Test6', 3);
insert into department (name, organization_id) values ('Test7', 4);
insert into department (name, organization_id) values ('Test8', 5);
insert into department (name, organization_id) values ('Test9', 5);
insert into employee (first_name, last_name, position, salary, age, department_id, organization_id) values ('John', 'Smith', 'Developer', 10000, 30, 1, 1);
insert into employee (first_name, last_name, position, salary, age, department_id, organization_id) values ('Adam', 'Hamilton', 'Developer', 12000, 35, 1, 1);
insert into employee (first_name, last_name, position, salary, age, department_id, organization_id) values ('Tracy', 'Smith', 'Architect', 15000, 40, 1, 1);
insert into employee (first_name, last_name, position, salary, age, department_id, organization_id) values ('Lucy', 'Kim', 'Developer', 13000, 25, 2, 1);
insert into employee (first_name, last_name, position, salary, age, department_id, organization_id) values ('Peter', 'Wright', 'Director', 50000, 50, 4, 2);
insert into employee (first_name, last_name, position, salary, age, department_id, organization_id) values ('Alan', 'Murray', 'Developer', 20000, 37, 4, 2);
insert into employee (first_name, last_name, position, salary, age, department_id, organization_id) values ('Pamela', 'Anderson', 'Analyst', 7000, 27, 4, 2);