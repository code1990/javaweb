package org.salever.rcp.tech.chapter3;


import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	private IWorkbenchAction iExitAction;
	private IWorkbenchAction iAboutAction;
	private IWorkbenchAction iNewWindowAction;
	private IWorkbenchAction iSaveAction;
	
	
    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {
    	iExitAction = ActionFactory.QUIT.create(window);
    	register(iExitAction);
    	iSaveAction = ActionFactory.SAVE.create(window);
    	register(iSaveAction);
    	iAboutAction = ActionFactory.ABOUT.create(window);
    	register(iAboutAction);
    	iNewWindowAction = ActionFactory.OPEN_NEW_WINDOW.create(window);
    	register(iNewWindowAction);
    	
    }

    protected void fillMenuBar(IMenuManager menuBar) {
    	MenuManager fileMenu = new MenuManager("&File",IWorkbenchActionConstants.M_FILE);
    	MenuManager helpMenu = new MenuManager("&Help",IWorkbenchActionConstants.M_HELP);
    			
    	menuBar.add(fileMenu);
    	menuBar.add(helpMenu);
    			
    	//file menu
    	fileMenu.add(iNewWindowAction);
    	fileMenu.add(iSaveAction);
    	fileMenu.add(new Separator());
    	fileMenu.add(iExitAction);
    	fileMenu.add(iNewWindowAction);
    	
    	//Help Menu
    	helpMenu.add(iAboutAction);
    			
    }
    
//    public void preWindowOpen(){
//    	IWorkbenchWindoRwConfigurer configurer = getWindowConfigurer();
//    	configurer.setInitialSize(new Point(400, 300));
//    	configurer.setShowCoolBar(true);
//    	configurer.setShowStatusLine(false);
//    	configurer.setTitle("Hello RCP");
//    	
//    }
    
}
