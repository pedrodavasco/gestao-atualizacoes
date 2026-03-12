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
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>Cadastro de Mudança</title>
  <style>
    body {
      margin: 0;
      font-family: Arial, sans-serif;
      background: #f0f2f5;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .form-container {
      background: white;
      padding: 50px 60px;
      border-radius: 12px;
      box-shadow: 0 6px 15px rgba(0,0,0,0.2);
      text-align: center;
      width: 400px;
    }

    .form-container h2 { margin-bottom: 35px; color: #333; }

    .form-container label {
      display: block;
      margin-top: 12px;
      text-align: left;
      font-weight: bold;
      color: #555;
    }

    .form-container input, .form-container select {
      width: 100%;
      padding: 10px;
      margin-top: 5px;
      border-radius: 8px;
      border: 1px solid #ccc;
      box-sizing: border-box;
    }

    .form-container button {
      margin-top: 25px;
      width: 100%;
      padding: 12px;
      color: white;
      border: none;
      border-radius: 8px;
      font-weight: bold;
      cursor: pointer;
      transition: background 0.3s, transform 0.2s;
    }

    .btn-cadastrar { background: #28a745; }
    .btn-cadastrar:hover { background: #218838; transform: scale(1.05); }
    .btn-voltar { background: #6c757d; }
    .btn-voltar:hover { background: #545b62; transform: scale(1.05); }
  </style>
</head>
<body>
  <div class="form-container">
    <h2>Cadastro de Mudança</h2>
    <form action="<%= request.getContextPath() %>/CadastrarMudancaServlet" method="post">
      <label for="idMudanca">ID da Mudança</label>
      <input type="text" id="idMudanca" name="idMudanca" required>

      <label for="descricao">Descrição</label>
      <input type="text" id="descricao" name="descricao" required>

      <label for="tipo">Tipo</label>
      <select id="tipo" name="tipo" required>
        <option value="">Selecione...</option>
        <option value="correcao">Correção</option>
        <option value="melhoria">Melhoria</option>
        <option value="atualizacao">Atualização</option>
      </select>

      <label for="impacto">Impacto</label>
      <select id="impacto" name="impacto" required>
        <option value="">Selecione...</option>
        <option value="alto">Alto</option>
        <option value="medio">Médio</option>
        <option value="baixo">Baixo</option>
      </select>

      <label for="urgencia">Urgência</label>
      <select id="urgencia" name="urgencia" required>
        <option value="">Selecione...</option>
        <option value="alta">Alta</option>
        <option value="media">Média</option>
        <option value="baixa">Baixa</option>
      </select>

      <label for="dataSolicitacao">Data de Solicitação</label>
      <input type="date" id="dataSolicitacao" name="dataSolicitacao" required>

      <button type="submit" class="btn-cadastrar">Cadastrar</button>
      <button type="button" class="btn-voltar" onclick="window.location.href='<%= request.getContextPath() %>/jsp/menu.jsp'">Voltar ao Menu</button>
    </form>
  </div>
</body>
</html>
