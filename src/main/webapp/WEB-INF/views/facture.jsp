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
					modelAttribute="client" action="saveFacture" method="post">
					<legend>
						<h4>Information Facture</h4>
					</legend>
					<div class="input_fields_wrap">
						<div class="row" id="1">
							<div class="input-field col s12 m8 l2">
								<f:input path="factureId" type="text" class="validate"
									readonly="true" />
								<label for="factureId">Id Facture:</label>
							</div>
							<div class="input-field col s12 m8 l2">
								<f:input path="dateFacture" type="text" class="validate" />
								<label for="nomSociete">Date Facture:</label>
							</div>
							<div class="input-field col s12 m8 l5">
								<f:input path="typeFacture" type="text" class="validate" />
								<label for="typeFacture">Type Facture:</label>
							</div>
							<div class="input-field col s12 m8 l5">
								<f:input path="montantFacture" type="text" class="validate" />
								<label for="montantFacture">Montant Facture :</label>
							</div>
							<div class="input-field col s12 m8 l5">
								<f:input path="statut" type="text" class="validate" />
								<label for="statut">Statut :</label>
							</div>
							<div class="input-field col s12 m8 l5">
								<f:input path="dateEcheance" type="text" class="validate" />
								<label for="siret">Date Echeance :</label>
							</div>
							<div class="input-field col s12 m8 l5">
								<f:input path="nbrPaiement" type="text" class="validate" />
								<label for="nbrPaiement">Nombre de paiement :</label>
							</div>
							<div class="input-field col s12 m8 l5">
								<f:input path="fraisFacture" type="text" class="validate" />
								<label for="fraisFacture">Frais de la facture :</label>
							</div>
							<div class="input-field col s12 m8 l5">
								<f:input path="nbrValidite" type="text" class="validate" />
								<label for="nbrValidite">Nombre de validite :</label>
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
						<h5>Liste des Factures</h5>
					</legend>
					<div class="col s12 l12">
						<div>
							<table class="striped bordered highlight centered white"
								id="recherche">
								<thead>
									<tr>
										<th>ID Facture</th>
										<th>Date de la facture</th>
										<th>Type facture</th>
										<th>Montant facture</th>
										<th>Statut</th>
										<th>Date d'echeance</th>
										<th>Nombre de paiement</th>
										<th>Frais de la facture</th>
										<th>Nombre de jour de validité</th>
										<th>Action</th>
									</tr>
								</thead>
								<c:forEach items="${societelist}" var="societelist">
									<tr>
										<td>${societelist.societeId}</td>
										<td>${societelist.nomSociete}</td>
										<td>${societelist.adresseSoceite}</td>
										<td>${societelist.telephoneSociete}</td>
										<td>${societelist.fax}</td>
										<td>${societelist.siret}</td>
										<td>${societelist.capital}</td>
										<td>${societelist.numTva}</td>
										<td>${societelist.naf}</td>
										<td><a
											href="editSociete?societeId=${societelist.societeId}">Modification</a></td>
										<td><a
											href="deleteSociete?societeId=${societelist.societeId}">Supprimer</a></td>
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