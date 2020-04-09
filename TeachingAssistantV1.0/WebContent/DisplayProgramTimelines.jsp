<%@page import="java.util.ArrayList"%>
<%@page import="com.abc.model.ProgramTimelineModel"%>
<%@page import="com.abc.model.ProgramModel"%>
<%@page import="java.util.List"%>
<script type="text/javascript">
function terms(id)
{
	
		window.location.href="subject?q=getprogramtimelineterms&id="+id;
		
}
function permanentDelete(id)
{
	if(confirm("Delete this program timeline permanently?"))
		{
		window.location.href="subject?q=deleteprogramtimeline&id="+id;
		}
}
function enable(id)
{
	if(confirm("Activate program timeline?"))
		{
		window.location.href="subject?q=enableprogramtimeline&id="+id;
		}
}
function disable(id)
{
	if(confirm("Disable program timeline?"))
		{
		window.location.href="subject?q=disableprogramtimeline&id="+id;
		}
}
function update(id)
{
	if(confirm("Update program timeline details?"))
		{
		window.location.href="forward?q=updateprogramtimeline&id="+id;
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
		if(confirm("Delete selected program timelines permenantly?"))
			{
			window.location.href="subject?q=multipledeleteprogramtimelines&ids="+u;
			}
		}
	else
		alert("No account selected.");
}</script>
<%
int i = 1;
List<ProgramTimelineModel> pts = null;
pts =(ArrayList) request.getAttribute("pts");
List<ProgramModel> programs = null;
programs =(ArrayList) request.getAttribute("programs");
int pIndex =0;

%>
<header class="head">
	<div class="main-bar">
    	<div class="row no-gutters">
        	<div class="col-6">
            	<h4 class="m-t-5">
                	<i class="fa fa-home"></i>
                    	Program Timelines
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
<input type="button" onclick="window.location.href = 'forward?q=addnewprogramtimeline'" value="Add New Program Timeline" />
<table class="table table-striped table-bordered table-hover " id="sample_6">
<thead>
<tr>

<!-- <th>CHECKBOX</th> -->

<th>SR NO.</th>

<th>PROGRAM-NAME</th>

<th>STARTING-TERM</th>

<th>TOTAL TERMS</th>

<th>TERMS</th>

<th>ACTION</th>

</tr>
</thead>
<tbody>
<%
if(pts != null)
{
for(int k = 0;k<pts.size();k++)
{
%>
<tr>

<%-- <td><input type="checkbox" name="select" value="<%= pts.get(k).getPtID() %>"/></td> --%>

<td><%=i%></td>

<%
for(int m = 0;m<programs.size();m++)
{
	if(pts.get(k).getProgramID() == programs.get(m).getProgramID())
	{
		pIndex = m;
	}
}
%>
<td><%= programs.get(pIndex).getProgramName()%></td>

<td><%=pts.get(k).getStartingTerm() +" "+pts.get(k).getStartingYear()%></td>
<td><%=programs.get(pIndex).getTotalTerms()%></td>
<td><input type="button" onclick="terms(<%=pts.get(k).getPtID() %>)" value="Edit Terms" /></td>

<%
if(pts.get(k).getActive_flag() == 1)
{
%>
<td>
<input type="button" onclick="permanentDelete(<%=pts.get(k).getPtID() %>)" value="Delete" />
<input type="button" onclick="disable(<%=pts.get(k).getPtID() %>)" value="Disable" />
<input type="button" onclick="update(<%=pts.get(k).getPtID() %>)" value="Update" />
</td>
<%
}
else
{
%>
<td style="background: red;">
<input type="button" onclick="permanentDelete(<%=pts.get(k).getPtID() %>)" value="Delete" />
<input type="button" onclick="enable(<%=pts.get(k).getPtID() %>)" value="Enable" />
<input type="button" onclick="update(<%=pts.get(k).getPtID() %>)" value="Update" /></td>
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