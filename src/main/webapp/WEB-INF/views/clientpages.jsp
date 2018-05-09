<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%@taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col s12 l12">
			<div class="row">

				<f:form class="col s12 m8 l5 offset-l4 white"
					modelAttribute="client" action="saveClient" method="post">
					<legend>
						<h4>Information Client</h4>
					</legend>
					<div class="input_fields_wrap">
						<div class="row" id="1">
							<div class="input-field col s12 m8 l2">
								<f:input path="clientId" type="text" class="validate"
									readonly="true" />

								<label for="clientId">Id Client:</label>
							</div>
							<div class="input-field col s12 m8 l2">
								<f:input path="clientNom" type="text" class="validate" />
								<label for="clientNom">Nom Client:</label>
							</div>
							<div class="input-field col s12 m8 l5">
								<f:input path="clientPrenom" type="text" class="validate" />
								<label for="clientPrenom">Prénom Client :</label>
							</div>
							<div class="input-field col s12 m8 l5">
								<f:input path="dateNaissanceClient" type="text" class="validate" />
								<label for="dateNaissanceClient">Date de naissance :</label>
							</div>
							<div class="input-field col s12 m8 l5">
								<f:input path="adresseClient" type="text" class="validate" />
								<label for="adresseClient">Adresse client :</label>
							</div>
							<tr>
								<f:select path="ville.idVille" items="${villelist}"
									itemValue="idVille" itemLabel="idVille"></f:select>
								<label for="idVille">Ville Id</label>
							</tr>
							<div class="input-field col s12 m8 l5">
								<f:input path="clientTelephone" type="text" class="validate" />
								<label for="clientTelephone">Numéro téléphone :</label>
							</div>
							<div class="input-field col s12 m8 l5">
								<f:input path="mail" type="text" class="validate" />
								<label for="mail">Mail :</label>
							</div>
							<div class="input-field col s12 m8 l5">
								<f:input path="clientType" type="text" class="validate" />
								<label for="clientType">Type du client :</label>
							</div>
							<div class="input-field col s12 m8 l5">
								<f:input path="dateDebutClient" type="text" class="validate" />
								<label for="dateDebutClient">Date en tant que Client :</label>
							</div>
							<div class="input-field col s12 m8 l5">
								<f:input path="montantAvoir" type="text" class="validate" />
								<label for="montantAvoir">Montant avoir :</label>
							</div>
							<div class="input-field col s12 m8 l5">
								<f:input path="monantDu" type="text" class="validate" />
								<label for="monantDu">Montant Du :</label>
							</div>
							<div class="input-field col s12 m8 l5">
								<f:input path="tauxRemise" type="text" class="validate" />
								<label for="tauxRemise">Taux de remise :</label>
							</div>
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
				<span>${error}</span>
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
										<th>ID Client</th>
										<th>Nom</th>
										<th>Prénom</th>
										<th>Date de naissance</th>
										<th>Adresse</th>
										<th>Ville</th>
										<th>Numéro Téléphone</th>
										<th>Mail</th>
										<th>Type Client</th>
										<th>Date début Client</th>
										<th>Montant Avoir</th>
										<th>Montant Du</th>
										<th>Taux de remise</th>
									</tr>
								</thead>
								<c:forEach items="${clientlist}" var="clientlist">
									<tr>
										<td>${clientlist.clientId}</td>
										<td>${clientlist.clientNom}</td>
										<td>${clientlist.clientPrenom}</td>
										<td><fmt:formatDate
												value="${clientlist.dateNaissanceClient}"
												pattern="dd/MM/yyyy" type="date" /></td>
										<td>${clientlist.adresseClient}</td>
										<td>${clientlist.ville.idVille}</td>
										<td>${clientlist.clientTelephone}</td>
										<td>${clientlist.mail}</td>
										<td>${clientlist.clientType}</td>
										<td><fmt:formatDate value="${clientlist.dateDebutClient}"
												pattern="dd/MM/yyyy" type="date" /></td>
										<td>${clientlist.montantAvoir}</td>
										<td>${clientlist.monantDu}</td>
										<td>${clientlist.tauxRemise}</td>
										<td><a href="editClient?clientId=${clientlist.clientId}">Modification</a></td>
										<td><a
											href="deleteClient?clientId=${clientlist.clientId}">Supprimer</a></td>
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