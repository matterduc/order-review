package com.crosssolutions.user.dto;

import java.io.Serializable;

import com.crosssolutions.user.enums.SearchOperation;

import lombok.Data;
import lombok.NonNull;

/**
 * @author Duc.Nguyen
 */
@Data
public class SearchCriteria implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** Search field */
    @NonNull
    private String key;

    /** Search operation */
    @NonNull
    private SearchOperation operation;

    /** Search value */
    @NonNull
    private Object value;

    public String getStringValue() {
        return (String) value;
    }
}
