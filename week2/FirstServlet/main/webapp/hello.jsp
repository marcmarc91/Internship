<html>
    <body>
    <form action="calculator" name="calculate" method="GET">
        <div>
            <h1>Hello <%= request.getAttribute("user") %></h1>
            <h1>Session <%= request.getSession().getAttribute("TEST") %></h1>

            Cookie:
            <%for (Cookie cookie : request.getCookies()){ 
                  out.print(cookie.getValue());
            }%>
            
        <table>
            <tr>
                <td>
                    <label for="fNumber">First number:</label>
                    <input type="number" name="first" id="fNumber">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="sNumber">Second number:</label>
                    <input type="number" name="second" id="sNumber">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit">
                </td>
            </tr>
        </table>           
        </div>
    </form>
</body>
</html>