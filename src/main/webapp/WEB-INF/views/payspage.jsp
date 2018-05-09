<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col s12 l12">
			<div class="row">

				<f:form class="col s12 m8 l5 offset-l4 white" modelAttribute="test"
					action="savePays" method="post">
					<legend>
						<h4>Information Pays</h4>
					</legend>
					<div class="row" id="1">
						<div class="input-field col s12 m8 l2">
							<f:input path="id" type="text" class="validate" />
							<label for="paysId">Pays Id:</label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="lib" type="text" class="validate" />
							<label for="paysLib">Pays Libelle :</label>
						</div>
					</div>
					<div class="row" id="1">
						<div class="input-field col s12 m8 l2">
							<f:input path="id" type="text" class="validate" />
							<label for="paysId">Pays Id:</label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="lib" type="text" class="validate" />
							<label for="paysLib">Pays Libelle :</label>
						</div>
					</div>
					<div class="row">
						<div class="col s12 m12 l12">
							<div class="col s12 m7 l3">
								<button class="btn waves-effect waves-light " type="submit"
									name="action">
									Sauvegarder<i class="material-icons right">done</i>
								</button>
							</div>
							<div class="col s12 m7 l2 offset-l5 ">
								<button class="btn waves-effect waves-light red lighten-1 right"
									type="reset" name="action">
									Annuler<i class="material-icons right">replay</i>
								</button>
							</div>
						</div>
					</div>
				</f:form>
			</div>
			<div class="row">
				<f:form class="col s12 m12 l12 white">
					<legend>
						<h5>Liste des Pays</h5>
					</legend>
					<div class="col s12 l12">
						<div>
							<table class="striped bordered highlight centered white"
								id="recherche">
								<thead>
									<tr>
										<th>ID PAYS</th>
										<th>LIB PAYS</th>
										<th>Action</th>
									</tr>
								</thead>
								<c:forEach items="${payslist}" var="payslis">
									<tr>
										<td>${payslis.paysId}</td>
										<td>${payslis.paysLib}</td>
										<td><a href="editPays?paysId=${payslis.paysId}">Modification</a></td>
										<td><a href="deletePays?paysId=${payslis.paysId}">Supprimer</a></td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</f:form>
			</div>
		</div>
	</div>



</body>
</html>