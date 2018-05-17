
<div id="modal1" class="modal">
	<div class="row">
		<form class="col s12 m10 l8 offset-l3">
			<div class="row">
				<div class="col s12 m10 l8">
					<div class="input-field col s10 m10 l12">
						<i class="material-icons prefix">account_circle</i> <input
							id="icon_prefix" type="text" class="validate"> <label
							for="icon_prefix">User Name</label>${user}
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col s12 m10 l8">
					<div class="input-field col s10 m10  l12">
						<i class="material-icons prefix">lock</i> <input id="icon_lock"
							type="password" class="validate"> <label for="icon_lock">Password</label>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col s12 m8 l6">
					<button class="btn waves-effect waves-light " type="submit"
						name="action">
						AUTHENTIFICATION<i class="material-icons right">done</i>
					</button>
				</div>
				<div class="col s12 m8 l6">
					<button class="btn waves-effect waves-light red lighten-1 right"
						type="reset" name="action">
						Reset<i class="material-icons right">replay</i>
					</button>
				</div>
			</div>
		</form>
	</div>
</div>
<ul id="slide-out" class="side-nav">
	<li>
		<div class="userView">
			<img class="background" src="images/office.jpg"> <a
				href="#!user"><i class="material-icons left">perm_identity</i>${user}</a>
			<a href="#!name"><span class="white-text name">John Doe</span></a> <a
				href="#!email"><span class="white-text email">jdandturk@gmail.com</span></a>
		</div>
	</li>
	<!-- Modal Structure -->
	<ul>
		<ol class="waves-effect">
			CAPITAL HUMAN
			<li><a class="waves-effect"
				href="<%=request.getContextPath()%>/">Accueil</a></li>
			<li><a class="waves-effect"
				href="<%=request.getContextPath()%>/Facture/index">Gestion
					Facture</a>
				<ul>
					<ol>
						<li><a class="waves-effect"
							href="<%=request.getContextPath()%>/Individu/index">Gestion
								Commande</a></li>
						<li><a class="waves-effect"
							href="<%=request.getContextPath()%>/Employe/index">Gestion
								Employe</a></li>
					</ol>
				</ul></li>
			<li><a class="waves-effect"
				href="<%=request.getContextPath()%>/Achat/index">Gestion Achat</a></li>

			<li><a class="waves-effect">Gestion Congé</a>
				<ul>
					<ol>
						<li><a class="waves-effect"
							href="<%=request.getContextPath()%>/DemandeConge/index">Demande
								Conge</a></li>
						<li><a class="waves-effect"
							href="<%=request.getContextPath()%>/Validation/index">Validation&nbsp;Conge&nbsp;en&nbsp;attente</a></li>
					</ol>
				</ul></li>
			<li><a class="waves-effect"
				href="<%=request.getContextPath()%>/Statistique/index">Statistiques</a>
				<ul>
					<ol>
						<li><a class="waves-effect"
							href="<%=request.getContextPath()%>/Age/index">Pyramide&nbsp;des&nbsp;âges</a></li>
						<li><a class="waves-effect"
							href="<%=request.getContextPath()%>/PresenceMois/encours">Présence&nbsp;mois&nbsp;en&nbsp;cours</a></li>
						<li><a class="waves-effect"
							href="<%=request.getContextPath()%>/PresenceMois/index">Présence&nbsp;dans&nbsp;l'année</a></li>
					</ol>
				</ul></li>
			<li><a class="waves-effect"
				href="<%=request.getContextPath()%>/menurecherche/index">Recherche</a>
				<ul>
					<ol>
						<li><a class="waves-effect"
							href="<%=request.getContextPath()%>/ReleveSpecifie/index">Relevé&nbsp;avec&nbsp;paramètre</a></li>
						<li><a class="waves-effect"
							href="<%=request.getContextPath()%>/Releve/index">Relevé&nbsp;de&nbsp;congé&nbsp;pour&nbsp;chaque&nbsp;employé</a></li>
						<li><a class="waves-effect"
							href="<%=request.getContextPath()%>/HistoriqueSpecife/index">Historique&nbsp;avec&nbsp;paramètre&nbsp;pour&nbsp;chaque&nbsp;employé</a></li>
						<li><a class="waves-effect"
							href="<%=request.getContextPath()%>/menuhistorique/index">Historique&nbsp;des&nbsp;congés</a></li>
					</ol>
				</ul></li>
			<li><a class="waves-effect"
				href="<%=request.getContextPath()%>/Document/index">Documents </a></li>

			<li><a class="waves-effect"
				href="<%=request.getContextPath()%>/Utilitaire/index">Utilitaire</a>
				<ul>
					<ol>
						<li><a class="waves-effect"
							href="<%=request.getContextPath()%>/Traitement/index">Traitement</a></li>
						<li><a class="waves-effect"
							href="<%=request.getContextPath()%>/Donnees/index">Données</a></li>
						<li><a class="waves-effect"
							href="<%=request.getContextPath()%>/Parametre/index">Paramètres</a></li>

					</ol>
				</ul></li>
		</ol>
	</ul>
	<li><a class="waves-effect red lighten-1"
		href="<%=request.getContextPath()%>/login"><i
			class="material-icons left">power_settings_new</i>Déconnexion</a></li>
</ul>