<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<div class="leftsidebar_box">
	<div class="line"></div>
	<dl>
		<dt>
			FundQuery<img
				src="${pageContext.request.contextPath}/menu/images/left/select_xl01.png">
		</dt>
		<dd class="first_dd">
			<a href="${pageContext.request.contextPath }/GetTopFundController">EverydayTop</a>
		</dd>
		<dd>
			<a href="${pageContext.request.contextPath }/GetTopFundController">EverydayLow</a>
		</dd>
		
		<dd>
			<a href="${pageContext.request.contextPath}/SpecifyFundQueryController">SpecifyFundQuery</a>
		</dd>
	</dl>

</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/menu/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/menu/js/left.js"></script>
