
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="header.jsp"%>

<div class="row">
	<f:form class="col s12 m8 l5 offset-l4 white" modelAttribute="commande"
		action="saveCommande" method="post">
		<legend>
			<h4>Information de la Commande</h4>
		</legend>
		<div class="input_fields_wrap">
			<div class="row">
				<div class="row">
					<div class="input-field col s12 m8 l2">
						<f:input path="commandeId" type="text" class="validate"
							readonly="true" />
						<label for="commandeId">Numéro de la Commande :</label>
					</div>
					<div class="input-field col s12 m8 l5">
						<f:select path="client.clientId" items="${clientlist}"
							itemValue="clientId" itemLabel="clientNom" id="clientId"></f:select>
						<label for="paysId">Nom du Client</label>
					</div>
					<div class="input-field col s12 m8 l3">
						<label>Prénom(s) : <f:input path="statut" type="text"
								class="validate" readonly="true" id="prenom" /></label>
					</div>
				</div>
				<div class="row">
					<f:input path="reference" type="text" style="display : none" />
					<div class="input-field col s12 m8 l5">
						<f:input path="reference" type="text" class="validate" />
						<label for="reference">Reference :</label>
					</div>

					<div class="input-field col s12 m12 l3">
						<f:input path="dateCommande" type="text" class="datepicker"
							id="dateCommande" />
						<label>Date de la Commande :</label>
					</div>
					<div class="input-field col s12 m8 l5">
						<f:input path="statut" type="text" class="validate" />
						<label for="statut">Statut :</label>
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
		</div>
	</f:form>
	<div class="row">
		<a href="<%=request.getContextPath()%>/Achat/index">
			<button class="btn waves-effect waves-light">
				Achat <i class="material-icons right">chevron_right</i>
			</button>
		</a>
	</div>

</div>
<span>${error}</span>
<div class="row">
	<f:form class="col s12 m12 l12 white">
		<legend>
			<h5>Liste des Commandes</h5>
		</legend>
		<div>
			<table class="striped bordered highlight centered white recherche">
				<thead>
					<tr>
						<th>Numéro du Commande</th>
						<th>Numéro du Client</th>
						<th>Reference Commande</th>
						<th>Date Commande</th>
						<th>Statut Commande</th>
						<th>Action</th>
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
						<td><a href="editCommande?commandeId=${villelist.commandeId}">Modification</a>
							<a href="deleteCommande?commandeId=${villelist.commandeId}">Supprimer</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</f:form>
</div>
<%@include file="footer.jsp"%>