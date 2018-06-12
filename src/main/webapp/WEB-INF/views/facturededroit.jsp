<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="header.jsp"%>
<%@include file="sidenave.jsp"%>
<div class="row">
	<div class="col s12 l12">
		<div class="row">
			<f:form class="col s12 m8 l5 offset-l4 white"
				modelAttribute="facturedroit" action="saveFacture" method="post">
				<legend>
					<h4>Information Facture de Droit</h4>
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
						<div class="input-field col s12 m8 l5" id="containerCommande">
							<f:select path="numCommande" type="text" class="validate"
								name="commande" placeholder="commande" id="commande" />
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

</div>
<%@include file="footer.jsp"%>