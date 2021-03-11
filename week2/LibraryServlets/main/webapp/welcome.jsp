<%@page import="model.User"%>
<%@page import="utils.BookRepo"%>
<%@page import="java.util.Map"%>
<%@page import="model.Book"%>
<html>
    <head>
        <style>
            table {
              font-family: arial, sans-serif;
              border-collapse: collapse;
              width: 100%;
            }
            
            td, th {
              border: 1px solid #dddddd;
              text-align: left;
              padding: 8px;
            }
            
            tr:nth-child(even) {
              background-color: #dddddd;
            }
            </style>
    </head>
    <body>
    <h1>Cookie: Welcome <%for (Cookie cookie : request.getCookies()) {
           if (cookie.getName().equals("username")) { 
               out.print(cookie.getValue()); 
            }}%>
    </h2>
    <h1>Attribute: Welcome <%=request.getAttribute("userName")%></h1>
    <h1>Session: Welcome <%= ((User) request.getSession().getAttribute("userLogin")).getName()%></h1>
    <table>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Action</th>
            <th>Shopping cart</th>
        </tr>
        <%Map<String, Book> allBooks = BookRepo.getInstance().getAllBooks();
            for (String title : allBooks.keySet()) { %>
            <tr>
                <td><%=(allBooks.get(title).getTitle())%></td>
                <td><%=(allBooks.get(title).getAuthor())%></td>
                <td>
                    <a href="<%=request.getContextPath()%>/book?title=<%=title%>&scope=edit">Edit</a>
                    <a href="<%=request.getContextPath()%>/book?title=<%=title%>&scope=delete">Delete</a>
                </td>
                <td><a href="">Add</a></td>
               </tr>
                
           <% }%>
    </table>
    </body>
</html