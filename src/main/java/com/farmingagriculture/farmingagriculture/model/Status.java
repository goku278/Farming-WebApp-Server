package com.farmingagriculture.farmingagriculture.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
public class Status {
    private String code;
    private String message;
    private String userId;
    private String userRole;

    public Status() {
    }

    public Status(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Status(String code, String message, String userId, String userRole) {
        this.code = code;
        this.message = message;
        this.userId = userId;
        this.userRole = userRole;
    }
}
