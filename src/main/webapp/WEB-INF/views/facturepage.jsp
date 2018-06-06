<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="header.jsp"%>
<%@include file="sidenave.jsp"%>
<div class="row">
	<div class="col s12 l12">
		<div class="row">
			<f:form class="col s12 m8 l5 offset-l4 white"
				modelAttribute="facture" action="saveFacture" method="post">
				<legend>
					<h4>Information Facture</h4>
				</legend>
				<div class="input_fields_wrap">
					<div class="row" id="1">
						<f:input path="factureId" type="text" class="validate"
							style="visibility:hidden" />
						<div class="input-field col s12 m8 l5">
							<f:select path="client.clientId" id="clientIdComm">
								<f:option value="">Selectionner</f:option>
								<f:options items="${clientlist}" itemValue="clientId"
									itemLabel="clientNom" />

							</f:select>
							<label for="clientId">Client Id</label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="numCommande" type="text" class="validate"
								name="commande" placeholder="commande" id="commande" />

						</div>
						<div class="input-field col s12 m8 l5">
							<f:select path="devise.deviseId" items="${deviselist}"
								itemValue="deviseId" itemLabel="deviseId"></f:select>
							<label for="deviseId">Devise Id</label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:select path="utilisateur.utilisateurId"
								items="${utilisateurlist}" itemValue="utilisateurId"
								itemLabel="login"></f:select>
							<label for="paysId">Utilisateur</label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="dateFacture" type="text" class="datepicker" />
							<label for="dateFacture">Date Facturation:</label>
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
							<f:input path="dateEcheance" type="datepicker" class="validate" />
							<label for="dateEcheance">Date Echeance :</label>
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
		</div>
		<span>${error}</span>
	</div>
	<div class="row">
		<f:form class="col s12 m12 l12 white">
			<legend>
				<h5>Liste des Factures</h5>
			</legend>
			<div class="col s12 l12">
				<div>
					<table class="striped bordered highlight centered white recherche">
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
						<c:forEach items="${facturelist}" var="facturelist">
							<tr>
								<td>${facturelist.factureId}</td>
								<td>${facturelist.dateFacture}</td>
								<td>${facturelist.typeFacture}</td>
								<td>${facturelist.telephoneSociete}</td>
								<td>${facturelist.fax}</td>
								<td>${facturelist.siret}</td>
								<td>${facturelist.capital}</td>
								<td>${facturelist.numTva}</td>
								<td>${facturelist.naf}</td>
								<td><a
									href="editFacture?factureId=${facturelist.factureId}">Modification</a>
									<a href="deleteFacture?factureId=${societelist.factureId}">Supprimer</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</f:form>
	</div>

</div>
<%@include file="footer.jsp"%>