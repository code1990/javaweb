package org.eclipse.rcp.intro.perspective;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class MyPerspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		// TODO Auto-generated method stub
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(true);
		layout.setFixed(false);
		layout.addStandaloneView(View.ID, false, IPageLayout.LEFT, 1.0f,
				editorArea);
	}

}
