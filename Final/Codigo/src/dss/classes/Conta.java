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
    private float totalPago;
    private List<Pagamento> pagam;
    private int utilizadoresPagaram;
    private int utilizadoresPagam;

    
    public Conta(String nome,int tipo,float totalFactura,List<Pagamento>pag,GregorianCalendar data
    ,int utiPagaram, int utiliPagam){
    
        this.nome=nome;
        this.tipo=tipo;
        this.totalFactura=totalFactura;
        this.pagam=pag;
        this.dataLimite=data;
        this.totalPago=0;
        this.dataPagamento= new GregorianCalendar();
        this.utilizadoresPagam=utiPagaram;
        this.utilizadoresPagam = utiliPagam;
    }
    
    
    
    public Conta () {
        
        this.totalFactura=-1;
        this.dataLimite=new GregorianCalendar();
        this.dataPagamento=new GregorianCalendar();
        this.nome="";
        this.tipo=-1;
        this.totalPago=-1;
        this.pagam= new ArrayList<>();
        this.utilizadoresPagam=-1;
        this.utilizadoresPagam = -1;
    }
    
    public Conta(float totalFactura, GregorianCalendar dataLimite, GregorianCalendar dataPagamento, 
            String nome, int tipo, float totalPago, List<Pagamento> pagam,int utiPagaram, int utiliPagam ) {
        this.totalFactura = totalFactura;
        this.dataLimite = dataLimite;
        this.dataPagamento = dataPagamento;
        this.nome = nome;
        this.tipo = tipo;
        this.totalPago = totalPago;
        this.pagam=pagam;
         this.utilizadoresPagam=utiPagaram;
        this.utilizadoresPagam = utiliPagam;
    }

  
    public Conta(Conta c) {
        this.totalFactura=c.getTotalFactura();
        this.totalPago=c.getTotalPago();
        this.nome=c.getNome();
        this.tipo=c.getTipo();
        this.pagam=c.getPagam();
         this.utilizadoresPagam=c.getUtilizadoresPagaram();
        this.utilizadoresPagam = c.getUtilizadoresPagam();
    }
    
    
    
    public void addUtilizador(Pagamento a) {
    
        this.pagam.add(a);
    }
    
    
    public void addPagamento (String e,String nome,float p) {
        this.totalPago+=p;
        Pagamento s = new Pagamento(e,nome,p);
        this.pagam.add(s.clone());
    }
   
    
    public boolean verificaPagamento () {
        return (this.totalPago==this.totalFactura);
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
                + "\n o que deviam ter pago "+ 
                 imprimeUtilizadores() +
                "\n totalPago=" + 
                totalPago ;
        
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
      
       
        if (!Objects.equals(this.pagam, other.pagam)) {
            return false;
        }
        
         if (!Objects.equals(this.utilizadoresPagam, other.utilizadoresPagam)) {
            return false;
        }
          if (!Objects.equals(this.utilizadoresPagaram, other.utilizadoresPagaram)) {
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

    public int getUtilizadoresPagaram() {
        return utilizadoresPagaram;
    }

    public int getUtilizadoresPagam() {
        return utilizadoresPagam;
    }

    public void setUtilizadoresPagaram(int utilizadoresPagaram) {
        this.utilizadoresPagaram = utilizadoresPagaram;
    }

    public void setUtilizadoresPagam(int utilizadoresPagam) {
        this.utilizadoresPagam = utilizadoresPagam;
    }
    
    public void addUtilizador() {
    
        this.utilizadoresPagaram++;
    }
    public boolean vertificaUtili() {
    
        return this.utilizadoresPagam==this.utilizadoresPagaram;
    }
    
    
    
    
    
    
    
    
    
}
