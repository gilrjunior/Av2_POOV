package servidor;

import cliente.Cliente;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import vinho.Vinho;

public class Servidor {
    
    public static void main(String[] args){
        
        Socket socket;
        int opc;
        Map<Cliente, ArrayList<Vinho>> Banco = new HashMap<>();
        ArrayList <Vinho> vinhos = new ArrayList();
        ArrayList <Cliente> listaordenadaC = new ArrayList();
        
        try{          
            ServerSocket serverSocket = new ServerSocket(8000);
            while(true) 
            {
                socket = serverSocket.accept();
                ObjectOutputStream envia = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream recebe = new ObjectInputStream(socket.getInputStream());
               
                opc = recebe.readInt();
                
                switch(opc){
                    
                    case 1:
                    
                        int ID_cliente = recebe.readInt();
                        String nome = recebe.readUTF();
                        String email = recebe.readUTF();
                        String telefone = recebe.readUTF();
                        String endereco = recebe.readUTF();
                        
                        Cliente cliente = new Cliente(ID_cliente, nome, email, telefone, endereco);
                        if(listaordenadaC.size() == 0){
                            
                            listaordenadaC.add(cliente);
                            
                        }else{
                            for(int i = 0; i < listaordenadaC.size(); i++){
                                if(cliente.getNome().compareTo(listaordenadaC.get(i).getNome()) < 0){
                                    listaordenadaC.add(i, cliente);
                                }else{
                                    listaordenadaC.add(cliente);
                                }
                            }
                        
                        }
                        
                        Banco.put(cliente, new ArrayList());
                                                 
                    break;
                    
                    case 2: 
                        
                        String idproduto = recebe.readUTF();
                        float valor = recebe.readFloat();
                        String descricao = recebe.readUTF();
                        String TipoUva = recebe.readUTF();
                        int AnoSafra = recebe.readInt();
                        int quantidade = recebe.readInt();
                        LocalDate DataVenda = LocalDate.parse(recebe.readUTF(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        
                        vinhos.add(new Vinho(idproduto, valor, descricao, TipoUva, AnoSafra, quantidade, DataVenda));
                        
                    break;
                    
                    case 3:
                        
                        int idcliente = recebe.readInt();
                        String idvinho = recebe.readUTF();
                        
                        for(Map.Entry<Cliente, ArrayList<Vinho>> entry : Banco.entrySet()){                                
                            if(entry.getKey().getIdCliente() == idcliente){ 
                                for(Vinho vinho: vinhos){ 
                                    if(vinho.getIdProduto().equals(idvinho)){
                                        ArrayList<Vinho> lista = entry.getValue();
                                        lista.add(vinho);
                                    } 
                                }   
                            }
                        }
                        
                    break;
                    
                    case 4:
                        
                       idcliente = recebe.readInt();
                        
                       for(Map.Entry<Cliente, ArrayList<Vinho>> entry : Banco.entrySet()){                                
                            if(entry.getKey().getIdCliente() == idcliente){ 
                                ArrayList<Vinho> lista = entry.getValue();
                                envia.writeInt(lista.size());
                                for(Vinho vinho: lista){ 
                                    envia.writeUTF(vinho.getIdProduto());
                                    envia.writeFloat(vinho.getValor());
                                    envia.writeUTF(vinho.getDescricao());
                                    envia.writeUTF(vinho.getTipoDaUva());
                                    envia.writeInt(vinho.getAnoDaSafra());
                                    envia.writeInt(vinho.getQuantidade());
                                    envia.writeUTF(vinho.getDiaDaVenda().toString());
                                    envia.flush();
                               }   

                            }
                        } 
                        
                    break;
                    
                    
                    
                }
            }
        } catch (IOException e) {
            System.out.println("Erro:" + e.getMessage());       
        }
   }
    
}
