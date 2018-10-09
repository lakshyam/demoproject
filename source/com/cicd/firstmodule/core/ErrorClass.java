package com.cicd.firstmodule.core;

public enum ErrorClass  {
	
        ALPHAONLY("[a-zA-Z]", "Invalid data.  Only Character allowed."),
	 	NUMONLY("[0-9]+", "Invalid data. Only numbers are allowed..");
 
        private final String status;
        private final String description;
 
        ErrorClass(String aStatus, String desc){
            this.status = aStatus;
            this.description = desc;
        }
        public String status(){
            return this.status;
        }
        public String description(){
            return this.description;
        }

}
