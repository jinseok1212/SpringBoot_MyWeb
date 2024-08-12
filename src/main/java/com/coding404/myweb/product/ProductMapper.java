package com.coding404.myweb.product;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.util.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface ProductMapper {

    public int productInsert(ProductVO vo);
    public ArrayList<ProductVO> getList(@Param("userId") String userId, @Param("cri") Criteria cri); //매개변수가 2개 이상이면, 이름을 붙여줘야함
    public int getTotal(@Param("userId") String userId, @Param("cri") Criteria cri); //전체게시글 수

    public ProductVO getDetail(int prodId);
    public int productUpdate(ProductVO vo); //수정
    public int productDelete(ProductVO vo); //삭제

}
