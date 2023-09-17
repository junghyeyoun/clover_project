package pack.model.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.product.ProductBean;

@Repository
public class ProductDao {
	// log로 확인
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductMappingInterface mappingInterface;

	// 전체 상품 읽기
	public List<ProductDto> selectAll() {
		List<ProductDto> list = mappingInterface.selectAll();
		logger.info("읽은 상품 수 : " + list.size());
		return list;
	}

	// 해당 상품 상세 보기
	public ProductDto detail(String product_id) {
		ProductDto dto = mappingInterface.selectOne(product_id);
		return dto;
	}

	public int totalCnt() {
		return mappingInterface.totalCnt();
	}

	// 상품 찾기
	public List<ProductDto> search(ProductBean bean) {
		List<ProductDto> list = mappingInterface.searchList(bean);
		logger.info("검색 반환된 레코드 수 : " + list.size());
		return list;
	}

	// 상품 등록
	public boolean insert(ProductBean bean) {
		boolean b = false;
		int re = mappingInterface.insertProduct(bean);
		if (re > 0)
			b = true;
		return b;
	}

	// 상품 수정
	public boolean update(ProductBean bean) {
		boolean b = false;
		int re = mappingInterface.updateProduct(bean);
		if (re > 0)
			b = true;
		return b;
	}

	// 상품 삭제
	public boolean delete(String product_id) {
		boolean b = false;
		int re = mappingInterface.deleteProduct(product_id);
		if (re > 0)
			b = true;
		return b;
	}

}
