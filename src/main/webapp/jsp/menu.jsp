<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%
    String username = (String) session.getAttribute("username");
    String cargo = (String) session.getAttribute("cargo");
    String idUsuario = (String) session.getAttribute("idUsuario");

    if (username == null || cargo == null || idUsuario == null) {
        response.sendRedirect(request.getContextPath() + "/jsp/Login.jsp?erro=1");
        return;
    }

    String cargoFormatado = "Cargo Desconhecido";
    if ("administrador".equals(cargo)) cargoFormatado = "Administrador";
    else if ("gerente".equals(cargo)) cargoFormatado = "Gerente de Projeto";
    else if ("desenvolvedor".equals(cargo)) cargoFormatado = "Desenvolvedor";
    else if ("qa".equals(cargo)) cargoFormatado = "Testador / QA";
    else if ("usuario".equals(cargo)) cargoFormatado = "Usuário Final / Solicitante";

    java.util.List<String> permissoes = new java.util.ArrayList<>();
    java.util.List<String> destinos = new java.util.ArrayList<>();

    // Permissões por nível de acesso
    if ("administrador".equals(cargo) || "gerente".equals(cargo)) {
        permissoes.add("Cadastrar Mudança"); destinos.add("jsp/CadastrarMudanca.jsp");
        permissoes.add("Consultar Mudança");  destinos.add("ConsultarMudancaServlet");
        permissoes.add("Resultados");         destinos.add("ResultadosServlet");
        permissoes.add("Sair");               destinos.add("jsp/Logout.jsp");
    } else if ("desenvolvedor".equals(cargo) || "qa".equals(cargo)) {
        permissoes.add("Consultar Mudança");  destinos.add("ConsultarMudancaServlet");
        permissoes.add("Resultados");         destinos.add("ResultadosServlet");
        permissoes.add("Sair");               destinos.add("jsp/Logout.jsp");
    } else if ("usuario".equals(cargo)) {
        permissoes.add("Resultados");         destinos.add("ResultadosServlet");
        permissoes.add("Sair");               destinos.add("jsp/Logout.jsp");
    }
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>Menu Principal</title>
  <style>
    body { margin:0; font-family:Arial,sans-serif; background:#f0f2f5; display:flex; justify-content:center; align-items:center; height:100vh; }
    .menu-container { background:white; padding:50px 60px; border-radius:12px; box-shadow:0 6px 15px rgba(0,0,0,0.2); text-align:center; width:380px; }
    h2 { margin-bottom:10px; color:#333; }
    h3 { margin-top:0; margin-bottom:15px; color:#555; font-weight:normal; }
    p { margin-top:0; margin-bottom:25px; color:#555; font-weight:bold; }
    .menu-container form { margin:0; padding:0; }
    .menu-container button { display:block; width:100%; margin-top:12px; padding:12px; background:#007bff; color:white; border:none; border-radius:8px; font-weight:bold; cursor:pointer; transition: background 0.3s, transform 0.2s; }
    .menu-container button:hover { background:#0056b3; transform:scale(1.05); }
  </style>
</head>
<body>
  <div class="menu-container">
    <h2>Menu Principal</h2>
    <h3>Bem-vindo, <%= username %>!</h3>
    <p><%= cargoFormatado %> | ID: <%= idUsuario %></p>

    <% 
       for (int i = 0; i < permissoes.size(); i++) {
           String permissao = permissoes.get(i);
           String destino = destinos.get(i);

           if ("Sair".equals(permissao)) {
    %>
           <form action="<%= request.getContextPath() %>/<%= destino %>" method="get">
               <button type="submit"><%= permissao %></button>
           </form>
    <% 
           } else if ("Consultar Mudança".equals(permissao) || "Resultados".equals(permissao)) {
               // Para os Servlets
    %>
           <form action="<%= request.getContextPath() %>/<%= destino %>" method="get">
               <button type="submit"><%= permissao %></button>
           </form>
    <% 
           } else {
               // Para os JSPs
    %>
           <form action="<%= request.getContextPath() %>/<%= destino %>" method="get">
               <button type="submit"><%= permissao %></button>
           </form>
    <% 
           }
       } 
    %>
  </div>
</body>
</html>
