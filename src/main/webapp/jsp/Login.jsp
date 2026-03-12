<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <title>Login</title>
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

    .login-container {
      background: white;
      padding: 50px 60px;
      border-radius: 12px;
      box-shadow: 0 6px 15px rgba(0,0,0,0.2);
      text-align: center;
      width: 350px;
    }

    .login-container h2 { margin-bottom: 35px; color: #333; }

    .login-container label { display: block; margin-top: 12px; text-align: left; font-weight: bold; color: #555; }

    .login-container input, .login-container select {
      width: 100%;
      padding: 10px;
      margin-top: 5px;
      border-radius: 8px;
      border: 1px solid #ccc;
      box-sizing: border-box;
    }

    .login-container button {
      margin-top: 25px;
      width: 100%;
      padding: 12px;
      background: #007bff;
      color: white;
      border: none;
      border-radius: 8px;
      font-weight: bold;
      cursor: pointer;
      transition: background 0.3s, transform 0.2s;
    }

    .login-container button:hover { background: #0056b3; transform: scale(1.05); }
  </style>
</head>
<body>
  <div class="login-container">
    <h2>Login</h2>
    <form action="${pageContext.request.contextPath}/login" method="post">
      <label for="idUsuario">ID do Usuário</label>
      <input type="text" id="idUsuario" name="idUsuario" required>

      <label for="username">Username</label>
      <input type="text" id="username" name="username" required>

      <label for="senha">Senha</label>
      <input type="password" id="senha" name="senha" required>

      <label for="cargo">Cargo</label>
      <select id="cargo" name="cargo" required>
        <option value="">Selecione...</option>
        <option value="administrador">Administrador</option>
        <option value="gerente">Gerente de Projeto</option>
        <option value="desenvolvedor">Desenvolvedor</option>
        <option value="qa">Testador / QA</option>
        <option value="usuario">Usuário Final / Solicitante</option>
      </select>

      <button type="submit">Entrar</button>
    </form>
  </div>
</body>
</html>
