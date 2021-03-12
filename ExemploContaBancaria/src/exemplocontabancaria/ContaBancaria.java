/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplocontabancaria;

/**
 *
 * @author Moreno
 */
public class ContaBancaria {
    private String banco;
    private String conta;
    private String agencia;
    private String tipo;
    private double valorSaldo;
    private double valorLimite;
    
    public ContaBancaria(){}
    
    public ContaBancaria(String banco, String agencia, String conta, String tipo){
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
        this.tipo = tipo;
    }
    public ContaBancaria(String banco, String agencia, String conta, String tipo, double valorSaldo, double valorLimite){
        this(banco, agencia, conta, tipo);
        this.valorLimite = valorLimite;
        this.valorSaldo = valorSaldo;
    }
    public void depositar(double valor){
        setValorSaldo(getValorSaldo() + valor);
    }
    public double verSaldo(){
        return getValorSaldo() + getValorLimite();
    }
    public boolean sacar(double valor){
        if(valor <= verSaldo()){
            setValorSaldo(getValorSaldo() - valor);
            return true;
        }
        else
            return false;
    }
    public String verExtrato(){
        return "Banco: " + getBanco() + "\n"
                + "Agência: " + getAgencia() + "\n"
                + "Conta: " + getConta() + "\n"
                + "Tipo: " + getTipo() + "\n"
                + "Saldo: " + getValorSaldo() + "\n"
                + "Limite: " + getValorLimite() + "\n"
                + "Total: " + verSaldo();
    }

    /**
     * @return the banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * @return the conta
     */
    public String getConta() {
        return conta;
    }

    /**
     * @param conta the conta to set
     */
    public void setConta(String conta) {
        this.conta = conta;
    }

    /**
     * @return the agencia
     */
    public String getAgencia() {
        return agencia;
    }

    /**
     * @param agencia the agencia to set
     */
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the valorSaldo
     */
    public double getValorSaldo() {
        return valorSaldo;
    }

    /**
     * @param valorSaldo the valorSaldo to set
     */
    public void setValorSaldo(double valorSaldo) {
        this.valorSaldo = valorSaldo;
    }

    /**
     * @return the valorLimite
     */
    public double getValorLimite() {
        return valorLimite;
    }

    /**
     * @param valorLimite the valorLimite to set
     */
    public void setValorLimite(double valorLimite) {
        this.valorLimite = valorLimite;
    }
    
}
