<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<c:catch var="ik">
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
			response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
			response.setHeader("Expires", "0");

			if (session.getAttribute("name") == null) {
				response.sendRedirect("papa.php?a=101");
			}
	%>
<html class="no-js" lang="en">
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<head>
    <meta charset="UTF-8">
    <title>Teaching Assignment</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="img/uofwfavicon.ico"/>

    <link type="text/css" rel="stylesheet" href="css/components.css" />
    <link type="text/css" rel="stylesheet" href="css/custom.css" />
    <link type="text/css" rel="stylesheet" href="css/customized.css" />
    <link type="text/css" rel="stylesheet" href="css/sliderc1.css" />

    <link type="text/css" rel="stylesheet" href="vendors/chartist/css/chartist.min.css" />
    <link type="text/css" rel="stylesheet" href="vendors/circliful/css/jquery.circliful.css">
    <link type="text/css" rel="stylesheet" href="css/pages/index.css">

	<link type="text/css" rel="stylesheet" href="vendors/select2/css/select2.min.css" />
    <link type="text/css" rel="stylesheet" href="vendors/datatables/css/scroller.bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="vendors/datatables/css/colReorder.bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="vendors/datatables/css/dataTables.bootstrap.css" />
    <link type="text/css" rel="stylesheet" href="css/pages/dataTables.bootstrap.css" />
    <link type="text/css" rel="stylesheet" href="css/plugincss/responsive.dataTables.min.css" />

    <link type="text/css" rel="stylesheet" href="css/pages/tables.css" />
    <link type="text/css" rel="stylesheet" href="vendors/bootstrap-switch/css/bootstrap-switch.min.css" />
    <link type="text/css" rel="stylesheet" href="vendors/switchery/css/switchery.min.css" />
    <link type="text/css" rel="stylesheet" href="vendors/radio_css/css/radiobox.min.css" />
    <link type="text/css" rel="stylesheet" href="vendors/checkbox_css/css/checkbox.min.css" />

    <link type="text/css" rel="stylesheet" href="css/pages/radio_checkbox.css" />
    <link type="text/css" rel="stylesheet" href="#" id="skin_change" />

	<link type="text/css" rel="stylesheet" href="vendors/chosen/css/chosen.css"/>
    <link type="text/css" rel="stylesheet" href="css/pages/form_elements.css"/>
</head>

<body class="body">
<div class="preloader homec1">
    <div class="preloader_img homec2" >
        <img src="img/loader.gif" style=" width: 50px;" alt="loading...">
    </div>
