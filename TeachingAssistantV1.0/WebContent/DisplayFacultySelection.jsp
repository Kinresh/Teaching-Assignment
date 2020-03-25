<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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

<table border="1">
<tr>
<th>FACULTY</th>
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
<%
if(fs!=null)
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
				p=p.concat(";"+l.get(c).getSubjectCode());
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
<tr>no records found</tr>
<%	
}
%>
</table>


