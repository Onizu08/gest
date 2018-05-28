<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@include file="header.jsp"%>
<%@include file="sidenave.jsp"%>
<div class="container">
	<a href="<c:url value ="/j_spring_security_logout"/>"></a>
	<div class="row">
		<div class="col s12 l12">
			<div class="row">
				<div class="col s12 l12">
					<div class="row">
						<div class="col s12 m12 l3">
							<div class="tri-d-wrapper">
								<figure id="img-wrapper">
									<img
										src="<%=request.getContextPath()%>/resources/img/gestion%20personnels.svg">
									<div class="contenue">
										<span class="mot activator white-text">Gestion des
											Clients</span>
									</div>
									<figcaption>
										<h2 class="title">Gestion des Clients</h2>
										<div class="bottom-detail">
											<p>Information ....</p>
											<div class="row">
												<div class="col s12 l12">
													<div class="row">
														<div class="col s12 l3">
															<div class="tri-action">
																<div class="col s12 l2">
																	<i class="material-icons left">open_in_new</i> <a
																		href="<%=request.getContextPath()%>/Client/index">Ouvrir</a>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</figcaption>
								</figure>
							</div>
						</div>
						<div class="col s12 m12 l3">
							<div class="tri-d-wrapper">
								<figure id="img-wrapper">
									<img
										src="<%=request.getContextPath()%>/resources/img/building.svg">
									<div class="contenue">
										<span class="mot activator white-text">Gestion des
											Sociétés</span>
									</div>
									<figcaption>
										<h2 class="title">Gestion des Sociétés</h2>
										<div class="bottom-detail">
											<p>Information ....</p>
											<div class="row">
												<div class="col s12 l12">
													<div class="row">
														<div class="col s12 l1">
															<div class="tri-action">
																<div class="col s12 l1">
																	<i class="material-icons left">open_in_new</i> <a
																		href="<%=request.getContextPath()%>/Societe/index">Ouvrir</a>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</figcaption>
								</figure>
							</div>
						</div>
						<div class="col s12 m12 l3">
							<div class="tri-d-wrapper">
								<figure id="img-wrapper">
									<img
										src="<%=request.getContextPath()%>/resources/img/gestionMission.svg">
									<div class="contenue">
										<span class="mot activator white-text">Gestion des
											Commandes</span>
									</div>
									<figcaption>
										<h2 class="title">Gestion Commandes</h2>
										<div class="bottom-detail">
											<p>Information ....</p>
											<div class="row">
												<div class="col s12 l12">
													<div class="row">
														<div class="col s12 l1">
															<div class="tri-action">
																<div class="col s12 l2">
																	<i class="material-icons left">open_in_new</i> <a
																		href="<%=request.getContextPath()%>/Commande/index">Ouvrir</a>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</figcaption>
								</figure>
							</div>
						</div>
						<div class="col s12 m12 l3">
							<div class="tri-d-wrapper">
								<figure id="img-wrapper">
									<img
										src="<%=request.getContextPath()%>/resources/img/gestionFormations.svg">
									<div class="contenue">
										<span class="mot activator white-text">Gestion des
											Achats</span>
									</div>
									<figcaption>
										<h2 class="title">Gestion des Achats</h2>
										<div class="bottom-detail">
											<p>Information ....</p>
											<div class="row">
												<div class="col s12 l12">
													<div class="row">
														<div class="col s12 l1">
															<div class="tri-action">
																<div class="col s12 l2">
																	<i class="material-icons left">open_in_new</i> <a
																		href="<%=request.getContextPath()%>/Facture/index">Ouvrir</a>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</figcaption>
								</figure>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col s12 m12 l3">
							<div class="tri-d-wrapper">
								<figure id="img-wrapper">
									<img
										src="<%=request.getContextPath()%>/resources/img/gestionStatistique.svg">
									<div class="contenue">
										<span class="mot activator white-text">Gestion des
											Article</span>
									</div>
									<figcaption>
										<h2 class="title">Article</h2>
										<div class="bottom-detail">
											<p>Information ....</p>
											<div class="row">
												<div class="col s12 l12">
													<div class="row">
														<div class="tri-action">
															<div class="col s12 l2">
																<i class="material-icons left">open_in_new</i><a
																	href="<%=request.getContextPath()%>/Article/index">Ouvrir</a>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</figcaption>
								</figure>
							</div>
						</div>
						<div class="col s12 m12 l3">
							<div class="tri-d-wrapper">
								<figure id="img-wrapper">
									<img
										src="<%=request.getContextPath()%>/resources/img/settings.svg">
									<div class="contenue">
										<span class="mot1 activator white-text">Utilitaire</span>
									</div>
									<figcaption>
										<h2 class="title">Utilitaire</h2>
										<div class="bottom-detail">
											<p>Information ....</p>
											<div class="row">
												<div class="col s12 l12">
													<div class="row">
														<div class="col s12 l1">
															<div class="tri-action">
																<div class="col s12 l4">
																	<i class="material-icons left">open_in_new</i><a
																		href="<%=request.getContextPath()%>/Utilitaire/index">Ouvrir</a>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</figcaption>
								</figure>
							</div>
						</div>
						<div class="col s12 m12 l3">
							<div class="tri-d-wrapper">
								<figure id="img-wrapper">
									<img
										src="<%=request.getContextPath()%>/resources/img/gestionFormations.svg">
									<div class="contenue">
										<span class="mot1 activator white-text">Documents</span>
									</div>
									<figcaption>
										<h2 class="title">Documents</h2>
										<div class="bottom-detail">
											<p>Information ....</p>
											<div class="row">
												<div class="col s12 l12">
													<div class="row">
														<div class="col s12 l1">
															<div class="tri-action">
																<div class="col s12 l1">
																	<i class="material-icons left">open_in_new</i><a
																		href="<%=request.getContextPath()%>/Document/index">Ouvrir</a>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</figcaption>
								</figure>
							</div>
						</div>
						<div class="col s12 m12 l3">
							<div class="tri-d-wrapper">
								<figure id="img-wrapper">
									<img
										src="<%=request.getContextPath()%>/resources/img/recherche.svg">
									<div class="contenue">
										<span class="mot1 activator white-text">Recherche</span>
									</div>
									<figcaption>
										<h2 class="title">Recherche avancée</h2>
										<div class="bottom-detail">
											<p>Information ....</p>
											<div class="row">
												<div class="col s12 l12">
													<div class="row">
														<div class="col s12 l1">
															<div class="tri-action">
																<div class="col s12 l1">
																	<i class="material-icons left">open_in_new</i> <a
																		href="<%=request.getContextPath()%>/menurecherche/index">Ouvrir</a>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</figcaption>
								</figure>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>
