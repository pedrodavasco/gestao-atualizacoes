package com.gestatualizacaonovo.controller;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.gestatualizacaonovo.util.Conexao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idUsuario = request.getParameter("idUsuario");
        String username = request.getParameter("username");
        String senha = request.getParameter("senha");
        String nivelAcesso = request.getParameter("cargo"); // campo select no Login.jsp

        System.out.println("Tentando login/criação:");
        System.out.println("ID: " + idUsuario);
        System.out.println("Username: " + username);
        System.out.println("Senha: " + senha);
        System.out.println("Cargo: " + nivelAcesso);

        try (Connection conn = Conexao.getConexao()) {

            if (conn == null) {
                throw new SQLException("Falha ao obter conexão com o banco de dados.");
            }

            // Primeiro tenta encontrar o usuário
            String sqlSelect = "SELECT * FROM usuario WHERE idUsuario = ? AND username = ? AND senha = ? AND nivelAcesso = ?";
            PreparedStatement stmtSelect = conn.prepareStatement(sqlSelect);
            stmtSelect.setString(1, idUsuario);
            stmtSelect.setString(2, username);
            stmtSelect.setString(3, senha);
            stmtSelect.setString(4, nivelAcesso);

            ResultSet rs = stmtSelect.executeQuery();

            if (rs.next()) {
                // Usuário existe → login normal
                System.out.println("Usuário encontrado. Login bem-sucedido!");
            } else {
                // Usuário não existe → cria novo
                System.out.println("Usuário não encontrado. Criando novo usuário...");

                String sqlInsert = "INSERT INTO usuario (idUsuario, username, senha, nivelAcesso) VALUES (?, ?, ?, ?)";
                PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert);
                stmtInsert.setString(1, idUsuario);
                stmtInsert.setString(2, username);
                stmtInsert.setString(3, senha);
                stmtInsert.setString(4, nivelAcesso);
                stmtInsert.executeUpdate();

                System.out.println("Novo usuário criado com sucesso!");
            }

            // Cria sessão e redireciona pro menu
            HttpSession session = request.getSession();
            session.setAttribute("idUsuario", idUsuario);
            session.setAttribute("username", username);
            session.setAttribute("cargo", nivelAcesso);

            response.sendRedirect(request.getContextPath() + "/jsp/menu.jsp");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "Driver do banco H2 não encontrado.");
        } catch (SQLException e) {
            e.printStackTrace();
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<h3>Erro ao efetuar login/criação: " + e.getMessage() + "</h3>");
        }
    }
}
