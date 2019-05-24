package test.ForkJoin线程池;

import java.util.ArrayList;
import java.util.List;

/**
 * 随机生成产品列表
 * @author yangfeng
 *
 */
public class ProductListGenerator {
	public List<Product> generate (int size){
		List<Product> ret = new ArrayList<>();
		for(int i =0 ;i<size;i++){
			Product product = new Product();
			product.setName("Product"+i);
			product.setPrice(10);
			ret.add(product);
		}
		return ret;
	}
}
