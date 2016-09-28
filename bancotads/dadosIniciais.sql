INSERT INTO tipoConta values 
(1, 'Conta Corrente'), 
(2, 'Conta Poupança'), 
(3, 'Conta Eletrônica');
INSERT INTO tipoUsuario values 
(1, 'Cliente'), 
(2, 'Bancário');
INSERT INTO genero values 
(1, 'Masculino'), 
(2, 'Feminino'), 
(3, 'Indefinido');
INSERT INTO pessoa values 
(1, 'João da Silva', '1980-06-14', '506.681.962-20', 1, '2016-09-25 21:34:02');
INSERT INTO agencia values 
(1, 'Cascavel/PR Centro', '0001', 'Cascavel/PR', '0001', 0.00), 
(2, 'Corbélia Centro', '0002', 'Corbélia/PR', null,  0.00), 
(3, 'São Paulo/SP Centro', '1001', 'São Paulo/SP', null, 0.00), 
(4, 'Salvador Centro', '2001', 'Salvador/BA', null, 0.00), 
(5, 'Palmas/TO Praia da Graciosa', '3001', 'Palmas/TO', null, 0.00), 
(6, 'Goiânia Centro', '4001', 'Goiânia/GO', null, 0.00), 
(7, 'Araguaína São João', '3002', 'Araguaína/TO', null, 0.00), 
(8, 'Cascavel/PR Cataratas', '0003', 'Cascavel/PR', null, 0.00), 
(9, 'Cascavel/PR Guarujá', '0004', 'Cascavel/PR', null, 0.00), 
(10, 'Foz do Iguaçu Vila A', '0005', 'Foz do Iguaçu/PR', null, 0.00);
INSERT INTO conta values 
(1, 1, '0001', 1, 0.00, '2016-09-25 21:37:32');
INSERT INTO usuario values 
(1, 1, 'jsilva', 'ab0bfc25edc26b6229b3f5428c1494ad', '25d55ad283aa400af464c76d713c07ad', 2, null, '2016-09-25 21:36:20', null, null, 'TRUE'), 
(2, 1, 'jdsilva', '3150167f31615f472f67fb4724eac9e2b37b04e1', '2d20df56611655df809e38467aabb14f508b4115', 1, 1, '2016-09-25 21:37:32', null, null, 'TRUE');

