<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>Welcome Page</title>
<%@include file="../../menu/header.jsp"%>
</head>
<body>
	<%@include file="../../menu/menu.jsp"%>
	<div class="main-right">

		<form method="post"
			action="${pageContext.request.contextPath }/SpecifyFundInfoQuery">
			<table width="90%" cellpadding="0" cellspacing="0">
				<tr>
					<td>FundCode</td>
					<td><input type="text" name="fundCode" value="${fundCode}" /></td>
					<td>FundName</td>
					<td><input type="text" name="fundName" value="${fundName}" /></td>
					<td>Date</td>
					<td><input type="text" name="date" value="${date}" /></td>
				</tr>
				<tr>
					<td><input type="submit" /></td>
					<td><input type="reset" /></td>
				</tr>
			</table>

		</form>

		<table width="100%">
			<tr>
				<td>id</td>
				<td>name</td>
				<td>code</td>
				<td>valdate</td>
				<td>unitvalue</td>
				<td>nowvalue</td>
				<td>increase</td>
				<td>nowvaluetime</td>
			</tr>
			<c:forEach var="fundinfo" items="${lstFundInfo}">
				<tr>
					<td>${fundinfo.id }</td>
					<td>${fundinfo.fundName }</td>
					<td>${fundinfo.fundCode }</td>
					<td>${fundinfo.valuationDate }</td>
					<td>${fundinfo.unitValuation }</td>
					<td>${fundinfo.nowValuation }</td>
					<td>${fundinfo.valuationIncres }</td>
					<td>${fundinfo.valuationTime }</td>
				</tr>

			</c:forEach>

		</table>

	</div>
</body>
</html>