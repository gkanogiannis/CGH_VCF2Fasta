/*******************************************************************************
 * Copyright (C) 2016 <CIRAD>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License, version 3 as
 * published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 *
 * See <http://www.gnu.org/licenses/gpl-3.0.html> for details about
 * GNU Affero General Public License V3.
 *
 * Contributors:
 *     Anestis Gkanogiannis <ganoyan@gmail.com>
 *******************************************************************************/
package cirad.cgh.vcf2fasta;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {

	public static String getTextFromFile(File file, Charset encoding) throws Exception {
		byte[] encoded = Files.readAllBytes(Paths.get(file.getAbsolutePath(), new String[0]));
		return new String(encoded, encoding);
	}

	public static String getTextFromURL(String url) throws Exception {
		if (url == null) {
			return null;
		}
		URL website = new URL(url);
		URLConnection connection = website.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		StringBuilder response = new StringBuilder();
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine + "\n");
		}
		in.close();

		return response.toString();
	}
	
	
}
