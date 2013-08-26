package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: saveln
 * Date: 8/26/13
 * Time: 12:48 PM
 * To change this template use File | Settings | File Templates.
 */

@Service("RecordService")
public class RecordServiceImpl implements RecordService{

    @Autowired
    private RecordDAO recordDAO;

    @Override
    public void addRecord(Record record) {
        recordDAO.addRecord(record);
    }

    @Override
    public List getRecords() {
        return recordDAO.getRecords();
    }

    @Override
    public void shutdown() {
        recordDAO.shutdown();
    }
}
