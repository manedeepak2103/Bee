package com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.shared.Add;
import com.shared.Books;
import com.shared.Data;

import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.addins.client.fileuploader.MaterialFileUploader;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialProgress;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.html.Option;

public class BUpl extends Composite {

	private static BUplUiBinder uiBinder = GWT.create(BUplUiBinder.class);

	interface BUplUiBinder extends UiBinder<Widget, BUpl> {
	}

	public BUpl() {
		initWidget(uiBinder.createAndBindUi(this));
		

	}
	GreetingServiceAsync a1=GWT.create(GreetingService.class);
	@UiField
	MaterialComboBox t1 ;
	
	@UiField
	MaterialTextBox t2;
	
	@UiField
	MaterialComboBox t3 ;
	@UiField
	MaterialTextArea t4;
	@UiField
	MaterialTextBox t6;
    @UiField
	MaterialButton b;
@UiHandler ("b")
void onClick(ClickEvent e) {
	Books b=new Books();
	b.setCaty(t1.getPlaceholder());
	b.setName(t2.getText());
	b.setSubcaty(t3.getPlaceholder());
	b.setDesct(t4.getText());
	b.setCity(t6.getText());
		a1.fun1(b,new AsyncCallback<Books>() {
		
		@Override
		public void onSuccess(Books result) {
			// TODO Auto-generated method stub
			Window.alert("SUCCESS");
			t1.setPlaceholder(result.getCaty());
			t2.setText(result.getName());
			t3.setPlaceholder(result.getSubcaty());
			t4.setText(result.getDesct());
			t6.setText(result.getCity());
			
			
			String s3= t6.getText();
			Add d= new Add();
			String s=d.cname;
			a1.po(s3, new AsyncCallback<Add[]>() {
				
				@Override
				public void onSuccess(Add[] result) {
					// TODO Auto-generated method stub
		for(int i=0;i<result.length;i++)
		{	MaterialRow r=new MaterialRow();
					RootPanel.get("r2").add(r);
					for(int j=0;j<result.length;j++)
					{MaterialColumn mc= new MaterialColumn();
					r.add(mc);
					MaterialCard m= new MaterialCard();
					mc.add(m);
					MaterialCardContent n= new MaterialCardContent();
					m.add(n);
					MaterialComboBox mb= new MaterialComboBox();
					mb.setPlaceholder("Select");
					n.add(mb);
					Option h= new Option();
					mb.add(h);
					h.setText(result[j].cname);}
					
		}
					
				
				}
				
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			Window.alert(caught.getMessage());
		}
	} );
}
}
