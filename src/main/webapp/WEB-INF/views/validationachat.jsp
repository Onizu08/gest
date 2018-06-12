<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="header.jsp"%>
<%@include file="sidenave.jsp"%>
<div class="row">
	<div class="col s12 l12">
		<div class="row">
			<f:form class="col s12 m8 l5 offset-l4 white"
				modelAttribute="facturedroit" action="validationFacture"
				method="post">
				<legend>
					<h4>Information Validation d'action de Droit</h4>
				</legend>


				<div class="input_fields_wrap">
					<div class="row" id="1">
						<f:input path="factureId" type="text" class="validate"
							style="visibility:hidden" />

						<div class="input-field col s12 m8 l5">
							<f:select path="devise.deviseId" items="${deviselist}"
								itemValue="deviseId" itemLabel="deviseId"></f:select>
							<label for="deviseId">Devise Id</label>
						</div>


						<div class="input-field col s12 m8 l5">
							<f:input path="dateFacture" type="text" class="datepicker" />
							<label for="dateFacture">Date Facturation:</label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="montantFacture" type="text" class="validate" />
							<label for="montantFacture">Montant Facture :</label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="dateEcheance" type="text" class="datepicker" />
							<label for="dateEcheance">Date Echeance :</label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="nbrPaiement" type="number" class="validate"
								min="1" max="4" />
							<label for="nbrPaiement">Nombre de paiement :</label>
						</div>
						<div class="input-field col s12 m8 l5">
							<f:input path="remise" type="text" class="validate" />
							<label for="remise">Remise :</label>
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

</div>
<%@include file="footer.jsp"%>