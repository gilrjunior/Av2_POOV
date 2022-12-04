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
        
        while(opc!= 9){
            
        opc = Integer.parseInt(JOptionPane.showInputDialog("MENU \n "+
                                        "1- Cadastrar clientes. \n" +
                                        "2- Cadastrar vinhos. \n" +
                                        "3- Vincular o cliente aos vinhos. \n" +
                                        "4- Buscar os vinhos de um cliente. \n" +
                                        "5- Atualizar os vinhos de um cliente. \n" +
                                        "6- Mostrar todos os clientes em ordem alfabética. \n" +
                                        "7- Apresentar o período compreendido entre o dia da venda e o momento atual \n" +
                                        "8- Mostrar Vinhos cadastrados\n"+
                                        "9- SAIR"));
                
        switch(opc){
            
            case 1:
                
                TelaCliente telacliente = new TelaCliente();
                telacliente.setVisible(true);
                while(opc!= 0){
                   if(Principal.verifica == 1){
                       opc = 0;
                       JOptionPane.showMessageDialog(null, "CLIENTE INSERIDO");
                   }
                }
                Principal.verifica = 0;
                telacliente.setVisible(false);
                
            break;
            
            case 2:
                
                TelaVinho telavinho = new TelaVinho();
                telavinho.setVisible(true);
                while(opc!= 0){
                   if(Principal.verifica == 1){
                       opc = 0;
                       JOptionPane.showMessageDialog(null, "VINHO INSERIDO");
                   }
                }
                Principal.verifica = 0;
                telavinho.setVisible(false);
                
            break;
            
            case 3:
                
                TelaVincularVinhos telavincular = new TelaVincularVinhos();
                telavincular.setVisible(true);
                while(opc!= 0){
                   if(Principal.verifica == 1){
                       opc = 0;
                       JOptionPane.showMessageDialog(null, "VINHOS VINCULADOS");
                   }
                   if(Principal.verifica == 2){
                       opc = 0;
                   }
                }
                Principal.verifica = 0;
                telavincular.setVisible(false);
                
            break;
            case 4:
                
                TelaMostrar telamostrar = new TelaMostrar();
                telamostrar.setVisible(true);
                while(opc!= 0){
                   if(Principal.verifica == 1){
                       opc = 0;
                       JOptionPane.showMessageDialog(null, "RETORNANDO AO MENU");
                   }
                }
                Principal.verifica = 0;
                telamostrar.setVisible(false);
                
            break;
            case 5:
                
                TelaAtualizarVinho telaattvinho = new TelaAtualizarVinho();
                telaattvinho.setVisible(true);
                while(opc!= 0){
                   if(Principal.verifica == 1){
                       opc = 0;
                       JOptionPane.showMessageDialog(null, "VINHO ATUALIZADO");
                   }
                }
                Principal.verifica = 0;
                telaattvinho.setVisible(false);
            break;
            case 6:
                
                TelaMostraClientes telamostrarC = new TelaMostraClientes();
                telamostrarC.setVisible(true);
                while(opc!= 0){
                   if(Principal.verifica == 1){
                       opc = 0;
                       JOptionPane.showMessageDialog(null, "RETORNANDO AO MENU");
                   }
                }
                Principal.verifica = 0;
                telamostrarC.setVisible(false);
                
            break;
            case 7:
                
              TelaPeriodo telaperiodo = new TelaPeriodo();
                telaperiodo.setVisible(true);
                while(opc!= 0){
                   if(Principal.verifica == 1){
                       opc = 0;
                       JOptionPane.showMessageDialog(null, "RETORNANDO AO MENU");
                   }
                }
                Principal.verifica = 0;
                telaperiodo.setVisible(false);  
                
            break;
            
            case 8:
                
                TelaVinhosCad telavinhsocad = new TelaVinhosCad();
                telavinhsocad.setVisible(true);
                while(opc!= 0){
                   if(Principal.verifica == 1){
                       opc = 0;
                       JOptionPane.showMessageDialog(null, "RETORNANDO AO MENU");
                   }
                }
                Principal.verifica = 0;
                telavinhsocad.setVisible(false);
                
            break;
                    
                
        }
            
    }
        
        
        
    }
}
    
