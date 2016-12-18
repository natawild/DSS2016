/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss.classes;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author gil
 */
public class Conta {
    private float totalFactura;
    private GregorianCalendar dataLimite;
    private GregorianCalendar dataPagamento;
    private String nome;
    private int tipo;
    private List<Pagamento> pagamentos;
    private float totalPago;
    private List<Pagamento> pagam;

    
    public Conta(String nome,int tipo,float totalFactura,List<Pagamento>pag,GregorianCalendar data){
    
        this.nome=nome;
        this.tipo=tipo;
        this.totalFactura=totalFactura;
        this.pagam=pag;
        this.dataLimite=data;
        this.totalPago=0;
        this.dataPagamento= new GregorianCalendar();
        this.pagamentos = new ArrayList<>();
    }
    
    
    
    public Conta () {
        
        this.totalFactura=-1;
        this.dataLimite=new GregorianCalendar();
        this.dataPagamento=new GregorianCalendar();
        this.nome="";
        this.tipo=-1;
        this.pagamentos=new ArrayList<>();
        this.totalPago=-1;
        this.pagam= new ArrayList<>();
    }
    
    public Conta(float totalFactura, GregorianCalendar dataLimite, GregorianCalendar dataPagamento, String nome, int tipo, List<Pagamento> pagamentos, float totalPago, List<Pagamento> pagam ) {
        this.totalFactura = totalFactura;
        this.dataLimite = dataLimite;
        this.dataPagamento = dataPagamento;
        this.nome = nome;
        this.tipo = tipo;
        this.pagamentos = pagamentos;
        this.totalPago = totalPago;
        this.pagam=pagam;
    }

  
    public Conta(Conta c) {
        this.totalFactura=c.getTotalFactura();
        this.totalPago=c.getTotalPago();
        this.nome=c.getNome();
        this.tipo=c.getTipo();
        this.pagamentos=c.getPagamentos();
        this.pagam=c.getPagam();
    }
    
    
    
    public void addUtilizador(Pagamento a) {
    
        this.pagam.add(a);
    }
    
    
    public void addPagamento (String e,String nome,float p) {
        this.totalPago+=p;
        Pagamento s = new Pagamento(e,nome,p);
        this.pagamentos.add(s.clone());
    }
   
    public void removePagamento(String email) {
        int i; 
        boolean para =false;
        for (i=0;i<this.pagam.size() && !para;i++) {
        
            if(this.pagam.get(i).getEmail().equals(email)) {
                this.pagam.remove(i);
                para =true;
             }
        }
    }
    
    public boolean verificaPagamento () {
        return (this.totalPago==this.totalFactura);
    }
    
    public boolean verificaTamanho() {
    
        return (this.pagam.size()==this.pagamentos.size());
    }
    

    @Override
    public String toString() {
        return "Conta:" + 
                "\n totalFactura=" + 
                totalFactura + 
                "\n dataLimite=" + 
                dataLimite + 
                "\n dataPagamento=" + 
                dataPagamento + 
                "\n nome da factura=" + nome 
                + "\n tipo da fatura=" 
                + imprimeTipo()
                + "\n pagamentos = " 
                + imprimeUtilizadoresPagaram() 
                + "\n o que deviam ter pago "+ 
                 imprimeUtilizadores() +
                "\n totalPago=" + 
                totalPago ;
        
    }
    
    public String imprimeUtilizadoresPagaram () {
    
        StringBuilder s = new StringBuilder();
        for (Pagamento a : this.pagamentos) {
        s.append(a.toString()).append("\n");
        }
        
      return s.toString();
    }
    
    public String imprimeUtilizadores(){
    
         StringBuilder s = new StringBuilder();
        for (Pagamento a : this.pagam) {
        s.append(a.toString()).append("\n");
        }
        
      return s.toString();
        
        
    
    }
    
    
    
    public String imprimeTipo() {
    
        if(this.tipo==0) {
        
            return "Recorrente";
        
        }
        else return "Extraordinaria";
    
    }
    
    
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conta other = (Conta) obj;
        if (Float.floatToIntBits(this.totalFactura) != Float.floatToIntBits(other.totalFactura)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        if (Float.floatToIntBits(this.totalPago) != Float.floatToIntBits(other.totalPago)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.dataLimite, other.dataLimite)) {
            return false;
        }
        if (!Objects.equals(this.dataPagamento, other.dataPagamento)) {
            return false;
        }
        if (!Objects.equals(this.pagamentos, other.pagamentos)) {
            return false;
        }
       
        if (!Objects.equals(this.pagam, other.pagam)) {
            return false;
        }
        
        return true;
    }

    
    public float getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(float totalFactura) {
        this.totalFactura = totalFactura;
    }

    public GregorianCalendar getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(GregorianCalendar dataLimite) {
        this.dataLimite = dataLimite;
    }

    public GregorianCalendar getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(GregorianCalendar dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public List<Pagamento> getPagamentos() {
        
       return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        
        
        this.pagamentos = pagamentos;
    }

    public float getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(float totalPago) {
        this.totalPago = totalPago;
    }

    @Override
   public Conta clone() {
   
       return new Conta(this);
   }

    public List<Pagamento> getPagam() {
        return pagam;
    }

    public void setPagam(List<Pagamento> pagam) {
        this.pagam = pagam;
    }
    
    
    
    
    
    
    
    
    
    
}
