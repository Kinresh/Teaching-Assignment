<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<link type="text/css" media="css/print"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>

function displayPriority(p)
{
	var s = "priority"+p;
	var selectTag = document.getElementById(s);
	if (selectTag.style.display == "none") {
		selectTag.style.display = "block";
	}
	else
	{
		selectTag.style.display = "none";
	}
}
</script>
<%@page import="java.util.ArrayList"%>
<%@page import="com.abc.model.FacultySelectionDisplayModel"%>
<%@page import="com.abc.model.TermModel"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>

<% 
List<FacultySelectionDisplayModel> fs = null;
fs = (ArrayList) request.getAttribute("fs");
List<FacultySelectionDisplayModel> fs_backup = fs;
List<TermModel> terms = null;
terms = (ArrayList) request.getAttribute("terms");
int totalTerms = terms.size();
%>
<style>
	@media print{
		.print-container-c1{
			visibility: visible !important;
		}
		.nonprint-container-c1{
			visibility: hidden !important;
		}
		body{
			visibility: hidden;
		}	
		
	}
</style>
<div class=".print-container-c1">
<header class="head print-container-c1">
	<div class="main-bar">
    	<div class="row no-gutters">
        	<div class="col-6">
            	<h4 class="m-t-5">
                	<i class="fa fa-home nonprint-container-c1"></i>
                    	Preferences For <%=request.getAttribute("scheduleName")%>
				</h4>
			</div>
		</div>
	</div>                    
</header>
<div class="outer">
	<div class="inner bg-container">
    	<div class="row">
			<div class="col-12 data_tables">
				<div class="card cardHoverRemove" style="border: 0px;">
					<div style="padding-right: 20px;">
						<div class=" m-t-25">
						
<input type="button" onclick="window.print();" value="Print" />
<table border="1" class="tablec2 print-container-c1" id="fst1">
<thead>
<tr>
<th style="width:15%;">FACULTY</th>
<%
if(terms!=null)
{
for(int k=0 ; k<terms.size(); k++)
{
%>
<th><%=terms.get(k).getName() %></th>
<%
}
}
%>
</tr>
</thead>
<tbody>
<%
if(fs.size()!=0)
{
List<Integer> marked = new ArrayList<>();
for(int i=0; i<fs.size();i++)
{
	if(marked.contains(i)){
		continue;
	}
	%><tr>
		<td><%=fs.get(i).getUserName() %></td>
	<%
	for(int k=0; k<totalTerms;k++)
	{
		
		
		List<FacultySelectionDisplayModel> l = new ArrayList<>();
		for(int j=0; j<fs.size();j++)
		{
			if(fs.get(i).getUserID() == fs.get(j).getUserID())
			{
				if(terms.get(k).getWeb_termID() == fs.get(j).getWeb_termsID())
				{
					l.add(fs.get(j));
					marked.add(j);
				}		
				
			}
		}
		String p = "";
		int min=0;
		FacultySelectionDisplayModel t =null;
		for (int c=0;c<l.size();c++) {
			//System.out.println(l.get(c).getDescription() +"-"+ l.get(c).getPriorityID());
			min=c;
			for (int c2=c+1;c2<l.size();c2++) {
				//System.out.println(l.get(c2).getPriorityID()+"<"+l.get(min).getPriorityID());
				if(l.get(c2).getPriorityID()<l.get(c).getPriorityID())
				{
					t= l.get(c);
					l.set(c,  l.get(c2));
					l.set(c2, t);
				}
				//System.out.println("min-"+min);
			}
			//System.out.println("-"+l.get(min).getSubjectCode());
			/* if(p.equals(""))
			{
				p=p.concat(l.get(min).getSubjectCode());
			}
			else
			{
				p=p.concat(";"+l.get(min).getSubjectCode());
			} 
			l.remove(min); */
		}
		for(int c=0; c<l.size(); c++)
		{
			if(p.equals(""))
			{
				p=p.concat(l.get(c).getSubjectCode());
			}
			else
			{
				p=p.concat("; "+l.get(c).getSubjectCode());
			} 
		}

		%><td><%=p %></td><%
	}
		
	%></tr><%
}
}
else
{
%>
<tr><td colspan="<%=totalTerms+1%>">No Records Found</td></tr>
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
</div>