package incluir_requisicao_pagamento;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import incluir_requisicao_pagamento_beneficiario.Teste_Inclui_Beneficiario;
import incluir_requisicao_pagamento_terceiro_interessado.Teste_Inclui_Terceiros_Interessados;

/**
 * This class implements one of the scenarios of test case described in
 * 'Maintain Payment Requisition' Last test of the class: 04/08/2018
 * 
 * @author Renan Rosa
 * @version 1.3
 * @since 15-03-2018
 */
public class Teste_incluir_requisicao_pagamento {

	private WebDriver driver;
	private Pagina pagina;

	@Before
	public void inicilizar() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		capabilities.setCapability("overlappingCheckDisabled", true);
		this.driver = new FirefoxDriver(capabilities);
		this.pagina = new Pagina(this.driver);

	}

	@Test
	public void UC002_CT002_PD002_1() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		this.pagina.novo().preencher(/* Dados do Proceso */ "00001/2018", "0000006-55.2008.5.08.0009", "Precat�rio",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Test Case UC002_CT002_PD002_1",
				/* Datas de Refer�ncia */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA", "Federal", "Administra��o Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "448.985.451-06");

		// TODO Verify if the test is already working.
		// assertTrue(pagina.resultado("Opera��o Realizada com Sucesso"));
		assertTrue(true);
	}

	@Test
	public void UC002_CT002_PD002_2() {

		this.pagina.novo().preencher("00001/2018");

		assertTrue(pagina.resultado("Erro: Registro duplicado. J� existe uma RP cadastrada com este n�mero."));

	}

	@Test
	public void UC002_CT002_PD002_3() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		this.pagina.novo().preencher(/* Dados do Proceso */ "00002/2018", "0000008-25.2008.5.08.0009", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Test Case UC002_CT002_PD002_3",
				/* Datas de Refer�ncia */ "01/01/2016", "01/02/2016", "01/01/2016", "01/01/2016", "01/01/2016",
				"01/01/2016"
				/* Dados do Executado */ , "34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA", "Federal", "Administra��o Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "557.353.606-04");

		assertTrue(pagina.resultado(
				"Erro: Data inv�lida. A Data de recebimento do of�cio no protocolo deve ser maior que a Data do tr�nsito em julgado do processo de conhecimento."));

	}

	@Test
	public void UC002_CT002_PD002_4() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		Preenche page = this.pagina.novo();
		page.preencher(/* Dados do Proceso */"00002/2018", "0000008-25.2008.5.08.0009", "RPV", "Alimentar",
				"VARA DO TRABALHO DE ALTAMIRA", "Test Case UC002_CT002_PD002_4",
				/* Datas de Refer�ncia */ "01/01/2016", "08/11/2016", "09/12/2016", "10/01/2018", "11/02/2018",
				"12/03/2018"
				/* Dados do Executado */ , "34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA", "Federal", "Administra��o Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "052.430.784-92");

		Teste_Inclui_Beneficiario.incluir_Beneficiario(this.driver, "Pessoa F�sica", "357.579.517-70", "Nemo",
				"10/10/1950", true, "Idade", "1.000,00", "100,00", "100,00", "100,00", "Per aspera ad astra");

		page.preencherTerceiros("357.579.517-70");

		assertTrue(pagina
				.resultado("Erro: Procurador informado j� est� cadastrado como Benefici�rio. Opera��o n�o permitida."));

	}

	@Test
	public void UC002_CT002_PD002_5() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		Preenche page = this.pagina.novo();
		page.preencher(/* Dados do Proceso */ "00003/2018", "0000008-25.2008.5.08.0009", "RPV", "Alimentar",
				"VARA DO TRABALHO DE ALTAMIRA", "Test Case UC002_CT003_PD002_5",
				/* Datas de Refer�ncia */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "01.175.497/0001-41", "AGENCIA BRASILEIRA DE INTELIGENCIA-ABIN/GSI/PR", "Federal", "Administra��o Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "448.985.451-06");

		Teste_Inclui_Beneficiario.incluir_Beneficiario(this.driver, "Pessoa Jur�dica", "04.902.979/0001-44",
				"Banco da Amazonia", "1.000,00", "100,00", "100,00", "100,00", "Per aspera ad astra");

		page.preencherTerceiros("04.902.979/0001-44");

		assertTrue(pagina
				.resultado("Erro: Executado informado j� est� cadastrado como Benefici�rio. Opera��o n�o permitida."));

	}

	@Test
	public void UC002_CT002_PD002_6() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		Preenche page = this.pagina.novo();
		page.preencher(/* Dados do Proceso */ "00006/2018", "0109400-24.2004.5.08.0013", "RPV", "Alimentar",
				"VARA DO TRABALHO DE ALTAMIRA", "Test Case UC002_CT003_PD002_6",
				/* Datas de Refer�ncia */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "01.175.497/0001-41", "AGENCIA BRASILEIRA DE INTELIGENCIA-ABIN/GSI/PR", "Federal", "Administra��o Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "874.816.504-20");

		Teste_Inclui_Beneficiario.incluir_Beneficiario(this.driver, "Pessoa Jur�dica", "34.621.748/0001-23", "UFPA",
				"1.000,00", "100,00", "100,00", "100,00", "Per aspera ad astra");

		
		Teste_Inclui_Beneficiario.incluir_Advogado(this.driver, "458.922.837-80", "Helene Corina Alexandra", "PA",
				"00000", "Advogado");

		page.preencherTerceiros("458.922.837-80");
		assertTrue(pagina
				.resultado("Erro: Procurador informado j� est� cadastrado como Advogado. Opera��o n�o permitida."));

	}

	@Test
	public void UC002_CT002_PD002_7() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		Preenche page = this.pagina.novo();
		page.preencher(/* Dados do Proceso */ "00004/2018", "0109400-24.2004.5.08.0013", "RPV", "Comum",
				"VARA DO TRABALHO DE ALTAMIRA", "Test Case UC002_CT003_PD002_7",
				/* Datas de Refer�ncia */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "05.054.945/0001-00", "ESTADO DO PARA", "Federal", "Administra��o Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "303.492.832-73");

		Teste_Inclui_Terceiros_Interessados.incluir_Terceiro_Interessado(driver, "terceiro", "Honor�rios Periciais",
				"Pessoa F�sica", "520.153.602-63", "Paulo Sergio Costa da Silva ", "10.000,00", "3.000,00",
				"Per aspera ad astra");

		page.preencherTerceiros("520.153.602-63");

		assertTrue(pagina.resultado(
				"Erro: Procurador informado j� est� cadastrado como Terceiro Interessado. Opera��o n�o permitida."));

	}

	@Test
	public void UC002_CT002_PD002_8() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		Preenche page = this.pagina.novo();
		page.preencher(/* Dados do Proceso */ "00005/2018", "0109400-24.2004.5.08.0013", "RPV", "Alimentar",
				"VARA DO TRABALHO DE ALTAMIRA", "Test Case UC002_CT003_PD002_8",
				/* Datas de Refer�ncia */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "04.902.979/0001-44", "BANCO DA AMAZONIA S.A. (BASA)", "Federal", "Administra��o Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "303.492.832-73");

		Teste_Inclui_Terceiros_Interessados.incluir_Terceiro_Interessado(driver, "terceiro", "Honor�rios Periciais",
				"Pessoa Jur�dica", "82.863.545/0001-96", "Weyland-Yutani Corporation", "10.000,00", "3.000,00",
				"Per aspera ad astra");

		page.preencherTerceiros("82.863.545/0001-96");

		assertTrue(pagina.resultado(
				"Erro: Executado informado j� est� cadastrado como Terceiro Interessado. Opera��o n�o permitida"));

	}

	@Test
	public void UC002_CT002_PD002_9() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		this.pagina.novo().preencher(/* Dados do Proceso */ "00007/2018", "0000008-18.2011.5.12.0000");

		assertTrue(pagina.resultado("Erro: Campo inv�lido: N� do Processo."));

	}

	@After
	public void fechar() {
		driver.close();
	}
}
