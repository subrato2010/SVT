package com.edifixio.soc.web.controllers;

import java.util.List;

import com.edifixio.soc.web.dto.TwitterInformationTopDTO;

public class ReplyTwitterDataController extends BaseWebObject{
    
    private static final String RIGHT = "Right";
    private static final String LEFT = "Left";
    private String twitterName;
    private String twitterMsg;
    private String twitterID;
    private String twitterImagePath;
    private String replyMessage;
    private String completeFlag="";
    private String leftRightData;
    private String referenceName="";
    private String fullTwtMsg;
    private String referenceType;
    
    private int clickIndex;
    
    public String getCompleteFlag() {
        return completeFlag;
    }

    public void setCompleteFlag(String completeFlag) {
        this.completeFlag = completeFlag;
    }
    public String getTwitterName() {
        return twitterName;
    }
    public String getTwitterMsg() {
        return twitterMsg;
    }
    public String getTwitterID() {
        return twitterID;
    }
    public String getTwitterImagePath() {
        return twitterImagePath;
    }
    public void setTwitterName(String twitterName) {
        this.twitterName = twitterName;
    }
    public void setTwitterMsg(String twitterMsg) {
        this.twitterMsg = twitterMsg;
    }
    public void setTwitterID(String twitterID) {
        this.twitterID = twitterID;
    }
    public void setTwitterImagePath(String twitterImagePath) {
        this.twitterImagePath = twitterImagePath;
    }
    
    public ReplyTwitterDataController()
    {
        int index;
        try
        { 
            if(getParameter("clickID") != null)
                setSessionAttribute("clickSideIndex", getParameter("clickID"));
            /*setSessionAttribute("validCredentials",true);
            setSessionAttribute("openEditPopup","");*/
            
            List<TwitterInformationTopDTO> twitterInfoList = (List<TwitterInformationTopDTO>)getObjSessionAttribute("getTwitterInfoList");
            
            if(getParameter("val") !=null)  {
                completeFlag = "yes";
                isClosable();
            }
            if(getParameter("clickID")== null)  {
               //TODO: All this line(Inside IF) will be deleted later on. Because after send twitt, that popup should be goes out.
                setLeftRightData(getLeftRightData());
                setClickIndex(getClickIndex());
                assignAllInformations(getClickIndex(), twitterInfoList,getLeftRightData());
            }
            else if(getParameter("clickID") != null || !(getParameter("clickID").equals("")))   {
                index = Integer.parseInt(getParameter("clickID"));
                
                
                
                setSessionAttribute("clickedIndex", index);
                setSessionAttribute("totalClicked", getSessionAttribute("totalClicked")+index);
                
                if(index == 0) {
                    setClickIndex(index);
                    setLeftRightData(LEFT);
                    assignAllInformations(index, twitterInfoList,getLeftRightData());
                }
                else if(index !=0) {
                    if(index == 2) {
                        setLeftRightData(LEFT);
                        setClickIndex(index-1);
                        assignAllInformations(index-1, twitterInfoList,getLeftRightData());
                    }
                    else if(index %2 == 0 && index >2) {
                        setLeftRightData(LEFT);
                        setClickIndex(index/2);
                        assignAllInformations(index/2, twitterInfoList,getLeftRightData());
                    }
                    else if(index %2 !=0 && index==1) {
                        setLeftRightData(RIGHT);
                        setClickIndex(index/2);
                        assignAllInformations(index/2, twitterInfoList,getLeftRightData());
                    }
                    else if(index%2 !=0) {
                        setLeftRightData(RIGHT);
                        setClickIndex((index-1)/2);
                        assignAllInformations((index-1)/2, twitterInfoList,getLeftRightData());
                        //setClickIndex(index - ((index/2)+1));
                    }
                }
                setSessionAttribute("indexValue", getClickIndex()+"");
                setSessionAttribute("sideClicked", getLeftRightData());
            }
      }catch(Exception e)  {
         //System.out.println("Error Found :"+e.getMessage());
          //e.printStackTrace();
      }
    }
    
    public boolean isClosable(){
        return (completeFlag.equalsIgnoreCase("yes"));
    }
    
    public void assignAllInformations(int index,List<TwitterInformationTopDTO> informationDTOList, String leftOrRight)    {
        if(leftOrRight.equals(LEFT)){
            setTwitterMsg(informationDTOList.get(index).getDtoLeft().getFullTweetMsg().replaceAll("\"", "'"));
            //setTwitterMsg(informationDTOList.get(index).getDtoLeft().getTwittMessage().replaceAll("\\<.*?\\>", "")); // to replace html tags
            setReferenceName(informationDTOList.get(index).getDtoLeft().getReferenceName());
            setTwitterName(informationDTOList.get(index).getDtoLeft().getTwitterScreenName());
            setTwitterImagePath(informationDTOList.get(index).getDtoLeft().getProfileImage());
            setSessionAttribute("replyInitials", "@"+informationDTOList.get(index).getDtoLeft().getTwitterScreenName()+" ");
//            setReplyMessage("@"+informationDTOList.get(index).getDtoLeft().getTwitterName()+" ");
            setFullTwtMsg(informationDTOList.get(index).getDtoLeft().getFullTweetMsg());
            setReferenceType(informationDTOList.get(index).getDtoLeft().getReferenceType());
        }
        else {
            setTwitterMsg(informationDTOList.get(index).getDtoRight().getFullTweetMsg().replaceAll("\"", "'"));
            //setTwitterMsg(informationDTOList.get(index).getDtoRight().getTwittMessage().replaceAll("\\<.*?\\>", "")); // to replace html tags
            setReferenceName(informationDTOList.get(index).getDtoRight().getReferenceName());
            setTwitterName(informationDTOList.get(index).getDtoRight().getTwitterScreenName());
            setTwitterImagePath(informationDTOList.get(index).getDtoRight().getProfileImage());
            setSessionAttribute("replyInitials", "@"+informationDTOList.get(index).getDtoRight().getTwitterScreenName()+" ");
            //setReplyMessage("@"+informationDTOList.get(index).getDtoRight().getTwitterName()+" ");
            setFullTwtMsg(informationDTOList.get(index).getDtoRight().getFullTweetMsg());
            setReferenceType(informationDTOList.get(index).getDtoRight().getReferenceType());
            setLeftRightData(RIGHT);
        }
    }
    public int getClickIndex() {
        return clickIndex;
    }
    public void setClickIndex(int clickIndex) {
        this.clickIndex = clickIndex;
    }
    public String getReplyMessage() {
        return replyMessage;
    }
    public void setReplyMessage(String replyMessage) {
        this.replyMessage = replyMessage;
    }

    public String getLeftRightData() {
        return leftRightData;
    }

    public void setLeftRightData(String leftRightData) {
        this.leftRightData = leftRightData;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public String getFullTwtMsg() {
        return fullTwtMsg;
    }

    public void setFullTwtMsg(String fullTwtMsg) {
        this.fullTwtMsg = fullTwtMsg;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }
}

