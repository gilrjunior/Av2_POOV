package conexao;

import java.io.IOException;
import java.net.Socket;

public class Conexao {
    
    public static Socket Conecta() throws IOException{
        
        String endereco= "127.0.0.1";
        int porta = 8000;
    
        return new Socket(endereco, porta);
        
    }
    
}
