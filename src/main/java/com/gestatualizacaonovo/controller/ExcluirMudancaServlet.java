package com.gestatualizacaonovo.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ExcluirMudancaServlet")
public class ExcluirMudancaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idMudanca = request.getParameter("idMudanca");

        try (Connection conn = com.gestatualizacaonovo.util.Conexao.getConexao()) {
            String sql = "DELETE FROM mudanca WHERE idMudanca = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, idMudanca);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Mudança " + idMudanca + " excluída com sucesso.");
            } else {
                System.out.println("Nenhuma mudança encontrada com ID: " + idMudanca);
            }

            // Redireciona de volta para a página de consulta
            response.sendRedirect(request.getContextPath() + "/ConsultarMudancaServlet");

        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<h3>Erro ao excluir mudança: " + e.getMessage() + "</h3>");
        }
    }
}
