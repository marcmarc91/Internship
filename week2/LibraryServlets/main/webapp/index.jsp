<%@page import="utils.UserRepo"%>
<%@page import="java.util.Map"%>
<%@page import="model.User"%>
<html>
    <body>
        <h2>Login</h2>
        <form action="login" name="login" method="POST">
            <table>
                <tr>
                    <td>
                        <label for="username">Your name:</label>
                        <input type="text" name="username" id="username">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="password">Your password:</label>
                        <input type="password" name="password" id="password">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit">
                    </td>
                </tr>
            </table>
    </form>
        <h3>Try login with:</h3>
        <ul>
        <% Map<String, User> users = UserRepo.getInstance().getAllUsers(); %>
        <%  for (String string : users.keySet()) { %>
            <li><%=(users.get(string).getName() + "/" + users.get(string).getPassword())%></li>
        <%}%>
        </ul>
    </body>
</html>
