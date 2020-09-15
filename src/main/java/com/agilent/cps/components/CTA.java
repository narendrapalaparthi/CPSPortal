package com.agilent.cps.components;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import com.agilent.cps.core.AutoPopulator;
import com.agilent.cps.core.Verify;
import com.agilent.cps.widgetactions.Button;
import com.agilent.cps.widgetactions.DropDown;
import com.agilent.cps.widgetactions.Link;
import com.agilent.cps.widgetactions.ListBox;
import com.agilent.cps.widgetactions.TextField;
import com.agilent.cps.widgets.WidgetInfo;

public class CTA extends BaseComponent {

	public static final String componentName = "Button Component";
	
	public static class Widgets{
		public static final WidgetInfo addButton = new WidgetInfo("xpath=//button/coral-button-label[text()='Add']", Button.class);
		public static final WidgetInfo buttonLabel = new WidgetInfo("name=./cta/item0/./ctatext", TextField.class);
		public static final WidgetInfo buttonLink = new WidgetInfo("name=./cta/item0/./link", TextField.class);
		public static final WidgetInfo linkActions = new WidgetInfo("name=./cta/item0/./linkaction", DropDown.class);
		public static final WidgetInfo iconPosition = new WidgetInfo("name=./cta/item0/./position", DropDown.class);
		public static final WidgetInfo buttonColor = new WidgetInfo("name=./cta/item0/./ctacolor", ListBox.class);
		public static final WidgetInfo buttontextColor = new WidgetInfo("name=./cta/item0/./ctatextcolor", ListBox.class);
	}
	
	public void populate(Map<String, String> rowData) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		DM.button(Widgets.addButton).click();
		AutoPopulator.populate(this, rowData);
	}
	
	@Override
	public void verifyPreview(Map<String, String> rowData) {
		WidgetInfo buttonLink = new WidgetInfo("linktext="+rowData.get("buttonLabel"), Link.class);
		WebElement element = DMHelper.getWebElement(buttonLink);
		String buttonColor = rowData.getOrDefault("buttonColor", "Blue/Solid");
		if(buttonColor.equalsIgnoreCase("Transparent")) {
			Verify.verifyEquals("Verifying button text color", "#0085d5", Color.fromString(element.getCssValue("color")).asHex());
			Verify.verifyEquals("Verifying button BG color", "#000000", Color.fromString(element.getCssValue("background-color")).asHex());
			Verify.verifyEquals("Verifying that button has border", element.getCssValue("border").contains("1px solid"));
		}else if(buttonColor.equalsIgnoreCase("Text")) {
			Verify.verifyEquals("Verifying button text color", "#0085d5", Color.fromString(element.getCssValue("color")).asHex());
			Verify.verifyEquals("Verifying button BG color", "#000000", Color.fromString(element.getCssValue("background-color")).asHex());
			Verify.verifyEquals("Verifying button does not has border", element.getCssValue("border").contains("0px none"));
		}else {
			Verify.verifyEquals("Verifying button text color", "#ffffff", Color.fromString(element.getCssValue("color")).asHex());
			Verify.verifyEquals("Verifying button BG color", "#0085d5", Color.fromString(element.getCssValue("background-color")).asHex());
			Verify.verifyEquals("Verifying button does not has border", element.getCssValue("border").contains("0px none"));
		}
		verifyLinkOrbutton(element, rowData.getOrDefault("linkActions", "Existing window/tab"), rowData.get("buttonLink"), "Testing | Agilent");
	}
	
	@Override
	public String getComponentName() {
		return componentName;
	}

}
