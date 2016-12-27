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
(idUtilizador,'ricardo','1994-1-10','ricardo','ricardo@email',10,'910322628',null),
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









