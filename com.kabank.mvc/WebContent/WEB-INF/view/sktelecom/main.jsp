<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
<body>
<section>
	<button id="skt_create_btn">개통</button>
	<button>변경</button>
	<button>통신사변경</button>
</section>
<%@ include file="../common/footer.jsp" %>
<script>
	document.querySelector('#skt_create_btn').addEventListener('click', function(){
		location.href = "${ctx}/skt.do?cmd=create&page=mypage&dir=user";
	}, false);
</script>
</html>
