<%@page import="com.denkolochi.model.Historique"%>
<%@page import="java.util.List"%>


<%
List<Historique> historiques = (List<Historique>) request.getAttribute("historiques");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Historique</title>

<style>
body {
	background: #f4f6f9;
	font-family: 'Segoe UI', sans-serif;
}

.contenaire {
	
	width: 90%;
	margin: 30px auto;
}

.gauche {
	width: 35%;
	margin: 30px auto;
}



.droite {
	width: 65%;
	margin: 30px auto;
}

.titre {
	color: #2c3e50;
	margin-bottom: 25px;
}

.historique-card {
	background: white;
	border-radius: 15px;
	padding: 20px;
	margin-bottom: 15px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);
	border-left: 6px solid #2E9E3E;
	transition: 0.3s;
}

.historique-card:hover {
	transform: translateY(-3px);
}

.header-card {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.action {
	font-size: 18px;
	font-weight: bold;
	color: #2c3e50;
}

.date {
	color: #7f8c8d;
	font-size: 14px;
}

.details {
	margin-top: 12px;
	color: #555;
	line-height: 1.6;
}

.badge {
	display: inline-block;
	margin-top: 10px;
	padding: 5px 12px;
	border-radius: 20px;
	background: #e8f5e9;
	color: #2e7d32;
	font-size: 13px;
	font-weight: bold;
}
</style>

</head>
<body>
<div class="contenaire">
	
	<div class="droite">

		<h2 class="titre"> Historique de l'enfant</h2>

		<%
		if (historiques == null || historiques.isEmpty()) {
		%>

		<div class="historique-card">Aucun historique disponible.</div>

		<%
		} else {
		%>

		<%
		for (Historique h : historiques) {
		%>

		<div class="historique-card">

			<div class="header-card">

				<div class="action">
					<%=h.getAction()%>
				</div>

				<div class="date">
					<%=h.getDateAction()%>
				</div>

			</div>

			<div class="details">
				<%=h.getDetails()%>
			</div>

			<div class="badge">Suivi Enfant</div>

		</div>

		<%
		}
		%>

		<%
		}
		%>

	</div>
	</div>

</body>
</html>