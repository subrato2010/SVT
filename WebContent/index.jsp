<%@page import="com.edifixio.soc.web.util.ErrorNotifier"%>
<%
	System.out.println("index.jsp is called.....");
	String strUri = request.getRequestURI();
	System.out.println("url = " + strUri);
	try {
		if (!strUri.equals("/TWT/error.jsp")) {
			if (request.getParameter("status") == null)
				response
						.sendRedirect("faces/twt.jsp?status=login");
			else
				response.sendRedirect("faces/twt.jsp?status="
						+ request.getParameter("status"));
		} else {
			new ErrorNotifier().notifyErrorByMail();
			response.sendRedirect("../twt.jsp?status=login");
		}
	} catch (Exception e) {
		System.out.println("Error :" + e.getMessage());
		e.printStackTrace();
	}
%>