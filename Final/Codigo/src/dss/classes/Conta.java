/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss.classes;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author gil
 * utilizadoresPagaram nr utilizadores que pagaram
 * utilizadoresPagam nr utilizadores que tem de pagar
 */
public class Conta {
    private float totalFactura;
    private GregorianCalendar dataLimite;
    private GregorianCalendar dataPagamento;
    private String nome;
    private String tipo;
    private float totalPago;
    private Map<String,Pagamento> pagam;
    private int utilizadoresPagaram;
    private int utilizadoresPagam;
    private int identificador;

    
    public Conta(String nome,String tipo,float totalFactura,GregorianCalendar data
    ,int utiPagaram, int utiliPagam,int identificador){
    
        this.nome=nome;
        this.tipo=tipo;
        this.totalFactura=totalFactura;
        this.pagam=new HashMap<>();
        this.dataLimite=data;
        this.totalPago=0;
        this.dataPagamento= new GregorianCalendar();
        this.utilizadoresPagaram=utiPagaram;
        this.utilizadoresPagam = utiliPagam;
        this.identificador=identificador;
    }
    
    
     public Conta(String nome,String tipo,float totalFactura,GregorianCalendar data
    ,int utiPagaram, int utiliPagam,int identificador,float totalFacturaPago){
        
        this.nome=nome;
        this.tipo=tipo;
        this.totalFactura=totalFactura;
        this.pagam=new HashMap<>();
        this.dataLimite=data;
        this.totalPago=totalFacturaPago;
        this.dataPagamento= new GregorianCalendar();
        this.utilizadoresPagaram=utiPagaram;
        this.utilizadoresPagam = utiliPagam;
        this.identificador=identificador;
    }
    
    
    
    
    public Conta (String nome, String tipo, int nrPessoasPagaram,float totalConta,
            GregorianCalendar dataPagamento, GregorianCalendar dataLimite,int id) {
    
        this.nome=nome;
        this.tipo=tipo;
        this.utilizadoresPagam=nrPessoasPagaram;
        this.totalFactura=totalConta;
        this.dataPagamento=dataPagamento;
        this.dataLimite=dataLimite;
        this.identificador=id;
        this.pagam=new HashMap<>();
    
    }
    
    
    
    
    public Conta () {
        
        this.totalFactura=-1;
        this.dataLimite=new GregorianCalendar();
        this.dataPagamento=new GregorianCalendar();
        this.nome="";
        this.tipo="";
        this.totalPago=-1;
        this.pagam= new HashMap<>();
        this.utilizadoresPagaram=-1;
        this.utilizadoresPagam = -1;
        this.identificador=-1;
    }
    
    public Conta(float totalFactura, GregorianCalendar dataLimite, GregorianCalendar dataPagamento, 
            String nome, String tipo, float totalPago, Map<String,Pagamento> pagam,int utiPagaram, 
            int utiliPagam,int identificador ) {
        this.totalFactura = totalFactura;
        this.dataLimite = dataLimite;
        this.dataPagamento = dataPagamento;
        this.nome = nome;
        this.tipo = tipo;
        this.totalPago = totalPago;
        this.pagam=pagam;
         this.utilizadoresPagaram=utiPagaram;
        this.utilizadoresPagam = utiliPagam;
        this.identificador= identificador;
    }

  
    public Conta(Conta c) {
        this.totalFactura=c.getTotalFactura();
        this.totalPago=c.getTotalPago();
        this.nome=c.getNome();
        this.tipo=c.getTipo();
        this.pagam=c.getPagam();
        this.utilizadoresPagaram=c.getUtilizadoresPagaram();
        this.utilizadoresPagam = c.getUtilizadoresPagam();
        this.identificador=c.getIdentificador();
    }
    
    
    
    public void addUtilizador(Pagamento a) {
    
        this.pagam.put(a.getEmail(),a);
    }
    
    
    public void addPagamento (String e,String nome,float p) {
        this.totalPago+=p;
        Pagamento s = new Pagamento(e,nome,p);
        this.pagam.put(e,s.clone());
    }
   
    
    public boolean verificaPagamento () {
        return (this.totalPago==this.totalFactura);
    }
    
   

    @Override
    public String toString() {
        return "\nConta:" + 
                "\n identificador = "+
                 identificador+
                "\n totalFactura=" + 
                totalFactura + 
                "\n ano limite do pagamento : " +dataLimite.get(Calendar.YEAR) +
                "\n mes limite do pagamento : " +(dataLimite.get(Calendar.MONTH)+1) +
                "\n dia limite do pagamento : " +dataLimite.get(Calendar.DAY_OF_MONTH)+
                
               
                "\n nome da factura=" + nome 
                + "\n tipo da fatura= " 
                + tipo +
                "\n totalPago= " + 
                totalPago;
    }
    
   
    
    public String imprimeUtilizadores(){
    
         StringBuilder s = new StringBuilder();
        for (Pagamento a : this.pagam.values()) {
        s.append(a.toString()).append("\n");
        }
        
      return s.toString();
        
        
    
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
        if (!Objects.equals(this.tipo,other.tipo)) {
            return false;
        }
        if (this.identificador!= other.identificador) {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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

    public Map<String,Pagamento> getPagam() {
        return pagam;
    }

    public void setPagam(Map<String,Pagamento> pagam) {
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

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    
    
    
    
    
    
    
    
    
}
