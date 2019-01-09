/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author KIENDINH
 */
public class PaginationController {
    
    private int pageSize;
    private int totalItem;
    private int currentPage;

    /**
     * 
     * @param pageSize
     * @param totalItem 
     */
    public PaginationController(int pageSize, int totalItem) {
        this.pageSize = pageSize;
        this.totalItem = totalItem;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalItem() {
        return totalItem;
    }

    public int getTotalPage() {
        return (totalItem / pageSize) ;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getCurrentItem() {
        return currentPage * pageSize;
    }

    public void nextPage() {
        currentPage++;
    }

    public void prevPage() {
        currentPage--;
    }

    public void firstPage() {
        currentPage = 0;
    }

    public void lastPage() {
        currentPage = getTotalPage();
    }

    public boolean isHasNextPage() {
        return currentPage <= getTotalPage();
    }

    public boolean isHasPrevPage() {
        return currentPage != 0;
    }
}
