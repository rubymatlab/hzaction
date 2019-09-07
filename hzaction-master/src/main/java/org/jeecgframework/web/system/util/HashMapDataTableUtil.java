package org.jeecgframework.web.system.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.aspose.cells.ICellsDataTable;



public class HashMapDataTableUtil implements ICellsDataTable {  
  
    //数据集合  
    private List<Map<String, Object>> dataList = null;  
      
    //索引  
    private int index;  
      
    //存放dataList当中Map<String, Object>的key  
    private String[] columns = null;  
  
    public HashMapDataTableUtil(Map<String, Object> data) {  
        if(this.dataList == null) {  
            this.dataList = new ArrayList<Map<String,Object>>();  
        }  
        dataList.add(data);  
    }  
      
    public HashMapDataTableUtil(List<Map<String, Object>> data) {  
        this.dataList = data;  
    }  
      
    /** 
     * 初始化方法 
     */  
    @Override  
    public void beforeFirst() {  
        index = -1;  
        columns = this.getColumns();  
    }  
  
    /** 
     * WorkbookDesigner自动调用 
     * 会将this.getColumns()方法所返回的列 按照顺序调用改方法 
     */  
    @Override  
    public Object get(int columnIndex) {  
        if(index < 0 || index >= this.getCount()) {  
            return null;  
        }  
        Map<String, Object> record = this.dataList.get(index);  
        String columnName = this.columns[columnIndex];  
        return record.get(columnName);  
    }  
  
    /** 
     * 根据columnName返回数据 
     */  
    @Override  
    public Object get(String columnName) {  
        Map<String, Object> record = this.dataList.get(index);  
        return record.get(columnName);  
    }  
  
    /** 
     * 获得列集合 
     */  
    @Override  
    public String[] getColumns() {  
        Map<String, Object> temp = this.dataList.get(0);  
        Set<Entry<String, Object>> entrys = temp.entrySet();  
        List<String> columns = new ArrayList<String>();  
        for (Entry<String, Object> e : entrys) {  
            columns.add(e.getKey());  
        }  
        String[] s = new String[entrys.size()];  
        columns.toArray(s);  
        return s;  
    }  
  
    @Override  
    public int getCount() {  
        return this.dataList.size();  
    }  
  
    @Override  
    public boolean next() {  
        index += 1;  
        if(index >= this.getCount())  
        {  
            return false;  
        }  
        return true;  
    }  
  
}  