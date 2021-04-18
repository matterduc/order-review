package com.bycnit.lap.util;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.bycnit.lap.dto.SearchCriteria;

/**
 * Unit test for "com.bycnit.lap.util.SearchCriteriaUtils"
 *
 * @author Z.DRISSI
 */
public class SearchCriteriaUtilsTest {

    @Test
    public void whenBuildingCriterias_ThenReturnList() {

        // Arrange
        final String searchToken = "firstName!babyJohn,lastName~doe,address:*vegas,age>25,weight<120,id:*Q26,uid:Q26*,email:*gmail*";

        // Act
        final List<SearchCriteria> criterias = SearchCriteriaUtils.build(searchToken);

        // Assert
        assertEquals(8, criterias.size());
        assertEquals("firstName", criterias.get(0).getKey());
        assertEquals("lastName", criterias.get(1).getKey());
        assertEquals("address", criterias.get(2).getKey());
        assertEquals("age", criterias.get(3).getKey());
        assertEquals("weight", criterias.get(4).getKey());
    }
}
