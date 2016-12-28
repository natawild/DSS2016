select *
from  mensagemadmin;

select *
from  morador;

select *
from emprestimo;

select sum(valorConta) from morador where  admin is not null;

select count(*) from morador where email='sdsaa' and admin is null;

insert into morador value(idUtilizador,'dd','2016-01-2','dsadsa','gil',10,'96132',1);
insert into morador value(idUtilizador,'dd','2016-01-2','dsadsa','sdsaa',10,'91322',1);
insert into morador value(idUtilizador,'dd','2016-01-2','dsadsa','s',10,'913224',null);
insert into morador value(idUtilizador,'andreia','2016-01-2','andreia','andreia',10,'8',1);

delete from emprestimo
        where valor=10
     limit 1;   


update morador
set admin=null
where admin is not null and idUtilizador!=1;

insert into mensagem values (idMensagem,'DSA','dfs',date(now()));
insert into mensagemadmin values(7,9);
insert into mensagemadmin values(2,1);

insert into emprestimo values (idEmprestimo,5,'2016-01-2',2);
insert into emprestimo values (idEmprestimo,10,'2016-02-2',1);
insert into emprestimo values (idEmprestimo,10,'2016-03-2',1);
insert into emprestimo values (idEmprestimo,10,'2016-04-2',1);

insert into divida values (idDivida,10,'2016-12-2',4);

select * from emprestimo order by dataEmprestimo ASC;

select *
from divida;

delete from divida; 

select *
from conta;

update conta
set dataPagamento = date(now())
where pago = true;

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
(idConta,'ola',1,10,'2016-02-14',null,230,10,false,'d');

insert into pagamento value (20,1,10,10);
insert into pagamento value (20,2,15,10);

update pagamento 
set pagamento.valorPago=10
where idConta=2 and idUtilizador=1;

insert into divida values (idDivida,5,'2016-12-2',4);



delete from conta where idConta=2;

update conta 
set pago =true
where idConta=2;


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