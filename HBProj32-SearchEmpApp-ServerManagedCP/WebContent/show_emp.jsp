
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
    <c:choose>
      <c:when test="${!empty empData }">
            <h1 style="color:red;text-align:center"> Emloyee DEtails </h1>
            <b>emp number :: ${empData.eid } </b> <br>
             <b>emp name :: ${empData.ename } </b> <br>
              <b>emp salary :: ${empData.salary} </b> <br>
             <b>emp email :: ${empData.email} </b> <br>
        </c:when>
        <c:otherwise>
              <b> Record not found</b>
        </c:otherwise>
     </c:choose>
     <br><br>
     <a href="search.html">home</a>
     