/*
 *
 * CGH_VCF2Fasta cirad.cgh.vcf2fasta.beans.Vcf2fastaInputBean
 *
 * Copyright (C) 2021 Anestis Gkanogiannis <anestis@gkanogiannis.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 *
 */
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
