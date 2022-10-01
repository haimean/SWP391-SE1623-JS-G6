<%-- 
    Document   : index
    Created on : 18-09-2022, 23:04:55
    Author     : haimi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="cd" uri="http://java.sun.com/jstl/core_rt" %>--%>

<!DOCTYPE html>

<%@include file="../layout/index.jsp"  %>
<link href="<%=request.getContextPath()%>/admin/user/style.css" rel="stylesheet">


<div class="content-wrap">
    <div class="main">
        <div class="container">
            <section id="main-content">
                <div class="table-responsive table-container">
                    <div>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Email</th>
                                    <th>Role</th>
                                    <th>Ban</th>   
                                </tr>
                            </thead>
                            <!--                            <tbody>
                            <cd:forEach var="u" items="${listU}">
                                <tr>
                                    <td>${u.id}</td>
                                    <td>${u.email}</td>
                                    <td>${u.role}</td>   
                                    <td>ban</td>
                                </tr>
                            </cd:forEach>
                            
                        </tbody>-->
                            <tbody>
                                <%
                                ArrayList<User> listUsers = new DAOUser().getAllUsers();
                                if(listUsers != null){
                                    for(User u : listUsers){
                                %>
                                <tr>
                                    <td><%=u.getId()%></td>
                                    <td><%=u.getEmail()%></td>
                                    <td><%=u.getRole()%></td>   
                                    <td>ban</td>
                                </tr>
                                <%
                                    }
                                }
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </section>
        </div>
    </div>
</div>


