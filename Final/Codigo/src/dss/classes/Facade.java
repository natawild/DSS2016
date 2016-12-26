/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss.classes;

import dao.ContaDAO;
import dao.DividaDAO;
import dao.EmprestimoDAO;
import dao.MensagemDAO;
import dao.PagamentoDAO;
import dao.UtilizadorDAO;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gil
 */
public class Facade {
  
    
    
    public Facade() {
       
    }
    
    public int getLogin(String email, String pw) throws SQLException {
    
        return UtilizadorDAO.login(email,pw);
    
    }
    
    public int getCasa(String email) throws SQLException {
    
        return UtilizadorDAO.estaEmCasa(email);
    
    }
    
    public void setDinheiroConta(float valor,String email) throws SQLException {
    
      UtilizadorDAO.updateConta(valor, email);
    
    }
    
    public int inserUtilizador(Morador u) throws SQLException {
    
    
        return UtilizadorDAO.putUtilizador(u);
    }
    
    public int actualizaNome(String nomeAlterado,String emailUser) throws SQLException  {
    
        return UtilizadorDAO.updateNome(nomeAlterado, emailUser);
    }
    
    
    public int actualizarNumero(String emailUser,String numeroAlterado) throws SQLException
    {
    
        return UtilizadorDAO.updateTelemovel(emailUser,numeroAlterado);
    }
    
    public void actualizarPass(String pass,String email) throws SQLException {
    
    
         UtilizadorDAO.updatePass(pass,email);
    }
    
    public int actualizarEmail(String emailNovo,String email) throws SQLException {
    
        
        return UtilizadorDAO.updateEmail(emailNovo,email);
    
    }
    
    public Morador getMorador (String email) throws SQLException {
    
    return UtilizadorDAO.getUtilizador(email);
    
    }
    
    public void actualizaData(String emailUser,GregorianCalendar dataNascimento) throws SQLException {
    
    
         UtilizadorDAO.updateDataNascimento(emailUser, dataNascimento);
    
    }
    
    public int putAdmin(String email) throws SQLException {
    
        return UtilizadorDAO.putAdmin(email);
    }
    
    public float getDinheiro(String email) throws SQLException {
    
    
        return UtilizadorDAO.getDinheiro(email);
    }
    
    
    public List<Conta> getConta(String email) throws SQLException {
    
    
        return ContaDAO.contasPagasUser(email);
    }
    
    public String getNome(String email) throws SQLException {
    
    return UtilizadorDAO.getNome(email);
        
    }
    
    public List<Emprestimo> getEmprestimos (String email,String nome) throws SQLException {
    
    
        return EmprestimoDAO.darEmprestimosUser(email, nome);
    
    }
    
    public List<Mensagem> getMensagem(String emailUser) throws SQLException {
    
        return MensagemDAO.lerMensagem(emailUser);
    }
    
    public List<Divida> getDividas(String email,String nome) throws SQLException {
    
        return DividaDAO.apresentarDividaUser(email,nome);
    
    }
    
    public int getIdDivida(int idDivida) throws SQLException {
    
        return  DividaDAO.getIdDivida( idDivida);
    }
    
    public float getValorDivida(int idDivida) throws SQLException {
    
        return DividaDAO.valorDivida(idDivida);
    }
    
    public void pagarDivida(int idDivida) throws SQLException {
    
        DividaDAO.pagaDivida(idDivida);
    }
    
    public void pagarEmprestimo(float valor) throws SQLException {
    
        EmprestimoDAO.removeEmprestimo(valor);
    }
    
    public Map<String,Pagamento> getPagamento(int idConta) throws SQLException {
      
       return PagamentoDAO.getPagamentosConta(idConta);
        
    }
    
    public Pagamento getPagamentoUser(String email,int idConta) throws SQLException
    {
    
        return PagamentoDAO.getPagamentoUser(email,idConta);
    }
    
    public int verificaConta(String email,int idConta) throws SQLException {
    
        return PagamentoDAO.verificaIdConta(email, idConta);
    
    }
    
    public float getValorPagamento(String email,int idConta) throws SQLException {
    
         return PagamentoDAO.valorPagar(email,idConta);
    }
    
    public void pagarConta(int idConta, String email,float valor) throws SQLException {
     
        PagamentoDAO.pagarConta( idConta,  email, valor);
    }
    
