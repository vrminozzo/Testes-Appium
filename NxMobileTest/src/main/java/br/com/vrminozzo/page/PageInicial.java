package br.com.vrminozzo.page;

import static br.com.vrminozzo.core.DriverFactory.getDriver;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static org.junit.Assert.assertTrue;

import br.com.vrminozzo.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class PageInicial extends BasePage{

	
	public void verificarWifi() {
		assertTrue(existeUmElementoPorId("br.com.logchart.ble:id/btn_configModeWIFI"));
		assertTrue(existeUmElementoPorId("br.com.logchart.ble:id/btn_monitoringModeWIFI"));
		assertTrue(existeUmElementoPorId("br.com.logchart.ble:id/btn_coletaModeWIFI"));
		assertTrue(existeUmElementoPorId("br.com.logchart.ble:id/btn_downloadModeWIFI"));
	}
	public void verificarBle() {
		assertTrue(existeUmElementoPorId("br.com.logchart.ble:id/btn_configModeBLE"));
		assertTrue(existeUmElementoPorId("br.com.logchart.ble:id/btn_monitoringModeBLE"));
		assertTrue(existeUmElementoPorId("br.com.logchart.ble:id/btn_preferencesBLE"));
		assertTrue(existeUmElementoPorId("br.com.logchart.ble:id/btn_downloadModeBLE"));
	}
	public boolean toogleWiFi() {
		if(	existeUmElementoPorId("br.com.logchart.ble:id/btn_configModeWIFI") &&
			existeUmElementoPorId("br.com.logchart.ble:id/btn_monitoringModeWIFI") &&
			existeUmElementoPorId("br.com.logchart.ble:id/btn_coletaModeWIFI") &&
			existeUmElementoPorId("br.com.logchart.ble:id/btn_downloadModeWIFI")) {
			return true;
		}else {
			return false;
		}
		}
	public boolean toogleBle() {
	if(	existeUmElementoPorId("br.com.logchart.ble:id/btn_configModeBLE") &&
		existeUmElementoPorId("br.com.logchart.ble:id/btn_monitoringModeBLE") &&
		existeUmElementoPorId("br.com.logchart.ble:id/btn_preferencesBLE") &&
		existeUmElementoPorId("br.com.logchart.ble:id/btn_downloadModeBLE")) {
		return true;
	}else {
		return false;
	}
	}
	public void clicarWifiBle() {
		
		MobileElement toogle = getDriver().findElementById("br.com.logchart.ble:id/toggle_isWifi");
		new TouchAction(getDriver()).tap(tapOptions().withElement(element(toogle))).perform();
		
	}

}
	