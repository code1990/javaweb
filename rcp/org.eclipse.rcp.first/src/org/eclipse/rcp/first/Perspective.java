package org.eclipse.rcp.first;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.addView("intro.commands.myView", IPageLayout.TOP, IPageLayout.RATIO_MAX, IPageLayout.ID_EDITOR_AREA);
	}
}