    public float verUltimo(int idConta) throws SQLException {
    
        return ContaDAO.ultimoApagar(idConta);
    
    }
    
    public float valorConta(int idConta) throws SQLException {
    
    
        return ContaDAO.valorConta(idConta);
    }
    
    public void emprestimo(Emprestimo e) throws SQLException {
    
        EmprestimoDAO.putEmprestimo(e);
    
    }
    
    public void divida(Divida d) throws SQLException {
     DividaDAO.inserDivida( d);
    
    }
    
    public List<Conta> getContaPorPagar(String email) throws SQLException {
    
    
        return ContaDAO.contasPorPagarUser(email);
    }
    
    public float getValorPago(int idConta) throws SQLException {
    
    
        return ContaDAO.valorContaPago(idConta);
    }
    
  
    
    public String getEmailAdmin() throws SQLException {
    
        return UtilizadorDAO.isAdmin();
    
    }
    
    public float getSaldoGlobal() throws SQLException {
    
    
        return UtilizadorDAO.getSaldoGlobal();
    }
    
    public List<String> getUserCasa() throws SQLException {
    
      return UtilizadorDAO.emailsUserCasa();
        
    }
    
    public List<String> getUser() throws SQLException {
    
      return UtilizadorDAO.emailsUser();
        
    }
    
    public void inserCasa(String emailAdmin,String emailUser) throws SQLException {
    
        UtilizadorDAO.inserCasa(emailAdmin,emailUser);
    
    }
    
    public List<Conta> getContasPagasAdmin() throws SQLException {
    
        return ContaDAO.contasPagas();
    
    }
    
            
    public List<Conta> getContasPorPagarAdmin() throws SQLException {
    
    
        return ContaDAO.contasPorPagarAdmin ();
    }
    
    public int nrPessoasPagaram(int idConta) throws SQLException {
    
        return ContaDAO.pessoasPagaran(idConta);
        
    }
    
    public int nrPessoasApagar(int idConta) throws SQLException
    {
    
         return ContaDAO.pessoasAPagar(idConta);
        
    
    }
    
    public void pagarContaAdmin( int idConta) throws SQLException {
    
        ContaDAO.pagarConta(idConta);
    }
    
    
    public int verificaContaAdmin(int idConta) throws SQLException {
    
        return ContaDAO.verificaIdContaAdmin(idConta);
    
    }
    
    public int inserMensagem(Mensagem m,List<String> emails) throws SQLException {
    
        return MensagemDAO.put( m, emails);
    
    }
    
    public List<String> getEmailMensagem(String emailAdmin) throws SQLException {
    
    
        return UtilizadorDAO.emailsMensagem(emailAdmin);
        
    }
    
    public int removerUser(String email) throws SQLException {
    
        return UtilizadorDAO.removeUserCasa(email);
    }
    
    public int nrAdmin () throws SQLException{
    
        return UtilizadorDAO.nrAdmin();
    
    }
    
    public void inserConta (Conta conta, Map<String,Pagamento> emails) throws SQLException {
    
        ContaDAO.putConta(conta, emails);
    
    }
    
    
    public List<Emprestimo> getEmprestimoAdmin() throws SQLException {
    
        return EmprestimoDAO.darEmprestimosAdmin();
    }
    
    public void dropDivida(int divida) throws SQLException{
    
        DividaDAO.dropDivida(divida);
    
    }
    
    public List<Conta> contasTotais() throws SQLException {
    
        return ContaDAO.todasContas ();
    
    }
    
    public void apagarConta(int idConta) throws SQLException {
      
        ContaDAO.apagarConta(idConta);
        
    }
    
    public List<Divida> getDividasAdmin() throws SQLException {
    
    
        return DividaDAO.apresentarDividaAdmin();
    }
    
    public List<Emprestimo> getEmprestimosAdmin() throws SQLException {
    
    
        return EmprestimoDAO.darEmprestimosAdmin ();
    }
    
    public int getIdEmprestimo(int id) throws SQLException {
    
        return EmprestimoDAO.getIdEmprestimo(id);
    
    }
    
    public void dropEmprestimo(int id) throws SQLException {
    
        EmprestimoDAO.dropEmprestimo(id);
    
    }
    
    
    
     public  double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
}
     
     
     
     
    
    
}
