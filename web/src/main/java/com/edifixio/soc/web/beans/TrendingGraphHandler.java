package com.edifixio.soc.web.beans;

import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.faces.event.ActionEvent;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.web.controllers.BaseWebObject;
import com.edifixio.soc.web.controllers.ChannelPerformanceController;
import com.edifixio.soc.web.dto.TrendingGraphDTO;
import com.edifixio.soc.web.dto.TrendingGraphOuterDTO;


public class TrendingGraphHandler extends BaseWebObject{
    
    ChannelPerformanceController channelPerformanceController;
    private List<TrendingGraphDTO> trendList;
    private Map<Date, TrendingGraphOuterDTO> trendMap = new TreeMap<Date, TrendingGraphOuterDTO>();
    private List<TrendingGraphOuterDTO> outerTrendList;
    
    private StringBuilder xmlDataForGraph;
    
    private static final String OVERALL = "Overall";
    private static final String SENTIMENT = "Sentiment";
    private static final String ENGAGEMENT = "Engagement";
    private static final String RETENTION = "Conversion";
    private static final String DEMOGRAPHICS = "Demographics";
    private static final String LOYALTY = "Loyalty";
    private static final String INFLUENCE = "Influence";
    private static final String REACH = "Reach";
    
    private static final String DISPLAYORDER = "displayOrder";
    private static final String ROOT_TAG = "GRADE";
    private static final String RESULT_TAG = "DATA";
    
    
    
    public TrendingGraphHandler()
    {
        System.out.println("TrendingGraphHandler constructor called....");        
        
    }
    
    public String getTrendingXMLData() throws SVTException{
//        System.out.println("called [" + xmlDataForGraph + "]");
       // viewTrending(null);
        if(xmlDataForGraph != null){
//            System.out.println("[" + xmlDataForGraph.toString() + "]");
            //return xmlDataForGraph.toString().replaceAll("+", "%2B");
            return buildXML(outerTrendList).replaceAll("\"", "'").replaceAll("\\+", "%2B");
        }
        return "";
    }
    
