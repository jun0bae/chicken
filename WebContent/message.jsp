<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- message.jsp -->
<%
		String msg = (String)request.getAttribute("msg");
		String url = (String)request.getAttribute("url");
		if (url.equals("memberInput")){%>
			<script type="text/javascript">
				alert("<%=msg%>")
				self.close()
			</script>
<% 	}else {%>
			<script type="text/javascript">
				alert("<%=msg%>")
				location.href="<%=url%>"
			</script>
<%	} %>
