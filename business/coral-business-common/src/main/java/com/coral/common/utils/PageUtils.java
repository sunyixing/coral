package com.coral.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @ClassName PageUtils
 * @Author sunyixing
 * @Date 2019-09-25 20:55
 * @Version 1.0
 */
@Data
@ToString
public class PageUtils<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int totalCount;
    private int pageSize;
    private int totalPage;
    private int currPage;
    private List<T> list;

    public PageUtils(List<T> list, int totalCount, int pageSize, int currPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalPage = (int)Math.ceil((double)totalCount / (double)pageSize);
    }

    public PageUtils(List<T> list, IPage page) {
        this.list = list;
        this.totalCount = (int)page.getTotal();
        this.pageSize = (int)page.getSize();
        this.currPage = (int)page.getCurrent();
        this.totalPage = (int)page.getPages();
    }

    public PageUtils(IPage<T> page) {
        this.list = page.getRecords();
        this.totalCount = (int)page.getTotal();
        this.pageSize = (int)page.getSize();
        this.currPage = (int)page.getCurrent();
        this.totalPage = (int)page.getPages();
    }

    public <U> PageUtils<U> convert(Function<T, U> converter) {
        List<U> data = (List)this.getList().stream().map(converter).collect(Collectors.toList());
        return new PageUtils(data, this.getTotalCount(), this.getPageSize(), this.getCurrPage());
    }

    /**
     * 判断对象是否相等
     * @param o
     * @return
     */
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageUtils)) {
            return false;
        } else {
            PageUtils<?> other = (PageUtils)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getTotalCount() != other.getTotalCount()) {
                return false;
            } else if (this.getPageSize() != other.getPageSize()) {
                return false;
            } else if (this.getTotalPage() != other.getTotalPage()) {
                return false;
            } else if (this.getCurrPage() != other.getCurrPage()) {
                return false;
            } else {
                Object this$list = this.getList();
                Object other$list = other.getList();
                if (this$list == null) {
                    if (other$list != null) {
                        return false;
                    }
                } else if (!this$list.equals(other$list)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof PageUtils;
    }

}

