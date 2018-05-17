<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%><%@ taglib
	prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>TANA SOFT SOLUTION Facture</title>

<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="assets/js/bootstrap-datepicker/css/datepicker.css" />
<link rel="stylesheet" type="text/css"
	href="assets/js/bootstrap-daterangepicker/daterangepicker.css" />

<!-- Custom styles for this template -->
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/style-responsive.css" rel="stylesheet">

<!--Jquerry -->
<script src="assets/Jquery/jquery.min.js"></script>
<script src="assets/Jquery/jquery.js"></script>
<script src="assets/Jquery/jquery-3.3.1.min.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<!-- Entête du modal -->
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">&times;</button>
		<h4 class="modal-title">Nouveau Client</h4>
	</div>
	<!-- Contenu du modal -->
	<div class="modal-body">
		<form class="form-horizontal style-form" method="get"></form>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	</div>
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
							<div class="form-group">
								<label class="col-sm-2 col-sm-2 control-label">Type de
									client</label>
								<div class="col-sm-10">
									<f:select path="clientType" id="clientType"
										class="form-control">
										<f:option value="Particulier">Client Particulier</f:option>
										<f:option value="Professionnel">Client Professionnel</f:option>
									</f:select>
								</div>

								<h2>Coordonnées</h2>
								<div id="clientParticulier" class="typeClientCoordonnees">
									<div class="input-field col s12 m8 l2">
										<f:input path="nomSociete" type="text" class="validate" />
										<label for="nomSociete">Nom Société:</label>
									</div>
									<div class="input-field col s12 m8 l5">
										<f:input path="siret" type="text" class="validate" />
										<label for="siret">SIRET :</label>
									</div>
									<div class="input-field col s12 m8 l5">
										<f:input path="dateNaissanceClient" type="text"
											class="validate" />
										<label for="dateNaissanceClient">Date de naissance :</label>
									</div>
									<div class="input-field col s12 m8 l5">
										<f:input path="adresseClient" type="text" class="validate" />
										<label for="adresseClient">Adresse client :</label>
									</div>
								</div>

								<div id="clientProfessionnel" class="typeClientCoordonnees">
									<label class="col-sm-2 col-sm-2 control-label">Nom
										Société</label>
									<div class="col-sm-10">
										<input type="text" class="form-control">
									</div>
									<label class="col-sm-2 col-sm-2 control-label">SIRET</label>
									<div class="col-sm-10">
										<input type="text" class="form-control">
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
										<f:input path="mail" type="text" class="validate" />
										<label for="mail">Mail :</label>
									</div>
									<div class="input-field col s12 m8 l5">
										<f:input path="clientTelephone" type="text" class="validate" />
										<label for="clientTelephone">Telephone Client :</label>
									</div>
									<div class="input-field col s12 m8 l5">
										<f:input path="telephonSocie" type="text" class="validate" />
										<label for="telephonSocie">Telephone Societe :</label>
									</div>
								</div>

								<h2>Adresse de facturation</h2>
								<div class="input-field col s12 m8 l5">
									<f:input path="adresseClient" type="text" class="validate" />
									<label for="adresseClient">Adresse client :</label>
								</div>
								<div class="input-field col s12 m8 l5">
									<f:input path="postale" type="text" class="validate" />
									<label for="postale">Code Postale :</label>
								</div>

								<div>
									<f:select path="ville.idVille" items="${villelist}"
										itemValue="idVille" itemLabel="idVille"></f:select>
									<label for="idVille">Ville Id</label>
								</div>
								<label class="col-sm-2 col-sm-2 control-label">Pays</label>
								<div class="col-sm-10">
									<f:select path="pays" class="form-control">
										<f:option value="France">France</f:option>
										<f:option value="Madagascar">Madagascar</f:option>
									</f:select>
								</div>
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
								<f:input path="adresseClient" type="text" class="validate" />
								<label for="adresseClient">Adresse client :</label>
							</div>
							<div>
								<f:select path="ville.idVille" items="${villelist}"
									itemValue="idVille" itemLabel="idVille"></f:select>
								<label for="idVille">Ville Id</label>
							</div>
							<div class="input-field col s12 m8 l5">
								<f:input path="clientTelephone" type="text" class="validate" />
								<label for="clientTelephone">Numéro téléphone :</label>
							</div>
							<div class="input-field col s12 m8 l5">
								<f:input path="mail" type="text" class="validate" />
								<label for="mail">Mail :</label>
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
										<th>Action</th>
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



	<script type="text/javascript">
		$(document).ready(function() {
			$('.typeClientCoordonnees').hide();
			$('#clientParticulier').show();
			$('#typeClient').on("change", function() {
				$('.typeClientCoordonnees').hide();
				$('#client' + $(this).val()).show();
			}).val("clientParticulier");
		});
	</script>
	<style>
.modal-header {
	color: white !important;
	text-align: center;
	font-size: 30px;
}
</style>
</body>


</html>