<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>ProductServlet</title>
</head>
<body>

<h1>Products</h1>
<pre>${products}</pre>

<h2>Request Info</h2>
<p>Context Path: ${contextPath}</p>
<p>Servlet Path: ${servletPath}</p>
<p>Path Info: ${pathInfo}</p>
<p>Query String: ${queryString}</p>
<p>Parameter1: ${param1}</p>
<p>Parameter2: ${param2}</p>
<p>User-Agent: ${user-agent}</p>
<p>Session Counter: ${counter}</p>

</body>
</html>