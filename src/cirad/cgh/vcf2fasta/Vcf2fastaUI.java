/*
 *
 * CGH_VCF2Fasta cirad.cgh.vcf2fasta.Vcf2fastaUI
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
package cirad.cgh.vcf2fasta;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.annotation.WebServlet;

import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.tree.xpath.XPathExpressionEngine;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;

import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;

import cirad.cgh.vcf2fasta.beans.Vcf2fastaInputBean;
import cirad.cgh.vcf2fasta.listeners.SubmitClickListener;
import cirad.cgh.vcf2fasta.view.Vcf2fastaForm;

import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

//@Theme("tests-valo")
@Title("Vcf2fasta")
//@PreserveOnRefresh
public class Vcf2fastaUI extends UI {
	
	private XMLConfiguration config;
	
	private Vcf2fastaForm vcf2fastaForm;
	
	private Vcf2fastaRunner vcf2fastaRunner;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = true, ui = Vcf2fastaUI.class)
	public static class Vcf2fastaServlet extends VaadinServlet {
	}
	
	public XMLConfiguration getConfig(){
		return config;
	}
	
	private XMLConfiguration initConfig(){
		System.out.println("INIT");
		try {
			File base = this.getSession().getService().getBaseDirectory();
			File webinf = new File(base,"WEB-INF");
			File tmp = new File(base, "tmp");
			if(!tmp.exists()) tmp.mkdirs();
				
			XMLConfiguration config = new XMLConfiguration(new File(webinf,"config.xml"));
			
			config.setProperty("base", base.getAbsolutePath());
			
			config.setExpressionEngine(new XPathExpressionEngine());
			
			return config;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	protected void init(VaadinRequest request) {
		config = initConfig();
		
		Panel mainPanel = new Panel("Vcf2fasta");
		
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		mainPanel.setContent(layout);
		
		vcf2fastaForm = new Vcf2fastaForm(this, config);
		vcf2fastaForm.setFormSubmitHandler(getSubmitClickListener(this));
		
		layout.addComponent(vcf2fastaForm);
		
		setTheme("tests-valo-reindeer");
		//setTheme("tests-valo-facebook");
		//setTheme("tests-valo-metro");
		
		setContent(mainPanel);
	}
	
	@Override
    protected void refresh(VaadinRequest request) {
        System.out.println("refresh");
    }
	
	private SubmitClickListener<Vcf2fastaInputBean> getSubmitClickListener(final Vcf2fastaUI vcf2fastaUI) {
		return new SubmitClickListener<Vcf2fastaInputBean>() {

			@Override
			public void onSubmit(Vcf2fastaInputBean vcf2fastaInputBean) {
				System.out.println(vcf2fastaInputBean.getAnalysis());
				System.out.println(vcf2fastaInputBean.getAccession());
				System.out.println(vcf2fastaInputBean.getContig());
				System.out.println(vcf2fastaInputBean.getInterval());
				
				vcf2fastaForm.vcf2fastaStart();
				
				vcf2fastaRunner = new Vcf2fastaRunner(vcf2fastaUI, vcf2fastaInputBean);
				Thread t = new Thread(vcf2fastaRunner);
				t.start();
			}
			
		};
	}
	
	public void vcf2fastaStop(){
		if(vcf2fastaRunner!=null) vcf2fastaRunner.vcf2fastaStop();
	}
	
	public void vcf2fastaEnd(String vcf2fastaResultURLcc, Vcf2fastaInputBean vcf2fastaInputBean) {
		//UUID uuid = UUID.randomUUID();
		try {
			String vcf2fastaResultTxt = Utils.getTextFromURL(vcf2fastaResultURLcc);
			if(vcf2fastaResultTxt!=null) {
				//String vcf2fastaResultFileName = "tmp." + uuid + ".fasta";
				String vcf2fastaResultFileName = vcf2fastaInputBean.getAnalysis().replaceAll("\\s+", "_") + vcf2fastaInputBean.getAccession() + "_" 
				+ vcf2fastaInputBean.getContig() + "_" + vcf2fastaInputBean.getInterval() + ".fasta";
				File vcf2fastaResultFile = new File(new File(new File(config.getString("base")), "tmp"), vcf2fastaResultFileName);
				vcf2fastaResultFile.deleteOnExit();
				FileUtils.writeStringToFile(vcf2fastaResultFile, vcf2fastaResultTxt, Charsets.UTF_8);
				String vcf2fastaResultURL = UI.getCurrent().getPage().getLocation().toString() + "tmp/" + vcf2fastaResultFileName;

				
				List<String[]> links = new ArrayList<String[]>();
				links.add(new String[]{"Download result fasta file.", vcf2fastaResultURL});
				
				vcf2fastaForm.drawResult(links);
			}
			
			vcf2fastaForm.vcf2fastaEnd();
		} 
		catch (Exception e) {
			e.printStackTrace();
			vcf2fastaForm.vcf2fastaEnd();
		}
	}

}