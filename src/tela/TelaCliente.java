package tela;

import conexao.Conexao;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import principal.Principal;
import principal.TelaPrincipal;

public class TelaCliente extends javax.swing.JFrame {

    /**
     * Creates new form TelaCliente
     */
    public TelaCliente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jlb_cliente = new javax.swing.JLabel();
        jlb_idcliente = new javax.swing.JLabel();
        jlb_nome = new javax.swing.JLabel();
        jlb_email = new javax.swing.JLabel();
        jlb_telefone = new javax.swing.JLabel();
        jlb_endereco = new javax.swing.JLabel();
        jtf_idcliente = new javax.swing.JTextField();
        jtf_nome = new javax.swing.JTextField();
        jtf_email = new javax.swing.JTextField();
        jtf_endereco = new javax.swing.JTextField();
        jbt_inserir = new javax.swing.JButton();
        jtf_telefone = new javax.swing.JFormattedTextField();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlb_cliente.setText("CLIENTE");

        jlb_idcliente.setText("ID CLIENTE");

        jlb_nome.setText("NOME");

        jlb_email.setText("E-MAIL");

        jlb_telefone.setText("TELEFONE");

        jlb_endereco.setText("ENDEREÇO");

        jbt_inserir.setText("INSERIR");
        jbt_inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_inserirActionPerformed(evt);
            }
        });

        try {
            jtf_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jlb_cliente))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_idcliente)
                                    .addComponent(jlb_nome, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlb_email, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtf_idcliente, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jtf_nome)
                                    .addComponent(jtf_email)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlb_endereco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtf_endereco))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jlb_telefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtf_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(96, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbt_inserir, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_cliente)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_idcliente)
                    .addComponent(jtf_idcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_nome)
                    .addComponent(jtf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_email)
                    .addComponent(jtf_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_telefone)
                    .addComponent(jtf_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlb_endereco))
                .addGap(41, 41, 41)
                .addComponent(jbt_inserir)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbt_inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_inserirActionPerformed
        
        int ID_cliente = Integer.parseInt(jtf_idcliente.getText());
        String nome = jtf_nome.getText();
        String email = jtf_email.getText();
        String telefone = jtf_telefone.getText();
        String endereco = jtf_endereco.getText();
        
        Socket socket;
        try{           
            socket = Conexao.Conecta();
            ObjectOutputStream envia = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream recebe = new ObjectInputStream(socket.getInputStream());
           
            envia.writeInt(1);
            envia.writeInt(ID_cliente);
            envia.writeUTF(nome);
            envia.writeUTF(email);
            envia.writeUTF(telefone);
            envia.writeUTF(endereco);
                  
            envia.flush();
            
            socket.close();
            JOptionPane.showMessageDialog(null, "CLIENTE INSERIDO");
            
            
        }catch (IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
        this.dispose();
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
    }//GEN-LAST:event_jbt_inserirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JButton jbt_inserir;
    private javax.swing.JLabel jlb_cliente;
    private javax.swing.JLabel jlb_email;
    private javax.swing.JLabel jlb_endereco;
    private javax.swing.JLabel jlb_idcliente;
    private javax.swing.JLabel jlb_nome;
    private javax.swing.JLabel jlb_telefone;
    private javax.swing.JTextField jtf_email;
    private javax.swing.JTextField jtf_endereco;
    private javax.swing.JTextField jtf_idcliente;
    private javax.swing.JTextField jtf_nome;
    private javax.swing.JFormattedTextField jtf_telefone;
    // End of variables declaration//GEN-END:variables
}
