<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${ sessionScope.login == 'successed' }">
	<a href="u_update.do">user update</a>
</c:if>
<c:if test="${ sessionScope.login == 'failed' || sessionScope.login == null }">
	<a href="u_login.do">login</a>
</c:if>