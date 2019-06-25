package br.com.vrminozzo.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;



import br.com.vrminozzo.core.BaseTest;
import br.com.vrminozzo.page.TelaColeta;

public class TelaColetaTest extends BaseTest {

	private TelaColeta page = new TelaColeta();
	
	
	@Before
	public void acessarColeta() {
		esperarAte("com.android.packageinstaller:id/permission_allow_button");
		page.clicar(By.id("com.android.packageinstaller:id/permission_allow_button"));
		page.conectarWiFi();
		
	}
	@Test
	public void devePreencherConexaoTest() {	
		page.preencherNomeConexao("Vithor");
		page.preencherIp("3432");
		page.preencherPorta("31");
		page.preencherTimeout("21");
		page.verificarNomeConexao("Vithor");
		page.verificarIp("abcde");
		page.verificarPorta("abc");
		page.verificarTimeout("ert");
	}
	 
	public void deveConectarTest() {
	
		//Preenchimento do Campo
		page.conectarLogBox();
		//Tela Download
		esperarAte("br.com.logchart.ble:id/StartTitleTV");
		page.pegarDiaMesAnoHoraMinutoSegundoInicialOpcoesColeta();
		page.clicar(By.id("br.com.logchart.ble:id/dialog_start_calendar"));
		esperarAte("android:id/pickers");
		//Alterar Data e hora do inicio e fim dos registros
		page.alterarDia();
		page.clicarTeclado(9);
		page.clicarTeclado(10);
		//Confirmar alteração KEYCODE_66 = Enter
		page.clicarTeclado(66);
		
		page.alterarMes();
	
		page.clicarTeclado(38);
	
		page.clicarTeclado(29);
		page.clicarTeclado(42);
	
		page.alterarAno();
	
		//clicar no teclado Nativo
		page.alterarHora();
	
		//clicar no teclado Nativo
		page.alterarMinuto();

		//clicar no teclado Nativo
		page.alterarSegundo();
	
		page.clicarTeclado(66);
		//clicar no teclado Nativo
		esperarAte("android:id/button1");
		page.clicar(By.id("android:id/button1"));
	
		page.pegarDiaMesAnoHoraMinutoSegundoFinalOpcoesColeta();
	
		page.clicar(By.id("br.com.logchart.ble:id/dialog_end_calendar"));

		page.alterarDia();

		page.clicarTeclado(9);
		page.clicarTeclado(16);

		page.clicarTeclado(66);
	
		page.clicar(By.id("android:id/button1"));

		page.clicar(By.id("br.com.logchart.ble:id/buttonOK_wifi"));
	}
	
	@Test
	public void verificaDataInicialMaiorFinalTest() {
		page.conectarLogBox();
		//Entrando na tela de opçoes de coleta
		esperarAte("br.com.logchart.ble:id/StartTitleTV");
		page.pegarDiaMesAnoHoraMinutoSegundoInicialOpcoesColeta();
		page.pegarDiaMesAnoHoraMinutoSegundoFinalOpcoesColeta();
		page.dataInicialMaiorQueFinalTest();
		page.verificaDataInicialMaiorFinal();	
	}
	@Test
	public void verificaPrimeiroRegistroTest() {
		page.conectarLogBox();
		//Entrando na tela de opçoes de coleta
		esperarAte("br.com.logchart.ble:id/StartTitleTV");
		page.pegarDiaMesAnoHoraMinutoSegundoInicialOpcoesColeta();
		page.clicar(By.id("br.com.logchart.ble:id/buttonOK_wifi"));
		page.clicar(By.id("android:id/button1"));
		page.verificaTelaGrafico();
		esperarAte("br.com.logchart.ble:id/btn_prev");
		page.comparaPrimeiroRegistroGrafico();
	}
	@Test
	public void verificaAlteracaoDataHoraTest() {
		page.conectarLogBox();
		//Tela Download
		//Entrando na tela de opçoes de coleta
		esperarAte("br.com.logchart.ble:id/StartTitleTV");
		page.pegarDiaMesAnoHoraMinutoSegundoInicialOpcoesColeta();
		page.clicar(By.id("br.com.logchart.ble:id/dialog_start_calendar"));
		esperarAte("android:id/pickers");
		page.alterarDia();
		page.clicarTeclado(9);
		page.clicarTeclado(10);
		//Confirmar alteração KEYCODE_66 = Enter
		page.clicarTeclado(66);
		page.alterarMes();
		page.clicarTeclado(38);
		page.clicarTeclado(29);
		page.clicarTeclado(42);
		page.alterarAno();
		page.clicarTeclado(9);
		page.clicarTeclado(7);
		page.clicarTeclado(8);
		page.clicarTeclado(13);
		page.clicarTeclado(66);
//		page.verificaAlterarDataHora();
		page.clicar(By.id("android:id/button1"));
		page.pegarDiaMesAnoHoraMinutoSegundoInicialOpcoesColeta();
		page.verificaAlterarDataHora();
	}
	