    public void viewTrending(ActionEvent actionEvent) throws SVTException, ParseException
    {
        System.out.println("Clicked to view TrendindGraph................"); 
        System.out.println("getAsOfPerformanceDate1() : " + getChannelPerformanceController().getPerformanceAsOfDate());
        System.out.println("getCurrentUid() : " + getChannelPerformanceController().getCurrentUid());
        System.out.println("getTwitterAccountId() : " + getChannelPerformanceController().getTwitterAccountId());
        System.out.println("getBenchmarkDateFrom() : " + getChannelPerformanceController().getBenchmarkDateFrom());
        System.out.println("getBenchmarkDateTo() : " + getChannelPerformanceController().getBenchmarkDateTo());
        System.out.println("getTargetId() : " + getChannelPerformanceController().getTargetId());
        
        System.out.println("getMode() : " + getChannelPerformanceController().getTrendingModeDWMSelected());
        System.out.println("getSelf() : " + getChannelPerformanceController().getTrendingSelfSelected());
        System.out.println("getCategory() : " + getChannelPerformanceController().getTrendingCategorySelected());
        
        if(getChannelPerformanceController().getPerformanceAsOfDate() == null)
        {
            return;
        }
        
        String strGraphDate = getParameter("graphDate");
        String strGraphTwitterId = getParameter("graphTwitterId");
        List<TrendingGraphDTO> dtos;
        
        if((strGraphDate!=null && strGraphDate.trim().length()>0) && (strGraphTwitterId!=null && strGraphTwitterId.trim().length()>0))
        {
            
            Date performDate;
            DateFormat formatter;
            formatter = new SimpleDateFormat("MM/dd/yyyy");
            performDate = (Date)formatter.parse(strGraphDate);
            
            // System.out.println("**************** performDate : "+performDate);
            // System.out.println("**************** strGraphTwitterId : "+strGraphTwitterId);
            
            dtos = getTwitterCalculatorMgr().getTrendingGraph(getChannelPerformanceController().getTrendingCategorySelected(), 
                    getChannelPerformanceController().getTrendingModeDWMSelected(),
                    performDate, 
                    getChannelPerformanceController().getCurrentUid(), 
                    strGraphTwitterId, 
                    getChannelPerformanceController().getBenchmarkDateFrom(), 
                    getChannelPerformanceController().getBenchmarkDateTo(), 
                    getChannelPerformanceController().getTargetId());
            
        }
        else
        {
            
            dtos = getTwitterCalculatorMgr().getTrendingGraph(getChannelPerformanceController().getTrendingCategorySelected(), 
                 getChannelPerformanceController().getTrendingModeDWMSelected(),
                 getChannelPerformanceController().getPerformanceAsOfDate(), 
                 getChannelPerformanceController().getCurrentUid(), 
                 getChannelPerformanceController().getTwitterAccountId(), 
                 getChannelPerformanceController().getBenchmarkDateFrom(), 
                 getChannelPerformanceController().getBenchmarkDateTo(), 
                 getChannelPerformanceController().getTargetId());
         
        }
                
        this.trendList = dtos;
        
        for(TrendingGraphDTO dt: dtos)
        {
            if(dt != null)
            {
                TrendingGraphOuterDTO outerDTO = null;
                if(trendMap.containsKey(dt.getAsOfPerformanceDate()))
                {
                        outerDTO = trendMap.get(dt.getAsOfPerformanceDate());
                }
                else
                {
                    outerDTO = new TrendingGraphOuterDTO();
                }   
                if(dt.isSelf())
                {
                    outerDTO.setSelfGraphDTO(dt);
                }
                else
                {
                    outerDTO.setCompGraphDTO(dt);
                }    
                trendMap.put(dt.getAsOfPerformanceDate(), outerDTO);
                
            }
            
         // check if working as desired
            
//            System.out.println("===================================");
//            System.out.println("MODE: " + dt.getMode());
//            System.out.println("SELF: " + dt.isSelf());
//            System.out.println("DATE: " + dt.getAsOfPerformanceDate());
//            System.out.println("DATE String : "+dt.getStrAsOfPerformanceDate());
//            
//            System.out.println("getOverallGrade:        " + dt.getGradeDetail().getOverallGrade());
//            System.out.println("getSentimentGrade:      " + dt.getGradeDetail().getSentimentGrade());
//            System.out.println("getEngagementGrade:     " + dt.getGradeDetail().getEngagementGrade());
//            System.out.println("getRetentionGrade:      " + dt.getGradeDetail().getRetentionGrade());
//            System.out.println("getDemographicsGrade:   " + dt.getGradeDetail().getDemographicsGrade());
//            System.out.println("getLoyaltyGrade:        " + dt.getGradeDetail().getLoyaltyGrade());
//            System.out.println("getInfluenceGrade:      " + dt.getGradeDetail().getInfluenceGrade());
//            System.out.println("getReachGrade:          " + dt.getGradeDetail().getReachGrade());
            
         }
        
        if(trendMap != null)
        {
            
            this.outerTrendList = new ArrayList<TrendingGraphOuterDTO>();
            
            Collection<TrendingGraphOuterDTO> trendCollection = trendMap.values();
            
            for (Iterator<TrendingGraphOuterDTO> iterator = trendCollection.iterator(); iterator.hasNext();) 
            {
                TrendingGraphOuterDTO objectTrendOuter = (TrendingGraphOuterDTO) iterator.next();
                
                if(getChannelPerformanceController().getTrendingCategorySelected() != null && getChannelPerformanceController().getTrendingCategorySelected().trim().length() > 0 )
                {
                    setSelectedTrendingCategoryGrade(objectTrendOuter, getChannelPerformanceController().getTrendingCategorySelected());
                }                
                
                this.outerTrendList.add(objectTrendOuter);
                
            }
            if(this.outerTrendList != null)
            {
                this.xmlDataForGraph =  createXMLForGraph(this.outerTrendList);
                //System.out.println(this.xmlDataForGraph);
            }
        }
    }
    
