<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%@ page import="java.util.List" %>
<%@ page import="com.gestatualizacaonovo.controller.ResultadosServlet.Mudanca" %>
<%
    String username = (String) session.getAttribute("username");
    String cargo = (String) session.getAttribute("cargo");
    if(username == null || cargo == null){
        response.sendRedirect(request.getContextPath()+"/jsp/Login.jsp?erro=1");
        return;
    }

    List<Mudanca> listaMudancas = (List<Mudanca>) request.getAttribute("listaMudancas");
    Integer totalMudancas = (Integer) request.getAttribute("totalMudancas");
    Integer totalCorrecao = (Integer) request.getAttribute("totalCorrecao");
    Integer totalMelhoria = (Integer) request.getAttribute("totalMelhoria");
    Integer totalAtualizacao = (Integer) request.getAttribute("totalAtualizacao");
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>Resultados das Mudanças</title>
  <style>
    body { margin:0; font-family:Arial,sans-serif; background:#f0f2f5; display:flex; justify-content:center; align-items:center; min-height:100vh; }
    .resultados-container { background:white; padding:40px 50px; border-radius:12px; box-shadow:0 6px 15px rgba(0,0,0,0.2); width:700px; text-align:center; }
    h2 { color:#333; margin-bottom:30px; }
    .cards { display:grid; grid-template-columns:repeat(auto-fit, minmax(150px, 1fr)); gap:20px; margin-bottom:30px; }
    .card { background:#007bff; color:white; border-radius:10px; padding:20px; box-shadow:0 4px 10px rgba(0,0,0,0.2); transition:transform 0.2s, background 0.3s; }
    .card:hover { transform:scale(1.05); background:#0056b3; }
    .card h3 { margin:0; font-size:1.2em; }
    .card p { margin:5px 0 0; font-size:1.5em; font-weight:bold; }
    .tabela-detalhes { width:100%; border-collapse:collapse; }
    th, td { padding:10px; border-bottom:1px solid #ddd; text-align:left; }
    th { background:#007bff; color:white; }
    tr:hover { background:#f9f9f9; }
    .voltar-btn { margin-top:25px; background:#6c757d; padding:12px; width:100%; border:none; border-radius:8px; color:white; font-weight:bold; cursor:pointer; transition:background 0.3s, transform 0.2s; }
    .voltar-btn:hover { background:#545b62; transform:scale(1.05); }
  </style>
</head>
<body>
  <div class="resultados-container">
    <h2>Resultados das Mudanças</h2>

    <div class="cards">
      <div class="card"><h3>Total de Mudanças</h3><p><%= totalMudancas %></p></div>
      <div class="card"><h3>Correções</h3><p><%= totalCorrecao %></p></div>
      <div class="card"><h3>Melhorias</h3><p><%= totalMelhoria %></p></div>
      <div class="card"><h3>Atualizações</h3><p><%= totalAtualizacao %></p></div>
    </div>

    <table class="tabela-detalhes">
      <thead>
        <tr>
          <th>ID</th>
          <th>Descrição</th>
          <th>Tipo</th>
          <th>Impacto</th>
          <th>Urgência</th>
          <th>Data</th>
        </tr>
      </thead>
      <tbody>
        <% if(listaMudancas != null){
               for(Mudanca m : listaMudancas){ %>
                  <tr>
                    <td><%= m.id %></td>
                    <td><%= m.descricao %></td>
                    <td><%= m.tipo %></td>
                    <td><%= m.impacto %></td>
                    <td><%= m.urgencia %></td>
                    <td><%= m.data %></td>
                  </tr>
        <%     } 
           } %>
      </tbody>
    </table>

    <button class="voltar-btn" onclick="window.location.href='<%= request.getContextPath() %>/jsp/menu.jsp'">Voltar ao Menu</button>
  </div>
</body>
</html>