</div>
<div id="wrap">
    <div id="top">
        <nav class="navbar navbar-static-top">
            <div class="container-fluid m-0">
                <div class="menu" style="margin-left:0px " >
                    <span class="toggle-left" id="menu-toggle">
                        <i class="fa fa-bars"></i>
                    </span>
                </div>
                <a class="navbar-brand" href="#">
                    <h4> <img src="img/uwindsor_shield.svg" class="admin_img iconc1" alt="logo"> TEACHING ASSIGNMENT</h4>
                </a>
                <div class="topnav dropdown-menu-right">
                    <div class="btn-group">
                        <div class="notifications no-bg">
                            <a class="btn btn-default btn-sm messages" data-toggle="dropdown" id="messages_section"> <i
                                    class="fa fa-envelope-o fa-1x"></i>
                                <span class="badge badge-pill badge-warning notifications_badge_top">0</span>
                            </a>
                            <div class="dropdown-menu drop_box_align" role="menu" id="messages_dropdown">
                                <div class="popover-header">You have 0 Messages</div>
                                <div id="messages">
                                </div>
                                <div class="popover-footer">
                                    <a href="mail_inbox.html" class="text-white">Inbox</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="btn-group">
                        <div class="notifications messages no-bg">
                            <a class="btn btn-default btn-sm" data-toggle="dropdown" id="notifications_section"> <i
                                    class="fa fa-bell-o"></i>
                                <span class="badge badge-pill badge-danger notifications_badge_top">0</span>
                            </a>
                            <div class="dropdown-menu drop_box_align" role="menu" id="notifications_dropdown">
                                <div class="popover-header">You have 0 Notifications</div>
                                <div id="notifications">
                                </div>
                                <div class="popover-footer">
                                    <a href="#" class="text-white">View All</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="btn-group">
                        <div class="notifications request_section no-bg">
                            <a class="btn btn-default btn-sm messages" id="request_btn"> <i
                                    class="fa fa-sliders" aria-hidden="true"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.container-fluid -->
        </nav>

    </div>
    <!-- /#top -->
    <div class="wrapper">
        <div id="left">
            <div class="menu_scroll">
                <div class="left_media">
                    <div class="media user-media">
                        <div class="user-wrapper">
                            <a class="user-link" href="#">
                                <p class="user-info menu_hide" style="margin: 0 0 5px 10px;padding:20px 0 0 0;font-size:21px; ">Welcome, <span style="text-transform: capitalize;">${sessionScope.name}</span></p>
                            </a>
                        </div>	
                    </div>
                    <hr/>
                </div>
                <ul id="menu">
                    <li class="active">
                        <a href="home">
                            <i class="fa fa-tachometer"></i>
                            <span class="link-title menu_hide">&nbsp;Dashboard

                            </span>
                        </a>
                    </li>
                    <c:if test="${sessionScope.role eq 'admin'}">
                    <li>
                    	<a href="forward?q=displayallusers">
                            <i class="fa fa-calendar"></i>
                            <span class="link-title menu_hide">&nbsp; View All Users</span>
                        </a>
                    </li>
                    <li class="dropdown_menu">
                        <a href="javascript:;">
                            <i class="fa fa-th-large"></i>
                            <span class="link-title menu_hide">&nbsp; Subjects</span>
                            <span class="fa arrow menu_hide"></span>
                        </a>
                        <ul>
                            <li>
                            	<a href="forward?q=displayallsubjects">
                                    <i class="fa fa-angle-right"></i>
                                    &nbsp; Display All Subjects
                                </a>
                            </li>
                            <li>
                                <a href="forward?q=addnewsubject">
                                    <i class="fa fa-angle-right"></i>
                                    &nbsp; Add New Subject
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown_menu">
                        <a href="javascript:;">
                            <i class="fa fa-th-large"></i>
                            <span class="link-title menu_hide">&nbsp; Programs</span>
                            <span class="fa arrow menu_hide"></span>
                        </a>
                        <ul>
                            <li>
                            	<a href="forward?q=displayallprograms">
                                    <i class="fa fa-angle-right"></i>
                                    &nbsp; Display All Programs
                                </a>
                            </li>
                            <li>
                            	<a href="forward?q=addnewprogram">
                            		<i class="fa fa-angle-right"></i>
                            		&nbsp; Add New Program
                            	</a>
							</li>
                        </ul>
                    </li>
                    <li class="dropdown_menu">
                        <a href="javascript:;">
                            <i class="fa fa-th-large"></i>
                            <span class="link-title menu_hide">&nbsp; Program Timelines</span>
                            <span class="fa arrow menu_hide"></span>
                        </a>
                        <ul>
                            <li>
	                            <a href="forward?q=displayallprogramtimelines">
	                            	<i class="fa fa-angle-right"></i>
	                            	&nbsp; Display All Program Timelines
	                            </a>
                            </li>
							<li>
								<a href="forward?q=addnewprogramtimeline">
									<i class="fa fa-angle-right"></i>
                            		&nbsp; Add New Program Timeline
								</a>
							</li>
                        </ul>
                    </li>
                    <li class="dropdown_menu">
                        <a href="javascript:;">
                            <i class="fa fa-th-large"></i>
                            <span class="link-title menu_hide">&nbsp; Schedule</span>
                            <span class="fa arrow menu_hide"></span>
                        </a>
                        <ul>
                            <li>
	                            <a href="forward?q=displayallschedules&in=if">
	                            	<i class="fa fa-angle-right"></i>
	                            	&nbsp; Display All Schedules
	                            </a>
                            </li>
							<li>
								<a href="forward?q=addnewschedule">
									<i class="fa fa-angle-right"></i>
                            		&nbsp; Add New Schedule
								</a>
							</li>
                        </ul>
                    </li>
					</c:if>
                    <li class="dropdown_menu">
                        <a href="javascript:;">
                            <i class="fa fa-th-large"></i>
                            <span class="link-title menu_hide">&nbsp; Input Form</span>
                            <span class="fa arrow menu_hide"></span>
                        </a>
                        <ul>
                            <li>
	                            <a href="forward?q=displayallschedules&in=if">
	                            	<i class="fa fa-angle-right"></i>
		                            &nbsp; Display All Input Forms
	                            </a>
                            </li>
                            <c:if test="${sessionScope.role eq 'admin'}">
							<li>
								<a href="forward?q=addnewinputform">
									<i class="fa fa-angle-right"></i>
	                            	&nbsp; Add New Input Form
								</a>
							</li>
							</c:if>
                        </ul>
                    </li>
                    <li class="dropdown_menu">
                        <a href="javascript:;">
                            <i class="fa fa-th-large"></i>
                            <span class="link-title menu_hide">&nbsp; Faculty Selection</span>
                            <span class="fa arrow menu_hide"></span>
                        </a>
                        <ul>
                            <li>
                            	<a href="forward?q=displayallschedules&in=fs">
                            		<i class="fa fa-angle-right"></i>
	                            	&nbsp; Display All Faculty Selections
                            	</a>
                            </li>
                        </ul>
                    </li>
                	<li>
                		<a href="insert.php?a=61">
                            <i class="fa fa-calendar"></i>
                            <span class="link-title menu_hide">&nbsp; Logout</span>
                        </a>
                    </li>
                </ul>
                <!-- /#menu -->
            </div>
        </div>
        <!-- /#left -->
        <div id="content" class="bg-container">
            
            
                        <!-- Add contect in this div -->
                        <div id="kinresh">
							<c:if test="${param.p ne null}">
								<c:import url="${param.p}.jsp"></c:import>
							</c:if>
							<c:if test="${param.p eq null}">
								<c:import url="Dashboard.jsp"></c:import>
							</c:if>
							
							<c:if test="${ik ne null}">
								<c:redirect url="error.jsp"></c:redirect>
							</c:if>
						</div>
                    
        </div>
        <!-- /#content -->
    </div>
    <!--/#wrapper-->
