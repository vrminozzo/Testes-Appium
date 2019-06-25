package br.com.vrminozzo.page;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import br.com.vrminozzo.core.BasePage;

public class TelaConfiguracao extends BasePage {

	
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
	public void verificarConexoesSalvas() {
		
	}
}


