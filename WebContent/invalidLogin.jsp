<html>
<%
	request.getSession().setAttribute("f","failed");
	response.sendRedirect("../faces/twt.jsp?status="+request.getSession().getAttribute("info"));
%>
<body>
	
</body>
</html>