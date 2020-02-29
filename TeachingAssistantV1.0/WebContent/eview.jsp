<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<script type="text/javascript">

function abcfcb(ghhh)
{
	if(confirm("kharekahr delete karvu 6??"))
		{
		window.location.href="insert.php?a=3&id="+ghhh;
		}
}

function abcd(ghhh)
{
	if(confirm("kharekahr update karvu 6??"))
		{
		window.location.href="papa.php?a=56&id="+ghhh;
		}
}

function per()
{
    var y = 0;
	var kn = document.getElementsByName('abc');  
	  for (var i=0; i<kn.length; i++) {
		     // And stick the checked ones onto an array...
		     if (kn[i].checked) {
		      y = 1;  
		     }
		  }
	if(y == 1)
		{
	
	if(confirm("kharekahr multiple delete karvu 6??"))
		{
		document.getElementById('pqw').submit();
		}
		}
	else{
		alert("koi select to karto!!");
	}
		}

</script>



<c:set value="vijay p" var="fs" scope="request"></c:set>
<c:set value="vijay pra" var="fs" scope="session"></c:set>
${requestScope.fs}${sessionScope.fs}

<c:remove scope="session" var="fs"/>

${requestScope.fs}${sessionScope.fs}
<c:catch var="ik">
<%-- <%=40/0 %> --%>

<form action="insert.php" id="pqw" method="post">
<input type="button" onclick="per()" value="DELETE"/>
<input type="hidden" name="action" value="mdel"/>
<table border="1">
<tr>

<th>

</th>
<th>
SR NO.
</th>
<th>
FULLNAME
</th>
<th>
NUMBER
</th>
<th>
GENDER
</th>
<th>
HOBBIES
</th>
<th>
ACTION
</th>
</tr>

<c:choose>
<c:when test="${not empty list}">
<c:forEach items="${list}" var="f" varStatus="count">
<tr>

<td><input type="checkbox"  name="abc" id="pet" value="${f.id}" /></td>

<td>${count.count}</td>

<td><c:out value="${fn:toUpperCase(f.fname)}"></c:out></td>

<td>${f.number}</td>

<td>${f.gender}</td>

<td>
<c:forTokens var="h" items="${f.hob}" delims=",">
${h}<br/>
</c:forTokens>

</td>

<td><input type="button" onclick="abcfcb(${f.id})" value="delete" />
<input type="button" onclick="abcd(${f.id})" value="update" />
</td>

</tr>
</c:forEach>
</c:when>
<c:otherwise>
	<tr>
	<td colspan="5"> 
	no record found
	</td>
	</tr>
	</c:otherwise>
	</c:choose>
</table>
</form>
</c:catch>
<c:if test="${ik ne null}">
<h1>
${ik}
</h1>
</c:if>