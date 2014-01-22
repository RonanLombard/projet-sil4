<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="fr.iut2.sil4.data.Etudiant"%>
<%@ page import="fr.iut2.sil4.data.EtudiantPeer"%>

<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="<%=getServletContext().getContextPath() %>/JSP/commun/bootstrap/css/bootstrap.min.css">
		<script src="<%=getServletContext().getContextPath() %>/JSP/commun/jquery-1.10.2.min.js"></script>
		<script src="<%=getServletContext().getContextPath() %>/JSP/commun/bootstrap/js/bootstrap.min.js"></script>
		<title>Accueil</title>
	</head>
	<body>
		<div class="container">
			<jsp:include page="/JSP/commun/header.jsp"/>
			<jsp:include page="/JSP/commun/navbar.jsp"/>
			
			<%
			
				/*
				Etudiant etu = new Etudiant();
				etu.setFirstName("nom");
				etu.setLastName("pnom");
				etu.save();
				*/
			
				for (Etudiant etudiant : EtudiantPeer.doSelectAll()) {
					out.write("<p>Prenom : " + etudiant.getFirstName() + "</br>");
					out.write("Nom : " + etudiant.getLastName() + "</p>");
				}
			%>
			<jsp:include page="/JSP/commun/footer.jsp"/>
		</div>
	</body>
</html>