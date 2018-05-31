
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="header.jsp"%>
<div class="row">
	<f:form class="col s12 m8 l5 offset-l4 white"
		modelAttribute="utilisateur" action="saveUtilisateur" method="post">
		<legend>
			<h4>Information de l'Utilisateur</h4>
		</legend>
		<div class="input_fields_wrap">
			<div class="row" id="1">
				<div class="input-field col s12 m8 l2">
					<label for="utilisateurId">Utilisateur Id:</label>
					<f:input path="utilisateurId" type="text" class="validate"
						readonly="true" />
				</div>
				<div class="input-field col s12 m8 l5">
					<f:select path="profil.profileId" items="${profilelist}"
						itemValue="profileId" itemLabel="profileLib"></f:select>
					<label for="profileId">Profile</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12 m8 l5">
					<f:input path="login" type="text" class="validate" />
					<label for="login">Login :</label>
				</div>
				<div class="input-field col s12 m8 l5">
					<f:input path="pwd" type="password" class="validate" />
					<label for="pwd">Password :</label>
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
<div class="row">
	<f:form class="col s12 m12 l12 white">
		<legend>
			<h5>Liste des Utilisateurs</h5>
		</legend>
		<div class="col s12 l12">
			<div class="row">
				<table class="striped bordered highlight centered white recherche">
					<thead>
						<tr>
							<th>ID User</th>
							<th>ID Profile</th>
							<th>Login</th>
							<th>Password</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${utilisateurlist}" var="utilisateurlist">
							<tr>
								<td>${utilisateurlist.utilisateurId}</td>
								<td>${utilisateurlist.profil.profileId}</td>
								<td>${utilisateurlist.login}</td>
								<td>${utilisateurlist.pwd}</td>
								<td><a
									href="editUtilisateur?utilisateurId=${utilisateurlist.utilisateurId}">Modification</a>
									<a
									href="deleteUtilisateur?utilisateurId=${utilisateurlist.utilisateurId}">Supprimer</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</f:form>
</div><%@include file="footer.jsp"%>