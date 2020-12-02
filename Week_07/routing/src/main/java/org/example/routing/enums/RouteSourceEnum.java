package org.example.routing.enums;

import lombok.Getter;

@Getter
public enum RouteSourceEnum {

    MASTER("master"),
    SLAVE("slave");
    private String dataSourceName;


    RouteSourceEnum(String dataSourceName){
        this.dataSourceName = dataSourceName;
    }
}
