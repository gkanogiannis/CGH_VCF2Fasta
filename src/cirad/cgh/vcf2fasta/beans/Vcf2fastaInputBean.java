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
package cirad.cgh.vcf2fasta.beans;

import java.io.Serializable;
import org.apache.commons.configuration.XMLConfiguration;

/**
 * @author gkanogiannis
 *
 */
public class Vcf2fastaInputBean implements Serializable {

	private static final long serialVersionUID = 7557124949251507448L;

	@SuppressWarnings("unused")
	private XMLConfiguration config;
	
	//@NotNull
	//@NotBlank(message="Query cannot be empty")

	private String analysis = "";
	private String accession = "";
	private String contig = "";
	private String interval = "";
	
	public Vcf2fastaInputBean(XMLConfiguration config) {
		this.config = config;
	}

	@SuppressWarnings("unused")
	private Vcf2fastaInputBean() {
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public String getAccession() {
		return accession;
	}

	public void setAccession(String accession) {
		this.accession = accession;
	}

	public String getContig() {
		return contig;
	}

	public void setContig(String contig) {
		this.contig = contig;
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	

}
