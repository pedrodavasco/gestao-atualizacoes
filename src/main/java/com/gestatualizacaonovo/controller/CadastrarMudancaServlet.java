package com.gestatualizacaonovo.controller;

import com.gestatualizacaonovo.util.Conexao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CadastrarMudancaServlet")
public class CadastrarMudancaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recupera dados do formulário
        String idMudanca = request.getParameter("idMudanca");
        String descricao = request.getParameter("descricao");
        String tipo = request.getParameter("tipo");
        String impacto = request.getParameter("impacto");
        String urgencia = request.getParameter("urgencia");
        String dataSolicitacao = request.getParameter("dataSolicitacao");

        try (Connection conn = Conexao.getConexao()) {

            String sql = "INSERT INTO mudanca (idMudanca, descricao, tipo, impacto, urgencia, dataSolicitacao) "
                       + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, idMudanca);
            stmt.setString(2, descricao);
            stmt.setString(3, tipo);
            stmt.setString(4, impacto);
            stmt.setString(5, urgencia);
            stmt.setString(6, dataSolicitacao);

            stmt.executeUpdate();

            // Redireciona para menu com mensagem de sucesso
            response.sendRedirect(request.getContextPath() + "/jsp/menu.jsp?msg=sucesso");

        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<h3>Erro ao cadastrar mudança: " + e.getMessage() + "</h3>");
        }
    }
}
