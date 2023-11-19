package br.com.pilares.ancontabil.util;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class DataUtilImpl implements DataUtil {

	private static final String ZONE_ID = "America/Bahia";
	
	@Override
	public LocalDateTime getDataHoraServidor() {
		return LocalDateTime.now(ZoneId.of(ZONE_ID));
	}
	
}
