<jsp:include page="../template/header.jsp" />

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-12">
		<div class="card">
			<div class="header">
				<h4 class="title">Cadastrar Aluno</h4>
			</div>
			<div class="content">
				<jsp:useBean id="curso" class="br.com.ct.bean.CursosBean"
					scope="page" />

				<form action="cadAluno" method="post">

					<div class="row">
						<div class="col-md-12">
							<label for="nomeEscola">Selecione o curso</label> <select
								class="form-control" id="curso" name="curso">
								<c:forEach var="curso" items="${curso.listaCursos}">
									<option value='<c:out value="${curso.id}"/>'><c:out
											value="${curso.nome}" /></option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>Nome</label> <input type="text" class="form-control"
									placeholder="Nome do Aluno" name="nome" required>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>RA</label> <input type="text" class="form-control"
									placeholder="Digite o RA" name="ra" required maxlength="10">
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>Login</label> <input type="text" class="form-control"
									placeholder="Usuário" name="usuario" required>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>Senha</label> <input type="text" class="form-control"
									placeholder="Senha" name="senha" required>
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