package com.edifixio.soc.web.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.ByteArrayOutputStream;


public class ImageScaler {
    
       
    public static byte[] getScalledImge(byte[] imageContent, int width, int height)
    {
        byte[] outputContent = null;
        ByteArrayOutputStream outStream;
        try{
            if(imageContent != null)
            {
                
                ImageIcon ico = new ImageIcon(imageContent);
                Image image = ico.getImage();
                
                int imgWd=  image.getWidth(new ImageIcon(image).getImageObserver());
                int imgHt=  image.getHeight(new ImageIcon(image).getImageObserver());
                
                
                //scale the image
                if(imgWd>imgHt){
                    if(imgWd>width)
                        image = image.getScaledInstance(width, -1,Image.SCALE_SMOOTH);
                }
                else{
                    if(imgHt>height)
                        image = image.getScaledInstance(-1, height,Image.SCALE_SMOOTH);
                }
                
                int imgScldWd=  image.getWidth(new ImageIcon(image).getImageObserver());
                int imgScldHt=  image.getHeight(new ImageIcon(image).getImageObserver());
                
                //image to buffered image
                BufferedImage bImage = getBufferedImage(image, imgScldWd, imgScldHt);
                
                //write image
                outStream =  new ByteArrayOutputStream();
                ImageIO.write(bImage, "PNG", outStream);
                if(outStream != null)
                    outputContent = outStream.toByteArray();
                outStream.close();
            }
            
          
        }catch(Exception e){e.printStackTrace();}
            
        //return 
        return outputContent;
    }
    
    private static BufferedImage getBufferedImage(Image image, int width, int height){
        //this code ensures that the image is fully loded
        ImageIcon ico = new ImageIcon(image);
        image = ico.getImage();
        
        //get image width height
        int imgW = image.getWidth(ico.getImageObserver());
        int imgH = image.getHeight(ico.getImageObserver());
        
        //image to bufferd image
        BufferedImage bImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bImage.createGraphics();       //paint the image
        
        
        int imgX = 0;
        int imgY = 0;
        
        //white place holder
        g.setColor(new Color(255,255,255,0));
        g.fillRect(0,0,width, height);
       
        
        if(width != imgW){
            imgX = (width - imgW)/2;
        }
        if(height!=imgH){
            imgY = (height - imgH)/2;
        }
        g.drawImage(image, imgX, imgY, null);
        g.dispose();
        
        return bImage;
    }
    
   
}
