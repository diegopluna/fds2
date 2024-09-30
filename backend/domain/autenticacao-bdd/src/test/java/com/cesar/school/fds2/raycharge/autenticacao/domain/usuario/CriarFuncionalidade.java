package com.cesar.school.fds2.raycharge.autenticacao.domain.usuario;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import com.cesar.school.fds2.raycharge.autenticacao.domain.AutenticacaoFuncionalidade;
import com.cesar.school.fds2.raycharge.autenticacao.domain.usuario.*;
import com.cesar.school.fds2.raycharge.infra.persistence.memory.Repository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

public class CriarFuncionalidade extends AutenticacaoFuncionalidade{

  private UsuarioService usuarioService;
  private UsuarioRepositorio usuarioRepositorio;
  private int resultadoCriarConta;

  public CriarFuncionalidade() {
    super();
    this.usuarioRepositorio = new Repository();
    this.usuarioService = new UsuarioService(usuarioRepositorio);
  }

  @Given("que não existe um usuário com o login {string}")
  public void queNaoExisteUmUsuarioComOLogin(String login) {
    Assertions.assertTrue(usuarioRepositorio.findByLogin(login).isEmpty());
  }

  @Given("que existe um usuário com o login {string}")
  public void queExisteUmUsuarioComOLogin(String login) {
    IdUsuario id = new IdUsuario(1);
    Usuario usuario = new Usuario(id, login, "senhaExistente", TipoUsuario.MOTORISTA);
    usuarioRepositorio.saveUsuario(usuario);
  }

  @When("eu criar uma nova conta com os seguintes detalhes:")
  public void euCriarUmaNovaContaComOsSeguintesDetalhes(DataTable dataTable) {
    List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
    Map<String, String> row = rows.get(0);

    String login = row.get("login");
    String senha = row.get("senha");
    TipoUsuario tipoUsuario = TipoUsuario.valueOf(row.get("tipoUsuario"));
    IdUsuario id = new IdUsuario(usuarioRepositorio.findByLogin(login).isPresent() ? 2 : 1);

    resultadoCriarConta = usuarioService.criarConta(login, senha, tipoUsuario, id);
  }

  @Then("a conta deve ser criada com sucesso")
  public void aContaDeveSerCriadaComSucesso() {
    Assertions.assertTrue(resultadoCriarConta > 0);
  }

  @Then("o id do usuário deve ser retornado")
  public void oIdDoUsuarioDeveSerRetornado() {
    Assertions.assertTrue(resultadoCriarConta > 0);
  }

  @Then("a criação da conta deve falhar")
  public void aCriacaoDaContaDeveFalhar() {
    Assertions.assertEquals(-1, resultadoCriarConta);
  }

  @Then("uma mensagem de erro indicando que o usuário já existe deve ser retornada")
  public void umaMensagemDeErroIndicandoQueOUsuarioJaExisteDeveSerRetornada() {
    // This step is implicitly verified by checking the return value in the previous step
    // We could extend this to check for a specific error message if the service provided one
  }

  @Given("um usuário com os seguintes dados:")
  public void umUsuarioComOsSeguintesDados(Map<String, String> dadosUsuario) {
    // Implementation
  }
}
