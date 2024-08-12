package com.coding404.myweb.product;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.util.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("productService") //이름
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductMapper productMapper;


    @Override
    public int productInsert(ProductVO vo) {

        return productMapper.productInsert(vo);
    }

    @Override
    public ArrayList<ProductVO> getList(String userId, Criteria cri) {
        return productMapper.getList(userId, cri);
    }

    @Override
    public int getTotal(String userId, Criteria cri) {
        return productMapper.getTotal(userId, cri);
    }


    @Override
    public ProductVO getDetail(int prodId) {
        return productMapper.getDetail(prodId);
    }

    @Override
    public int productUpdate(ProductVO vo) {

        return productMapper.productUpdate(vo);
    }

    @Override
    public int productDelete(ProductVO vo) {
        return productMapper.productDelete(vo);
    }
}
