<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="java.util.*, br.com.caelum.agenda.dao.*, br.com.caelum.agenda.modelo.*,java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	 <thead>
	 <tr>
	 <th>nome</th>
	 <th>email</th>
	 </tr>
	
		<%
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			for (Contato contato : contatos) {
		%>
		<tr>
		
		<td><%=contato.getNome()%></td>
		
			<td><%=contato.getEmail()%></td>
			<td><%=contato.getEndereco()%></td>
			<td><%=date.format(contato.getDataNascimento().getTime())%></td>

		</tr>
		<%
			}
		%>
	</thead>
	</table>



</body>
</html>