</div>
<!-- /#wrap -->

<script type="text/javascript" src="js/components.js"></script>
<script type="text/javascript" src="js/custom.js"></script>

<script type="text/javascript" src="vendors/chartist/js/chartist.min.js"></script>
<script type="text/javascript" src="vendors/circliful/js/jquery.circliful.js"></script>
<script type="text/javascript" src="vendors/countUp.js/js/countUp.min.js"></script>
<script type="text/javascript" src="vendors/flip/js/jquery.flip.min.js"></script>
<script type="text/javascript" src="vendors/flotchart/js/jquery.flot.js" ></script>
<script type="text/javascript" src="vendors/flotchart/js/jquery.flot.resize.js"></script>
<script type="text/javascript" src="vendors/swiper/js/swiper.min.js"></script>
<script type="text/javascript" src="js/pluginjs/jquery.sparkline.js"></script>
<script type="text/javascript" src="js/pluginjs/chartist-tooltip.js"></script>


<script type="text/javascript" src="js/pluginjs/dataTables.tableTools.js"></script>
<script type="text/javascript" src="js/pluginjs/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="vendors/select2/js/select2.min.js"></script>
<script type="text/javascript" src="vendors/datatables/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="vendors/datatables/js/dataTables.colReorder.js"></script>
<script type="text/javascript" src="vendors/datatables/js/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="vendors/datatables/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="vendors/datatables/js/dataTables.responsive.min.js"></script>
<script type="text/javascript" src="vendors/datatables/js/dataTables.rowReorder.min.js"></script>
<script type="text/javascript" src="vendors/datatables/js/dataTables.scroller.min.js"></script>

<script type="text/javascript" src="vendors/bootstrap-switch/js/bootstrap-switch.min.js"></script>
<script type="text/javascript" src="vendors/switchery/js/switchery.min.js"></script>

<script type="text/javascript" src="js/pages/index.js"></script>
<script type="text/javascript" src="js/pages/datatable.js"></script>        
<script type="text/javascript" src="js/pages/radio_checkbox.js"></script>
<script type="text/javascript" src="js/pages/form_elements.js"></script>

<script type="text/javascript" src="vendors/chosen/js/chosen.jquery.js"></script>

</body>
</c:catch>
</html>