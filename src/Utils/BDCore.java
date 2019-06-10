/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Class.Car;
import Interface.ModelDataBase;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author artur
 */
public class BDCore {
    
    private Connection connection = null;
    private Statement stdados = null;
    private ResultSet rsdados = null;
    private JTable tabela = null;
    private JScrollPane scroller = null;
    private PreparedStatement pstdados = null;
    private CallableStatement cstdados = null;
    
    public boolean AcessaBD() {
        try {
            String usuario = "postgres";
            String senha = "massaroartur12";

            Class.forName("org.postgresql.Driver");  //para acesso ao banco de dados Postgre
            String urlconexao = "jdbc:postgresql://127.0.0.1/ProgDesk"; //para acesso ao banco de dados fabricio, usando o banco de dados Postgre.
            connection = DriverManager.getConnection(urlconexao, usuario, senha);
            connection.setAutoCommit(false);//configuracao necessaria para confirmacao ou nao de alteracoes no banco de dados.
            DatabaseMetaData dbmt = connection.getMetaData();
            System.out.println("Nome do BD: " + dbmt.getDatabaseProductName());
            System.out.println("Versao do BD: " + dbmt.getDatabaseProductVersion());
            System.out.println("URL: " + dbmt.getURL());
            System.out.println("Driver: " + dbmt.getDriverName());
            System.out.println("Versao Driver: " + dbmt.getDriverVersion());
            System.out.println("Usuario: " + dbmt.getUserName());
        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC/ODBC." + erro);
            return false;
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
            return false;
        }
        return true;
    }
    
    
    public void Sair() {
        try {
            if (rsdados != null) {
                rsdados.close();
                stdados.close();
                connection.close();
            }
        } catch (SQLException erro) {
            System.out.println("Nao foi possivel a desconexao." + erro);
        }
    }
    
    public void ExecutaPUpdate(String exec, ModelDataBase obj) {
        try {
            String sqldml = obj.getInsertQuery();
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);
            
            String nome = JOptionPane.showInputDialog("Entre com o nome: ");
            pstdados.setString(1, nome);
            
            String fone = JOptionPane.showInputDialog("Entre com o fone: ");
            pstdados.setString(2, fone);
            
            String email = JOptionPane.showInputDialog("Entre com o e-mail: ");
            pstdados.setString(3, email);
            
            int idade = Integer.valueOf(JOptionPane.showInputDialog("Entre com a idade: "));
            pstdados.setInt(4, idade);
            
            int resposta = pstdados.executeUpdate();
            System.out.println("Resposta do P-Update = " + resposta);
            
        } catch (SQLException erro) {
            System.out.println("Erro Executa P-Update = " + erro);
        }
    }
    
    
}
