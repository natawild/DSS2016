

drop trigger apagaConta ;

DELIMITER $$
create trigger apagaConta
before delete on Conta
for each row
begin
DECLARE done BOOL DEFAULT 0;

declare idUtilizador1 int;
declare valorPago1,valorApagar1 decimal(21,11) ;

DECLARE cur1 CURSOR FOR SELECT idUtilizador,valorPago,valorApagar
                          from pagamento as P
                          where P.idConta=OLD.idConta;

DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;                                                   
                                                    
OPEN cur1;

 read_loop: LOOP
 
 FETCH cur1 into idUtilizador1,valorPago1,valorApagar1 ;   

IF done THEN
      LEAVE read_loop;
     end if;


if OLD.pago !=true
   
   then if valorPago1>-1
         
         then  
              update morador
			  set morador.valorConta = morador.valorConta +valorPago1
              where morador.idUtilizador=idUtilizador1;
          
          if (valorPago1 -valorApagar1) >0 
            then 
                delete from emprestimo 
                       where emprestimo.valor =(valorPago1 -valorApagar1) and emprestimo.idUtilizador=idUtilizador1
                        limit 1;
          
          else if  (valorPago1 -valorApagar1) <0
                   then
                   delete from divida 
                          where valorDivida =(valorApagar1-valorPago1) and divida.idUtilizador=idUtilizador1
                          limit 1;

                
                end if;
              
          end if;
          
          
          
         end if;


END IF;

END loop;

CLOSE cur1;

END $$ 
