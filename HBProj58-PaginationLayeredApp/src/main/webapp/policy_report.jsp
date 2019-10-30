<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> 
 
 <c:choose>
     <c:when test="${!empty pageData}">
         <table border="1">
           <tr><th>policyId </th><th>policyName</th> <th>policyHoderName</th><th>tenure</th> </tr>
         <c:forEach var="dto" items="${pageData}">
              <tr>
                 <td>${dto.policyId} </td>
                 <td>${dto.policyName} </td>
                 <td>${dto.policyHolderName} </td>
                 <td>${dto.tenure} </td>
              </tr>
         </c:forEach>
         </table>
         <br><br>
         <!-- dispaly hyperlinks -->
         <c:forEach var="i"  begin="1"  end="${pageCount }" step="1">
             [<a href="controller?type=link&pageNo=${i }">${i}</a>] &nbsp;&nbsp;&nbsp;&nbsp;
         </c:forEach>
         
     </c:when>
     <c:otherwise>
            <b> data not found</b>
     </c:otherwise>
 </c:choose>   
