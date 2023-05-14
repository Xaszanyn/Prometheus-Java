package com.bitirmetezi.prometheusjava.core.mappers;

public enum ResponseConstants {
    SUCCESSFUL, FAILED, NOT_FOUND, NULL;

    public int getResponseCode(){
        switch (this){
            case SUCCESSFUL: return 1;
            case FAILED: return 2;
            case NOT_FOUND: return 3;
            case NULL: return 4;
        }
        return 0;
    }

    public String getResponseDesc(){
        switch (this){
            case SUCCESSFUL: return "Successfully completed.";
            case FAILED: return "An error occured.";
            case NOT_FOUND: return "No data found.";
            case NULL: return "Null value returned";
        }
        return "";
    }
}