	@Test
	public void testeEstresse() {
		page.conectarLogBox();
		esperarAte("br.com.logchart.ble:id/StartTitleTV");
		page.pegarDiaMesAnoHoraMinutoSegundoInicialOpcoesColeta();
		page.clicar(By.id("br.com.logchart.ble:id/buttonOK_wifi"));
		page.clicar(By.id("android:id/button1"));
		page.verificaTelaGrafico();
		esperarAte("br.com.logchart.ble:id/btn_prev");
		page.comparaPrimeiroRegistroGrafico();
		page.clicarTeclado(4);
		page.clicarTeclado(4);
		esperarAte("br.com.logchart.ble:id/btn_coletaModeWIFI");
		//
		page.rotinaStress();
	}
	@Test
	public void opcaoNxc() {
		page.conectarLogBox();
		esperarAte("br.com.logchart.ble:id/StartTitleTV");
		page.clicar(By.id("br.com.logchart.ble:id/buttonOK_wifi"));
		page.clicar(By.id("android:id/button1"));
		esperarAte("br.com.logchart.ble:id/btn_prev");
		page.tap(690,310);
		page.clicar(By.id("br.com.logchart.ble:id/export_csv"));
		page.clicar(By.id("br.com.logchart.ble:id/export_nxd"));
		page.tap(245, 325);
		page.clicar(By.id("br.com.logchart.ble:id/overflow"));
		page.encontrarElementosBy(By.className("android.widget.LinearLayout"),1);
		esperar(2000);
		page.clicar(By.id("br.com.logchart.ble:id/overflow"));
		esperarAte("br.com.logchart.ble:id/icon");
		page.encontrarElementosBy(By.className("android.widget.LinearLayout"),2);
		page.clicar(By.xpath("//*[@text='Gmail']"));
		esperarAte("com.google.android.gm:id/to");
		page.clicarTeclado(4);
		page.encontrarArquivosSalvos("com.google.android.gm:id/attachment_tile_title","NXC");
		page.verificaArquivosSalvos("com.google.android.gm:id/attachment_tile_title" , "NXC");
		
	}
	
	@Test
	public void opcaoNxd() {
		page.conectarLogBox();
		esperarAte("br.com.logchart.ble:id/StartTitleTV");
		page.clicar(By.id("br.com.logchart.ble:id/buttonOK_wifi"));
		page.clicar(By.id("android:id/button1"));
		esperarAte("br.com.logchart.ble:id/btn_prev");
		page.tap(690,310);
		page.clicar(By.id("br.com.logchart.ble:id/export_csv"));
		page.clicar(By.id("br.com.logchart.ble:id/export_nxc"));
		page.tap(245, 325);
		page.clicar(By.id("br.com.logchart.ble:id/overflow"));
		page.encontrarElementosBy(By.className("android.widget.LinearLayout"),1);
		esperar(2000);
		page.clicar(By.id("br.com.logchart.ble:id/overflow"));
		esperarAte("br.com.logchart.ble:id/icon");
		page.encontrarElementosBy(By.className("android.widget.LinearLayout"),2);
		page.clicar(By.xpath("//*[@text='Gmail']"));
		esperarAte("com.google.android.gm:id/to");
		page.clicarTeclado(4);
		page.encontrarArquivosSalvos("com.google.android.gm:id/attachment_tile_title","NXD");
		page.verificaArquivosSalvos("com.google.android.gm:id/attachment_tile_title" , "NXD");
	}
	@Test
	public void opcaoCsv() {
		page.conectarLogBox();
		esperarAte("br.com.logchart.ble:id/StartTitleTV");
		page.clicar(By.id("br.com.logchart.ble:id/buttonOK_wifi"));
		page.clicar(By.id("android:id/button1"));
		esperarAte("br.com.logchart.ble:id/btn_prev");
		page.tap(690,310);
		page.clicar(By.id("br.com.logchart.ble:id/export_nxc"));
		page.clicar(By.id("br.com.logchart.ble:id/export_nxd"));
		page.tap(245, 325);
		page.clicar(By.id("br.com.logchart.ble:id/overflow"));
		page.encontrarElementosBy(By.className("android.widget.LinearLayout"),1);
		esperar(2000);
		page.clicar(By.id("br.com.logchart.ble:id/overflow"));
		esperarAte("br.com.logchart.ble:id/icon");
		page.encontrarElementosBy(By.className("android.widget.LinearLayout"),2);
		page.clicar(By.xpath("//*[@text='Gmail']"));
		esperarAte("com.google.android.gm:id/to");
		page.clicarTeclado(4);
		page.encontrarArquivosSalvos("com.google.android.gm:id/attachment_tile_title","Tem");
		page.verificaArquivosSalvos("com.google.android.gm:id/attachment_tile_title" , "Tem");
	}
	
	@Test
	public void verLista() {
		page.conectarLogBox();
		esperar(5000);
		page.clicarConexoesSalvas();
		page.existeUmElementoPorId("android:id/text1");
	}
	
}