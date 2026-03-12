package com.gestatualizacaonovo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/api/mudancas")
public class MudancaApiServlet extends HttpServlet {

    private Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }

    // GET - listar mudanças
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");

        try (Connection conn = getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM mudanca")) {

            StringBuilder json = new StringBuilder("[");
            boolean first = true;

            while (rs.next()) {
                if (!first) json.append(",");
                json.append("{")
                        .append("\"idMudanca\":\"").append(rs.getInt("idMudanca")).append("\",")
                        .append("\"descricao\":\"").append(rs.getString("descricao")).append("\",")
                        .append("\"tipo\":\"").append(rs.getString("tipo")).append("\",")
                        .append("\"impacto\":\"").append(rs.getString("impacto")).append("\",")
                        .append("\"urgencia\":\"").append(rs.getString("urgencia")).append("\",")
                        .append("\"dataSolicitacao\":\"").append(rs.getString("dataSolicitacao")).append("\"")
                        .append("}");
                first = false;
            }
            json.append("]");
            resp.getWriter().write(json.toString());

        } catch (Exception e) {
            resp.getWriter().write("{\"erro\":\"" + e.getMessage() + "\"}");
        }
    }

    // POST - criar nova mudança
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");

        String idMudanca = req.getParameter("idMudanca");
        String descricao = req.getParameter("descricao");
        String tipo = req.getParameter("tipo");
        String impacto = req.getParameter("impacto");
        String urgencia = req.getParameter("urgencia");
        String dataSolicitacao = req.getParameter("dataSolicitacao");

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "INSERT INTO mudanca (idMudanca, descricao, tipo, impacto, urgencia, dataSolicitacao) VALUES (?, ?, ?, ?, ?, ?)")) {

            ps.setString(1, idMudanca);
            ps.setString(2, descricao);
            ps.setString(3, tipo);
            ps.setString(4, impacto);
            ps.setString(5, urgencia);
            ps.setString(6, dataSolicitacao);

            ps.executeUpdate();
            resp.getWriter().write("{\"mensagem\":\"Mudança cadastrada com sucesso\"}");

        } catch (Exception e) {
            resp.getWriter().write("{\"erro\":\"" + e.getMessage() + "\"}");
        }
    }

    // PUT - atualizar mudança
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");

        String idMudancaStr = req.getParameter("idMudanca");
        String descricao = req.getParameter("descricao");
        String tipo = req.getParameter("tipo");
        String impacto = req.getParameter("impacto");
        String urgencia = req.getParameter("urgencia");
        String dataSolicitacao = req.getParameter("dataSolicitacao");

        if (idMudancaStr == null) {
            resp.getWriter().write("{\"erro\":\"idMudanca ausente\"}");
            return;
        }

        try {
            int idMudanca = Integer.parseInt(idMudancaStr);

            try (Connection conn = getConnection();
                 PreparedStatement ps = conn.prepareStatement(
                         "UPDATE mudanca SET descricao=?, tipo=?, impacto=?, urgencia=?, dataSolicitacao=? WHERE idMudanca=?")) {

                ps.setString(1, descricao);
                ps.setString(2, tipo);
                ps.setString(3, impacto);
                ps.setString(4, urgencia);
                ps.setString(5, dataSolicitacao);
                ps.setInt(6, idMudanca);

                int linhas = ps.executeUpdate();
                if (linhas > 0) {
                    resp.getWriter().write("{\"mensagem\":\"Mudança atualizada com sucesso\"}");
                } else {
                    resp.getWriter().write("{\"erro\":\"Mudança não encontrada\"}");
                }
            }

        } catch (NumberFormatException e) {
            resp.getWriter().write("{\"erro\":\"idMudanca inválido\"}");
        } catch (Exception e) {
            resp.getWriter().write("{\"erro\":\"" + e.getMessage() + "\"}");
        }
    }

    // DELETE - remover mudança
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");

        String idMudancaStr = req.getParameter("idMudanca");

        if (idMudancaStr == null) {
            resp.getWriter().write("{\"erro\":\"idMudanca ausente\"}");
            return;
        }

        try {
            int idMudanca = Integer.parseInt(idMudancaStr);

            try (Connection conn = getConnection();
                 PreparedStatement ps = conn.prepareStatement("DELETE FROM mudanca WHERE idMudanca=?")) {

                ps.setInt(1, idMudanca);
                int linhas = ps.executeUpdate();
                if (linhas > 0) {
                    resp.getWriter().write("{\"mensagem\":\"Mudança excluída com sucesso\"}");
                } else {
                    resp.getWriter().write("{\"erro\":\"Mudança não encontrada\"}");
                }

            }

        } catch (NumberFormatException e) {
            resp.getWriter().write("{\"erro\":\"idMudanca inválido\"}");
        } catch (Exception e) {
            resp.getWriter().write("{\"erro\":\"" + e.getMessage() + "\"}");
        }
    }
}
