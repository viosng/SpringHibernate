package com.springapp.mvc;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saveln
 * Date: 8/26/13
 * Time: 12:47 PM
 * To change this template use File | Settings | File Templates.
 */
public interface RecordService {
    public void addRecord(Record record);
    public List getRecords();
    public void shutdown();
}
