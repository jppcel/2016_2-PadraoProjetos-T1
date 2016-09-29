INSERT INTO tipoConta values 
(1, 'Conta Corrente', 'CC'), 
(2, 'Conta Poupança', 'CP'), 
(3, 'Conta Eletrônica', 'CE');
INSERT INTO tipoUsuario values 
(1, 'Cliente'), 
(2, 'Bancário');
INSERT INTO tipoOperacao values 
(1, 'Saque'),
(2, 'Depósito'),
(3, 'Transferência');
INSERT INTO genero values 
(1, 'Masculino'), 
(2, 'Feminino'), 
(3, 'Indefinido');
INSERT INTO pessoa values 
(1, 'João da Silva', '1980-06-14', '506.681.962-20', 1, '2016-09-25 21:34:02');
INSERT INTO agencia values 
(1, 'Cascavel/PR Centro', '0001', 'Cascavel/PR', '0003', 100.00), 
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
(1, 1, '0001', 1, 100.00, '2016-09-25 21:37:32'),
(2, 1, '0002', 2, 0.00, '2016-09-25 21:37:32'),
(3, 1, '0003', 3, 0.00, '2016-09-25 21:37:32');
INSERT INTO usuario values 
(1, 1, 'jsilva', 'ab0bfc25edc26b6229b3f5428c1494ad', '25d55ad283aa400af464c76d713c07ad', 2, null, '2016-09-25 21:36:20', null, null, 'TRUE'), 
(2, 1, 'jsilva1', 'a94ed5df1dc87c84666fe6d2072f282c68b4cb2a', 'a126a23190fe474e8ef5eca8a57a80aed901fd05', 1, 1, '2016-09-25 21:37:32', null, null, 'TRUE'),
(3, 1, 'jsilva2', '40d5b81243256168bd7c508f4d5b0ba701243a96', 'ad96e3bae371d730bd4c3b0382b704086ae7ae37', 1, 2, '2016-09-25 21:37:32', null, null, 'TRUE'),
(4, 1, 'jsilva3', '89042cc13fa556d8f362387156c6a4cc7f3e0166', '2a15da05f6bd8570220b02d09975f2bd3873bb4', 1, 3, '2016-09-25 21:37:32', null, null, 'TRUE');
INSERT INTO movimentacao values
(1, 1, 2, 2, 100.00, '2016-09-25 21:37:32', null);

