package FinalProject.REST;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;

import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

import FinalProject.Entities.Item;
import FinalProject.Model.Category;
import FinalProject.Services.ItemService;
import FinalProject.Services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<>(productService.getItems(), HttpStatus.OK);
	}
	

	@RequestMapping(method = RequestMethod.GET, value = "/id/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> getItems(@PathVariable("productId") Integer id) throws JsonProcessingException {

		Item items = productService.getItem(id);
		if (items == null) {
			return new ResponseEntity<>("No product found for ID " + id, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(mapper.writeValueAsString(items), HttpStatus.OK);
		}
	}
	
	@RequestMapping(method= RequestMethod.GET, path="/category/{category}")
	@ResponseBody
	public ResponseEntity<?> getItemsFromCategory(@PathVariable(name="category") Category category){
		return new ResponseEntity<>(productService.getItemsByCategory(category),HttpStatus.OK);
	}
	
	@RequestMapping(method= RequestMethod.GET, path="/name/{name}")
	@ResponseBody
	public ResponseEntity<?> getItemsByName(@PathVariable(name="name") String name){
			List<Item> item = productService.getItemsByName(name);
			return new ResponseEntity<>(item,HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addItem(@RequestBody Item item) throws JsonProcessingException {

		int success = productService.createItem(item);
		if (success!=0) {
			return new ResponseEntity<>("The item was created",HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateItem(@PathVariable int itemId, @RequestBody Item item) throws JsonProcessingException {

		boolean success = productService.updateItem(item);
		if (success) {
			return new ResponseEntity<>(item, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(method= RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> deleteItem(@RequestBody(required=true) int itemId){
		Item item = productService.getItem(itemId);
		boolean success = productService.deleteItem(item);
		if(success)
			return ResponseEntity.ok().build();
		else
			return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
}
