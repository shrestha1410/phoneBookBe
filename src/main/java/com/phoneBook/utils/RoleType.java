package com.phoneBook.utils;

public enum RoleType {
    USER("USER"),
    ADMIN("ADMIN");
    RoleType(String user) {
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public RoleType fromValue(String text){
        for(RoleType r:RoleType.values()){
            if(text.equalsIgnoreCase(r.name())){
                return  r;
            }
        }
        return null;
    }
}
