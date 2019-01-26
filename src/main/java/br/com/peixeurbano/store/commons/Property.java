package br.com.peixeurbano.store.commons;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Application Properties
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
@Component
public class Property {

	@Value("${backdoor.header}")
	public String BACKDOOR_HEADER;

	@Value("${backdoor.access.key}")
	public String BACKDOOR_ACCESS_KEY;

	@Value("${client.header}")
	public String XF_CLIENT_HEADER;

	@Value("${client.secret}")
	public String XF_CLIENT_SECRET;

	@Value("${api.header}")
	public String XF_API_HEADER;

	@Value("${api.key}")
	public String XF_API_KEY;
}
