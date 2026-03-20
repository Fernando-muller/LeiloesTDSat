import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    
    public void cadastrarProduto(ProdutosDTO produto){
        
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";

        conn = new ConexaoDAO().conectaBD();

        try {
            prep = conn.prepareStatement(sql);
            
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());

            prep.execute();
            prep.close();

            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e.getMessage());
        }
    }
    
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        ArrayList<ProdutosDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

      conn = new conectaDAO().conectaBD();

        try {
            prep = conn.prepareStatement(sql);
            resultset = prep.executeQuery();

            while(resultset.next()){
                ProdutosDTO produto = new ProdutosDTO();

                produto.setNome(resultset.getString("nome"));
                produto.setValor(resultset.getInt("valor"));
                produto.setStatus(resultset.getString("status"));

                lista.add(produto);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
        }

        return lista;
    }
}