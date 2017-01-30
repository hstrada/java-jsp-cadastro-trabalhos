<jsp:include page="../template/header.jsp" />

<div class="row">
	<div class="col-md-12">
		<div class="card">
			<div class="header">
				<h4 class="title">Cadastrar Notas</h4>
			</div>
			<div class="content">
				<form action="cadNotas" method="post">

					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label>Nome</label> <input type="text" class="form-control"
									placeholder="Nome da Escola" name="nome">
							</div>
						</div>
					</div>

					<input type="submit" class="btn btn-secondary btn-fill pull-right"
						value="Cadastrar" />
					<div class="clearfix"></div>

				</form>

				${mensagem}

			</div>
		</div>
	</div>

</div>

<jsp:include page="../template/footer.jsp" />