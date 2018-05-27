<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="header.jsp"%>
<div class="row">
	<div class="col s12 m12 l12">
		<div class="row">
			<f:form class="col s12 m8 l5 offset-l4 white" modelAttribute="client"
				action="saveClient" method="post">
				<legend>
					<h4>Information du Client</h4>
				</legend>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">Type du
						client</label>
					<div class="col-sm-10">
						<f:select id="typeClient" path="clientType" class="form-control">
							<f:option value="Particulier">Client Particulier</f:option>
							<f:option value="Professionnel">Client Professionnel</f:option>
						</f:select>
					</div>

					<div id="clientParticulier" class="typeClientCoordonnees">
						<div class="input-field col s12 m8 l5">
							<f:input path="clientNom" type="text" class="validate" />
							<label>Nom Client</label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="clientPrenom" type="text" class="validate" />
							<label for="clientPrenom">Pr�nom Client : </label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="mail" type="text" class="validate" />
							<label for="mail">E-Mail</label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="clientTelephone" type="text" class="validate" />
							<label for="clientTelephone">T�l�phone </label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="adresseClient" type="text" class="validate" />
							<label for="adresseClient">Adresse de la Soci�t� </label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="postale" type="text" class="validate" />
							<label for="postale">Code Postale : </label>
						</div>

						<div class="input-field col s12 m8 l5">
							<f:select path="ville" items="${villelist}" itemValue="idVille"
								itemLabel="idVille"></f:select>
							<label>Ville Id</label>

						</div>
						<div class="input-field col s12 m8 l5">
							<f:select path="pays">
								<f:option value="france">France</f:option>
								<f:option value="Madagascar">Madagascar</f:option>
							</f:select>
							<label for="idVille">Ville Id</label>
						</div>
					</div>

					<div id="clientProfessionnel" class="typeClientCoordonnees">
						<div class="input-field col s12 m8 l5">
							<f:input path="nomSociete" type="text" class="validate" />
							<label>Nom du Soci�t� </label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="siret" type="text" class="validate" />
							<label>SIRET </label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="clientNom" type="text" class="validate" />
							<label>Nom Client</label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="clientPrenom" type="text" class="validate" />
							<label for="clientPrenom">Pr�nom Client : </label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="mail" type="text" class="validate" />
							<label for="mail">E-Mail</label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="clientTelephone" type="text" class="validate" />
							<label for="clientTelephone">T�l�phone </label>
						</div>

						<div class="input-field col s12 m8 l5">
							<f:input path="telephonSocie" type="text" class="validate" />
							<label for="telephonSocie">T�l�phone Soci�t�</label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="adresseClient" type="text" class="validate" />
							<label for="adresseClient">Adresse de la Soci�t� </label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="postale" type="text" class="validate" />
							<label for="postale">Code Postale : </label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:select path="ville.idVille" items="${villelist}"
								itemValue="idVille" itemLabel="idVille"></f:select>
							<label for="idVille">Ville</label>

						</div>
						<div class="input-field col s12 m8 l5">
							<f:select path="pays" items="${payslist}" itemValue="paysId"
								itemLabel="paysId"></f:select>
							<label>Pays</label>

						</div>
					</div>
				</div>
				<div class="row">
					<div class="col s12 m12 l12">
						<div class="col s12 m12 l3 offset-l1  ">
							<button class="btn waves-effect waves-light red lighten-1"
								type="reset" name="action">
								Annuler<i class="material-icons right">replay</i>
							</button>
						</div>
						<div class="col s12 m12 l3 offset-l3">
							<button class="btn waves-effect waves-light " type="submit"
								name="action">
								Sauvegarder<i class="material-icons right">done</i>
							</button>
						</div>
					</div>
				</div>
			</f:form>
		</div>
	</div>
</div>
<span>${error}</span>
<div>
	<table class="striped bordered highl ight centered white"
		id="recherche">
		<thead>
			<tr>
				<th>Id Client</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>T�l�phone</th>
				<th>Adresse</th>
				<th>Code Postale</th>
				<th>Ville</th>
				<th>Pays</th>
				<th>Societe</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${clientlist}" var="clientlist">
				<tr>
					<td>${clientlist.clientId }</td>
					<td>${clientlist.clientNom }</td>
					<td>${clientlist.clientPrenom }</td>
					<td>${clientlist.clientTelephone}</td>
					<td>${clientlist.adresseClient }</td>
					<td>${clientlist.postale }</td>
					<td>${clientlist.ville.idVille }</td>
					<td>${clientlist.pays}</td>
					<td>${clientlist.societe.societeId}</td>
					<td><a href="editClient?clientId=${clientlist.clientId}">Modification</a>
						<a href="deleteClient?clientId=${clientlist.clientId}">Supprimer</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div><%@include file="footer.jsp"%>