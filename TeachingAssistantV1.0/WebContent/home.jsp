<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:catch var="ik">
<%-- <%=40/0 %> --%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setHeader("Expires", "0");


if(session.getAttribute("name") == null)
{
	response.sendRedirect("papa.php?a=40");
}
%>
<h1>welcome,${sessionScope.name}</h1>

<h1>
header
</h1>
<a href="papa.php?a=1">Add New User</a>
<span>  |  </span>
<!-- <a href="papa.php?a=2">triji record</a> -->
<a href="papa.php?a=5">Add New Country</a>
<span>  |  </span>
<a href="papa.php?a=6">Add New Specialization</a>
<span> | </span>
<a href="papa.php?a=3">View All Users(Admin)</a>
<span> | </span>
<a href="papa.php?a=4">View Active Users</a>
<span> | </span>
<a href="insert.php?a=61">Logout</a>


<div>

<c:if test="${param.p ne null}">
<c:import url="${param.p}.jsp"></c:import>
</c:if>
<c:if test="${param.p eq null}">
<c:import url="form.jsp"></c:import>
</c:if>


</div>

<h1>
footer
</h1>
</c:catch>
<c:if test="${ik ne null}">
<c:redirect url="error.jsp"></c:redirect>
</c:if>