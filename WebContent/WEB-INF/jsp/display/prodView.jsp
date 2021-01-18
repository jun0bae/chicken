<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="my.chicken.model.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="top.jsp" %>
<div align="center">
			<hr color="green" width="500">
			<h3>${dto.pname}</h3>
			<hr color="green" width="500">
			<table width="100%" align="center">
				<tr>
				<td align="center">
					<img src="${upPath}/${dto.getimage}" width="60" height="60">
					</a>
					<br>
					${dto.getPname}<br>
					<font color="red">${dto.getPrice}</font>¿ø<br>
					<font color="blue"></font>point<br>
				</td>

				</tr><tr>

				</tr>
			</table>		
</div>
<%@ include file="bottom.jsp"%>