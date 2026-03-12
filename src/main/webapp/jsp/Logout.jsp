<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%
    session.invalidate();
    response.sendRedirect(request.getContextPath() + "/jsp/Login.jsp");
%>
