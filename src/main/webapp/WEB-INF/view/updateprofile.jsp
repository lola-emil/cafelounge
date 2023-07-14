<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:url var="imageFolder" value="/resources/image"/>
<c:url var="signinRoute" value="/signin"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Profile</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body >
    <div class="bg-[url('resources/image/background.jpg')] bg-cover bg-no-repeat justify-items-center ">
        <div class="bg-zinc-950/40 min-h-screen ">
            <div class="flex items-center h-24 pt-5">
                <nav class="pl-12">
                    <img class="h-56 cursor-pointer" src="${imageFolder}/logo.png" alt="">
                </nav>
            </div>
            <form:form class="flex justify-center items-center pt-32" action="${updateprofileRoute}" method="post" modelAttribute="userForm">
                <div>
                    <h1 class="text-white text-center text-3xl font-semibold">Update Profile</h1>
                    <c:if test="${not empty error}">
                        <div class="bg-red-500 text-white rounded p-3">
                            ${error}
                        </div>
                    </c:if>
                    <br>
                    <form:input type="text" path="username" placeholder="Username" class="p-2 w-96 items-start rounded-2xl" disabled="true"/>
                    <br><br>    
                    <form:input type="password" path="password" placeholder="Password" class="p-2 w-96 items-start rounded-2xl border-none" />
                    <br><br>
                    <form:input type="password" path="confirmPassword" placeholder="Confirm Password" class="p-2 w-96 items-start rounded-2xl border-none" />
                    <br><br>
                    <div class="flex justify-center">
                        <input type="submit" value="Submit" class="font-bold text-center text-black bg-orange-500 hover:bg-orange-400 rounded-3xl p-2 w-56">
                    </div>
                </div>
            </form:form>
        </div>
    </div>
    
</body>
</html>