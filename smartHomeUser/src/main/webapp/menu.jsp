<<<<<<< HEAD
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${ sessionScope.login == 'successed' }">
	<a href="u_update.do">user update</a>
	<a href="u_logout.do">logout</a>
</c:if>
<c:if test="${ sessionScope.login == 'failed' || sessionScope.login == null }">
	<a href="u_login.do">login</a>
</c:if>
=======
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${ sessionScope.login == 'successed' }">
	<a href="u_update.do">user update</a>
	<a href="u_logout.do">logout</a>
</c:if>
<c:if test="${ sessionScope.login == 'failed' || sessionScope.login == null }">
	<a href="u_login.do">login</a>
</c:if>
>>>>>>> branch 'master' of https://github.com/u-joy-happy/smartHomeUser.git
