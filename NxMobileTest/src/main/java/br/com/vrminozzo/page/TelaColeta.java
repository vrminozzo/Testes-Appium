package br.com.vrminozzo.page;

import static br.com.vrminozzo.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import br.com.vrminozzo.core.BasePage;
import br.com.vrminozzo.core.BaseTest;

public class TelaColeta extends BasePage {

	DataHelper dataOpcoesColeta = new DataHelper();
	PageInicial page =  new PageInicial();
	
	private int diaInicial = 0;
	private int mesInicial = 0;
	private int anoInicial = 0;
	private int horaInicial = 0;
	private int minutoInicial = 0;
	private int segundoInicial = 0;
	private int diaFinal = 0;
	private int mesFinal = 0;
	private int anoFinal = 0;
	private int horaFinal = 0;
	private int minutoFinal = 0;
	private int segundoFinal = 0;

	public void conectarLogBox() {
		preencherNomeConexao("Vithor");
		preencherIp("192.168.0.16");
		clicarConexao();
	}
	public void conectarWiFi() {
		if(page.toogleWiFi() == true) {
			acessarColeta();
		}else {
			page.clicarWifiBle();
			acessarColeta();
		}
		
	}
	public void preencherNomeConexao(String texto) {
		escrever(By.id("br.com.logchart.ble:id/et_connectionName"), texto);
	}

	public void preencherIp(String texto) {
		escrever(By.id("br.com.logchart.ble:id/et_ipAddress"), texto);
	}

	public void preencherPorta(String texto) {
		escrever(By.id("br.com.logchart.ble:id/et_porta"), texto);
	}

	public void preencherTimeout(String texto) {
		escrever(By.id("br.com.logchart.ble:id/et_timeOut"), texto);
	}

	public void verificarNomeConexao(String texto) {
		assertEquals(texto, obterTexto(By.id("br.com.logchart.ble:id/et_connectionName")));
	}

	public void verificarIp(String texto) {
		assertEquals(texto, obterTexto(By.id("br.com.logchart.ble:id/et_ipAddress")));
	}

	public void verificarPorta(String texto) {
		assertEquals(texto, obterTexto(By.id("br.com.logchart.ble:id/et_porta")));
	}

	public void verificarTimeout(String texto) {
		assertEquals(texto, obterTexto(By.id("br.com.logchart.ble:id/et_timeOut")));
	}

	public void clicarConexao() {
		clicar(By.id("br.com.logchart.ble:id/btn_connect"));
	}

	public void verificarAlertMsg() {
		assertTrue(existeUmElementoPorId("android:id/alertTitle"));
	}

	public void clicarConexoesSalvas() {
		clicar(By.id("br.com.logchart.ble:id/sp_connectionsSaved"));
	}

