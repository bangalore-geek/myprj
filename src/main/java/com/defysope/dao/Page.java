package com.defysope.dao;

import java.util.List;

/**
 * @author Pietro Polsinelli ppolsinelli@open-lab.com
 */
public interface Page {

	boolean isFirstPage();

	boolean isLastPage();

	boolean hasNextPage();

	boolean hasPreviousPage();

	int getLastPageNumber();

	List getThisPageElements();

	int getTotalNumberOfElements();

	int getThisPageFirstElementNumber();

	int getThisPageLastElementNumber();

	int getNextPageNumber();

	int getPreviousPageNumber();

	int getPageSize();

	int getPageNumber();
}