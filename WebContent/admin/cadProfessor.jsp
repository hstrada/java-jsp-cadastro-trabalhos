<jsp:include page="../template/header.jsp" />

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-12">
		<div class="card">
			<div class="header">
				<h4 class="title">Cadastrar Professor</h4>
			</div>
			<div class="content">
				<jsp:useBean id="escola" class="br.com.ct.bean.EscolasBean"
					scope="page" />

				<form action="cadProfessor" method="post">

					<div class="row">
						<div class="col-md-12">
							<label for="escola">Selecione a Escola</label> <select
								class="form-control" id="escola" name="escola">
								<c:forEach var="escola" items="${escola.listaEscolas}">
									<option value='<c:out value="${escola.id}"/>'><c:out
											value="${escola.nome}" /></option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label>Nome</label> <input type="text" class="form-control"
									placeholder="Nome do Professor" name="nome" required>
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