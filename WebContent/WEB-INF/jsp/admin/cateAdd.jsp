<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="my.chicken.model.*,java.util.*"%>
<%@ include file="top.jsp" %>
<div align="center">
	<hr color="green" width="300">
	<h2>ī�װ����</h2>
	<form name="f" action="cateAdd.chi" method="post">
		<input type="text" name="cname">
		<input type="submit" value="���">
		<% request.setAttribute("cname",null); %>
	</form>
	
	<hr color="green" width="300">
	<table border="1" width="300">
		<tr>
			<th colspan="2">ī�װ���</th>
		</tr>
<%
		List<CategoryDTO> list = null;
	    list = (List)request.getAttribute("catelist");
		if (list == null || list.size()==0){%>
		<tr>
			<td>��ϵ� ī�װ��� �����ϴ�.</td>
		</tr>
<%	}else { 
			for(CategoryDTO dto : list){%>
		<tr>
			<td width="80%"><%=dto.getCname()%>
			</td>
			<td>
			<a href="cateDelete.chi?cnum=<%=dto.getCnum()%>">����</a>
			</td>
		</tr>	
<%		}
		}%>				
	</table>
</div>
<%@ include file="bottom.jsp"%>	