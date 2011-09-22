package com.edifixio.soc.web.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import twitter4j.Status;


public class TwtFileBean {
    
    private static final String FILE_PREFIX = "TWT";
    
    private String fileName;
    private File file;
    private long timeStamp;


    private void init() {
        try {
            //create temp file
            this.file = File.createTempFile(FILE_PREFIX, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param sessionId
     * @param handler
     */
    public TwtFileBean(String sessionId, String handler) {
        this.fileName = "" + sessionId + "_" + handler + ".txt";
        init();
    }


    public String getFileName() {
        return fileName;
    }


    public File getFile() {
        return file;
    }


    public void setFile(File file) {
        this.file = file;
    }


    /**
     * This method returns time in milliseconds which represents the time frame 
     * since the file saved last time. Returns -1 if the file is not saved once. 
     * @return
     */
    public long getSinceLastSaved() {
        if (timeStamp == 0)
            return -1;
        return (System.currentTimeMillis() - timeStamp);
    }


    /**
     * This method saves status list in file.
     * @param alRefreshedList
     * @throws IOException
     */
    public void save(List<Status> alRefreshedList) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                file.getCanonicalPath()));
        oos.writeObject(new ArrayList<Status>(alRefreshedList));
        this.timeStamp = System.currentTimeMillis();
    }


    /**
     * This method returns status list from file. 
     * Returns null if doesnt contains anything or first time.
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Status> getResult() {
        List<Status> alAllTweets = null;
        try {
            if (file.exists()) {
                alAllTweets = (List<Status>) new ObjectInputStream(
                        new FileInputStream(file.getCanonicalPath()))
                        .readObject();
            }
        } catch (Exception ex) {
            System.out.println("Could not read file : " + ex.getMessage());
        }
        return alAllTweets;
    }
}
