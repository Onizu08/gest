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
					modelAttribute="payement" action="savePayement" method="post">
					<legend>
						<h4>Information Client</h4>
					</legend>
					<div class="input_fields_wrap">
						<div class="row" id="1">
							<div class="input-field col s12 m8 l2">
								<label for="paymentId">Id Payement :</label>
								<f:input path="paymentId" type="text" class="validate"
									readonly="true" />
							</div>
							<div>
								<label for="idVille">Id Facture :</label>
								<f:select path="facture.factureId" items="${facturelist}"
									itemValue="factureId" itemLabel="factureId"></f:select>
							</div>
							<div>
								<f:select path="client.clientId" items="${clientlist}"
									itemValue="clientId" itemLabel="clientId"></f:select>
								<label for="clientId">Id Client :</label>
							</div>
							<div class="input-field col s12 m8 l2">
								<label for="datePrevu">Date Prévu:</label>
								<f:input path="datePrevu" type="text" class="validate" />
							</div>
							<div class="input-field col s12 m8 l5">
								<label for="montantPrevu">Montant Prévu :</label>
								<f:input path="montantPrevu" type="text" class="validate" />
							</div>
							<div class="input-field col s12 m8 l5">
								<label for="datePayement">Date Payement :</label>
								<f:input path="datePayement" type="text" class="validate" />
							</div>
							<div class="input-field col s12 m8 l5">
								<label for="montantPayement">Montant Payement :</label>
								<f:input path="montantPayement" type="text" class="validate" />
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
										<button
											class="btn waves-effect waves-light red lighten-1 right"
											type="reset" name="action">
											Annuler<i class="material-icons right">replay</i>
										</button>
									</div>
								</div>
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
										<th>ID Payement</th>
										<th>ID Facture</th>
										<th>ID Facture</th>
										<th>Date Prévu</th>
										<th>Montant Prévu</th>
										<th>Date Paiement</th>
										<th>Montant Payement</th>
										<th>Action</th>
									</tr>
								</thead>
								<c:forEach items="${payementlist}" var="payementlist">
									<tr>
										<td>${payementlist.payementId}</td>
										<td>${payementlist.facture.factureId}</td>
										<td>${payementlist.client.clientId}</td>
										<td><fmt:formatDate value="${payementlist.datePrevu}"
												pattern="dd/MM/yyyy" type="date" /></td>
										<td>${payementlist.montantPrevu}</td>
										<td><fmt:formatDate value="${payementlist.datePayement}"
												pattern="dd/MM/yyyy" type="date" /></td>
										<td>${payementlist.montantPayement}</td>
										<td><a
											href="editPayement?payementId=${payementlist.payementId}">Modification</a></td>
										<td><a
											href="deletePayement?payementId=${payementlist.payementId}">Supprimer</a></td>
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