    private void setSelectedTrendingCategoryGrade(TrendingGraphOuterDTO objectTrendOuter,  String trendingCategorySelected)
    {
        // OVERALL
        if(trendingCategorySelected.equalsIgnoreCase(OVERALL))
        {
            if(objectTrendOuter.getCompGraphDTO() != null &&
                    objectTrendOuter.getCompGraphDTO().getGradeDetail() != null &&
                    objectTrendOuter.getCompGraphDTO().getGradeDetail().getOverallGrade() != null )
            {
                objectTrendOuter.getCompGraphDTO().getGradeDetail().setSelectedCategoryGrade(objectTrendOuter.getCompGraphDTO().getGradeDetail().getOverallGrade());
            }
            
            if(objectTrendOuter.getSelfGraphDTO() != null &&
                    objectTrendOuter.getSelfGraphDTO().getGradeDetail() != null &&
                    objectTrendOuter.getSelfGraphDTO().getGradeDetail().getOverallGrade() != null )
            {
                objectTrendOuter.getSelfGraphDTO().getGradeDetail().setSelectedCategoryGrade(objectTrendOuter.getSelfGraphDTO().getGradeDetail().getOverallGrade());
            }
        }
        
        //SENTIMENT
        if(trendingCategorySelected.equalsIgnoreCase(SENTIMENT))
        {
            if(objectTrendOuter.getCompGraphDTO() != null &&
                    objectTrendOuter.getCompGraphDTO().getGradeDetail() != null &&
                    objectTrendOuter.getCompGraphDTO().getGradeDetail().getSentimentGrade() != null )
            {
                objectTrendOuter.getCompGraphDTO().getGradeDetail().setSelectedCategoryGrade(objectTrendOuter.getCompGraphDTO().getGradeDetail().getSentimentGrade());
            }
            
            if(objectTrendOuter.getSelfGraphDTO() != null &&
                    objectTrendOuter.getSelfGraphDTO().getGradeDetail() != null &&
                    objectTrendOuter.getSelfGraphDTO().getGradeDetail().getSentimentGrade() != null )
            {
                objectTrendOuter.getSelfGraphDTO().getGradeDetail().setSelectedCategoryGrade(objectTrendOuter.getSelfGraphDTO().getGradeDetail().getSentimentGrade());
            }
        }
        
        //ENGAGEMENT
        if(trendingCategorySelected.equalsIgnoreCase(ENGAGEMENT))
        {
            if(objectTrendOuter.getCompGraphDTO() != null &&
                    objectTrendOuter.getCompGraphDTO().getGradeDetail() != null &&
                    objectTrendOuter.getCompGraphDTO().getGradeDetail().getEngagementGrade() != null )
            {
                objectTrendOuter.getCompGraphDTO().getGradeDetail().setSelectedCategoryGrade(objectTrendOuter.getCompGraphDTO().getGradeDetail().getEngagementGrade());
            }
            
            if(objectTrendOuter.getSelfGraphDTO() != null &&
                    objectTrendOuter.getSelfGraphDTO().getGradeDetail() != null &&
                    objectTrendOuter.getSelfGraphDTO().getGradeDetail().getEngagementGrade() != null )
            {
                objectTrendOuter.getSelfGraphDTO().getGradeDetail().setSelectedCategoryGrade(objectTrendOuter.getSelfGraphDTO().getGradeDetail().getEngagementGrade());
            }
        }
        
        //RETENTION
        if(trendingCategorySelected.equalsIgnoreCase(RETENTION))
        {
            if(objectTrendOuter.getCompGraphDTO() != null &&
                    objectTrendOuter.getCompGraphDTO().getGradeDetail() != null &&
                    objectTrendOuter.getCompGraphDTO().getGradeDetail().getRetentionGrade() != null )
            {
                objectTrendOuter.getCompGraphDTO().getGradeDetail().setSelectedCategoryGrade(objectTrendOuter.getCompGraphDTO().getGradeDetail().getRetentionGrade());
            }
            
            if(objectTrendOuter.getSelfGraphDTO() != null &&
                    objectTrendOuter.getSelfGraphDTO().getGradeDetail() != null &&
                    objectTrendOuter.getSelfGraphDTO().getGradeDetail().getRetentionGrade() != null )
            {
                objectTrendOuter.getSelfGraphDTO().getGradeDetail().setSelectedCategoryGrade(objectTrendOuter.getSelfGraphDTO().getGradeDetail().getRetentionGrade());
            }
        }
        
        //DEMOGRAPHICS
        if(trendingCategorySelected.equalsIgnoreCase(DEMOGRAPHICS))
        {
            if(objectTrendOuter.getCompGraphDTO() != null &&
                    objectTrendOuter.getCompGraphDTO().getGradeDetail() != null &&
                    objectTrendOuter.getCompGraphDTO().getGradeDetail().getDemographicsGrade() != null )
            {
                objectTrendOuter.getCompGraphDTO().getGradeDetail().setSelectedCategoryGrade(objectTrendOuter.getCompGraphDTO().getGradeDetail().getDemographicsGrade());
            }
            
            if(objectTrendOuter.getSelfGraphDTO() != null &&
                    objectTrendOuter.getSelfGraphDTO().getGradeDetail() != null &&
                    objectTrendOuter.getSelfGraphDTO().getGradeDetail().getDemographicsGrade() != null )
            {
                objectTrendOuter.getSelfGraphDTO().getGradeDetail().setSelectedCategoryGrade(objectTrendOuter.getSelfGraphDTO().getGradeDetail().getDemographicsGrade());
            }
        }
        
        //LOYALTY
        if(trendingCategorySelected.equalsIgnoreCase(LOYALTY))
        {
            if(objectTrendOuter.getCompGraphDTO() != null &&
                    objectTrendOuter.getCompGraphDTO().getGradeDetail() != null &&
                    objectTrendOuter.getCompGraphDTO().getGradeDetail().getLoyaltyGrade() != null )
            {
                objectTrendOuter.getCompGraphDTO().getGradeDetail().setSelectedCategoryGrade(objectTrendOuter.getCompGraphDTO().getGradeDetail().getLoyaltyGrade());
            }
            
            if(objectTrendOuter.getSelfGraphDTO() != null &&
                    objectTrendOuter.getSelfGraphDTO().getGradeDetail() != null &&
                    objectTrendOuter.getSelfGraphDTO().getGradeDetail().getLoyaltyGrade() != null )
            {
                objectTrendOuter.getSelfGraphDTO().getGradeDetail().setSelectedCategoryGrade(objectTrendOuter.getSelfGraphDTO().getGradeDetail().getLoyaltyGrade());
            }
        }
        
        //INFLUENCE
        if(trendingCategorySelected.equalsIgnoreCase(INFLUENCE))
        {
            if(objectTrendOuter.getCompGraphDTO() != null &&
                    objectTrendOuter.getCompGraphDTO().getGradeDetail() != null &&
                    objectTrendOuter.getCompGraphDTO().getGradeDetail().getInfluenceGrade() != null )
            {
                objectTrendOuter.getCompGraphDTO().getGradeDetail().setSelectedCategoryGrade(objectTrendOuter.getCompGraphDTO().getGradeDetail().getInfluenceGrade());
            }
            
            if(objectTrendOuter.getSelfGraphDTO() != null &&
                    objectTrendOuter.getSelfGraphDTO().getGradeDetail() != null &&
                    objectTrendOuter.getSelfGraphDTO().getGradeDetail().getInfluenceGrade() != null )
            {
                objectTrendOuter.getSelfGraphDTO().getGradeDetail().setSelectedCategoryGrade(objectTrendOuter.getSelfGraphDTO().getGradeDetail().getInfluenceGrade());
            }
        }
        
        //REACH
        if(trendingCategorySelected.equalsIgnoreCase(REACH))
        {
            if(objectTrendOuter.getCompGraphDTO() != null &&
                    objectTrendOuter.getCompGraphDTO().getGradeDetail() != null &&
                    objectTrendOuter.getCompGraphDTO().getGradeDetail().getReachGrade() != null )
            {
                objectTrendOuter.getCompGraphDTO().getGradeDetail().setSelectedCategoryGrade(objectTrendOuter.getCompGraphDTO().getGradeDetail().getReachGrade());
            }
            
            if(objectTrendOuter.getSelfGraphDTO() != null &&
                    objectTrendOuter.getSelfGraphDTO().getGradeDetail() != null &&
                    objectTrendOuter.getSelfGraphDTO().getGradeDetail().getReachGrade() != null )
            {
                objectTrendOuter.getSelfGraphDTO().getGradeDetail().setSelectedCategoryGrade(objectTrendOuter.getSelfGraphDTO().getGradeDetail().getReachGrade());
            }
        }
    }

