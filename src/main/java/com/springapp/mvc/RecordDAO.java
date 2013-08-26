package com.springapp.mvc;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saveln
 * Date: 8/22/13
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
public interface RecordDAO {
    public void addRecord(Record record);
    public List getRecords();
    public void shutdown();
}
