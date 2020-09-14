package life.majiang.community.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDto {
    private List<QuestionDto> questions;
    private boolean showPrevious;//跳转上一页
    private boolean showFirstPage;//跳转第一页
    private boolean showNext;//跳转下一页
    private boolean showEndPage;//跳转最后一页
    private Integer page;//当前页码
    private List<Integer> pages = new ArrayList<>();//显示页码
    private Integer totalPage;//总页数


    public void setPagination(Integer totalPage, Integer page) {
        this.totalPage=totalPage;
       /* if(totalCount % size == 0){
            totalPage = totalCount / size;
        }else{
            totalPage = totalCount / size + 1;
        }
        if(page <1){
            page = 1;
        }
        if(page >totalPage){
            page = totalPage;
        }*/
        this.page=page;
        pages.add(page);
        for(int i=1;i <=3; i++){
            if(page - i > 0){
                pages.add(0,page - i);
            }
            if(page + i <= totalPage){
                pages.add(page + i);
            }
        }


        if(page == 1){
            showPrevious = false;
        }else{
            showPrevious = true;
        }
        if(page == totalPage){
            showNext = false;
        }else{
            showNext = true;
        }
        if(pages.contains(1)){
            showFirstPage = false;
        }else{
            showFirstPage = true;
        }
        if(pages.contains(totalPage)){
            showEndPage = false;
        }else{
            showEndPage = true;
        }

    }
}
