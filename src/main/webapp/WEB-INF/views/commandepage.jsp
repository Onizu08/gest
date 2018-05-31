
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="header.jsp"%>
<!-- <script type="text/javascript">
	$(document).ready(function() {
		$("#clientId").change(function() {
			var l1 = $("#clientId").val();
			alert(l1);
		});
	});
</script> -->
<div class="row">
	<f:form class="col s12 m8 l5 offset-l4 white" modelAttribute="commande"
		action="saveCommande" method="post">
		<legend>
			<h4>Information Commande</h4>
		</legend>
		<div class="input_fields_wrap">
			<div class="row">
				<div class="input-field col s12 m8 l2">
					<f:input path="commandeId" type="text" class="validate"
						readonly="true" />
					<label for="commandeId">Commande Id:</label>
				</div>
				<div class="input-field col s12 m8 l9">
					<f:select path="client.clientId" items="${clientlist}"
						itemValue="clientId" itemLabel="clientNom"></f:select>
					<label for="paysId">Id Client</label>
				</div>
				<f:input path="reference" type="text" style="display : none" />
				<div class="input-field col s12 m8 l9">
					<f:input path="reference" type="text" class="validate" />
					<label for="reference">Reference :</label>
				</div>
				<div>
					<label id="anarana">egz</label>
				</div>
				<div class="input-field col s12 m8 l5">
					<f:input path="dateCommande" type="text" class="validate" />
					<label for="dateCommande">Date Commande</label>
				</div>
				<div class="input-field col s12 m8 l5">
					<f:input path="statut" type="text" class="validate" />
					<label for="statut">Statut :</label>
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
		</div>
	</f:form>
</div>
<span>${error}</span>
<div class="row">
	<f:form class="col s12 m12 l12 white">
		<legend>
			<h5>Liste des Categories</h5>
		</legend>
		<div>
			<table class="striped bordered highlight centered white recherche">
				<thead>
					<tr>
						<th>Id Reduction</th>
						<th>Client Id</th>
						<th>Reference Commande</th>
						<th>Date Commande</th>
						<th>Statut Commande</th>
					</tr>
				</thead>
				<c:forEach items="${commandelist}" var="villelist">
					<tr>
						<td>${villelist.commandeId }</td>
						<td>${villelist.client.clientId }</td>
						<td>${villelist.reference }</td>
						<td><fmt:formatDate value="${villelist.dateCommande }"
								pattern="dd/MM/yyyy" type="date" /></td>
						<td>${villelist.statut}</td>
						<td><a href="editCommande?commandeId=${villelist.commandeId}">Modification</a></td>
						<td><a
							href="deleteCommande?commandeId=${villelist.commandeId}">Supprimer</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</f:form>
</div>
<%@include file="footer.jsp"%>