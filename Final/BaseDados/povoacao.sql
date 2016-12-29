INSERT INTO `dss`.`morador`
(`idUtilizador`,
`nome`,
`dataNascimento`,
`password`,
`email`,
`valorConta`,
`nrTelemovel`,
`admin`)
VALUES
(idUtilizador,'gil','1994-1-10','gil','gil@email',10,'910322618',1),
(idUtilizador,'celia','1992-12-24','celia','celia@email',10,'910322718',1),
(idUtilizador,'daniel','1994-2-10','daniel','daniel@email',10,'910322619',1),
(idUtilizador,'ricardo','1994-1-10','ricardo','ricardo@email',10,'910322628',1),
(idUtilizador,'humberto','1992-1-10','humberto','humberto@email',10,'910332618',null),
(idUtilizador,'marcia','1996-1-10','marcia','marcia@email',10,'911322618',null);

INSERT INTO `dss`.`mensagem`
(`idMensagem`,
`Assunto`,
`mensagem`,
`dataMensagem`)
VALUES
(idMensagem,'Depositar dinheiro','Estamos com pouco dinheiro',date(now())),
(idMensagem,'Pagar a conta','Tens de pagar a conta','2015-1-14'),
(idMensagem,'O humberto partiu a televisao','O Humberto partiu a televisao ricardo tens de a pagar','2016-1-12'),
(idMensagem,'Falta papel','E preciso comprar paper higienico','2016-2-10'),
(idMensagem,'Apaguei a tua divida','Apaguei a tua divida de ontem','2016-12-25');



INSERT INTO `dss`.`conta`
(`idConta`,
`nome`,
`nrPessoasPagaram`,
`nrPessoasApagar`,
`dataLimite`,
`dataPagamento`,
`totalConta`,
`totalContaPago`,
`pago`,
`tipo`)
VALUES
(idConta,'Conta da água',4,4,'2016-10-11','2016-10-9',20,20,true,'Recorrente'),
(idConta,'Conta da Televisão',1,1,'2016-9-11','2016-9-9',100,100,true,'Extraordinaria'),
(idConta,'Conta da luz',4,4,'2016-08-10','2016-08-9',24,24,true,'Recorrente'),
(idConta,'Conta do papél higienico',4,4,'2016-09-11','2016-09-10',2,2,true,'Recorrente'),
(idConta,'Conta da luz',4,4,'2016-01-11','2016-01-9',30,30,true,'Recorrente'),
(idConta,'Conta da caldeira',4,4,'2016-10-11','2016-10-9',10,10,true,'Extraordinaria'),
(idConta,'Conta da água',3,4,'2016-10-11',null,10,10,false,'Recorrente'),
(idConta,'Conta da água',0,1,'2016-10-13',null,10,0,false,'Extraordinaria'),
(idConta,'Conta da água',0,4,'2016-10-12',null,10,0,false,'Recorrente')
(idConta,'Conta da água',4,4,'2016-10-11','2016-10-9',40,40,true,'Recorrente');







INSERT INTO `dss`.`divida`
(`idDivida`,
`valorDivida`,
`dataDivida`,
`idUtilizador`)
VALUES
(idDivida,10,'2016-03-13',1),
(idDivida,5,'2016-02-12',1),
(idDivida,4,'2016-01-11',1),
(idDivida,15,'2016-02-10',2),
(idDivida,10,'2016-03-9',2),
(idDivida,10,'2016-04-8',2),
(idDivida,10,'2016-05-7',2),
(idDivida,10,'2016-05-6',3);


INSERT INTO `dss`.`emprestimo`
(`idEmprestimo`,
`valor`,
`dataEmprestimo`,
`idUtilizador`)
VALUES
(idEmprestimo,10,'2016-03-14',2),
(idEmprestimo,5,'2016-02-13',2),
(idEmprestimo,4,'2016-01-12',2),
(idEmprestimo,10,'2016-02-01',1),
(idEmprestimo,10,'2016-03-10',1),
(idEmprestimo,10,'2016-04-9',1),
(idEmprestimo,10,'2016-05-6',1),
(idEmprestimo,10,'2016-05-7',2);




INSERT INTO `dss`.`mensagemadmin`
(`idMensagem`,
`idUtilizador`)
VALUES
(1,2),
(1,3),
(1,4),
(3,4),
(5,2),
(2,2);



INSERT INTO `dss`.`pagamento`
(`idConta`,
`idUtilizador`,
`valorPago`,
`valorApagar`)
VALUES
(1,1,5,5),
(1,2,5,5),
(1,3,5,5),
(1,4,5,5),
(8,1,-1,10),
(2,1,1,100),
(3,1,6,6),
(3,2,6,6),
(3,3,6,6),
(3,4,6,6),
(4,1,0.5,0.5),
(4,2,0.5,0.5),
(4,3,0.5,0.5),
(4,4,0.5,0.5);

