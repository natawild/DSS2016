/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.ContaDAO;
import dao.DividaDAO;
import dao.EmprestimoDAO;
import dao.PagamentoDAO;
import dss.exception.TelemoverExisteException;
import dao.UtilizadorDAO;
import dss.classes.Conta;
import dss.classes.Divida;
import dss.classes.Emprestimo;
import dss.classes.Morador;
import dss.classes.Normal;
import dss.classes.Pagamento;
import dss.exception.EmailExisteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.*;

/**
 *
 * @author gil
 */
public class DSS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)    {
        // TODO code application logic here
        try {
        //Mensagem m =new Mensagem("s", "mensagem", new GregorianCalendar());
        //List emails = new ArrayList();
        //emails.add("o");
         
        //MensagemDOA.put(m, emails);
        
        //MensagemDOA.lerMensagem("sdsfa");
        
        //MensagemDOA.put(m, emails);
        Morador u = new Normal("nome", "email","password",1000,"nrTelemovel", new GregorianCalendar());
        
        List<String> ola = new ArrayList<>();
        
        ola.add("sd");
        //UtilizadorDOA.putAdmin ("s");
            Emprestimo emp = new Emprestimo("s", "nome", 10, new GregorianCalendar()) ;
           Divida d =new Divida("s", "dd",10, new GregorianCalendar(), 1);
        
            //DividaDOA.apresentarDividaAdmin();
        
        //System.out.println(UtilizadorDOA.emailsUser());
        Conta conta = new Conta("nome", "tipo", 20, new GregorianCalendar(), 0, 1, 0);
        Map<String,Pagamento> emails = new HashMap<>();
        emails.put("s",new Pagamento("s","nome",10));
        
        //System.out.println(PagamentoDOA.getPagamentosConta(2));
        //System.out.println(ContaDOA.contasPagas());
        //System.out.println((ContaDOA.contasPorPagarUser("s")));
        //out.println(UtilizadorDOA.getNome("s"));
        //ContaDOA.contasPorPagarAdmin();
        //System.out.println(PagamentoDOA.valorPagar("s",2));
        //System.out.println(PagamentoDAO.pagarConta(2,"s",10));
        System.out.println(UtilizadorDAO.login("s", "dsadsa"));
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            
          }
        
    }
    
    
    
    
    
}
