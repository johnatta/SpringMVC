<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="mvc">
   <input type="hidden" name="logica" value="AlteraContatoLogic" />
   <input type="hidden" name="id" value="${contato.id}" />
   <input type="text" name="nome" value="${contato.nome}" />
    <input type="text" name="endereco" value="${contato.endereco}" />
       
   <fmt:formatDate value="${contato.dataNascimento.time}" pattern = "dd/mm/yyyy" var="data" />
   <input type="text" name="dataNascimento" value="${data }" />
  	<input type="submit" value="Altera" />
   </form>
</body>
</html>