select *
from  conta;

select * from morador ;

insert into morador value(idUtilizador,'dd','2016-01-2','dsadsa','sdsa',10,'9132',null);
insert into morador value(idUtilizador,'dd','2016-01-2','dsadsa','sdsaa',10,'91322',null);
insert into morador value(idUtilizador,'dd','2016-01-2','dsadsa','s',10,'913224',null);


update morador
set email ='2'
where email = 'ola';

insert into emprestimo values (idEmprestimo,10,'2016-01-2',1);
insert into emprestimo values (idEmprestimo,10,'2016-02-2',1);
insert into emprestimo values (idEmprestimo,10,'2016-03-2',1);
insert into emprestimo values (idEmprestimo,10,'2016-04-2',1);

insert into divida values (idDivida,10,'2016-12-2',1);

select idEmprestimo, valor , dataEmprestimo from emprestimo order by dataEmprestimo ASC;

select *
from divida;

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
(idConta,'ola',1,1,'2016-02-14','2016-10-25',23,1,true,'d');

insert into pagamento value (3,3,10,10);

update conta
set dataPagamento = date(now())
where idConta=6;

select *
from pagamento;