package com.edifixio.soc.web.util;





public class WebControllerFactory {
    
    private static WebControllerFactory webControllerFactory;
    
    private static final String CHANNEL_CONTROLLER = "channelController";
    private static final String PAGE_CONTROLLER = "pageController";
    private static final String DASHBOARD_CONTROLLER = "dashboardController";
    
    private WebControllerFactory() {
    }
    
    public static WebControllerFactory getInstance(){
        if(webControllerFactory == null)
            webControllerFactory = new WebControllerFactory();
        return webControllerFactory;
    }
    
//    public ChannelController getChannelController(){
//        return (ChannelController)getExternalContext().getSessionMap().get(CHANNEL_CONTROLLER);
//    }
//    
//    public InboundController getPageController(){
//        return (InboundController)getExternalContext().getSessionMap().get(PAGE_CONTROLLER);
//    }
//    
//    private ExternalContext getExternalContext(){
//        return  FacesContext.getCurrentInstance().getExternalContext();
//    }
//    
//    public DashBoardController getDashBoardController(){
//        return (DashBoardController)getExternalContext().getSessionMap().get(DASHBOARD_CONTROLLER);
//    }
    
}
