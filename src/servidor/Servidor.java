package servidor;

import cliente.Cliente;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.Period;
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
                    
                    case 5:
                        
                        idcliente = recebe.readInt();
                        idvinho = recebe.readUTF();
                        valor = recebe.readFloat();
                        descricao = recebe.readUTF();
                        TipoUva = recebe.readUTF();
                        AnoSafra = recebe.readInt();
                        quantidade = recebe.readInt();
                        DataVenda = LocalDate.parse(recebe.readUTF(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        
                        for(Map.Entry<Cliente, ArrayList<Vinho>> entry : Banco.entrySet()){                                
                            if(entry.getKey().getIdCliente() == idcliente){ 
                                ArrayList<Vinho> lista = entry.getValue();
                                for(Vinho vinho: lista){
                                    if(vinho.getIdProduto().equalsIgnoreCase(idvinho)){
                                        
                                        vinho.setValor(valor);
                                        vinho.setDescricao(descricao);
                                        vinho.setTipoDaUva(TipoUva);
                                        vinho.setAnoDaSafra(AnoSafra);
                                        vinho.setQuantidade(quantidade);
                                        vinho.setDiaDaVenda(DataVenda);
                                        
                                    }
                               }   

                            }
                        }
                        
                    break;
                    
                    case 6:
                        
                       envia.writeInt(listaordenadaC.size());
                       
                       for(Cliente clientee : listaordenadaC){
                           
                           envia.writeInt(clientee.getIdCliente());
                           envia.writeUTF(clientee.getNome());
                           envia.writeUTF(clientee.getEmail());
                           envia.writeUTF(clientee.getEndereco());
                           envia.writeUTF(clientee.getTelefone());
                           envia.flush();
                           
                       }
                    
                    break;
                    
                    case 7:
                        
                       idvinho = recebe.readUTF();
                       
                       for(Vinho vinho : vinhos){
                           
                           if(vinho.getIdProduto().equals(idvinho)){
                               
                               Period periodo = Period.between(vinho.getDiaDaVenda(), LocalDate.now());
                               envia.writeInt(periodo.getDays());
                               
                           }
                           
                       }
                        
                    break;
                    
                    case 8:
                        
                        envia.writeInt(vinhos.size());
                                for(Vinho vinho: vinhos){ 
                                    envia.writeUTF(vinho.getIdProduto());
                                    envia.writeFloat(vinho.getValor());
                                    envia.writeUTF(vinho.getDescricao());
                                    envia.writeUTF(vinho.getTipoDaUva());
                                    envia.writeInt(vinho.getAnoDaSafra());
                                    envia.writeInt(vinho.getQuantidade());
                                    envia.writeUTF(vinho.getDiaDaVenda().toString());
                                    envia.flush();
                               }
                        
                    break;
                    
                    case 10: //realizar uma busca de vinho específica
                    
                        idcliente = recebe.readInt();
                        idvinho = recebe.readUTF();
                        
                        for(Map.Entry<Cliente, ArrayList<Vinho>> entry : Banco.entrySet()){                                
                            if(entry.getKey().getIdCliente() == idcliente){ 
                                ArrayList<Vinho> lista = entry.getValue();
                                for(Vinho vinho: lista){
                                    if(vinho.getIdProduto().equalsIgnoreCase(idvinho)){
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
                        }
                        
                    break;
                    
                }
            }
        } catch (IOException e) {
            System.out.println("Erro:" + e.getMessage());       
        }
   }
    
}
