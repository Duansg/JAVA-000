package org.common.base;



public class WebErrorFactory extends RuntimeException {

    public WebErrorFactory(){
        super();
    }

    public WebErrorFactory(String mes ,Throwable cause ,boolean  str ,boolean str1 ){
        super(mes , cause , str ,str1) ;
    }

    public WebErrorFactory(String mes ,Throwable cause){
        super( mes , cause);
    }

    public WebErrorFactory(String mes){
        super( mes );
    }

    public WebErrorFactory(Throwable cause){
        super(  cause);
    }

}