package com.agilent.cps.components;

import java.util.Map;

import com.agilent.cps.widgetactions.Button;
import com.agilent.cps.widgetactions.CheckBox;
import com.agilent.cps.widgetactions.DropDown;
import com.agilent.cps.widgetactions.GUIWidget;
import com.agilent.cps.widgetactions.RadioGroup;
import com.agilent.cps.widgetactions.TextField;
import com.agilent.cps.widgets.WidgetInfo;

public class PEPList extends BaseComponent {

	public static final String componentName = "PEP List";
	
	public static class Widgets{
		public static final WidgetInfo layoutType = new WidgetInfo("xpath=//h3[text()='Layout Type']/parent::div", RadioGroup.class);
		public static final WidgetInfo listSettingsTab = new WidgetInfo("xpath=//coral-tab/coral-tab-label[text()='List Settings']", GUIWidget.class);
		public static final WidgetInfo buildList = new WidgetInfo("name=./listFrom", DropDown.class);
		public static final WidgetInfo showFilters = new WidgetInfo("name=./filter", CheckBox.class);
		
//		Child Pages Options
		public static final WidgetInfo parentPage = new WidgetInfo("name=./parentPage", TextField.class);
		public static final WidgetInfo childDeapth = new WidgetInfo("name=./childDepth", TextField.class);
		public static final WidgetInfo orderByPublishDate = new WidgetInfo("name=./orderby", CheckBox.class);
		public static final WidgetInfo hideImage = new WidgetInfo("name=./hideimage", CheckBox.class);
		public static final WidgetInfo hidePEPDescription = new WidgetInfo("name=./hidedescription", CheckBox.class);
		public static final WidgetInfo hideCategoryTags = new WidgetInfo("name=./hidecategorytags", CheckBox.class);
		public static final WidgetInfo hideEventDate = new WidgetInfo("name=./hideeventdate", CheckBox.class);
		public static final WidgetInfo hideEventPresenter = new WidgetInfo("name=./hideeventpresenter", CheckBox.class);
		
//		Fixed List Options
		public static final WidgetInfo addButton = new WidgetInfo("xpath=//button/coral-button-label[text()='Add']", Button.class);
		
		
	}
	
	@Override
	public void verifyPreview(Map<String, String> rowData) {
		
	}

	@Override
	public String getComponentName() {
		return componentName;
	}

}
