<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:catch var="ik">
	<%-- <%=40/0 %> --%>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
			response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
			response.setHeader("Expires", "0");

			if (session.getAttribute("name") == null) {
				response.sendRedirect("papa.php?a=101");
			}
	%>
<style type="text/css">
ul, li {
	margin: 0;
	padding: 0;
	font-size: 12px;
}

.a ul li {
	position: relative;
	cursor: pointer;
	display: inline-block;
	padding: 15px 20px;
}

.a ul li:hover {
	background: #000;
}

.a ul li:hover>a {
	color: #fff;
}

.a ul ul {
	display: none;
	background: black;
	top: 100%;
	left: 0;
	position: absolute;
}

.a ul ul li {
	position: relative;
	padding: 7px 15px;
	width: 200px;
}

.a ul ul li a {
	color: #fff;
	height: 100%;
}

.a ul ul ul {
	display: none;
	position: absolute;
	left: 100%;
	top: 0;
}

.a ul ul li::before {
	transition: all 0.3s ease-in;
	background: #005596;
	content: '';
	position: absolute;
	top: 0;
	left: 0;
	height: 100%;
	width: 0%;
	z-index: 0;
}

.a ul ul li:hover::before {
	width: 100%;
}

.a ul ul li:hover {
	background: none;
}

.a ul li:hover>ul {
	display: block;
}

.a ul ul li:hover>ul {
	display: block;
}

.a ul li a {
	font-size: 14px;
	text-transform: uppercase;
	text-decoration: none;
	color: #000;
	position: relative;
	z-index: 999;
}
</style>

	<h1>Welcome, ${sessionScope.name}</h1>

	<h1>header</h1>
	<!-- <a href="papa.php?a=1">Add New User</a>
<span> | </span>
<a href="papa.php?a=6">Add New Specialization</a>
<span> | </span> -->
	<div class="a">
		<ul>
			<li><a href="">Home</a></li>
			<li><a href="">Users</a>
				<ul>
					<li><c:if test="${sessionScope.role eq 'admin'}">
							<a href="forward?q=displayallusers">View All Users</a>
						</c:if></li>
				</ul></li>
			<li><a href="">Subjects</a>
				<ul>
					<li><a href="forward?q=displayallsubjects">Display All
							Subjects</a></li>
					<li><a href="forward?q=addnewsubject">Add New Subject</a></li>
				</ul></li>
			<li><a href="">Programs</a>
				<ul>
					<li><a href="forward?q=displayallprograms">Display All
							Programs</a></li>
					<li><a href="forward?q=addnewprogram">Add New Program</a></li>
				</ul></li>
			<li><a href="">Program Timelines</a>
				<ul>
					<li><a href="forward?q=displayallprogramtimelines">Display
							All Program Timelines</a></li>
					<li><a href="forward?q=addnewprogramtimeline">Add New
							Program Timeline</a></li>
				</ul></li>
			<li><a href="">Schedule</a>
				<ul>
					<li><a href="forward?q=displayallschedules&in=if">Display
							All Schedules</a></li>
					<li><a href="forward?q=addnewschedule">Add New Schedule</a></li>
				</ul></li>
			<li><a href="">Input Form</a>

				<ul>
					<li><a href="forward?q=displayallschedules&in=if">Display
							All Input Forms</a></li>
					<li><a href="forward?q=addnewinputform">Add New Input Form</a></li>
				</ul></li>
			<li><a href="">Faculty Selection</a>
				<ul>
					<li><a href="forward?q=displayallschedules&in=fs">Display
							All Faculty Selections</a></li>
				</ul></li>
			<li><a href="insert.php?a=61">Logout</a></li>
		</ul>
	</div>

	<div>

		<c:if test="${param.p ne null}">
			<c:import url="${param.p}.jsp"></c:import>
		</c:if>
		<c:if test="${param.p eq null}">
			<c:import url="Dashboard.jsp"></c:import>
		</c:if>


	</div>

	<h1>footer</h1>
</c:catch>
<c:if test="${ik ne null}">
	<c:redirect url="error.jsp"></c:redirect>
</c:if>