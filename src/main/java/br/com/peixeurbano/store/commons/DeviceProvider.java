package br.com.peixeurbano.store.commons;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Component;

/**
 * Device Provider
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
@Component
public class DeviceProvider {

	public Device getCurrentDevice(HttpServletRequest request) {
		return DeviceUtils.getCurrentDevice(request);
	}
}
