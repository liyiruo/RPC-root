package com.liyiruo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author liyiruo
 */
@Data
public class UserDTo implements Serializable {
    private static final Long SERIALIZE_VERSIONUUID =1L;
    private String name;
    private int age;
    private String userId;
}
