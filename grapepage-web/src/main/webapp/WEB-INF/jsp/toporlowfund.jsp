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
			action="${pageContext.request.contextPath}/fundquery/toporlow.do">
			<table width="90%" cellpadding="0" cellspacing="0">
				<tr>
					<td>时间</td>
					<td><input type="text" name="datetime" value="${datetime}" /></td>
					<td>显示调试</td>
					<td><input type="text" name="showtotal" value="${showtotal}" /></td>
					<td>排序规则</td>
					<td><select name="sortType">
							<option value="0">倒序</option>
							<option value="1">升序</option>
					</select></td>
				</tr>
				<tr>
					<td><input type="submit" text="查询" /></td>
					<td><input type="reset" /></td>
				</tr>
			</table>
			<span>${pageContext.request.contextPath}</span>
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
				<c:forEach var="fund" items="${fundInfo}">
					<tr>
						<td>${fund.id }</td>
						<td>${fund.fundName }</td>
						<td>${fund.fundCode }</td>
						<td>${fund.valuationDate }</td>
						<td>${fund.unitValuation }</td>
						<td>${fund.nowValuation }</td>
						<td>${fund.valuationIncres }</td>
						<td>${fund.valuationTime }</td>
					</tr>

				</c:forEach>

			</table>
		</form>



	</div>
</body>
</html>