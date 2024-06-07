package com.car.manage.system.search;

import com.car.manage.common.constants.Constants;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * Pageable search.
 */
public class PageSearch extends PageRequest {
    /**
     * default init.
     */
    public PageSearch() {
        super(0, Constants.DEFAULT_PAGE_SIZE);
    }

    /**
     * Creates a new {@link PageSearch}. Pages are zero indexed, thus providing 0 for {@code page} will return
     * the first page.
     *
     * @param page zero-based page index.
     * @param size the size of the page to be returned.
     */
    public PageSearch(int page, int size) {
        super(page, size);
    }

    /**
     * Creates a new {@link PageSearch} with sort parameters applied.
     *
     * @param page       zero-based page index.
     * @param size       the size of the page to be returned.
     * @param direction  the direction of the {@link Sort} to be specified, can be {@literal null}.
     * @param properties the properties to sort by, must not be {@literal null} or empty.
     */
    public PageSearch(int page, int size, Sort.Direction direction, String... properties) {
        super(page, size, direction, properties);
    }

    /**
     * Creates a new {@link PageSearch} with sort parameters applied.
     *
     * @param page zero-based page index.
     * @param size the size of the page to be returned.
     * @param sort can be {@literal null}.
     */
    public PageSearch(int page, int size, Sort sort) {
        super(page, size, sort);
    }

}
