package com.liyiruo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author liyiruo
 */
@Data
public class RPCCommonReqDTO implements Serializable {
    private static final Long SERIALIZE_VERSIONUUID = 1L;
    private String methodName;
    private String classpath;
    private Object[] args;
}
