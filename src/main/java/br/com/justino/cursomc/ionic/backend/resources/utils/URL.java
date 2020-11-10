package br.com.justino.cursomc.ionic.backend.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {

	public static String decodeString(String param) {
		try {
			return URLDecoder.decode(param, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	public static List<Integer> decodeIntList(String lista) {
		return Arrays.asList(lista.split(",")).stream().map(i -> Integer.valueOf(i)).collect(Collectors.toList());
	}

}
