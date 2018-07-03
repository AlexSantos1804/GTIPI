<%@page import="persistencia.CidadeBD"%>
<%
String codigo = request.getParameter("codigo");
CidadeBD.excluir(Integer.parseInt(codigo));
response.sendRedirect("listar.jsp");
%>