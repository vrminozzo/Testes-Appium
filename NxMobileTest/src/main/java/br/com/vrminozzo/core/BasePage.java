package br.com.vrminozzo.core;

import static br.com.vrminozzo.core.DriverFactory.getDriver;
import static io.appium.java_client.touch.offset.PointOption.point;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.apache.tools.ant.filters.LineContains.Contains;
import org.hamcrest.core.StringStartsWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import com.sun.xml.internal.ws.wsdl.writer.document.StartWithExtensionsType;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;

public class BasePage {

	
	
	public void verificarTelaConfig() {
		assertTrue(existeUmElementoPorId("br.com.logchart.ble:id/et_connectionName"));
		assertTrue(existeUmElementoPorId("br.com.logchart.ble:id/et_ipAddress"));
		assertTrue(existeUmElementoPorId("br.com.logchart.ble:id/et_porta"));
		assertTrue(existeUmElementoPorId("br.com.logchart.ble:id/et_timeOut"));
	}
	
	public void acessarConfiguração() {
		clicar(By.id("br.com.logchart.ble:id/btn_configModeWIFI"));
	}
	public void acessarColeta() {
		clicar(By.id("br.com.logchart.ble:id/btn_coletaModeWIFI"));
	}
	
	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public void clicarPorTexto(String texto) {
		getDriver().findElement(By.xpath("//*[@text='" + texto + "']")).click();
	}

	public void clicar(By by) {
		getDriver().findElement(by).click();
	}

	public boolean existeUmElementoPorTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
		return elementos.size() > 0;
	}
	public boolean existeUmElementoPorId(String texto) {
		List<MobileElement> elementos = getDriver().findElementsById(texto);
		for(int i = 0; i < elementos.size(); i++) {
		System.out.println(elementos.get(i).getText());
		}
		return elementos.size() > 0;
	}
	
	public void selecionarCombo(By by, String valor) {
		getDriver().findElement(by).click();
		clicarPorTexto(valor);
	}

	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("false");
	}
	public void tap(int x, int y) {
	new TouchAction(getDriver()).tap(point(x, y)).perform();
	}
	
	public void scroll(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		
		int x = size.width/2;
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);
		
		new TouchAction(getDriver()).longPress(point(x,start_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(point(x,end_y)).release().perform();
//		new TouchAction(getDriver()).longPress(point(x,start_y)).waitAction(Duration.ofMillis(500)).moveTo(x,end_y).release().perform();
	}
	public String obterTituloAlerta(){
		return obterTexto(By.id("android:id/alertTitle"));
	}
	public String obterMensagemAlerta() {
		return obterTexto(By.id("android:id/message"));
	}
	public void swipe(double inicio,double fim) {
		Dimension size = getDriver().manage().window().getSize();
		
		int y = size.height/2;
		
		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);
		
		new TouchAction(getDriver()).press(point(start_x,y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(point(end_x,y)).release().perform();
	}
	public void swipeElement(MobileElement element,double inicio,double fim) {
		int y = element.getLocation().y + (element.getSize().height/2);
		
		int start_x = (int) (element.getSize().width * inicio);
		int end_x = (int) (element.getSize().width * fim);
	
		new TouchAction(getDriver()).press(point(start_x,y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(point(end_x,y)).release().perform();
//	new TouchAction(getDriver()).press(point(start_x,y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(point(end_x,y)).release().perform();
	}
	public void scrollDown() {
		scroll(0.9,0.1);
	}
	public void scrollUp() {
		scroll(0.1,0.9);
	}
	public void swipeLeft() {
		swipe(0.1,0.9);
	}
	public void swipeRight() {
		swipe(0.9,0.1);
	}
	
	public void encontrarElementosBy(By tipo , int vetor) {
		List<MobileElement> elementosEncontrados = getDriver().findElements(tipo);
		for(MobileElement elemento : elementosEncontrados) {
			System.out.println(elemento.getText());
		}
		elementosEncontrados.get(vetor).click();
	}
	public boolean encontrarArquivosSalvos(String texto, String tipoArquivo) {
		List<MobileElement> elementos = getDriver().findElements(By.id(texto));
		elementos.toString().startsWith(tipoArquivo);
		for(int i = 0; i < elementos.size(); i++) {
			System.out.println(elementos.get(i).getText());
			}
		return  elementos.size() > 0;
	}
	
	// Achar por ID as preferencias, fazer um if check e pedir parar as opções que quero
	
	public void verificaArquivosSalvos(String texto , String tipoArquivo) {
		assertTrue(encontrarArquivosSalvos(texto , tipoArquivo));
	}
}
