package dgo.dgmt;

import dgo.dgmt.items.ageutils.AgtypeWrapper;
import dgo.dgmt.items.graph.ItemMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DgmtApplicationTests {

	@Autowired
	ItemMapper itemMapper;

	@Test
	void contextLoads() {
		var f = itemMapper.findByName(AgtypeWrapper.from("item"));
		f.subscribe(itemData -> {
			System.out.println(itemData.toString());
			Assertions.assertNotNull(itemData);
		});
	}

}