    /**
     * 
     * use buildXML instead
     */
    @Deprecated
    private StringBuilder createXMLForGraph(List<TrendingGraphOuterDTO> outerTrendDataList)
    {
        StringBuilder xmlData = new StringBuilder();
        int count = 1;
        
        xmlData.append("<GRADE>");
            
        for (Iterator<TrendingGraphOuterDTO> iterator = outerTrendDataList.iterator(); iterator.hasNext();)
        {
            xmlData.append("<DATA displayOrder='"+count+"'>");
            
            TrendingGraphOuterDTO trendingGraphOuterDTO = (TrendingGraphOuterDTO) iterator.next();
            
            xmlData.append("<DATE>"+trendingGraphOuterDTO.getSelfGraphDTO().getStrAsOfPerformanceDate()+"</DATE>");
            xmlData.append("<YOU>"+trendingGraphOuterDTO.getSelfGraphDTO().getGradeDetail().getSelectedCategoryGrade()+"</YOU>");
            xmlData.append("<COMPETITOR>"+trendingGraphOuterDTO.getCompGraphDTO().getGradeDetail().getSelectedCategoryGrade()+"</COMPETITOR>");
            xmlData.append("<CATEGORY>"+getChannelPerformanceController().getTrendingCategorySelected()+"</CATEGORY>");
            xmlData.append("</DATA>");
            
            count++;
            
        }
        
        xmlData.append("</GRADE>");
        
        return xmlData;
    }


