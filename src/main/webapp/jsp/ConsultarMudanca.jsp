<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page session="true" %>
<%
    String username = (String) session.getAttribute("username");
    String cargo = (String) session.getAttribute("cargo");
    String idUsuario = (String) session.getAttribute("idUsuario");

    if (username == null || cargo == null || idUsuario == null) {
        response.sendRedirect(request.getContextPath() + "/jsp/Login.jsp?erro=1");
        return;
    }
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Consultar Mudanças</title>
<style>
body { margin:0; font-family:Arial,sans-serif; background:#f0f2f5; display:flex; justify-content:center; align-items:center; height:100vh; }
.consultar-container { background:white; padding:40px 50px; border-radius:12px; box-shadow:0 6px 15px rgba(0,0,0,0.2); width:800px; text-align:center; }
h2 { color:#333; margin-bottom:20px; }
table { margin-top:25px; width:100%; border-collapse:collapse; }
th, td { border-bottom:1px solid #ddd; padding:10px; text-align:left; }
th { background:#007bff; color:white; }
tr:hover { background:#f9f9f9; }
.btn-excluir { padding:6px 12px; background:#dc3545; color:white; border:none; border-radius:6px; cursor:pointer; font-weight:bold; transition: background 0.3s, transform 0.2s; }
.btn-excluir:hover { background:#b02a37; transform:scale(1.05); }
.sem-permissao { color:gray; font-style:italic; }
.voltar-btn { margin-top:25px; background:#6c757d; padding:12px; width:100%; border:none; border-radius:8px; color:white; font-weight:bold; cursor:pointer; transition: background 0.3s, transform 0.2s; }
.voltar-btn:hover { background:#545b62; transform:scale(1.05); }
</style>
</head>
<body>
<div class="consultar-container">
<h2>Consultar Mudanças</h2>
<table>
  <thead>
    <tr>
      <th>ID</th>
      <th>Descrição</th>
      <th>Tipo</th>
      <th>Impacto</th>
      <th>Urgência</th>
      <th>Data</th>
      <th>Ação</th>
    </tr>
  </thead>
  <tbody>
<%
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        conn = com.gestatualizacaonovo.util.Conexao.getConexao();
        String sql = "SELECT * FROM mudanca";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();

        while (rs.next()) {
            String idMudanca = rs.getString("idMudanca");
            String descricao = rs.getString("descricao");
            String tipo = rs.getString("tipo");
            String impacto = rs.getString("impacto");
            String urgencia = rs.getString("urgencia");
            String dataSolicitacao = rs.getString("dataSolicitacao");
%>
    <tr>
      <td><%= idMudanca %></td>
      <td><%= descricao %></td>
      <td><%= tipo %></td>
      <td><%= impacto %></td>
      <td><%= urgencia %></td>
      <td><%= dataSolicitacao %></td>
      <td>
        <%
            boolean podeExcluir = "administrador".equals(cargo) || "gerente".equals(cargo);
            if (podeExcluir) {
        %>
            <form action="<%= request.getContextPath() %>/ExcluirMudancaServlet" method="post" style="margin:0;">
              <input type="hidden" name="idMudanca" value="<%= idMudanca %>">
              <button type="submit" class="btn-excluir"
                      onclick="return confirm('Deseja realmente excluir esta mudança?');">
                Excluir
              </button>
            </form>
        <%
            } else {
        %>
            <span class="sem-permissao">Sem permissão</span>
        <%
            }
        %>
      </td>
    </tr>
<%
        }
    } catch (Exception e) {
        out.println("Erro ao carregar mudanças: " + e.getMessage());
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (stmt != null) stmt.close(); } catch (Exception e) {}
        try { if (conn != null) conn.close(); } catch (Exception e) {}
    }
%>
  </tbody>
</table>

<!-- Botão voltar para menu -->
<button class="voltar-btn" onclick="window.location.href='<%= request.getContextPath() %>/jsp/menu.jsp'">
    Voltar ao Menu
</button>
</div>
</body>
</html>
