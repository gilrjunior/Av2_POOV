package principal;

import javax.swing.JOptionPane;
import tela.*;

/**
 *
 * @author User
 */
public class Principal {
    
    public static int verifica = 0;
    
    public static void main(String[] args) {
        
        int opc = 0;
        int aux = 0;
        
        while(opc!= 8){
            
        opc = Integer.parseInt(JOptionPane.showInputDialog("MENU \n "+
                                        "1- Cadastrar clientes. \n" +
                                        "2- Cadastrar vinhos. \n" +
                                        "3- Vincular o cliente aos vinhos. \n" +
                                        "4- Buscar os vinhos de um cliente. \n" +
                                        "5- Atualizar os vinhos de um cliente. \n" +
                                        "6- Mostrar todos os clientes em ordem alfabética. \n" +
                                        "7- Apresentar o período compreendido entre o dia da venda e o momento atual \n" +
                                        "8- SAIR"));
                
        switch(opc){
            
            case 1:
                
                TelaCliente telacliente = new TelaCliente();
                telacliente.setVisible(true);
                while(Principal.verifica != 1);
                Principal.verifica = 0;
                telacliente.setVisible(false);
                
            break;
            
            case 2:
                
                TelaVinho telavinho = new TelaVinho();
                telavinho.setVisible(true);
                while(Principal.verifica != 1){
                    System.out.println("");
                }
                Principal.verifica = 0;
                telavinho.setVisible(false);
            
            
        }
            
    }
        
        
        
    }
}
    
