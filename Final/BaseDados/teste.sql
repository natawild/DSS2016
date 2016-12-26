select *
from  mensagemadmin;

select *
from  morador;

select *
from emprestimo;

select count(*) from morador where email='sdsaa' and admin is null;

insert into morador value(idUtilizador,'dd','2016-01-2','dsadsa','gil',10,'96132',1);
insert into morador value(idUtilizador,'dd','2016-01-2','dsadsa','sdsaa',10,'91322',1);
insert into morador value(idUtilizador,'dd','2016-01-2','dsadsa','s',10,'913224',null);
insert into morador value(idUtilizador,'andreia','2016-01-2','andreia','andreia',10,'8',1);


update morador
set morador.valorConta = 100
where idUtilizador=3;

insert into mensagem values (idMensagem,'DSA','dfs',date(now()));
insert into mensagemadmin values(7,9);
insert into mensagemadmin values(2,1);

insert into emprestimo values (idEmprestimo,10,'2016-01-2',2);
insert into emprestimo values (idEmprestimo,10,'2016-02-2',1);
insert into emprestimo values (idEmprestimo,10,'2016-03-2',1);
insert into emprestimo values (idEmprestimo,10,'2016-04-2',1);

insert into divida values (idDivida,10,'2016-12-2',1);

select idEmprestimo, valor , dataEmprestimo from emprestimo order by dataEmprestimo ASC;

select *
from divida;

delete from divida; 

select *
from conta;

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
(idConta,'ola',1,2,'2016-02-14',null,23,10,false,'d');

insert into pagamento value (11,2,-1,10);

update conta
set dataPagamento = now()
where pago = true;

SET SQL_SAFE_UPDATES=0;

SET SQL_SAFE_UPDATES=1;

update morador
set morador.valorConta=0.33333333333*3
where idUtilizador=4;


select *
from Conta;

select *
from mensagem;

select *
from pagamento;

select count(*) from morador where admin is not null