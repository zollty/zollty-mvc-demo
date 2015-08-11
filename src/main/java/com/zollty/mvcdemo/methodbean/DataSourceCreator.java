package com.zollty.mvcdemo.methodbean;

public class DataSourceCreator {
    
    private String name;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public FakeDataSource getDataSource(){
        return new FakeDataSource(name);
    }
  
}
