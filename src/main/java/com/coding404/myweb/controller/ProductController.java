package com.coding404.myweb.controller;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.product.ProductService;
import com.coding404.myweb.util.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    @Qualifier("productService") //이름으로 연결
    private ProductService productService;


    //목록
    @GetMapping("/productList")
    public String productList(Model model, Criteria cri) {

        //현재 로그인 되어있는 사람 아이디가 admin이라고 가정하고
        String userId = "admin";

        System.out.println(cri.toString());

        ArrayList<ProductVO> list = productService.getList(userId, cri);

        model.addAttribute("list", list);

        return "product/productList";
    }
    //등록
    @GetMapping("/productReg")
    public String ProductReg() {
        return "product/ProductReg";
    }
    //상세
    @GetMapping("/productDetail")
    public String productDetail(@RequestParam("prodId") int prodId, Model model) {

        ProductVO vo = productService.getDetail(prodId);
        model.addAttribute("vo", vo);
        return "product/productDetail";
    }

    //등록요청
    @PostMapping("/registForm")
    public String registForm(ProductVO vo, RedirectAttributes ra) {//리다이렉트어트리뷰트는 한번만 데이터 보냄

        //서버측에서 유효성 검사 진행가능

        int result = productService.productInsert(vo);

        if(result == 1) {
            ra.addFlashAttribute("msg", "정상 등록되었습니다.");
        } else {
            ra.addFlashAttribute("msg", "등록에 실패했습니다.");
        }

        return "redirect:/product/productList"; //다시 목록을 태워서 나감(데이터를 들고)
    }

    //상품 수정기능 - 반드시 필요한 값은 PK
    @PostMapping("/productUpdate")
    public String productUpdate(ProductVO vo,
                                RedirectAttributes ra) {

        //업데이트
        int result = productService.productUpdate(vo);
        if(result == 1) {
            ra.addFlashAttribute("msg", "수정되었습니다.");
        } else {
            ra.addFlashAttribute("msg", "수정에 실패했습니다.");
        }
        return "redirect:/product/productDetail?prodId=" + vo.getProdId(); //상세화면은 id값을 필요로 함
    }
    @PostMapping("/productDelete")
    public String productDelete(ProductVO vo, RedirectAttributes ra) {

        int result = productService.productDelete(vo);
        if(result == 1) {
            ra.addFlashAttribute("msg", "삭제되었습니다.");
        } else {
            ra.addFlashAttribute("msg", "삭제에 실패했습니다.");
        }
        return "redirect:/product/productList";

    }
}
