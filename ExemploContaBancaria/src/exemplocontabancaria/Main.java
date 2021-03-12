/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplocontabancaria;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Moreno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opc = 0;
        String banco, agencia, conta, tipo;
        double valorsaldo, valorlimite,valor;
        ContaBancaria contaBancaria = null;
        ContaBancaria contaBancariaSelecionada = null;
        ArrayList<ContaBancaria> listContaBancaria = new ArrayList<>();
        
        while (opc != 6){
            opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Abrir nova conta\n2 - Sacar\n3 - Depositar\n"
                                        + "4 - Extrato\n5 - Aumentar Limite\n6 - Sair"));
            
            if(opc >= 2 && opc <= 5){
                conta = JOptionPane.showInputDialog("Digite a conta");
                for(ContaBancaria c : listContaBancaria){
                    if(c.getConta().equals(conta)){
                        contaBancariaSelecionada = c;
                    }
                }
            }
            
            switch(opc){
                case 1: 
                    banco = JOptionPane.showInputDialog("Banco");
                    agencia = JOptionPane.showInputDialog("Agência");
                    conta = JOptionPane.showInputDialog("Conta");
                    tipo = JOptionPane.showInputDialog("Tipo");
                    valorsaldo = Double.parseDouble(JOptionPane.showInputDialog("Valor Saldo"));
                    valorlimite = Double.parseDouble(JOptionPane.showInputDialog("Valor Limite"));
                    contaBancaria = new ContaBancaria(banco, agencia, conta, tipo, valorsaldo, valorlimite);
                    listContaBancaria.add(contaBancaria);
                    break;
                case 2: 
                    if(contaBancariaSelecionada != null){
                        valor = Double.parseDouble(JOptionPane.showInputDialog("Valor"));
                        if(contaBancariaSelecionada.sacar(valor))
                            JOptionPane.showMessageDialog(null, "Saque efetuado com sucesso");
                        else
                            JOptionPane.showMessageDialog(null, "Limite indisponível","Atenção",JOptionPane.ERROR_MESSAGE);                        
                    }
                    break;
                case 3: 
                    if(contaBancariaSelecionada != null){
                        valor = Double.parseDouble(JOptionPane.showInputDialog("Valor"));
                        contaBancariaSelecionada.depositar(valor);
                    }
                    break;
                case 4: 
                    if(contaBancariaSelecionada != null){
                        JOptionPane.showMessageDialog(null, contaBancariaSelecionada.verExtrato());
                    }
                    break;
                case 5: 
                    if(contaBancariaSelecionada != null){
                        valor = Double.parseDouble(JOptionPane.showInputDialog("Novo limite"));
                        contaBancariaSelecionada.setValorLimite(valor);
                    }
                    break;
                case 6: break;
                default: break;
            }
        }
    }
    
}
