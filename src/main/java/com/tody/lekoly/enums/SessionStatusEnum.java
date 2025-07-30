package com.tody.lekoly.enums;


import lombok.Getter;

@Getter
public enum SessionStatusEnum  {
    OPEN("OP"), CLOSED("CLO"), FULL("FULL"), CANCELED("CAN");

    private final String status;

    SessionStatusEnum(String status) {
        this.status = status;
    }
}
