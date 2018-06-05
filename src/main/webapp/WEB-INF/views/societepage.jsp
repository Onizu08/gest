<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="header.jsp"%><%@include file="sidenave.jsp"%>
<div class="row">
	<div class="col s12 l12">
		<div class="row">
			<f:form class="col s12 m8 l5 offset-l4 white"
				modelAttribute="societe" action="saveSociete" method="post">
				<legend>
					<h4>Information du Société</h4>
				</legend>
				<div class="input_fields_wrap">
					<div class="row" id="1">
						<div class="input-field col s12 m8 l2">
							<f:input path="societeId" type="text" class="validate"
								readonly="true" />
							<label for="societeId">Id Societe:</label>
						</div>
						<div class="input-field col s12 m8 l2">
							<f:input path="nomSociete" type="text" class="validate" />
							<label for="nomSociete">Nom Société:</label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="adresseSoceite" type="text" class="validate" />
							<label for="adresseSoceite">Adresse Societe:</label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="telephoneSociete" type="text" class="validate" />
							<label for="telephoneSociete">Téléphone Société :</label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="fax" type="text" class="validate" />
							<label for="fax">Fax Societe :</label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="siret" type="text" class="validate" />
							<label for="siret">Siret :</label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="capital" type="text" class="validate" />
							<label for="capital">Capital Social :</label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="numTva" type="text" class="validate" />
							<label for="numTva">Numéro TVA :</label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="naf" type="text" class="validate" />
							<label for="naf">NAF :</label>
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
					<h5>Liste des SociétésSSS</h5>
				</legend>
				<div class="col s12 l12">
					<div>
						<table class="striped bordered highlight centered white recherche">
							<thead>
								<tr>
									<th>ID Socié</th>
									<th>Nom Société</th>
									<th>Adresse</th>
									<th>Numéro Téléphone</th>
									<!-- <th>Fax</th> -->
									<th>SIRET</th>
									<th>Capital Social</th>
									<th>Numéro TVA</th>
									<th>NAF</th>
									<th>Action</th>
								</tr>
							</thead>
							<c:forEach items="${societelist}" var="societelist">
								<tr>
									<td>${societelist.societeId}</td>
									<td>${societelist.nomSociete}</td>
									<td>${societelist.adresseSoceite}</td>
									<td>${societelist.telephoneSociete}</td>
									<%-- <td>${societelist.fax}</td> --%>
									<td>${societelist.siret}</td>
									<td>${societelist.capital}</td>
									<td>${societelist.numTva}</td>
									<td>${societelist.naf}</td>
									<td><a
										href="editSociete?societeId=${societelist.societeId}">Modification</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</f:form>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>