	public void pegarDiaMesAnoHoraMinutoSegundoInicialOpcoesColeta() {
		String data = getDriver().findElement(By.id("br.com.logchart.ble:id/dialog_start_date_edit")).getText();
		System.out.println(data);
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		// dia
		try {
			Date startDate = format.parse(data);
			diaInicial = startDate.getDate();

			System.out.println(diaInicial);
			dataOpcoesColeta.setDia(diaInicial);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// mes
		try {
			Date startDate = format.parse(data);
			mesInicial = startDate.getMonth() + 1;

			System.out.println(mesInicial);
			dataOpcoesColeta.setMes(mesInicial);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ano
		try {
			Date startDate = format.parse(data);
			anoInicial = startDate.getYear() + 1900;

			System.out.println(anoInicial);
			dataOpcoesColeta.setAno(anoInicial);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Date startDate = format.parse(data);
			segundoInicial = startDate.getSeconds();

			System.out.println(segundoInicial);
			dataOpcoesColeta.setSegundo(segundoInicial);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// mes
		try {
			Date startDate = format.parse(data);
			minutoInicial = startDate.getMinutes();

			System.out.println(minutoInicial);
			dataOpcoesColeta.setMinuto(minutoInicial);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ano
		try {
			Date startDate = format.parse(data);
			horaInicial = startDate.getHours();

			System.out.println(horaInicial);
			dataOpcoesColeta.setHora(horaInicial);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pegarDiaMesAnoHoraMinutoSegundoFinalOpcoesColeta() {
		String data = getDriver().findElement(By.id("br.com.logchart.ble:id/dialog_end_date_edit")).getText();
		System.out.println(data);
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		// dia
		try {
			Date startDate = format.parse(data);
			diaFinal = startDate.getDate();

			System.out.println(diaFinal);
			dataOpcoesColeta.setDia(diaFinal);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// mes
		try {
			Date startDate = format.parse(data);
			mesFinal = startDate.getMonth() + 1;

			System.out.println(mesFinal);
			dataOpcoesColeta.setMes(mesFinal);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ano
		try {
			Date startDate = format.parse(data);
			anoFinal = startDate.getYear() + 1900;

			System.out.println(anoFinal);
			dataOpcoesColeta.setAno(anoFinal);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Date startDate = format.parse(data);
			segundoFinal = startDate.getSeconds();

			System.out.println(segundoFinal);
			dataOpcoesColeta.setSegundo(segundoFinal);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// mes
		try {
			Date startDate = format.parse(data);
			minutoFinal = startDate.getMinutes();

			System.out.println(minutoFinal);
			dataOpcoesColeta.setMinuto(minutoFinal);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ano
		try {
			Date startDate = format.parse(data);
			horaFinal = startDate.getHours();

			System.out.println(horaFinal);
			dataOpcoesColeta.setHora(horaFinal);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void alterarDia() {
		System.out.println(dataOpcoesColeta.getDia());
		clicar(By.xpath("//*[@text=" + dataOpcoesColeta.getDia() + "]"));
	}

	public String retornaMesString(int valorMes) {
		switch (valorMes) {
		case 1:
			return "jan";
		case 2:
			return "fev";
		case 3:
			return "mar";
		case 4:
			return "abr";
		case 5:
			return "mai";
		case 6:
			return "jun";
		case 7:
			return "jul";
		case 8:
			return "ago";
		case 9:
			return "set";
		case 10:
			return "out";
		case 11:
			return "nov";
		case 12:
			return "dez";
		default:
			return "jan";
		}
	}
	
	public void alterarMes() {
		clicar(By.xpath("//*[@text='" + retornaMesString(dataOpcoesColeta.getMes()) + "']"));
	}

	public void alterarAno() {
		clicar(By.xpath("//*[@text=" + dataOpcoesColeta.getAno() + "]")); 
	}

	public void alterarHora() {
		System.out.println(dataOpcoesColeta.getHora());
		clicar(By.xpath("//*[@text=" + dataOpcoesColeta.getHora() + "]"));
	}

	public void alterarMinuto() {
		System.out.println(dataOpcoesColeta.getMinuto());
		clicar(By.xpath("//*[@text=" + dataOpcoesColeta.getMinuto() + "]"));
	}

	public void alterarSegundo() {
		System.out.println(dataOpcoesColeta.getSegundo());
		clicar(By.xpath("//*[@text=" + dataOpcoesColeta.getSegundo() + "]"));
	}

	public void clicarTeclado(int x) {
		getDriver().pressKeyCode(x);
	}

	public void dataInicialMaiorQueFinalTest() {
		clicar(By.id("br.com.logchart.ble:id/dialog_start_calendar"));
		alterarDia();
		clicarTeclado(10);
		clicarTeclado(7);
		clicarTeclado(66);
		alterarMes();
		clicarTeclado(38);
		clicarTeclado(29);
		clicarTeclado(42);
		alterarAno();
		clicarTeclado(9);
		clicarTeclado(7);
		clicarTeclado(8);
		clicarTeclado(15);
		clicarTeclado(66);
		clicar(By.id("android:id/button1"));
		clicar(By.id("br.com.logchart.ble:id/dialog_end_calendar"));
		alterarDia();
		clicarTeclado(9);
		clicarTeclado(16);
		clicarTeclado(66);
		alterarMes();
		clicarTeclado(38);
		clicarTeclado(29);
		clicarTeclado(42);
		alterarAno();
		clicarTeclado(9);
		clicarTeclado(7);
		clicarTeclado(8);
		clicarTeclado(15);
		clicarTeclado(66);
		clicar(By.id("android:id/button1"));
		clicar(By.id("br.com.logchart.ble:id/buttonOK_wifi"));
	}
	public void rotinaStress() {
		for(int i = 0 ; i < 100 ; i++ ) {
			acessarColeta();
			clicarConexao();
			BaseTest.esperarAte("br.com.logchart.ble:id/StartTitleTV");
			pegarDiaMesAnoHoraMinutoSegundoInicialOpcoesColeta();
			clicar(By.id("br.com.logchart.ble:id/buttonOK_wifi"));
			clicar(By.id("android:id/button1"));
			verificaTelaGrafico();
			BaseTest.esperarAte("br.com.logchart.ble:id/btn_prev");
			comparaPrimeiroRegistroGrafico();
			clicarTeclado(4);
			clicarTeclado(4);
			BaseTest.esperarAte("br.com.logchart.ble:id/btn_coletaModeWIFI");
		}
	}
	
	public void verificaTelaGrafico() {
		assertTrue(existeUmElementoPorId("android:id/alertTitle"));
	}
	public void comparaPrimeiroRegistroGrafico() {
		
		clicar(By.id("br.com.logchart.ble:id/btn_prev"));
		String data = obterTexto(By.id("br.com.logchart.ble:id/date_tv"));
		String[] words = data.split(" ");
		String diaString = String.valueOf(dataOpcoesColeta.getDia());
		String anoString = String.valueOf(dataOpcoesColeta.getAno());
		System.out.println(Arrays.toString(words));
		System.out.println(diaString);
		System.out.println(anoString);
		assertEquals(diaString,words[0]);
		assertEquals(retornaMesString(dataOpcoesColeta.getMes()),words[2]);
		assertEquals(anoString,words[4]);
	
	}
	
	
	public void verificaDataInicialMaiorFinal() {
		assertFalse(existeUmElementoPorId("android:id/alertTitle"));
		assertTrue(existeUmElementoPorId("br.com.logchart.ble:id/StartTitleTV"));
	}
	public void verificaAlterarDataHora() {
		System.out.println(dataOpcoesColeta.getAno());
		System.out.println(dataOpcoesColeta.getMes());
		System.out.println(dataOpcoesColeta.getDia());
		assertEquals(dataOpcoesColeta.getDia(), diaInicial);
		assertEquals(dataOpcoesColeta.getMes(), mesInicial);
		assertEquals(dataOpcoesColeta.getAno(), anoInicial);		
	/*	getDriver().findElement(By.xpath("//*[@text=" + dataOpcoesColeta.getAno() + "]")).getText();
		getDriver().findElement(By.xpath("//*[@text=" + dataOpcoesColeta.getMes() + "]"));
		getDriver().findElement(By.xpath("//*[@text=" + dataOpcoesColeta.getDia() + "]")).getText();
	*/	
	}
}
//	public void pegarData() {
//		String time = getDriver().getDeviceTime();
//		System.out.println(time);
//	}
