package com.gestatualizacaonovo.controller;

import com.gestatualizacaonovo.util.Conexao;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ConsultarMudancaServlet")
public class ConsultarMudancaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Classe interna para representar uma mudança
    public static class Mudanca {
        private String idMudanca;
        private String descricao;
        private String tipo;
        private String impacto;
        private String urgencia;
        private Date dataSolicitacao;

        public Mudanca(String idMudanca, String descricao, String tipo, String impacto, String urgencia, Date dataSolicitacao) {
            this.idMudanca = idMudanca;
            this.descricao = descricao;
            this.tipo = tipo;
            this.impacto = impacto;
            this.urgencia = urgencia;
            this.dataSolicitacao = dataSolicitacao;
        }

        public String getIdMudanca() { return idMudanca; }
        public String getDescricao() { return descricao; }
        public String getTipo() { return tipo; }
        public String getImpacto() { return impacto; }
        public String getUrgencia() { return urgencia; }
        public Date getDataSolicitacao() { return dataSolicitacao; }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Mudanca> lista = new ArrayList<>();

        try (Connection conn = Conexao.getConexao()) {
            String sql = "SELECT * FROM mudanca ORDER BY idMudanca";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Mudanca m = new Mudanca(
                        rs.getString("idMudanca"),
                        rs.getString("descricao"),
                        rs.getString("tipo"),
                        rs.getString("impacto"),
                        rs.getString("urgencia"),
                        rs.getDate("dataSolicitacao")
                );
                lista.add(m);
            }

            request.setAttribute("mudancas", lista);
            request.getRequestDispatcher("/jsp/ConsultarMudanca.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<h3>Erro ao consultar mudanças: " + e.getMessage() + "</h3>");
        }
    }
}
