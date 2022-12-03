package cliente;


public class Cliente {
    
    private int IdCliente;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;

    public Cliente(int IdCliente, String nome, String email, String telefone, String endereco) {
        this.IdCliente = IdCliente;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }
        
        public Cliente() {
        this.IdCliente = 0;
        this.nome = "";
        this.email = "";
        this.telefone = "";
        this.endereco = "";
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "IdCliente=" + IdCliente + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", endereco=" + endereco;
    }

    
}
