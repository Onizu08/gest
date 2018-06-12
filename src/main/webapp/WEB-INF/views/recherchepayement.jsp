<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="header.jsp"%>
<%@include file="sidenave.jsp"%>
<div class="row">
	<div class="col s12 l12">
		<div class="row">
			<f:form class="col s12 m8 l5 offset-l4 white"
				modelAttribute="payement" action="recherche" method="post">
				<legend>
					<h4>Recherche de Payement</h4>
				</legend>
				<div class="input_fields_wrap">
					<div class="row" id="1">
						<div class="input-field col s12 m8 l5">
							<f:select path="client.clientId" id="nomClient">
								<f:option value="">Selectionner</f:option>
								<f:options items="${clientlist}" itemValue="clientId"
									itemLabel="clientNom" />
							</f:select>
							<label for="clientId">Client Id</label>
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
		</div>
		<span>${error}</span>
	</div>
	<div class="row">
		<f:form class="col s12 m12 l12 white">
			<legend>
				<h5>Liste des Pays</h5>
			</legend>
			<div class="col s12 l12">
				<div>
					<table class="striped bordered highlight centered white recherche">
						<thead>
							<tr>
								<th>ID Payement</th>
								<th>ID Facture</th>
								<th>ID Facture</th>
								<th>Date Prévu</th>
								<th>Montant Prévu</th>
								<th>Date Paiement</th>
								<th>Montant Payement</th>
							</tr>
						</thead>
						<c:forEach items="${payementlist}" var="payementlist">
							<tr>
								<td>${payementlist.paymentId}</td>
								<td>${payementlist.facture.factureId}</td>
								<td>${payementlist.client.clientId}</td>
								<td><fmt:formatDate value="${payementlist.datePrevu}"
										pattern="dd/MM/yyyy" type="date" /></td>
								<td>${payementlist.montantPrevu}</td>
								<td><fmt:formatDate value="${payementlist.datePayement}"
										pattern="dd/MM/yyyy" type="date" /></td>
								<td>${payementlist.montantPayement}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</f:form>
	</div>
</div>
<%@include file="footer.jsp"%>