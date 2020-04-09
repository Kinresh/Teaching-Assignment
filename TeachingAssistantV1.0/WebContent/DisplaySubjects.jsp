<%@page import="java.util.ArrayList"%>
<%@page import="com.abc.model.SubjectModel"%>
<%@page import="java.util.List"%>
<script type="text/javascript">

function permanentDelete(id)
{
	if(confirm("Delete this subject permanently?"))
		{
		window.location.href="subject?q=deletesubject&id="+id;
		}
}
function enable(id)
{
	if(confirm("Activate Subject?"))
		{
		window.location.href="subject?q=enablesubject&id="+id;
		}
}
function disable(id)
{
	if(confirm("Disable Subject?"))
		{
		window.location.href="subject?q=disablesubject&id="+id;
		}
}
function update(id)
{
	if(confirm("Update subject details?"))
		{
		window.location.href="forward?q=updatesubject&id="+id;
		}
}
function deleteSelected()
{
	var u = new Array();
	var t=0;
	var ar = document.getElementsByName('select');
	for(var j=0 ; j<ar.length ; j++)
		{
		
			if(ar[j].checked)
			{
				u.push(ar[j].value);
				t=1;
				
			}
		}
	
	if(t==1)
		{
		if(confirm("Delete selected subjects permenantly?"))
			{
			window.location.href="subject?q=multipledeletesubjects&ids="+u;
			}
		}
	else
		alert("No account selected.");
}</script>
<%
int i = 1;
List<SubjectModel> subjects = null;
subjects =(ArrayList) request.getAttribute("subjects");
%>
<header class="head">
	<div class="main-bar">
    	<div class="row no-gutters">
        	<div class="col-6">
            	<h4 class="m-t-5">
                	<i class="fa fa-home"></i>
                    	Subjects
				</h4>
			</div>
		</div>
	</div>                    
</header>
<div class="outer">
	<div class="inner bg-container">
    	<div class="row">
			<div class="col-12 data_tables">
				<div class="card">
					<div class="card-body p-t-10">
						<div class=" m-t-25">

<!-- <input type="button" onclick="deleteSelected()" value="Delete Selected" /> -->
<input type="button" onclick="window.location.href = 'forward?q=addnewsubject'" value="Add New Subject" />
<table class="table table-striped table-bordered table-hover " id="sample_6">
<thead>
<tr>

<!-- <th>CHECKBOX</th> -->

<th>SR NO.</th>

<th>SUBJECT-CODE</th>

<th>SUBJECT-NAME</th>

<th>DESCRIPTION</th>

<th>MAX INSTRUCTOR</th>

<th>ACTION</th>

</tr>
</thead>
<tbody>
<%
if(subjects != null)
{
for(int k = 0;k<subjects.size();k++)
{
%>
<tr>

<%-- <td><input type="checkbox" name="select" value="<%= subjects.get(k).getSubjectID() %>"/></td> --%>

<td><%=i%></td>

<td><%=subjects.get(k).getSubjectCode()%></td>

<td><%=subjects.get(k).getSubjectName()%></td>

<td><%=subjects.get(k).getSubjectDescription()%></td>

<td><%=subjects.get(k).getMaxInstructor()%></td>

<%
if(subjects.get(k).getActive_flag() == 1)
{
%>
<td>
<input type="button" onclick="permanentDelete(<%=subjects.get(k).getSubjectID() %>)" value="Delete" />
<input type="button" onclick="disable(<%=subjects.get(k).getSubjectID() %>)" value="Disable" />
<input type="button" onclick="update(<%=subjects.get(k).getSubjectID() %>)" value="Update" />
</td>
<%
}
else
{
%>
<td style="background: red;">
<input type="button" onclick="permanentDelete(<%=subjects.get(k).getSubjectID() %>)" value="Delete" />
<input type="button" onclick="enable(<%=subjects.get(k).getSubjectID() %>)" value="Enable" />
<input type="button" onclick="update(<%=subjects.get(k).getSubjectID() %>)" value="Update" /></td>
<%
}
%>

</tr>
<%
i++;
}
}
else{
	%>
	<tr>
	<td colspan="5"> 
	no record found
	</td>
	</tr>
	<% 
}
%>
</tbody>
</table>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>