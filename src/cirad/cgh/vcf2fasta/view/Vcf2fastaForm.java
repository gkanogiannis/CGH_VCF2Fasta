/*
 *
 * CGH_VCF2Fasta cirad.cgh.vcf2fasta.view.Vcf2fastaForm
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
package cirad.cgh.vcf2fasta.view;

import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.XMLConfiguration;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitEvent;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.fieldgroup.FieldGroup.CommitHandler;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.shared.ui.combobox.FilteringMode;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import cirad.cgh.vcf2fasta.Vcf2fastaUI;
import cirad.cgh.vcf2fasta.beans.Vcf2fastaInputBean;
import cirad.cgh.vcf2fasta.listeners.SubmitClickListener;

public class Vcf2fastaForm extends VerticalLayout implements View {
	
	public static final String ANALYSIS = "analysis";
	public static final String ANALYSIS_CAPTION = "Analysis";
	
	public static final String ACCESSION = "accession";
	public static final String ACCESSION_CAPTION = "Accession";
	
	public static final String CONTIG = "contig";
	public static final String CONTIG_CAPTION = "Contig";
	
	public static final String INTERVAL = "interval";
	public static final String INTERVAL_CAPTION = "Interval";

	public static final String RESET_CAPTION = "Reset";
	public static final String SUBMIT_CAPTION = "Go!";
	
	private XMLConfiguration config;
	
	private Vcf2fastaUI vcf2fastaUI;
	
    private Vcf2fastaInputBean vcf2fastaInputBean;
	
	private BeanFieldGroup<Vcf2fastaInputBean> fieldGroup;
	
	private SubmitClickListener<Vcf2fastaInputBean> submitClickListener;
	
	private VerticalLayout resultLayout;
	
	private Button submitButton;
	private Button resetButton;
	
	private ProgressBar progress;
	private Label status;
	
	public Vcf2fastaForm(Vcf2fastaUI vcf2fastaUI, XMLConfiguration config) {
		this.vcf2fastaUI = vcf2fastaUI;
		this.config = config;
		setImmediate(true);

		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		removeAllComponents();
		
		fieldGroup = new BeanFieldGroup<Vcf2fastaInputBean>(Vcf2fastaInputBean.class);
		vcf2fastaInputBean = new Vcf2fastaInputBean(config);
		fieldGroup.setItemDataSource(vcf2fastaInputBean);
		
		FormLayout layout = new FormLayout();
		layout.setResponsive(true);
		layout.setMargin(true);
		layout.setWidth("100%");
		//layout.addStyleName("light");
		layout.setImmediate(true);
		addComponent(layout);
		
		Label section1;
		final ComboBox analysis_combo;
		final ComboBox accession_combo;
		Label section2;
		ComboBox contig_combo;
		TextField interval;
		Label section3;
		Component buttonLayout;
		Component progressLayout;
		
		section1 = new Label("Input");
		section1.addStyleName("h3 colored");
		layout.addComponent(section1);
		analysis_combo = getComboBox(ANALYSIS_CAPTION, ANALYSIS, getAnalysesList(), false);
		layout.addComponent(analysis_combo);
		accession_combo = getComboBox(ACCESSION_CAPTION, ACCESSION, getAccessionsList(((List<String>)(Object)vcf2fastaUI.getConfig().getList("analyses/analysis/@name")).get(0)), false);
		layout.addComponent(accession_combo);
		
		analysis_combo.addValueChangeListener(new ValueChangeListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void valueChange(ValueChangeEvent event) {
				accession_combo.setContainerDataSource(getAccessionsList((String) analysis_combo.getValue()));
				accession_combo.select(accession_combo.getContainerDataSource().getItemIds().iterator().next());
			}
		});
		
		section2 = new Label("Parameters");
		section2.addStyleName("h3 colored");
		layout.addComponent(section2);
		contig_combo = getComboBox(CONTIG_CAPTION, CONTIG, getContigsList(), true);
		layout.addComponent(contig_combo);
		interval = getTextField(INTERVAL_CAPTION, INTERVAL, vcf2fastaUI.getConfig().getString("defaultInterval"), 20);
		layout.addComponent(interval);
		
		section3 = new Label("Result");
		section3.addStyleName("h3 colored");
		layout.addComponent(section3);
		resultLayout = new VerticalLayout();
		resultLayout.setSizeFull();
		resultLayout.setMargin(true);
		resultLayout.setSpacing(true);
		resultLayout.addStyleName("light");
		layout.addComponent(resultLayout);
		
		layout.addComponent(new Label(""));

		buttonLayout = getSubmitLayout();
		layout.addComponent(buttonLayout);
		progressLayout = getProgressLayout();
		layout.addComponent(progressLayout);
		
		
		initCommitHandler();
	}
	
	private void initCommitHandler() {
		fieldGroup.addCommitHandler(new CommitHandler() {
			private static final long serialVersionUID = 1L;

			@Override
			public void preCommit(CommitEvent commitEvent) throws CommitException {
				// Check for validations
				fieldGroup.isValid();
			}

			@Override
			public void postCommit(CommitEvent commitEvent) throws CommitException {
				if (submitClickListener != null && fieldGroup != null) {
					Vcf2fastaInputBean bean = fieldGroup.getItemDataSource().getBean();
					submitClickListener.onSubmit(bean);
				}
			}
		});
	}
	
	private ComboBox getComboBox(String caption, String bindName, Container container, boolean editable) {
		ComboBox comboBox = new ComboBox(caption);
		comboBox.setItemCaptionMode(ItemCaptionMode.PROPERTY);
		comboBox.setItemCaptionPropertyId("name");
		comboBox.setContainerDataSource(container);
		comboBox.setImmediate(true);
		comboBox.setValidationVisible(false);
		comboBox.setNewItemsAllowed(false);
		comboBox.setFilteringMode(FilteringMode.CONTAINS);
		comboBox.setNullSelectionAllowed(false);
		fieldGroup.bind(comboBox, bindName);
		comboBox.setTextInputAllowed(editable);
		comboBox.setWidth("300px");
		comboBox.select(container.getItemIds().iterator().next());

		return comboBox;
	}

	@SuppressWarnings("unchecked")
	private Container getAnalysesList() {
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("id", String.class, "");
		container.addContainerProperty("name", String.class, "");
		List<String> analyses_ids = (List<String>)(Object)vcf2fastaUI.getConfig().getList("analyses/analysis/@id");
		List<String> analyses_names = (List<String>)(Object)vcf2fastaUI.getConfig().getList("analyses/analysis/@name");
		for (int i = 0; i < analyses_ids.size(); i++) {
			String analysis_id = (String) analyses_ids.get(i);
			String analysis_name = (String) analyses_names.get(i);
			//Item newItem = container.addItem(analysis_id);
			Item newItem = container.addItem(analysis_name);
			newItem.getItemProperty("id").setValue(analysis_id);
			newItem.getItemProperty("name").setValue(analysis_name);
		}
		return container;
	}
	
	@SuppressWarnings("unchecked")
	private Container getAccessionsList(String analysis_name) {
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("name", String.class, "");
		List<String> accessions_names = (List<String>)(Object)vcf2fastaUI.getConfig().getList("analyses/analysis[@name='" + analysis_name + "']/accessions");
		for (int i = 0; i < accessions_names.size(); i++) {
			String accession_name = (String) accessions_names.get(i);
			Item newItem = container.addItem(accession_name);
			newItem.getItemProperty("name").setValue(accession_name);
		}
		return container;
	}
	
	@SuppressWarnings("unchecked")
	private Container getContigsList() {
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("name", String.class, "");
		List<String> contigs = (List<String>)(Object)vcf2fastaUI.getConfig().getList("contigs");
		for (int i = 0; i < contigs.size(); i++) {
			String name = (String) contigs.get(i);
			Item newItem = container.addItem(name);
			newItem.getItemProperty("name").setValue(name);
		}
		return container;
	}
	
	private TextField getTextField(String caption, String bindName, String defaultValue, int columns) {
		TextField textField = new TextField(caption);
		textField.setImmediate(true);
		fieldGroup.bind(textField, bindName);
		textField.setValidationVisible(false);
		textField.setNullRepresentation("");
		textField.setNullSettingAllowed(true);
		textField.setColumns(columns);
		textField.setValue(defaultValue);

		return textField;
	}
	
	private Button getButton(String caption) {
		Button button = new Button(caption);
		button.setImmediate(true);
		button.setHtmlContentAllowed(true);
		return button;
	}
	
	private Component getSubmitLayout() {
		HorizontalLayout buttonLayout = new HorizontalLayout();
		buttonLayout.setSpacing(true);

		submitButton = getButton(SUBMIT_CAPTION);
		submitButton.addClickListener(getSubmitButtonClickListener());
		buttonLayout.addComponent(submitButton);

		resetButton = getButton(RESET_CAPTION);
		resetButton.addClickListener(getResetClickListener());
		buttonLayout.addComponent(resetButton);

		return buttonLayout;
	}

	private Component getProgressLayout() {
		HorizontalLayout layout = new HorizontalLayout();
		layout.setSpacing(true);

		status = new Label("");
		layout.addComponent(this.status);

		progress = new ProgressBar();
		progress.setEnabled(false);
		progress.setVisible(false);
		layout.addComponent(progress);

		return layout;
	}
	
	private ClickListener getResetClickListener() {
		return new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				resetForm();
			}
		};
	}
	
	public void resetForm() {
		vcf2fastaStop();
	}
	
	private ClickListener getSubmitButtonClickListener() {
		return new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			@Override
			public void buttonClick(ClickEvent event) {
				try {
					resultLayout.removeAllComponents();
					
					fieldGroup.commit();
					
					/*
					System.out.println(vcf2fastaInputBean.getAnalysis());
					System.out.println(vcf2fastaInputBean.getAccession());
					System.out.println(vcf2fastaInputBean.getContig());
					System.out.println(vcf2fastaInputBean.getInterval());
					*/
					
					UI.getCurrent().setPollInterval(200);
				} 
				catch (CommitException e) 
				{
					Map<Field<?>, InvalidValueException> invalidFields = e.getInvalidFields();
					for (Map.Entry<Field<?>, InvalidValueException> invalidField : invalidFields.entrySet()) {
						((AbstractField) invalidField.getKey()).setValidationVisible(true);
					}
					if (invalidFields.isEmpty()) {
						e.printStackTrace();
						Notification.show("VCF2FASTA ERROR, Please try again");
					}
				}
			}
		};
	}
	
	public void vcf2fastaStop() {
		vcf2fastaUI.vcf2fastaStop();
		initComponents();
	}
	
	public void vcf2fastaStart() {
		Thread t = new Thread() {
			public void run() {
				// Update the UI thread-safely
				UI.getCurrent().access(new Runnable() {
					@Override
					public void run() {
						progress.setIndeterminate(true);
						progress.setVisible(true);
						progress.setEnabled(true);
						submitButton.setEnabled(false);
						status.setValue("running...");
					}
				});
			}
		};
		t.start();
	}
	
	public void vcf2fastaEnd() {
		//System.out.println("Vcf2fastaForm vcf2fastaEnd()");
		Thread t = new Thread() {
			public void run() {
				// Update the UI thread-safely
				UI.getCurrent().access(new Runnable() {
					@Override
					public void run() {
						status.setValue("all done");
						progress.setIndeterminate(false);
						progress.setVisible(false);
						progress.setEnabled(false);
					}
				});
				
				// Show the "all done" for a while
				try {
					sleep(1500L);
				} 
				catch (InterruptedException localInterruptedException) {
				}
				
				// Update the UI thread-safely
				UI.getCurrent().access(new Runnable() {
					@Override
					public void run() {
						submitButton.setEnabled(true);
						status.setValue("");
						UI.getCurrent().setPollInterval(-1);
					}
				});
			}
		};
		t.start();
	}

	public Vcf2fastaInputBean getVcf2fastaInputBean() {
		return vcf2fastaInputBean;
	}
	
	public void setFormSubmitHandler(SubmitClickListener<Vcf2fastaInputBean> submitClickListener) {
		this.submitClickListener = submitClickListener;
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
	}

	public void drawResult(List<String[]> links) {		
		for(String[] link : links){
			Link section1Down = new Link(link[0], new ExternalResource(link[1]), "_blank", 0, 0, null);
			section1Down.addStyleName("colored");
			resultLayout.addComponent(section1Down);
		}
	}
}
