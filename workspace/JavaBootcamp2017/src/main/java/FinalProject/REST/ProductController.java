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
import FinalProject.Services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService){
		this.productService = productService;
	}

	ObjectMapper mapper = new ObjectMapper();

	
	@RequestMapping(method = RequestMethod.GET, value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<?> getItems(@PathVariable("productId") Integer id) throws JsonProcessingException {

		Item items = productService.getItem(id);
		if (items == null) {
			return new ResponseEntity<>("No product found for ID " + id, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(mapper.writeValueAsString(items), HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addItem(@RequestBody ProductService product1) throws JsonProcessingException {

		// boolean success = product1.createItem(product);
		boolean success = true;
		if (success) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
}
