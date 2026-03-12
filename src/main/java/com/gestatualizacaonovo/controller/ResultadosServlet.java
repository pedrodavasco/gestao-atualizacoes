package com.gestatualizacaonovo.controller;

import com.gestatualizacaonovo.util.Conexao;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ResultadosServlet")
public class ResultadosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public static class Mudanca {
        public String id;
        public String descricao;
        public String tipo;
        public String impacto;
        public String urgencia;
        public String data;

        public Mudanca(String id, String descricao, String tipo, String impacto, String urgencia, String data) {
            this.id = id;
            this.descricao = descricao;
            this.tipo = tipo;
            this.impacto = impacto;
            this.urgencia = urgencia;
            this.data = data;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Mudanca> listaMudancas = new ArrayList<>();
        int total = 0, correcao = 0, melhoria = 0, atualizacao = 0;

        try (Connection conn = Conexao.getConexao()) {
            String sql = "SELECT * FROM mudanca";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("idMudanca");
                String descricao = rs.getString("descricao");
                String tipo = rs.getString("tipo");
                String impacto = rs.getString("impacto");
                String urgencia = rs.getString("urgencia");
                String data = rs.getString("dataSolicitacao");

                listaMudancas.add(new Mudanca(id, descricao, tipo, impacto, urgencia, data));

                total++;

                if(tipo != null) {
                    String t = tipo.toLowerCase();
                    if(t.contains("correcao") || t.contains("correção")) correcao++;
                    else if(t.contains("melhoria")) melhoria++;
                    else if(t.contains("atualizacao") || t.contains("atualização")) atualizacao++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("listaMudancas", listaMudancas);
        request.setAttribute("totalMudancas", total);
        request.setAttribute("totalCorrecao", correcao);
        request.setAttribute("totalMelhoria", melhoria);
        request.setAttribute("totalAtualizacao", atualizacao);

        request.getRequestDispatcher("/jsp/Resultados.jsp").forward(request, response);
    }
}
