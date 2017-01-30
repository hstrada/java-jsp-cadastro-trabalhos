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
						<div class="col-md-6">
							<div class="form-group">
								<label>ID do Aluno</label> <input type="text"
									class="form-control" value="${nota.aluno.id}" name="idAluno"
									readonly="readonly">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>ID da Disciplina</label> <input type="text"
									class="form-control" value="${nota.disciplina.id}"
									name="idDisciplina" readonly="readonly">
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<label>Atividade Prática</label> <input type="text"
									class="form-control" placeholder="Atividade Prática"
									value="${nota.atividadePratica}" name="atpratica">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label>Projeto 1</label> <input type="text" class="form-control"
									placeholder="Nota do Projeto 1" value="${nota.projeto1}"
									name="projeto1">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label>Projeto 2</label> <input type="text" class="form-control"
									placeholder="Nota do Projeto 1" value="${nota.projeto2}"
									name="projeto2">
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