<jsp:include page="../template/header.jsp" />

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-12">
		<div class="card">
			<div class="header">
				<h4 class="title">Cadastrar Curso</h4>
			</div>
			<div class="content">
				<jsp:useBean id="escola" class="br.com.ct.bean.EscolasBean"
					scope="page" />

				<form action="cadCurso" method="post">

					<div class="row">
						<div class="col-md-12">
							<label for="nomeEscola">Selecione a escola</label> <select
								class="form-control" id="escola" name="escola">
								<c:forEach var="escola" items="${escola.listaEscolas}">
									<option value='<c:out value="${escola.id}"/>'><c:out
											value="${escola.nome}" /></option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>Nome</label> <input type="text" class="form-control"
									placeholder="Nome do Curso" name="nome" required>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>Sigla</label> <input type="text" class="form-control"
									placeholder="Digite a sigla do curso" name="sigla"
									maxlength="10" required>
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