    /**
     * buildXML
     * @param socialIntelligenceList
     * @return string
     */
        public String buildXML(List<TrendingGraphOuterDTO> tgOuterDto){  
            Document doc = null;       
            try{ 
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = factory.newDocumentBuilder();
                doc = docBuilder.newDocument();
            }catch(Exception e){
            }
            if(tgOuterDto != null && tgOuterDto.size() > 0){
                doc = setElements(tgOuterDto,doc);    
            }
            //System.out.println(getDocumentAsString(doc));
            return getDocumentAsString(doc);
        }
    
        /**
         * @param List of TrendingGraphOuterDTO
         * @param doc
         * @return Document doc
         */
        private Document setElements(List<TrendingGraphOuterDTO> tgOuterDto,Document doc) {       
            Element root = doc.createElement(ROOT_TAG); // Grade
            doc.appendChild(root);
            Element resultInfo = null;
            int count=1;
            for(TrendingGraphOuterDTO dto:tgOuterDto){
                resultInfo = doc.createElement(RESULT_TAG); // Data
                resultInfo.setAttribute(DISPLAYORDER, ""+count);
                root.appendChild(resultInfo);

                Element date = doc.createElement("DATE"); 
                date.appendChild(doc.createTextNode(dto.getSelfGraphDTO().getStrAsOfPerformanceDate()));
                Element you = doc.createElement("YOU");
                you.appendChild(doc.createTextNode(dto.getSelfGraphDTO().getGradeDetail().getSelectedCategoryGrade()));
                Element competitor = doc.createElement("COMPETITOR");
                competitor.appendChild(doc.createTextNode(dto.getCompGraphDTO().getGradeDetail().getSelectedCategoryGrade()));
                Element category = doc.createElement("CATEGORY");
                category.appendChild(doc.createTextNode(getChannelPerformanceController().getTrendingCategorySelected()));
                
                resultInfo.appendChild(date);
                resultInfo.appendChild(you);
                resultInfo.appendChild(competitor);
                resultInfo.appendChild(category);
                count++;           
            }
            return doc;
        }   

        /**
         * getDocumentAsString
         * @param doc
         * @return string
         */
        public String getDocumentAsString(Node doc){
            String docAsString = null;
            try {
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                StringWriter sw = new StringWriter();
                DOMSource source = new DOMSource(doc);
                StreamResult result =  new StreamResult(sw);
                transformer.transform(source, result);
                docAsString = sw.toString();
            }catch (TransformerException e){}               
            return docAsString;
        }

        
    public List<TrendingGraphDTO> getTrendList()
    {
        return trendList;
    }
    
    public void setTrendList(List<TrendingGraphDTO> trendList) 
    {
        this.trendList = trendList;
    }
    public ChannelPerformanceController getChannelPerformanceController()
    {
        return channelPerformanceController;
    }

    public void setChannelPerformanceController(ChannelPerformanceController channelPerformanceController)
    {
        this.channelPerformanceController = channelPerformanceController;
    }

    public List<TrendingGraphOuterDTO> getOuterTrendList()
    {
        return outerTrendList;
    }

    public StringBuilder getXmlDataForGraph() 
    {
        return xmlDataForGraph;
    }
    
    
 
}