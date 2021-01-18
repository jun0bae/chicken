<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="my.chicken.model.*,java.util.*"%>
<%@ include file="top.jsp" %>
<div align="center">
	<hr color="green" width="300">
	<h2>카테고리등록</h2>
	<form name="f" action="cateAdd.chi" method="post">
		<input type="text" name="cname">
		<input type="submit" value="등록">
		<% request.setAttribute("cname",null); %>
	</form>
	
	<hr color="green" width="300">
	<table border="1" width="300">
		<tr>
			<th colspan="2">카테고리명</th>
		</tr>
<%
		List<CategoryDTO> list = null;
	    list = (List)request.getAttribute("catelist");
		if (list == null || list.size()==0){%>
		<tr>
			<td>등록된 카테고리가 없습니다.</td>
		</tr>
<%	}else { 
			for(CategoryDTO dto : list){%>
		<tr>
			<td width="80%"><%=dto.getCname()%>
			</td>
			<td>
			<a href="cateDelete.chi?cnum=<%=dto.getCnum()%>">삭제</a>
			</td>
		</tr>	
<%		}
		}%>				
	</table>
</div>
<%@ include file="bottom.jsp"%>	