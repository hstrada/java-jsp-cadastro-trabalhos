<jsp:include page="../template/header.jsp" />

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-12">
		<div class="card">
			<div class="header">
				<h4 class="title">Cadastrar Disciplina</h4>
			</div>
			<div class="content">

				<form action="cadDisciplina" method="post">

					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label>Nome da Disciplina</label> <input type="text"
									class="form-control" placeholder="Digite o nome da disciplina"
									name="nome" required>
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