<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xx
  Date: 13.04.2017
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Klienci</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Klienci</h1>
            <p>Wszyscy klienci dostepni w naszym sklepie</p>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <c:forEach items="${customers}" var="customer">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>Nazwisko: ${customer.surname}</h3>
                        <p>Imie: ${customer.name}</p>
                        <p>Adres: ${customer.address}</p>
                        <p>Liczba zamowien: ${customer.noOfOrdersMade}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
</body>
</html>
