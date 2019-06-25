package br.com.vrminozzo.test;

import org.junit.Before;
import org.junit.Test;

import br.com.vrminozzo.core.BaseTest;
import br.com.vrminozzo.page.TelaConfiguracao;

public class TelaConfigTest extends BaseTest {

private TelaConfiguracao page = new TelaConfiguracao();
	
	@Before
	public void acessarConfig() {
		page.acessarConfiguração();
	}
	
	@Test
	public void deveEntrarConfigTest() {
	
		page.verificarTelaConfig();
}
	@Test
	public void devePreencherConfigTest() {

		page.preencherNomeConexao("Vithor");
		page.preencherIp("3432");
		page.preencherPorta("31");
		page.preencherTimeout("21");
		page.verificarNomeConexao("Vithor");
		page.verificarIp("abcde");
		page.verificarPorta("abc");
		page.verificarTimeout("ert");
}
	@Test
	public void deveConectarTest() {
		page.clicarConexao();
		page.verificarAlertMsg();
	}
	@Test
	public void verLista() {
		
		page.preencherNomeConexao("Vithor");
		page.preencherIp("3432");
		page.preencherPorta("31");
		page.preencherTimeout("21");
		page.clicarConexao();
		esperar(5000);
		page.clicarConexoesSalvas();
		page.existeUmElementoPorId("android:id/text1");
	}
	
	
}




